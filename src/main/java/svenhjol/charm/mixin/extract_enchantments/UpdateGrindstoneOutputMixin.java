package svenhjol.charm.mixin.extract_enchantments;

import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.inventory.Inventory;
import net.minecraft.screen.GrindstoneScreenHandler;
import net.minecraft.screen.ScreenHandler;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import svenhjol.charm.module.ExtractEnchantments;

import javax.annotation.Nullable;

@Mixin(value = GrindstoneScreenHandler.class, priority = 1)
public class UpdateGrindstoneOutputMixin {
    @Nullable
    PlayerEntity player;

    @Shadow @Final Inventory input;

    @Shadow @Final private Inventory result;

    @Inject(
        method = "updateResult",
        at = @At("RETURN"),
        cancellable = true
    )
    private void hookUpdateResult(CallbackInfo ci) {
        boolean result = ExtractEnchantments.tryUpdateGrindstoneOutput(this.input, this.result, this.player);
        if (result) {
            ((ScreenHandler) (Object) this).sendContentUpdates();
            ci.cancel();
        }
    }
}
