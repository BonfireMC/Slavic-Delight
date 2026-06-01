package ua.bonfiremc.slavicdelight.world.item

import net.minecraft.core.Holder
import net.minecraft.world.item.Item
import net.minecraft.world.item.Items
import ua.bonfiremc.slavicdelight.SlavicDelight.SD_VATRA
import vectorwing.farmersdelight.common.FoodValues
import vectorwing.farmersdelight.common.item.ConsumableItem

object SDItems {
    private val CONSUMABLE_ITEM: (Item.Properties) -> Item = { props -> ConsumableItem(props, true) }

    val BANOSH: Holder<Item> = SD_VATRA.item("banosh", CONSUMABLE_ITEM)
    val BOHRACH: Holder<Item> = SD_VATRA.item("bohrach", CONSUMABLE_ITEM)
    val BORSHCH: Holder<Item> = SD_VATRA.item("borshch", CONSUMABLE_ITEM) {
        food {
            nutrition(8)
            saturationModifier(0.5f)
            usingConvertsTo(Items.BOWL)

            SD_VATRA.setFoodEffect(this, 1f) { FoodValues.nourishment(1200) }
        }
    }
    val SOUR_CREAM: Holder<Item> = SD_VATRA.item("sour_cream", CONSUMABLE_ITEM)

    fun touch() {

    }
}