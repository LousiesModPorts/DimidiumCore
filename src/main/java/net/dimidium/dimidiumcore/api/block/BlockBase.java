package net.dimidium.dimidiumcore.api.block;

import net.minecraft.world.item.DyeColor;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.material.MapColor;

import java.util.function.ToIntFunction;

public class BlockBase extends Block
{
    private final String blockName;
    private final float hardness;
    private final float resistance;
    private final SoundType soundType;
    private final Class<? extends BlockBase> className;
    private final MapColor mapColor;
    private final DyeColor dyeColor;
    private final ToIntFunction<BlockState> lightLevel;
    private final boolean noDrops;
    private final boolean isLiquid;


    BlockBase(String blockName, float hardness, float resistance, SoundType soundType, Class<? extends BlockBase> className)
    {
        super(BlockBehaviour.Properties.of()
                .strength(hardness, resistance)
                .sound(soundType)
                .requiresCorrectToolForDrops()
        );

        this.blockName = blockName;
        this.hardness = hardness;
        this.resistance = resistance;
        this.soundType = soundType;
        this.className = className;
        this.mapColor = null;
        this.dyeColor = null;
        this.lightLevel = null;
        this.noDrops = false;
        this.isLiquid = false;
    }

    BlockBase(String blockName, MapColor mapColor, float hardness, float resistance, SoundType soundType, Class<? extends BlockBase> className)
    {
        super(BlockBehaviour.Properties.of()
                .mapColor(mapColor)
                .strength(hardness, resistance)
                .sound(soundType)
                .requiresCorrectToolForDrops()
        );

        this.blockName = blockName;
        this.mapColor = mapColor;
        this.hardness = hardness;
        this.resistance = resistance;
        this.soundType = soundType;
        this.className = className;
        this.dyeColor = null;
        this.lightLevel = null;
        this.noDrops = false;
        this.isLiquid = false;
    }

    BlockBase(String blockName, DyeColor dyeColor, float hardness, float resistance, SoundType soundType, Class<? extends BlockBase> className)
    {
        super(BlockBehaviour.Properties.of()
                .mapColor(dyeColor)
                .strength(hardness, resistance)
                .sound(soundType)
                .requiresCorrectToolForDrops()
        );

        this.blockName = blockName;
        this.dyeColor = dyeColor;
        this.hardness = hardness;
        this.resistance = resistance;
        this.soundType = soundType;
        this.className = className;
        this.mapColor = null;
        this.lightLevel = null;
        this.noDrops = false;
        this.isLiquid = false;
    }

    BlockBase(String blockName, float hardness, float resistance, SoundType soundType, ToIntFunction<BlockState> lightLevel, boolean noDrops, Class<? extends BlockBase> className)
    {
        super(BlockBehaviour.Properties.of()
                .strength(hardness, resistance)
                .sound(soundType)
                .lightLevel(lightLevel)
                .noLootTable()
        );

        this.blockName = blockName;
        this.hardness = hardness;
        this.resistance = resistance;
        this.soundType = soundType;
        this.lightLevel = lightLevel;
        this.noDrops = noDrops;
        this.className = className;
        this.mapColor = null;
        this.dyeColor = null;
        this.isLiquid = false;
    }

    BlockBase(String blockName, float hardness, float resistance, SoundType soundType, Class<? extends BlockBase> className, boolean noDrops, boolean isLiquid)
    {
        super(BlockBehaviour.Properties.of()
                .strength(hardness, resistance)
                .sound(soundType)
                .liquid()
                .noLootTable()
        );

        this.blockName = blockName;
        this.hardness = hardness;
        this.resistance = resistance;
        this.soundType = soundType;
        this.className = className;
        this.noDrops = noDrops;
        this.isLiquid = isLiquid;
        this.mapColor = null;
        this.dyeColor = null;
        this.lightLevel = null;
    }
}
