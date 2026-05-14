package ua.bonfiremc.slavicdelight

import net.minecraft.resources.ResourceLocation
import ua.bonfiremc.slavicdelight.world.item.SDItems
import ua.bonfiremc.vatra.VatraAdapter
import ua.bonfiremc.vatra.VatraInstance

object SlavicDelight {
    const val MOD_ID = "slavicdelight"

    lateinit var SD_VATRA: VatraInstance

    fun initialize(adapter: VatraAdapter) {
        SD_VATRA = adapter.createInstance(MOD_ID)

        SDItems.touch()
    }

    fun id(path: String): ResourceLocation = ResourceLocation.fromNamespaceAndPath(MOD_ID, path)
}