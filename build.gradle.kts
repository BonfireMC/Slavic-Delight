@file:Suppress("AvoidApplyPluginMethod")

import org.gradle.internal.extensions.stdlib.capitalized

plugins {
    alias(libs.plugins.kotlin)
}

val modVersion: String = "1.0.0"

allprojects {
    apply(plugin = "org.jetbrains.kotlin.jvm")

    version = "$modVersion+${rootProject.libs.versions.minecraft.get()}"
    group = "ua.bonfiremc"

    base {
        archivesName = "SlavicDelight-${project.name.capitalized()}"
    }

    repositories {
        mavenCentral()
    }

    java {
        sourceCompatibility = JavaVersion.VERSION_21
        targetCompatibility = JavaVersion.VERSION_21

        withSourcesJar()
    }
}

subprojects {
    tasks {
        processResources {
            val minecraftVersion: String = libs.versions.minecraft.get()
            val neoforgeVersion: String = libs.versions.neoforge.get()

            inputs.property("version", version)
            inputs.property("minecraft_version", minecraftVersion)
            inputs.property("neoforge_version", neoforgeVersion)

            filesMatching(setOf("fabric.mod.json", "META-INF/neoforge.mods.toml")) {
                expand(
                    "version" to version,
                    "minecraft_version" to minecraftVersion,
                    "neoforge_version" to neoforgeVersion
                )
            }
        }

        jar {
            from(rootProject.file("LICENSE"))
        }
    }
}
