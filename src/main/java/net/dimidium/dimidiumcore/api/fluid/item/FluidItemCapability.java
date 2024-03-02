package net.dimidium.dimidiumcore.api.fluid.item;

import net.dimidium.dimidiumcore.api.capabilities.Capabilities;
import net.dimidium.dimidiumcore.api.fluid.block.IBlockFluidStorage;
import net.minecraft.core.Direction;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.capabilities.ICapabilityProvider;
import net.minecraftforge.common.util.LazyOptional;
import net.minecraftforge.fluids.FluidStack;
import net.minecraftforge.fluids.IFluidTank;
import net.minecraftforge.fluids.capability.IFluidHandler;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class FluidItemCapability implements ICapabilityProvider, IFluidTank
{
    private final FluidStack fluidStack;
    private final ItemStack is;

    private final IBlockFluidStorage block;
    private final int maxInput;
    private int maxOutput;

    public FluidItemCapability(FluidStack fluidStack, ItemStack is, IBlockFluidStorage block, int maxInput, int maxOutput)
    {
        this.fluidStack = fluidStack;
        this.is = is;
        this.block = block;
        this.maxInput = maxInput;
        this.maxOutput = maxOutput;
    }

    @Override
    @SuppressWarnings("unchecked")
    public @NotNull <T> LazyOptional<T> getCapability(@NotNull Capability<T> capability, @Nullable Direction direction)
    {
        if(capability == Capabilities.FLUID_BLOCK)
        {
            return (LazyOptional<T>) LazyOptional.of(() -> this);
        }

        return LazyOptional.empty();
    }

    @Override
    public @NotNull FluidStack getFluid()
    {
        return fluidStack;
    }

    @Override
    public int getFluidAmount()
    {
        return (int)this.block.getCurrentFluid(this.is);
    }

    @Override
    public int getCapacity()
    {
        return (int)this.block.getMaxFluid(this.is);
    }

    @Override
    public boolean isFluidValid(FluidStack newFluid)
    {
        return fluidStack.containsFluid(newFluid);
    }

    @Override
    public int fill(FluidStack fluidStack, IFluidHandler.FluidAction fluidAction)
    {
        double overflow = this.block.inputFluid(this.is, maxInput, IFluidHandler.FluidAction.EXECUTE);
        return maxInput - (int)overflow;
    }

    @Override
    public @NotNull FluidStack drain(int i, IFluidHandler.FluidAction fluidAction)
    {
        double overflow = this.block.extractFluid(this.is, maxOutput, IFluidHandler.FluidAction.EXECUTE);
        maxOutput = (int)overflow;
        return fluidStack;
    }

    @Override
    public @NotNull FluidStack drain(FluidStack fluidStack, IFluidHandler.FluidAction fluidAction)
    {
        double overflow = this.block.extractFluid(this.is, maxOutput, IFluidHandler.FluidAction.EXECUTE);
        maxOutput = (int)overflow;
        return fluidStack;
    }
}
