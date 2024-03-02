package net.dimidium.dimidiumcore.api.energy.item;

import net.dimidium.dimidiumcore.api.capabilities.Capabilities;
import net.dimidium.dimidiumcore.api.energy.EnergyAction;
import net.minecraft.core.Direction;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.capabilities.ICapabilityProvider;
import net.minecraftforge.common.util.LazyOptional;
import net.minecraftforge.energy.IEnergyStorage;

import javax.annotation.Nullable;

public class EnergyItemCapability implements ICapabilityProvider, IEnergyStorage
{
    private final ItemStack is;

    private final IItemFEStorage item;

    public EnergyItemCapability(ItemStack is, IItemFEStorage item)
    {
        this.is = is;
        this.item = item;
    }

    @SuppressWarnings("unchecked")
    @Override
    public <T> LazyOptional<T> getCapability(Capability<T> capability, @Nullable Direction facing)
    {
        if (capability == Capabilities.FORGE_ENERGY)
        {
            return (LazyOptional<T>) LazyOptional.of(() -> this);
        }

        return LazyOptional.empty();
    }

    @Override
    public int receiveEnergy(int maxReceive, boolean simulate)
    {
        double overflow = this.item.inputFE(this.is, maxReceive, simulate ? EnergyAction.SIMULATE : EnergyAction.EXECUTE);
        return maxReceive - (int)overflow;
    }

    @Override
    public int extractEnergy(int maxExtract, boolean simulate)
    {
        return 0;
    }

    @Override
    public int getEnergyStored()
    {
        return (int)this.item.getCurrentFE(this.is);
    }

    @Override
    public int getMaxEnergyStored()
    {
        return (int)this.item.getMaxFE(this.is);
    }

    @Override
    public boolean canExtract()
    {
        return false;
    }

    @Override
    public boolean canReceive()
    {
        return true;
    }
}
