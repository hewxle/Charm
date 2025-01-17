package svenhjol.charm.api.event;

import net.fabricmc.fabric.api.event.Event;
import net.fabricmc.fabric.api.event.EventFactory;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;

public interface PlayerDropInventoryCallback {
    Event<PlayerDropInventoryCallback> EVENT = EventFactory.createArrayBacked(PlayerDropInventoryCallback.class, (listeners) -> (player, inventory) -> {
        for (PlayerDropInventoryCallback listener : listeners) {
            InteractionResult result = listener.interact(player, inventory);
            if (result != InteractionResult.PASS)
                return result;
        }

        return InteractionResult.PASS;
    });

    InteractionResult interact(Player entity, Inventory inventory);
}
