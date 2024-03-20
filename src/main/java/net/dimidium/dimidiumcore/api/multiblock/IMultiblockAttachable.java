package net.dimidium.dimidiumcore.api.multiblock;

import net.minecraft.world.level.block.entity.BlockEntity;

public interface IMultiblockAttachable
{
    void setMultiblock(AbstractMultiblock multiblock);

    BlockEntity controller();
    AbstractMultiblock multiblock();

    boolean canInvalidateCache();
}
