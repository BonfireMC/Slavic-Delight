plugins {
    alias(libs.plugins.neoforged.moddev)
}

neoForge {
    version = libs.versions.neoforge.get()

    runs {
        create("client") {
            client()
        }

        create("server") {
            server()
        }
    }
}

repositories {
    maven("https://thedarkcolour.github.io/KotlinForForge")
    maven("https://api.modrinth.com/maven")
}

dependencies {
    implementation(libs.kotlinforforge)
    implementation(libs.farmersdelight.neoforge)

    implementation(project(":common"))
}

tasks {
    jar {
        from(project(":common").sourceSets.main.get().output)
    }
}