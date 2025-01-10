plugins {
    // this is necessary to avoid the plugins to be loaded multiple times
    // in each subproject's classloader
    alias(libs.plugins.androidApplication) apply false
    alias(libs.plugins.androidLibrary) apply false
    alias(libs.plugins.jetbrainsCompose) apply false
    alias(libs.plugins.compose.compiler) apply false
    alias(libs.plugins.kotlinAndroid) apply false
    alias(libs.plugins.ksp) apply false
    alias(libs.plugins.kotlinx.serialization) apply false
    alias(libs.plugins.kotlinJvm) apply false
    alias(libs.plugins.kotlinMultiplatform) apply false
    alias(libs.plugins.sqldelight) apply false
    alias(libs.plugins.buildkonfig) apply false
//    alias(libs.plugins.ktlint)
}

//val composeRules = libs.ktlint.compose.rules

//subprojects {
//    apply(plugin = "org.jlleitschuh.gradle.ktlint")
//
//    configure<org.jlleitschuh.gradle.ktlint.KtlintExtension> {
//        version.set("1.3.1")
//        debug.set(true)
//        verbose.set(true)
//        enableExperimentalRules.set(true)
//        outputToConsole.set(true)
//        outputColorName.set("RED")
//
//        filter {
//            exclude { element ->
//                element.file.path.contains("generated") ||
//                    element.file.path.contains("build")
//            }
//        }
//    }
//
//    dependencies {
//        ktlintRuleset(composeRules)
//    }
//}

tasks.register<Copy>("setUpGitHooks") {
    group = "help"
    from("$rootDir/.hooks")
    into("$rootDir/.git/hooks")
}
