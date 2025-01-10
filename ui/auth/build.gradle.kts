plugins {
    id("compose.mp")
    alias(libs.plugins.kotlinx.serialization)
}

kotlin {
    sourceSets.commonMain.dependencies {
        with(projects) {
            implementation(domain.authDomain)
            implementation(core.ui)
            implementation(core.utils)
        }

        with(libs.kotlinx) {
            implementation(coroutines.core)
        }

        implementation(libs.multiplatform.settings)
    }
}
