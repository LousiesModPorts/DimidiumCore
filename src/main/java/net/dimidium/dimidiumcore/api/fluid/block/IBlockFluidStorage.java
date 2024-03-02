package net.dimidium.dimidiumcore.api.fluid.block;

import net.minecraft.world.item.ItemStack;
import net.minecraftforge.fluids.capability.IFluidHandler;

public interface IBlockFluidStorage
{
    double inputFluid(ItemStack paramItemStack, double paramDouble, IFluidHandler.FluidAction paramEnergyAction);

    double extractFluid(ItemStack paramItemStack, double paramDouble, IFluidHandler.FluidAction paramEnergyAction);

    double getMaxFluid(ItemStack paramItemStack);

    double getCurrentFluid(ItemStack paramItemStack);

    double getMaxInput(ItemStack paramItemStack);

    double getMaxOutput(ItemStack paramItemStack);
}
