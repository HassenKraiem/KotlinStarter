plugins {
    id("compose.mp")
    alias(libs.plugins.kotlinx.serialization)
}

kotlin {
    sourceSets.commonMain.dependencies {
        with(projects) {
            implementation(domain.recipeDomain)
            implementation(core.ui)
            implementation(core.utils)
        }

        with(libs.kotlinx) {
            implementation(coroutines.core)
        }

        implementation(libs.multiplatform.settings)
        implementation(libs.coil)
        implementation(libs.coil3.coil.network.ktor3)
        implementation(libs.coil.compose)


    }
}