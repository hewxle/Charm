package svenhjol.charm.module.village_clocks;

import svenhjol.charm.Charm;
import svenhjol.charm.annotation.CommonModule;
import svenhjol.charm.loader.CharmModule;

@CommonModule(mod = Charm.MOD_ID, description = "A clock with imagery showing the current villager activities.")
public class VillageClocks extends CharmModule {
    public static VillageClockItem VILLAGE_CLOCK;

    @Override
    public void register() {
        VILLAGE_CLOCK = new VillageClockItem(this);
    }
}
