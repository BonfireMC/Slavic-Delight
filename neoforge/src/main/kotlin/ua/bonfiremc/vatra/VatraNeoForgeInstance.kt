package ua.bonfiremc.vatra

import net.neoforged.neoforge.registries.DeferredRegister

class VatraNeoForgeInstance(modId: String) : VatraInstance(modId, VatraNeoForgeAdapter) {
    val items: DeferredRegister.Items by lazy {
        DeferredRegister.createItems(modId)
    }
}