package net.dimidium.dimidiumcore.api.util;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.Vec3i;

public class BlockUtil extends BlockPos
{
    public final int origX;
    public final int origY;
    public final int origZ;

    public static BlockUtil of(BlockPos pos)
    {
        if(pos instanceof BlockUtil)
        {
            return (BlockUtil) pos;
        }

        return new BlockUtil(pos.getX(), pos.getY(), pos.getZ());
    }

    public BlockUtil(int x, int y, int z)
    {
        super(x, y, z);
        origX = x;
        origY = y;
        origZ = z;
    }

    public BlockUtil(Vec3i pos)
    {
        super(pos);
        origX = pos.getX();
        origY = pos.getY();
        origZ = pos.getZ();
    }

    public BlockUtil revert()
    {
        this.setX(origX);
        this.setY(origY);
        this.setZ(origZ);
        return this;
    }

    @Override
    public BlockUtil relative(Direction direction, int distance)
    {
        setX(getX()+direction.getStepX() * distance);
        setY(getY()+direction.getStepY() * distance);
        setZ(getZ()+direction.getStepZ() * distance);
        return this;
    }

    @Override
    public BlockUtil relative(Direction direction)
    {
        return relative(direction, 1);
    }

    @Override
    public BlockUtil offset(int x, int y, int z)
    {
        setX(getX()+x);
        setY(getY()+y);
        setZ(getZ()+z);
        return this;
    }

    public BlockUtil y(int y)
    {
        setY(y);
        return this;
    }

    public BlockUtil x(int x)
    {
        setX(x);
        return this;
    }

    public BlockUtil z(int z)
    {
        setZ(z);
        return this;
    }

    public BlockPos copy() 
    {
        return new BlockUtil(getX(), getY(), getZ());
    }
}
