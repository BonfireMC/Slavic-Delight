package ua.bonfiremc.vatra.builder

import net.minecraft.core.Holder
import ua.bonfiremc.vatra.VatraInstance

interface RegistrableBuilder<T> {
    val vatra: VatraInstance

    val id: String

    fun register(): Holder<T>
}