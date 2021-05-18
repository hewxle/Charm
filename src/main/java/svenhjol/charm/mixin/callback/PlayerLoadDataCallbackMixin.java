package svenhjol.charm.mixin.callback;

import net.minecraft.nbt.NbtCompound;
import net.minecraft.server.PlayerManager;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.world.WorldSaveHandler;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;
import svenhjol.charm.base.helper.PlayerHelper;
import svenhjol.charm.event.PlayerLoadDataCallback;

@Mixin(PlayerManager.class)
public class PlayerLoadDataCallbackMixin {
    @Shadow
    @Final
    private WorldSaveHandler saveHandler;

    /**
     * Fires the {@link PlayerLoadDataCallback} event.
     */
    @Inject(
        method = "loadPlayerData",
        at = @At("HEAD")
    )
    private void hookLoadPlayerData(ServerPlayerEntity playerEntity, CallbackInfoReturnable<NbtCompound> cir) {
        PlayerLoadDataCallback.EVENT.invoker().interact(playerEntity, PlayerHelper.getPlayerDataDir(saveHandler));
    }
}
