package net.dimidium.dimidiumcore.api.fluid.item;

import net.minecraft.world.item.ItemStack;
import net.minecraftforge.common.capabilities.ICapabilityProvider;
import net.minecraftforge.fluids.capability.IFluidHandler;
import net.minecraftforge.fluids.capability.IFluidHandlerItem;

public interface IItemFluidStorage
{
    double inputFluid(ItemStack paramItemStack, double paramDouble, IFluidHandler.FluidAction paramEnergyAction);

    double extractFluid(ItemStack paramItemStack, double paramDouble, IFluidHandler.FluidAction paramEnergyAction);

    double getMaxFluid(ItemStack paramItemStack);

    double getCurrentFluid(ItemStack paramItemStack);

    double getMaxInput(ItemStack paramItemStack);

    double getMaxOutput(ItemStack paramItemStack);
}
