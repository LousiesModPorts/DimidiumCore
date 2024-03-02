package net.dimidium.dimidiumcore.api.capabilities;

import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.capabilities.CapabilityManager;
import net.minecraftforge.common.capabilities.CapabilityToken;
import net.minecraftforge.energy.IEnergyStorage;
import net.minecraftforge.fluids.IFluidTank;
import net.minecraftforge.fluids.capability.IFluidHandlerItem;

public class Capabilities
{
    public static Capability<IEnergyStorage> FORGE_ENERGY = CapabilityManager.get(new CapabilityToken<IEnergyStorage>() {});
    public static Capability<IFluidTank> FLUID_BLOCK = CapabilityManager.get(new CapabilityToken<IFluidTank>() {});
    public static Capability<IFluidHandlerItem> FLUID_ITEM = CapabilityManager.get(new CapabilityToken<IFluidHandlerItem>() {});
}
