plugins {
    application
    kotlin("jvm")
}

application {
    mainClassName = "xyz.kektech.trading.example.MainKt"
}

dependencies {
    implementation(kotlin("stdlib"))

    implementation(project(":core"))
    implementation(project(":api:api-tinkoff"))
    implementation(project(":data:data-influx"))
}
