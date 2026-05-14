package ua.bonfiremc.slavicdelight.world.item

import net.minecraft.core.Holder
import net.minecraft.world.item.Item
import net.minecraft.world.item.Items
import ua.bonfiremc.slavicdelight.SlavicDelight.SD_VATRA
import vectorwing.farmersdelight.common.FoodValues
import vectorwing.farmersdelight.common.item.ConsumableItem

object SDItems {
    val BORSHCH: Holder<Item> = SD_VATRA.item("borshch", { props -> ConsumableItem(props, true) }) {
        food {
            nutrition(8)
            saturationModifier(0.5f)
            usingConvertsTo(Items.BOWL)

            SD_VATRA.adapter.setFoodEffect(this, 1f) { FoodValues.nourishment(1200) }
        }
    }

    fun touch() {

    }
}