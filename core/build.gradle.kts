import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    kotlin("jvm")
}

dependencies {
    implementation(kotlin("stdlib"))
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-core:1.3.4")
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-jdk8:1.3.4")
}


tasks.withType<KotlinCompile>().all {
    kotlinOptions.freeCompilerArgs += "kotlin.time.ExperimentalTime"
}
