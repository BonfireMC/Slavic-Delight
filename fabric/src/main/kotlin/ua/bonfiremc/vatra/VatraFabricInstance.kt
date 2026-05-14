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
import ua.bonfiremc.vatra.datagen.VatraFabricENUSProvider
import ua.bonfiremc.vatra.datagen.VatraFabricModelProvider
import ua.bonfiremc.vatra.item.ItemBuilder

class VatraFabricInstance(modId: String) : VatraInstance(modId) {
    override fun registerItem(vatra: VatraInstance, constructor: (Item.Properties) -> Item, builder: ItemBuilder): Holder<Item> {
        val item: Item = Registry.register(
            BuiltInRegistries.ITEM,
            ResourceLocation.fromNamespaceAndPath(vatra.modId, builder.id),
            constructor(builder.properties())
        )

        return Holder.direct(item)
    }

    override fun registerProviders(vatra: VatraInstance, pack: DataGenerator.PackGenerator) {
        if (pack !is FabricDataGenerator.Pack) return

        if (vatra.langMap.isNotEmpty()) {
            pack.addProvider { output, lookup -> VatraFabricENUSProvider(vatra, output, lookup) }
        }

        if (vatra.itemModelMap.isNotEmpty()) {
            pack.addProvider { output: FabricDataOutput -> VatraFabricModelProvider(vatra, output) }
        }
    }

    override fun setFoodEffect(builder: FoodProperties.Builder, probability: Float, getter: () -> MobEffectInstance) {
        builder.effect(getter(), probability)
    }
}