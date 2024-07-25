package net.dimidium.dimidiumcore.item;

import net.dimidium.dimidiumcore.api.item.EnergyItemBase;
import net.minecraft.world.item.ItemStack;

public class ExampleEnergyItem extends EnergyItemBase
{
    public ExampleEnergyItem()
    {
        super(10000D, 1);
    }

    @Override
    public double getMaxInput(ItemStack paramItemStack)
    {
        return 10D;
    }
}
