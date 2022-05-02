package svenhjol.charm.module.village_clocks;

import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import svenhjol.charm.item.CharmItem;
import svenhjol.charm.loader.CharmModule;

public class VillageClockItem extends CharmItem {
    public VillageClockItem(CharmModule module) {
        super(module, "village_clock", new Item.Properties()
            .tab(CreativeModeTab.TAB_TOOLS));
    }
}
