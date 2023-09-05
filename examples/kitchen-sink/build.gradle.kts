import org.jetbrains.compose.desktop.application.dsl.TargetFormat

plugins {
    kotlin("multiplatform")
    id("org.jetbrains.compose")
}

group = "dev.lizainslie.saku"
version = rootProject.version

repositories {
    google()
    mavenCentral()
    maven("https://maven.pkg.jetbrains.space/public/p/compose/dev")
}

kotlin {
    jvm {
        jvmToolchain(11)
        withJava()
    }

    sourceSets {
        val jvmMain by getting {
            dependencies {
                implementation(compose.desktop.currentOs)
                implementation("br.com.devsrsouza.compose.icons:feather:1.1.0")
                implementation(project(":lib"))
            }
        }
    }
}

compose.desktop {
    application {
        mainClass = "dev.lizainslie.saku.demo.MainKt"
        nativeDistributions {
            targetFormats(TargetFormat.Dmg, TargetFormat.Msi, TargetFormat.Deb)
            packageName = "SakuDemo"
            packageVersion = "1.0.0"
        }
    }
}
