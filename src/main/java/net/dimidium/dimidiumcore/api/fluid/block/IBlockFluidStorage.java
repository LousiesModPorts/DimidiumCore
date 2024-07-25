package net.dimidium.dimidiumcore.api.fluid.block;

import net.minecraft.world.item.ItemStack;
import net.neoforged.neoforge.fluids.capability.IFluidHandler;

public interface IBlockFluidStorage
{
    double inputFluid(ItemStack paramItemStack, double paramDouble, IFluidHandler.FluidAction paramEnergyAction);

    double extractFluid(ItemStack paramItemStack, double paramDouble, IFluidHandler.FluidAction paramEnergyAction);

    double getMaxFluid(ItemStack paramItemStack);

    double getCurrentFluid(ItemStack paramItemStack);

    double getMaxInput(ItemStack paramItemStack);

    double getMaxOutput(ItemStack paramItemStack);

    double extractFluid(ItemStack is, int maxOutput, IFluidHandler.FluidAction fluidAction);
}
