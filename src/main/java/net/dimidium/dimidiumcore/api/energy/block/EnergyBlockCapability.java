package net.dimidium.dimidiumcore.api.energy.block;

import net.dimidium.dimidiumcore.api.energy.EnergyAction;
import net.minecraft.world.item.ItemStack;
import net.neoforged.neoforge.energy.IEnergyStorage;

public class EnergyBlockCapability implements IEnergyStorage
{
    private final ItemStack is;

    private final IBlockFEStorage block;

    public EnergyBlockCapability(ItemStack is, IBlockFEStorage block)
    {
        this.is = is;
        this.block = block;
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
