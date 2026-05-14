package ua.bonfiremc.vatra

import net.minecraft.core.Holder
import net.minecraft.data.DataGenerator
import net.minecraft.world.effect.MobEffectInstance
import net.minecraft.world.food.FoodProperties
import net.minecraft.world.item.Item
import ua.bonfiremc.vatra.item.ItemBuilder

object VatraNeoForgeAdapter : VatraAdapter {
    override fun createInstance(modId: String): VatraInstance = VatraNeoForgeInstance(modId)

    override fun registerItem(vatra: VatraInstance, constructor: (Item.Properties) -> Item, builder: ItemBuilder): Holder<Item> {
        if (vatra !is VatraNeoForgeInstance) throw IllegalArgumentException()

        return vatra.items.registerItem(builder.id, constructor, builder.properties())
    }

    override fun registerProviders(vatra: VatraInstance, pack: DataGenerator.PackGenerator) {
        throw UnsupportedOperationException("i use fabric datagen btw")
    }

    override fun setFoodEffect(builder: FoodProperties.Builder, probability: Float, getter: () -> MobEffectInstance) {
        builder.effect(getter, probability)
    }
}