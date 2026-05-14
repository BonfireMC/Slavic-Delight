package ua.bonfiremc.vatra.item

import net.minecraft.data.models.model.ModelTemplate
import net.minecraft.data.models.model.ModelTemplates
import net.minecraft.world.food.FoodProperties

class ItemBuilder(val id: String) {
    var name: String = id.split("_").joinToString(" ") { part -> part.replaceFirstChar { it.uppercase() } }

    var model: ModelTemplate? = ModelTemplates.FLAT_ITEM

    var food: FoodProperties? = null
        private set

    fun food(properties: FoodProperties.Builder.() -> Unit) {
        food = FoodProperties.Builder().apply(properties).build()
    }
}