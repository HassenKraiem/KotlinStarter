import com.codingfeline.buildkonfig.compiler.FieldSpec
import com.codingfeline.buildkonfig.gradle.TargetConfigDsl
import java.io.FileInputStream
import java.io.InputStreamReader
import java.util.*

plugins {
    id("kotlin.mp")
    alias(libs.plugins.buildkonfig)
}

buildkonfig {
    packageName = "com.softylines.config"
    exposeObjectWithName = "BuildConfig"

    val properties = getLocalProperties()

    defaultConfigs {
        setFlavorConfig(
            flavor = BuildFlavor.Dev,
            properties = properties,
        )
    }

    defaultConfigs("staging") {
        setFlavorConfig(
            flavor = BuildFlavor.Staging,
            properties = properties,
        )
    }

    defaultConfigs("release") {
        setFlavorConfig(
            flavor = BuildFlavor.Release,
            properties = properties,
        )
    }
}

fun Project.getLocalProperties(file: String = "local.properties"): Properties {
    val properties = Properties()
    val localProperties = File(rootDir, file)

    if (localProperties.exists() && localProperties.isFile) {
        InputStreamReader(FileInputStream(localProperties), Charsets.UTF_8).use { reader ->
            properties.load(reader)
        }
    }

    return properties
}

fun TargetConfigDsl.setFlavorConfig(
    flavor: BuildFlavor,
    properties: Properties,
) {
    val flavorString = flavor.name.uppercase()

    buildConfigField(
        FieldSpec.Type.STRING,
        "buildFlavor",
        flavorString,
    )

    buildConfigField(
        FieldSpec.Type.STRING,
        "essntlBaseUrl",
        System.getenv("ESSNTL_BASE_URL_$flavorString")
            ?: properties.getProperty("ESSNTL_BASE_URL_$flavorString")
            ?: "https://be.essntl.app",
    )
}

enum class BuildFlavor {
    Dev,
    Staging,
    Release,
    Demo,
}