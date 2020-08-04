package svenhjol.charm;

import net.minecraftforge.fml.common.Mod;
import svenhjol.charm.base.CharmMessages;
import svenhjol.charm.base.CharmSounds;
import svenhjol.charm.module.*;
import svenhjol.meson.MesonMod;
import svenhjol.meson.MesonModule;

import java.util.Arrays;
import java.util.List;

@Mod(Charm.MOD_ID)
public class Charm extends MesonMod {
    public static final String MOD_ID = "charm";

    public Charm() {
        super(MOD_ID);

        CharmMessages.init(this);
        CharmSounds.init(this);
    }

    protected List<Class<? extends MesonModule>> getModules() {
        return Arrays.asList(
            AnvilImprovements.class,
            ArmorInvisibility.class,
            AutomaticRecipeUnlock.class,
            BatBucket.class,
            BeaconsHealMobs.class,
            BlockOfEnderPearls.class,
            BlockOfGunpowder.class,
            BlockOfSugar.class,
            Bookcases.class,
            Candles.class,
            CaveSpidersDropCobwebs.class,
            ChickensDropFeathers.class,
            Crates.class,
            DecreaseRepairCost.class,
            DirtToPath.class,
            EndermitePowder.class,
            ExtractEnchantments.class,
            FeatherFallingCrops.class,
            GoldBars.class,
            GoldChains.class,
            GoldLanterns.class,
            HoeHarvesting.class,
            HuskImprovements.class,
            InventoryCrafting.class,
            InventorySorting.class,
            LanternsObeyGravity.class,
            MineshaftImprovements.class,
            MoreVillageBiomes.class,
            MoreVillagerTrades.class,
            MusicImprovements.class,
            NetheriteNuggets.class,
            ParrotsStayOnShoulder.class,
            PathToDirt.class,
            RedstoneLanterns.class,
            RedstoneSand.class,
            RemoveNitwits.class,
            RemovePotionGlint.class,
            SleepImprovements.class,
            StackableBooks.class,
            StackablePotions.class,
            StrayImprovements.class,
            TamedAnimalsNoDamage.class,
            UseTotemFromInventory.class,
            VariantAnimalTextures.class,
            VariantBarrels.class,
            VariantBookshelves.class,
            VariantChests.class,
            VillagersFollowEmeralds.class,
            WanderingTraderImprovements.class,
            WitchesDropLuck.class
        );
    }
}
