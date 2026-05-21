package ua.bonfiremc.vatra

import net.minecraft.core.Holder
import net.minecraft.data.DataGenerator
import net.minecraft.world.effect.MobEffectInstance
import net.minecraft.world.food.FoodProperties
import net.minecraft.world.item.Item
import net.neoforged.bus.api.IEventBus
import net.neoforged.neoforge.registries.DeferredRegister
import ua.bonfiremc.vatra.builder.item.ItemBuilder

class VatraNeoForgeInstance(modId: String) : VatraInstance(modId) {
    val items: DeferredRegister.Items by lazy {
        DeferredRegister.createItems(modId)
    }

    fun register(bus: IEventBus) {
        items.register(bus)
    }

    override fun registerItem(constructor: (Item.Properties) -> Item, builder: ItemBuilder): Holder<Item> {
        return items.registerItem(builder.id, constructor, builder.properties())
    }

    override fun registerProviders(pack: DataGenerator.PackGenerator) {
        throw UnsupportedOperationException("i use fabric datagen btw")
    }

    override fun setFoodEffect(builder: FoodProperties.Builder, probability: Float, getter: () -> MobEffectInstance) {
        builder.effect(getter, probability)
    }
}