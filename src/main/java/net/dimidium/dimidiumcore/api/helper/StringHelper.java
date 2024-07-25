package net.dimidium.dimidiumcore.api.helper;

import net.minecraft.ChatFormatting;
import net.minecraft.client.resources.language.I18n;
import net.minecraft.network.chat.MutableComponent;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.material.Fluid;
import net.neoforged.neoforge.fluids.FluidStack;

public class StringHelper
{
    public static ResourceLocation location(String modId)
    {
        return ResourceLocation.parse(modId);
    }

    public static ResourceLocation modLocation(String modId, String path)
    {
        return ResourceLocation.fromNamespaceAndPath(modId, path);
    }

    public static ResourceLocation forgeLocation(String path)
    {
        return ResourceLocation.fromNamespaceAndPath("forge", path);
    }

    public static MutableComponent getFluidName(FluidStack stack)
    {
        Fluid fluid = stack.getFluid();
        MutableComponent name = fluid.getFluidType().getDescription(stack).copy();

        switch (fluid.getFluidType().getRarity(stack))
        {
            case UNCOMMON -> name.withStyle(ChatFormatting.GREEN);
            case RARE -> name.withStyle(ChatFormatting.BLUE);
            case EPIC -> name.withStyle(ChatFormatting.LIGHT_PURPLE);
        }
        return name;
    }

    //todo below

   /* public static MutableComponent getItemName(ItemStack stack)
    {

        Item item = stack.getItem();
        MutableComponent name = item.getName(stack).copy();

        switch (item.getRarity(stack))
        {
            case UNCOMMON -> name.withStyle(ChatFormatting.GREEN);
            case RARE -> name.withStyle(ChatFormatting.BLUE);
            case EPIC -> name.withStyle(ChatFormatting.LIGHT_PURPLE);
        }

        return name;
    }
*/
    public static String[] decompose(String resourceLoc, char delimiter)
    {
        return decompose("minecraft", resourceLoc, delimiter);
    }

    public static String[] decompose(String modid, String resourceLoc, char delimiter)
    {
        String[] decomposed = new String[]{modid, resourceLoc};
        int delIndex = resourceLoc.indexOf(delimiter);

        if (delIndex >= 0)
        {
            decomposed[1] = resourceLoc.substring(delIndex + 1);
            if (delIndex >= 1)
            {
                decomposed[0] = resourceLoc.substring(0, delIndex);
            }
        }

        return decomposed;
    }
}
