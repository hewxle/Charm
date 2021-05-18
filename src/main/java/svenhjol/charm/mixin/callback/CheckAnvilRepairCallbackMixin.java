package svenhjol.charm.mixin.callback;

import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.screen.AnvilScreenHandler;
import net.minecraft.screen.ForgingScreenHandler;
import net.minecraft.screen.ScreenHandlerContext;
import net.minecraft.screen.ScreenHandlerType;
import org.jetbrains.annotations.Nullable;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;
import svenhjol.charm.event.CheckAnvilRepairCallback;

@Mixin(AnvilScreenHandler.class)
public abstract class CheckAnvilRepairCallbackMixin extends ForgingScreenHandler {

    public CheckAnvilRepairCallbackMixin(@Nullable ScreenHandlerType<?> type, int syncId, PlayerInventory playerInventory, ScreenHandlerContext context) {
        super(type, syncId, playerInventory, context);
    }

    /**
     * Fires the {@link CheckAnvilRepairCallback} event.
     *
     * Allows intervention when checking if the anvil item can be
     * repaired with another item via the CheckAnvilRepairCallback event.
     *
     * For example, elytra cannot normally be repaired with leather,
     * but using the player.world we can check if insomnia is disabled
     * and therefore allow this repair check.  The reason we don't
     * hook into ElytraItem's canRepair method directly is because
     * there is no world reference.
     */
    @Redirect(
        method = "updateResult",
        at = @At(
            value = "INVOKE",
            target = "Lnet/minecraft/item/Item;canRepair(Lnet/minecraft/item/ItemStack;Lnet/minecraft/item/ItemStack;)Z"
        )
    )
    private boolean hookUpdateResultCanRepair(Item leftItem, ItemStack leftStack, ItemStack rightStack) {
        return CheckAnvilRepairCallback.EVENT.invoker().interact((AnvilScreenHandler)(Object) this, this.player, leftStack, rightStack);
    }
}
