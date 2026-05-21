package ua.bonfiremc.vatra.builder.item

import net.minecraft.core.Holder
import net.minecraft.data.models.model.ModelTemplate
import net.minecraft.data.models.model.ModelTemplates
import net.minecraft.world.food.FoodProperties
import net.minecraft.world.item.Item
import ua.bonfiremc.vatra.VatraInstance
import ua.bonfiremc.vatra.builder.RegistrableBuilder

class ItemBuilder(override val vatra: VatraInstance, override val id: String, val constructor: (Item.Properties) -> Item) : RegistrableBuilder<Item> {
    var name: String = id.split("_").joinToString(" ") { part -> part.replaceFirstChar { it.uppercase() } }

    var model: ModelTemplate? = ModelTemplates.FLAT_ITEM

    var food: FoodProperties? = null
        private set

    fun food(properties: FoodProperties.Builder.() -> Unit) {
        food = FoodProperties.Builder().apply(properties).build()
    }

    fun properties(): Item.Properties {
        return Item.Properties().apply {
            if (food != null) {
                food(food!!)
            }
        }
    }

    override fun register(): Holder<Item> {
        vatra.langMap["item.${vatra.modId}.$id"] = name

        val item: Holder<Item> = vatra.registerItem(constructor, this)

        if (model != null) {
            vatra.itemModelMap[item] = model!!
        }

        return item
    }
}