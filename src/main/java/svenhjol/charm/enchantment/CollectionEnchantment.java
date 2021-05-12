package svenhjol.charm.enchantment;

import net.minecraft.enchantment.EnchantmentTarget;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ShearsItem;
import svenhjol.charm.base.CharmModule;
import svenhjol.charm.base.enchantment.CharmEnchantment;

public class CollectionEnchantment extends CharmEnchantment {
    public CollectionEnchantment(CharmModule module) {
        super(module, "collection", Rarity.UNCOMMON, EnchantmentTarget.DIGGER, new EquipmentSlot[] { EquipmentSlot.MAINHAND });
    }

    @Override
    public int getMinPower(int level) {
        return 15;
    }

    @Override
    public int getMaxLevel() {
        return 1;
    }

    @Override
    public boolean isTreasure() {
        return false;
    }

    @Override
    public boolean isAcceptableItem(ItemStack stack) {
        return module.enabled && (stack.getItem() instanceof ShearsItem || super.isAcceptableItem(stack));
    }
}