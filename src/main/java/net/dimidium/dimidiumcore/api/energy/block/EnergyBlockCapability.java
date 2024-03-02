package net.dimidium.dimidiumcore.api.energy.block;

import net.dimidium.dimidiumcore.api.capabilities.Capabilities;
import net.dimidium.dimidiumcore.api.energy.EnergyAction;
import net.minecraft.core.Direction;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.capabilities.ICapabilityProvider;
import net.minecraftforge.common.util.LazyOptional;
import net.minecraftforge.energy.IEnergyStorage;

import javax.annotation.Nullable;

public class EnergyBlockCapability implements ICapabilityProvider, IEnergyStorage
{
    private final ItemStack is;

    private final IBlockFEStorage block;

    public EnergyBlockCapability(ItemStack is, IBlockFEStorage block)
    {
        this.is = is;
        this.block = block;
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
        double overflow = this.block.inputFE(this.is, maxReceive, simulate ? EnergyAction.SIMULATE : EnergyAction.EXECUTE);
        return maxReceive - (int)overflow;
    }

    @Override
    public int extractEnergy(int maxExtract, boolean simulate)
    {
        double overflow = this.block.extractFE(this.is, maxExtract, simulate ? EnergyAction.SIMULATE : EnergyAction.EXECUTE);
        return maxExtract = (int)overflow;
    }

    @Override
    public int getEnergyStored()
    {
        return (int)this.block.getCurrentFE(this.is);
    }

    @Override
    public int getMaxEnergyStored()
    {
        return (int)this.block.getMaxFE(this.is);
    }

    @Override
    public boolean canExtract()
    {
        return true;
    }

    @Override
    public boolean canReceive()
    {
        return true;
    }
}
