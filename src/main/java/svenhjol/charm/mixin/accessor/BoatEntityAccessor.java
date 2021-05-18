package svenhjol.charm.mixin.accessor;

import net.minecraft.entity.vehicle.BoatEntity;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.gen.Accessor;
import svenhjol.charm.base.iface.CharmMixin;

@Mixin(BoatEntity.class)
@CharmMixin(required = true)
public interface BoatEntityAccessor {
    @Accessor
    void setPaddlePhases(float[] paddlePhases);
}
