package svenhjol.charm.mixin.callback;

import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.damage.DamageSource;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import svenhjol.charm.event.EntityDropItemsCallback;

@Mixin(LivingEntity.class)
public class EntityDropItemsCallbackMixin {

    /**
     * Fires the {@link EntityDropItemsCallback} event.
     */
    @Inject(
        method = "drop",
        at = @At("TAIL")
    )
    private void hookDrop(DamageSource source, CallbackInfo ci) {
        LivingEntity entity = (LivingEntity)(Object)this;
        int lootingLevel = EnchantmentHelper.getLooting(entity);

        EntityDropItemsCallback.AFTER.invoker().interact(entity, source, lootingLevel);
    }
}
