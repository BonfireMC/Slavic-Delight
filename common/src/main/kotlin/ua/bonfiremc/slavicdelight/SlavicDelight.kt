package ua.bonfiremc.slavicdelight

import net.minecraft.resources.ResourceLocation
import ua.bonfiremc.slavicdelight.world.item.SDItems
import ua.bonfiremc.vatra.VatraInstance

object SlavicDelight {
    const val MOD_ID = "slavicdelight"

    lateinit var SD_VATRA: VatraInstance

    fun <T : VatraInstance> initialize(instanceBuilder: (String) -> T): T {
        SD_VATRA = instanceBuilder(MOD_ID)

        SDItems.touch()

        @Suppress("UNCHECKED_CAST")
        return SD_VATRA as T
    }

    fun id(path: String): ResourceLocation = ResourceLocation.fromNamespaceAndPath(MOD_ID, path)
}