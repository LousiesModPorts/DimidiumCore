package net.dimidium.dimidiumcore.api.energy.item;

import net.dimidium.dimidiumcore.api.energy.EnergyAction;
import net.minecraft.world.item.ItemStack;

public interface IItemFEStorage
{
    double inputFE(ItemStack paramItemStack, double paramDouble, EnergyAction paramEnergyAction);

    double extractFE(ItemStack paramItemStack, double paramDouble, EnergyAction paramEnergyAction);

    double getMaxFE(ItemStack paramItemStack);

    double getCurrentFE(ItemStack paramItemStack);

    double getMaxInput(ItemStack paramItemStack);
}
