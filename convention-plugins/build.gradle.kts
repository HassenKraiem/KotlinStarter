plugins {
    `kotlin-dsl`
}

dependencies {
    implementation(libs.gradlePlugin.android)
    implementation(libs.gradlePlugin.jetbrainsCompose)
    implementation(libs.gradlePlugin.kotlin)
    implementation(libs.gradlePlugin.composeCompiler)
    implementation(libs.gradlePlugin.ksp)
    implementation(libs.gradlePlugin.seriazliation)

    // hack to access version catalogue https://github.com/gradle/gradle/issues/15383
    compileOnly(files(libs.javaClass.superclass.protectionDomain.codeSource.location))
}
