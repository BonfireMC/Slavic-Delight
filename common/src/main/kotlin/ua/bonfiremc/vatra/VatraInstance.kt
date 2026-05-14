package ua.bonfiremc.vatra

import net.minecraft.core.Holder
import net.minecraft.data.DataGenerator
import net.minecraft.data.models.model.ModelTemplate
import net.minecraft.world.item.Item
import ua.bonfiremc.vatra.item.ItemBuilder

open class VatraInstance(val modId: String, val adapter: VatraAdapter) {
    val langMap: MutableMap<String, String> = mutableMapOf()
    val itemModelMap: MutableMap<Holder<Item>, ModelTemplate> = mutableMapOf()

    fun item(id: String, constructor: (Item.Properties) -> Item = ::Item, properties: ItemBuilder.() -> Unit = {}): Holder<Item> {
        val builder: ItemBuilder = ItemBuilder(id).apply(properties)
        val item: Holder<Item> = adapter.registerItem(this, constructor, builder)

        langMap["item.${modId}.${builder.id}"] = builder.name

        if (builder.model != null) {
            itemModelMap[item] = builder.model!!
        }

        return item
    }

    fun addLang(key: String, value: String) {
        langMap[key] = value
    }

    fun addProviders(pack: DataGenerator.PackGenerator) {
        adapter.registerProviders(this, pack)
    }
}