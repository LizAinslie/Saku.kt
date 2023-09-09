import org.jetbrains.compose.desktop.application.dsl.TargetFormat

plugins {
    kotlin("jvm")
    id("org.jetbrains.compose")
}

group = "dev.lizainslie.saku.examples.editor"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
    maven("https://maven.pkg.jetbrains.space/public/p/compose/dev")
    google()
}

dependencies {
    implementation(compose.desktop.currentOs)

    implementation("br.com.devsrsouza.compose.icons:feather:1.1.0")
    implementation("ro.dragossusi:navigation:0.0.2")

    implementation(project(":lib"))
}

compose.desktop {
    application {
        mainClass = "dev.lizainslie.saku.examples.editor.MainKt"

        nativeDistributions {
            targetFormats(TargetFormat.Dmg, TargetFormat.Msi, TargetFormat.Deb)
            packageName = "Editor"
            packageVersion = "1.0.0"
        }
    }
}
