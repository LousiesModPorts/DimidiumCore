package net.dimidium.dimidiumcore.api.util;

import com.mojang.serialization.Codec;
import net.minecraft.core.component.DataComponentType;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.codec.ByteBufCodecs;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.function.Consumer;

public class ComponentUtil
{
    private static final DeferredRegister<DataComponentType<?>> DATA_COMPONENT_TYPES = DeferredRegister
            .create(Registries.DATA_COMPONENT_TYPE, ModUtil.MOD_ID);

    public static final DataComponentType<Double> ENERGY_CAPACITY = register("energy_capacity",
            builder -> builder.persistent(Codec.DOUBLE).networkSynchronized(ByteBufCodecs.DOUBLE));

    public static final DataComponentType<Double> STORED_ENERGY = register("stored_energy",
            builder -> builder.persistent(Codec.DOUBLE).networkSynchronized(ByteBufCodecs.DOUBLE));

    private static <T>DataComponentType<T> register(String componentName, Consumer<DataComponentType.Builder<T>> consumer)
    {
        var builder = DataComponentType.<T>builder();
        consumer.accept(builder);
        var component = builder.build();
        DATA_COMPONENT_TYPES.register(componentName, () -> component);
        return component;
    }
}
