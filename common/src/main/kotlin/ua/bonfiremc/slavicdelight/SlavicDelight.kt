package ua.bonfiremc.slavicdelight

import net.minecraft.resources.ResourceLocation

object SlavicDelight {
    const val MOD_ID = "slavicdelight"

    fun initialize() {
        println("test")
    }

    fun id(path: String): ResourceLocation = ResourceLocation.fromNamespaceAndPath(MOD_ID, path)
}