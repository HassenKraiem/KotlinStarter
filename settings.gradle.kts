rootProject.name = "KotlinStarter"
enableFeaturePreview("TYPESAFE_PROJECT_ACCESSORS")
enableFeaturePreview("STABLE_CONFIGURATION_CACHE")

pluginManagement {
    includeBuild("convention-plugins")
    repositories {
        google {
            @Suppress("UnstableApiUsage")
            mavenContent {
                includeGroupAndSubgroups("androidx")
                includeGroupAndSubgroups("com.android")
                includeGroupAndSubgroups("com.google")
            }
        }
        mavenCentral()
        gradlePluginPortal()
    }
}

dependencyResolutionManagement {
    @Suppress("UnstableApiUsage")
    repositories {
        google {
            mavenContent {
                includeGroupAndSubgroups("androidx")
                includeGroupAndSubgroups("com.android")
                includeGroupAndSubgroups("com.google")
            }
        }
        mavenCentral()
    }
}

plugins {
    id("org.gradle.toolchains.foojay-resolver-convention") version "0.5.0"
}

// Executable apps
include(
    ":app:android",
    ":app:desktop",
    ":app:web",
    ":app:common",
)

// Core modules
include(
    ":core:ui",
    ":core:database",
    ":core:network",
    ":core:utils",
    ":core:config",
)

// Data modules
include(
    ":data:auth_data",
    ":data:user_data",
    ":data:recipe_data",
)

project(":data:auth_data").projectDir = file("data/auth")
project(":data:user_data").projectDir = file("data/user")
project(":data:recipe_data").projectDir = file("data/recipe")

// Domain module
include(
    ":domain:auth_domain",
    ":domain:user_domain",
    ":domain:recipe_domain",
    ":domain:recipe_details_domain"

)

project(":domain:auth_domain").projectDir = file("domain/auth")
project(":domain:user_domain").projectDir = file("domain/user")
project(":domain:recipe_domain").projectDir = file("domain/recipe")
project(":domain:recipe_details_domain").projectDir = file("domain/recipe_details")


// Feature modules
include(
    ":ui:auth_ui",
    ":ui:user_ui",
    ":ui:details_ui",
    ":ui:recipe_list_ui"
)

project(":ui:auth_ui").projectDir = file("ui/auth")
project(":ui:user_ui").projectDir = file("ui/user")
project(":ui:details_ui").projectDir = file("ui/details")
project(":ui:recipe_list_ui").projectDir = file("ui/recipe_list")

