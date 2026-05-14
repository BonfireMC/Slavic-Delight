package ua.bonfiremc.vatra

import net.minecraft.core.Holder
import net.minecraft.data.DataGenerator
import net.minecraft.world.effect.MobEffectInstance
import net.minecraft.world.food.FoodProperties
import net.minecraft.world.item.Item
import ua.bonfiremc.vatra.item.ItemBuilder

interface VatraAdapter {
    fun createInstance(modId: String): VatraInstance = VatraInstance(modId, this)

    fun registerItem(vatra: VatraInstance, constructor: (Item.Properties) -> Item, builder: ItemBuilder): Holder<Item>

    fun registerProviders(vatra: VatraInstance, pack: DataGenerator.PackGenerator)

    fun setFoodEffect(builder: FoodProperties.Builder, probability: Float, getter: () -> MobEffectInstance)
}