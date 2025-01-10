import org.gradle.accessors.dm.*
import org.gradle.api.*
import org.gradle.kotlin.dsl.*
import org.jetbrains.kotlin.gradle.dsl.*
import org.jetbrains.kotlin.gradle.tasks.*

fun Project.koinSetup() {
    val libs = the<LibrariesForLibs>()

    extensions.configure<KotlinMultiplatformExtension> {
        sourceSets.commonMain {
            kotlin.srcDir("build/generated/ksp/metadata/commonMain/kotlin")
        }

        sourceSets.commonMain.dependencies {
            implementation(libs.koin.core)
            implementation(libs.koin.annotations)
        }
    }

    dependencies {
        add("kspCommonMainMetadata", libs.koin.ksp.compiler)
        add("kspAndroid", libs.koin.ksp.compiler)
        add("kspDesktop", libs.koin.ksp.compiler)
        add("kspIosX64", libs.koin.ksp.compiler)
        add("kspIosArm64", libs.koin.ksp.compiler)
        add("kspIosSimulatorArm64", libs.koin.ksp.compiler)
    }

    tasks.withType<KotlinCompilationTask<*>>().configureEach {
        if (name != "kspCommonMainKotlinMetadata") {
            dependsOn("kspCommonMainKotlinMetadata")
        }
    }
}