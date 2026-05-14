// i'm fucking HATE neoforge

plugins {
    alias(libs.plugins.neoforged.moddev)
}

neoForge {
    version = libs.versions.neoforge.get()

    runs {
        create("client") {
            client()
            systemProperty("neoforge.enabledGameTestNamespaces", "slavicdelight")
        }

        create("server") {
            server()
            systemProperty("neoforge.enabledGameTestNamespaces", "slavicdelight")
        }
    }

    mods {
        register("slavicdelight") {
            sourceSet(sourceSets["main"])
            sourceSet(project(":common").sourceSets["main"])
        }
    }
}

repositories {
    maven("https://thedarkcolour.github.io/KotlinForForge")
}

dependencies {
    implementation(libs.kotlinforforge)
    implementation(libs.farmersdelight.neoforge)

    implementation(project(":common"))
}
