package net.dimidium.dimidiumcore.api.item;


import net.dimidium.dimidiumcore.api.energy.EnergyAction;
import net.dimidium.dimidiumcore.api.energy.item.EnergyItemCapability;
import net.dimidium.dimidiumcore.api.energy.item.IItemFEStorage;
import net.minecraft.ChatFormatting;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.chat.Component;
import net.minecraft.util.Mth;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.Level;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.api.distmarker.OnlyIn;

import java.util.List;

public abstract class EnergyItemBase extends ItemBase implements IItemFEStorage
{
    private static final double MIN_FE = 1.0E-4D;

    private static final String CURRENT_FE_KEY = "currentFE";

    private static final String MAX_FE_KEY = "maxFE";

    private final double feCapacity;

    public EnergyItemBase(double feCapacity, int stackSize)
    {
        super(stackSize, false, false, false, true);
        this.feCapacity = feCapacity;
    }

    //todo below

    /*@OnlyIn(Dist.CLIENT)
    @Override
    public void appendHoverText(ItemStack stack, TooltipContext context, List<Component> lines, TooltipFlag advancedTooltips)
    {
        CompoundTag tag = stack.getTag();
        double currentFE = 0.0D;
        double maxFE = getMaxFE(stack);

        if (tag != null)
        {
            currentFE = tag.getDouble("currentFE");
        }

        lines.add(Component.literal("" + currentFE + "/" + maxFE + "FE").withStyle(ChatFormatting.DARK_AQUA));
    }*/

    /*@Override
    public int getBarWidth(ItemStack stack)
    {
        double filled = getCurrentFE(stack) / getMaxFE(stack);
        return Mth.clamp((int)(filled * 13.0D), 0, 13);
    }

    @Override
    public int getBarColor(ItemStack stack)
    {
        return Mth.hsvToRgb(0.33333334F, 1.0F, 1.0F);
    }

    @Override
    public double inputFE(ItemStack stack, double amount, EnergyAction mode)
    {
        double maxStorage = getMaxFE(stack);
        double currentStorage = getCurrentFE(stack);
        double required = maxStorage - currentStorage;
        double overflow = Math.max(0.0D, Math.min(amount - required, amount));

        if (mode == EnergyAction.EXECUTE)
        {
            double toAdd = Math.min(amount, required);
            setCurrentFE(stack, currentStorage + toAdd);
        }

        return overflow;
    }

    @Override
    public double extractFE(ItemStack stack, double amount, EnergyAction mode)
    {
        double currentStorage = getCurrentFE(stack);
        double fulfillable = Math.min(amount, currentStorage);

        if (mode == EnergyAction.EXECUTE)
        {
            setCurrentFE(stack, currentStorage - fulfillable);
        }

        return fulfillable;
    }

    public double getMaxFE(ItemStack stack)
    {
        CompoundTag tag = stack.getTag();

        if (tag != null && tag.contains("maxFE", 6))
        {
            return tag.getDouble("maxFE");
        }

        return this.feCapacity;
    }

    protected final void setMaxFE(ItemStack stack, double maxPower)
    {
        double defaultCapacity = this.feCapacity;

        if (Math.abs(maxPower - defaultCapacity) < 1.0E-4D)
        {
            stack.remove.removeTagKey("maxFE");
            maxPower = defaultCapacity;
        }

        else
        {
            stack.getOrCreateTag().putDouble("maxFE", maxPower);
        }

        double currentPower = getCurrentFE(stack);

        if (currentPower > maxPower)
        {
            setCurrentFE(stack, maxPower);
        }
    }

    @Override
    public double getCurrentFE(ItemStack is)
    {
        CompoundTag tag = is.getTag();
        if (tag != null)
            return tag.getDouble("currentFE");
        return 0.0D;
    }

    protected final void setCurrentFE(ItemStack stack, double power)
    {
        if (power < 1.0E-4D)
        {
            stack.removeTagKey("currentFE");
        }

        else
        {
            stack.getOrCreateTag().putDouble("currentFE", power);
        }
    }

    public ICapabilityProvider initCapabilities(ItemStack stack, CompoundTag nbt)
    {
        return new EnergyItemCapability(stack, this);
    }*/
}
