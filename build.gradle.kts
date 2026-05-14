@file:Suppress("AvoidApplyPluginMethod")

// TODO: clean this bullshit

import org.gradle.internal.extensions.stdlib.capitalized

plugins {
    alias(libs.plugins.kotlin)
}

val modVersion: String = "1.0.0"

allprojects {
    apply(plugin = "org.jetbrains.kotlin.jvm")

    version = "${rootProject.libs.versions.minecraft.get()}-$modVersion"
    group = "ua.bonfiremc"

    repositories {
        mavenCentral()
        maven("https://api.modrinth.com/maven")
    }

    java {
        sourceCompatibility = JavaVersion.VERSION_21
        targetCompatibility = JavaVersion.VERSION_21
    }

    kotlin {
        jvmToolchain(21)
    }
}

subprojects {
    base {
        archivesName = "SlavicDelight-${project.name.capitalized()}"
    }

    tasks {
        processResources {
            val minecraftVersion: String = libs.versions.minecraft.get()
            val neoforgeVersion: String = libs.versions.neoforge.get()

            inputs.property("version", modVersion)
            inputs.property("minecraft_version", minecraftVersion)
            inputs.property("neoforge_version", neoforgeVersion)

            filesMatching(setOf("fabric.mod.json", "META-INF/neoforge.mods.toml")) {
                expand(
                    "version" to modVersion,
                    "minecraft_version" to minecraftVersion,
                    "neoforge_version" to neoforgeVersion
                )
            }
        }

        jar {
            from(rootProject.file("LICENSE"))
        }
    }

    if (project.name != "common") {
        tasks {
            jar {
                from(project(":common").sourceSets.main.get().output)
                from(project(":common").file("src/generated/resources")) {
                    exclude(".cache")
                }

                duplicatesStrategy = DuplicatesStrategy.EXCLUDE
            }

            processResources {
                from(project(":common").sourceSets.main.get().resources)
            }
        }
    }
}
