import org.jetbrains.kotlin.gradle.plugin.mpp.KotlinNativeTarget

plugins {
    id("compose.mp")
    id("koin")
}

kotlin {
    targets
        .filterIsInstance<KotlinNativeTarget>()
        .forEach { iosTarget ->
            iosTarget.binaries.framework {
                baseName = "Common"
                isStatic = true
                linkerOpts.add("-lsqlite3")
            }
        }

    sourceSets.commonMain.dependencies {
        with(projects) {
            with(core) {
                implementation(ui)
                implementation(network)
                implementation(database)
                implementation(utils)
            }

            with(ui) {
                implementation(authUi)
                implementation(userUi)
            }

            with(data) {
                implementation(authData)
                implementation(userData)
            }
        }

        with(libs.voyager) {
            implementation(koin)
            implementation(navigator)
            implementation(transitions)
        }
    }

    sourceSets.commonTest.dependencies {
        implementation(kotlin("test"))
    }

    sourceSets.androidMain.dependencies {
        implementation(libs.koin.android)
    }

    sourceSets.desktopTest.dependencies {
        implementation(libs.konsist)
    }

    sourceSets.iosMain.dependencies {
        implementation(libs.extras.stately)
    }
}