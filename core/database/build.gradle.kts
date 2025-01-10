plugins {
    id("kotlin.mp")
    id("com.google.devtools.ksp")
    alias(libs.plugins.sqldelight)
    alias(libs.plugins.room)
}

sqldelight {
    databases {
        create("Database") {
            packageName.set("database")
            schemaOutputDirectory = file("src/commonMain/sqldelight/database")
            deriveSchemaFromMigrations = true
            verifyMigrations = true
        }
    }
}

kotlin {
    sourceSets.commonMain.dependencies {
        implementation(libs.koin.core)

        implementation(libs.sqldelight.coroutinesExtensions)
        implementation(libs.sqldelight.primitiveAdapters)

        implementation(libs.androidx.room.runtime)
        implementation(libs.sqlite.bundled)
    }

    sourceSets.androidMain.dependencies {
        // SqlDelight
        implementation(libs.sqldelight.driver.android)
        // Koin
        implementation(libs.koin.android)
    }

    sourceSets.iosMain.dependencies {
        // SqlDelight
        implementation(libs.sqldelight.driver.native)
    }

    sourceSets.desktopMain.dependencies {
        // SqlDelight
        implementation(libs.sqldelight.sqliteDriver)
    }
}

dependencies {
    add("kspCommonMainMetadata", libs.androidx.room.compiler)
    add("kspAndroid", libs.androidx.room.compiler)
    add("kspDesktop", libs.androidx.room.compiler)
    add("kspIosX64", libs.androidx.room.compiler)
    add("kspIosArm64", libs.androidx.room.compiler)
    add("kspIosSimulatorArm64", libs.androidx.room.compiler)
}

room {
    schemaDirectory("$projectDir/schemas")
}