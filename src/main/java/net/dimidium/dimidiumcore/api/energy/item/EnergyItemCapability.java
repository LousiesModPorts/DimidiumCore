package net.dimidium.dimidiumcore.api.energy.item;

import net.dimidium.dimidiumcore.api.energy.EnergyAction;
import net.minecraft.world.item.ItemStack;
import net.neoforged.neoforge.energy.IEnergyStorage;

public class EnergyItemCapability implements IEnergyStorage
{
    private final ItemStack is;

    private final IItemFEStorage item;

    public EnergyItemCapability(ItemStack is, IItemFEStorage item)
    {
        this.is = is;
        this.item = item;
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
