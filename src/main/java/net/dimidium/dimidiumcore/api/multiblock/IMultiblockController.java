package net.dimidium.dimidiumcore.api.multiblock;

import net.minecraft.core.BlockPos;
import net.minecraft.world.level.block.entity.BlockEntity;

public interface IMultiblockController
{
    BlockEntity controllerBE();

    void clearStats();

    void addErroredBlock(BlockPos relative);
}
