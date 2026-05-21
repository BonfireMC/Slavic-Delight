package ua.bonfiremc.vatra

import net.fabricmc.fabric.api.datagen.v1.FabricDataGenerator
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput
import net.minecraft.core.Holder
import net.minecraft.core.Registry
import net.minecraft.core.registries.BuiltInRegistries
import net.minecraft.data.DataGenerator
import net.minecraft.resources.ResourceLocation
import net.minecraft.world.effect.MobEffectInstance
import net.minecraft.world.food.FoodProperties
import net.minecraft.world.item.Item
import ua.bonfiremc.vatra.builder.item.ItemBuilder
import ua.bonfiremc.vatra.datagen.VatraFabricENUSProvider
import ua.bonfiremc.vatra.datagen.VatraFabricModelProvider

class VatraFabricInstance(modId: String) : VatraInstance(modId) {
    override fun registerItem(constructor: (Item.Properties) -> Item, builder: ItemBuilder): Holder<Item> {
        val item: Item = Registry.register(
            BuiltInRegistries.ITEM,
            ResourceLocation.fromNamespaceAndPath(modId, builder.id),
            constructor(builder.properties())
        )

        return Holder.direct(item)
    }

    override fun registerProviders(pack: DataGenerator.PackGenerator) {
        if (pack !is FabricDataGenerator.Pack) return

        if (this.langMap.isNotEmpty()) {
            pack.addProvider { output, lookup -> VatraFabricENUSProvider(this, output, lookup) }
        }

        if (this.itemModelMap.isNotEmpty()) {
            pack.addProvider { output: FabricDataOutput -> VatraFabricModelProvider(this, output) }
        }
    }

    override fun setFoodEffect(builder: FoodProperties.Builder, probability: Float, getter: () -> MobEffectInstance) {
        builder.effect(getter(), probability)
    }
}