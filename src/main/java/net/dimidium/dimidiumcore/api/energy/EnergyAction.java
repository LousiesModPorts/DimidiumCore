package net.dimidium.dimidiumcore.api.energy;

import net.neoforged.neoforge.fluids.capability.IFluidHandler;

public enum EnergyAction
{
    EXECUTE(IFluidHandler.FluidAction.EXECUTE),
    SIMULATE(IFluidHandler.FluidAction.SIMULATE);

    private final IFluidHandler.FluidAction fluidAction;

    EnergyAction(IFluidHandler.FluidAction fluidAction)
    {
        this.fluidAction = fluidAction;
    }

    public static EnergyAction of(IFluidHandler.FluidAction action)
    {
        switch (action)
        {
            default:
                throw new IncompatibleClassChangeError();

            case EXECUTE: case SIMULATE: break;
        }

        return SIMULATE;
    }

    public static EnergyAction shouldSimulate(boolean simulate)
    {
        return simulate ? SIMULATE : EXECUTE;
    }

    public IFluidHandler.FluidAction getAction()
    {
        return this.fluidAction;
    }

    public boolean shouldSimulate()
    {
        return (this == SIMULATE);
    }
}
