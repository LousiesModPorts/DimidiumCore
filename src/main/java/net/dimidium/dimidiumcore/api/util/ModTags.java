package net.dimidium.dimidiumcore.api.util;

import net.dimidium.dimidiumcore.api.helper.StringHelper;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.ItemTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;

public class ModTags
{
    public static class Blocks
    {
        private static TagKey<Block> tag(String name)
        {
            return BlockTags.create(StringHelper.modLocation(ModUtil.MOD_ID, name));
        }

        private static TagKey<Block> forgeTag(String name)
        {
            return BlockTags.create(StringHelper.forgeLocation(name));
        }
    }

    public static class Items
    {
        private static TagKey<Item>tag(String name)
        {
            return ItemTags.create(StringHelper.modLocation(ModUtil.MOD_ID, name));
        }
    }

    private static TagKey<Item> forgeTag(String name)
    {
        return ItemTags.create(StringHelper.forgeLocation(name));
    }
}
