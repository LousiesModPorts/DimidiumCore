package net.dimidium.dimidiumcore.handler.registry;

import net.dimidium.dimidiumcore.api.util.ModUtil;
import net.dimidium.dimidiumcore.item.ExampleEnergyItem;
import net.minecraft.world.item.Item;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;

public class ItemRegistry
{
    private static final DeferredRegister.Items ITEMS = DeferredRegister.createItems(ModUtil.MOD_ID);

    private static final DeferredItem<Item> EXAMPLE_ENERGY_ITEM = ITEMS.register("example_energy_item", ExampleEnergyItem::new);

    public static void registerItems(IEventBus eventBus)
    {
        ITEMS.register(eventBus);
    }
}
