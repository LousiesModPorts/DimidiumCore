package net.dimidium.dimidiumcore.api.item;

import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.enchantment.Enchantment;

public class ItemBase extends Item
{

    private int stackSize;
    private boolean canEnchant;
    private boolean canEnchantTable;
    private  boolean canBookEnchant;
    private boolean isVisible;

    public ItemBase(int stackSize, boolean canEnchant, boolean canEnchantTable, boolean canBookEnchant, boolean isVisible)
    {
        super(new Item.Properties().stacksTo(stackSize));

        this.stackSize = stackSize;
        this.canEnchant = canEnchant;
        this.canEnchantTable = canEnchantTable;
        this.canBookEnchant = canBookEnchant;
        this.isVisible = isVisible;
    }

    @Override
    public boolean isEnchantable(ItemStack stack)
    {
        return canEnchant;
    }


    //todo below

    /*@Override
    public boolean canApplyAtEnchantingTable(ItemStack stack, Enchantment enchantment)
    {
        return canEnchantTable;
    }*/

    @Override
    public boolean isBookEnchantable(ItemStack itemstack1, ItemStack itemstack2)
    {
        return canBookEnchant;
    }

    @Override
    public boolean isBarVisible(ItemStack stack)
    {
        return isVisible;
    }
}
