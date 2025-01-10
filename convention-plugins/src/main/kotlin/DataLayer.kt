import org.gradle.accessors.dm.LibrariesForLibs
import org.gradle.api.Project
import org.gradle.kotlin.dsl.configure
import org.gradle.kotlin.dsl.the
import org.jetbrains.kotlin.gradle.dsl.KotlinMultiplatformExtension

fun Project.setupDataLayer() {
    val libs = the<LibrariesForLibs>()

    extensions.configure<KotlinMultiplatformExtension> {
        sourceSets.commonMain.dependencies {
            // Ktor Bundle
            implementation(libs.bundles.ktor)
        }
    }
}