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
}

dependencies {
    implementation(libs.kotlinforforge)

    implementation(project(":common"))
}

tasks {
    jar {
        from(project(":common").sourceSets.main.get().output)
    }
}