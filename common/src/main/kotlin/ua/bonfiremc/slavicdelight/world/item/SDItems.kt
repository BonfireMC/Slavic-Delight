package ua.bonfiremc.slavicdelight.world.item

import net.minecraft.core.Holder
import net.minecraft.world.item.Item
import net.minecraft.world.item.Items
import ua.bonfiremc.slavicdelight.SlavicDelight.SD_VATRA
import vectorwing.farmersdelight.common.FoodValues
import vectorwing.farmersdelight.common.item.ConsumableItem

object SDItems {
    private val CONSUMABLE_ITEM: (Item.Properties) -> Item = { props -> ConsumableItem(props, true) }

    val BORSHCH: Holder<Item> = SD_VATRA.item("borshch", CONSUMABLE_ITEM) {
        food {
            nutrition(8)
            saturationModifier(0.5f)
            usingConvertsTo(Items.BOWL)

            SD_VATRA.setFoodEffect(this, 1f) { FoodValues.nourishment(1200) }
        }
    }

    fun touch() {

    }
}