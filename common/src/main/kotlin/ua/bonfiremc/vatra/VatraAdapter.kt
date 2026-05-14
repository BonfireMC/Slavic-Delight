package ua.bonfiremc.vatra

import net.minecraft.core.Holder
import net.minecraft.data.DataGenerator
import net.minecraft.world.item.Item
import ua.bonfiremc.vatra.item.ItemBuilder

interface VatraAdapter {
    fun registerItem(vatra: VatraInstance, constructor: (Item.Properties) -> Item, builder: ItemBuilder): Holder<Item>

    fun registerProviders(vatra: VatraInstance, pack: DataGenerator.PackGenerator)
}