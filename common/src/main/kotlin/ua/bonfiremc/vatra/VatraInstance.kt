package ua.bonfiremc.vatra

import net.minecraft.core.Holder
import net.minecraft.data.DataGenerator
import net.minecraft.data.models.model.ModelTemplate
import net.minecraft.world.effect.MobEffectInstance
import net.minecraft.world.food.FoodProperties
import net.minecraft.world.item.Item
import ua.bonfiremc.vatra.builder.item.ItemBuilder

abstract class VatraInstance(val modId: String) {
    val langMap: MutableMap<String, String> = mutableMapOf()
    val itemModelMap: MutableMap<Holder<Item>, ModelTemplate> = mutableMapOf()

    fun item(id: String, constructor: (Item.Properties) -> Item = ::Item, properties: ItemBuilder.() -> Unit = {}): Holder<Item> {
        val builder: ItemBuilder = ItemBuilder(this, id, constructor).apply(properties)

        return builder.register()
    }

    abstract fun registerItem(constructor: (Item.Properties) -> Item, builder: ItemBuilder): Holder<Item>

    abstract fun registerProviders(pack: DataGenerator.PackGenerator)

    abstract fun setFoodEffect(builder: FoodProperties.Builder, probability: Float, getter: () -> MobEffectInstance)
}