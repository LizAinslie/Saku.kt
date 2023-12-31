@file:Suppress("OPT_IN_IS_NOT_ENABLED")

import org.jetbrains.dokka.gradle.DokkaTask
import java.net.URL

plugins {
    kotlin("multiplatform")
    id("com.android.library")
    id("org.jetbrains.compose")
    id("org.jetbrains.dokka") version "1.8.20"
    `maven-publish`
}

version = rootProject.version

kotlin {
    android {
        publishLibraryVariants("release", "debug")
        publishLibraryVariantsGroupedByFlavor = true
    }

    jvm("desktop")

    listOf(
        iosX64(),
        iosArm64(),
        iosSimulatorArm64()
    ).forEach { iosTarget ->
        iosTarget.apply {
            binaries {
                framework {
                    baseName = "shared"
                    isStatic = true
                }
            }
        }
    }

    sourceSets {
        val commonMain by getting {
            dependencies {
                implementation(compose.runtime)
                implementation(compose.foundation)
                @OptIn(org.jetbrains.compose.ExperimentalComposeLibrary::class)
                implementation(compose.components.resources)
            }
        }
        val androidMain by getting {
            dependencies {
                api("androidx.activity:activity-compose:1.8.0")
                api("androidx.appcompat:appcompat:1.6.1")
                api("androidx.core:core-ktx:1.12.0")
            }
        }

        val iosMain by creating {
            dependsOn(commonMain)
        }
        val iosX64Main by getting {
            dependsOn(iosMain)
        }
        val iosArm64Main by getting {
            dependsOn(iosMain)
        }
        val iosSimulatorArm64Main by getting {
            dependsOn(iosMain)
        }
        
        val desktopMain by getting {
            dependsOn(commonMain)
            dependencies {
                implementation(compose.desktop.common)
            }
        }
    }

    // publish

    val publicationsFromMainHost =
        listOf(jvm("desktop"), android()).map { it.name } + "kotlinMultiplatform"

    publishing {
        repositories {
            maven {
                name = "GitHubPackages"
                url = uri("https://maven.pkg.github.com/LizAinslie/Saku.kt")
                credentials {
                    username = project.findProperty("gpr.user") as String? ?: System.getenv("USERNAME")
                    password = project.findProperty("gpr.key") as String? ?: System.getenv("TOKEN")
                }
            }
        }

        publications {
            matching { it.name in publicationsFromMainHost }.all {

                val targetPublication = this@all
                tasks.withType<AbstractPublishToMaven>()
                    .matching { it.publication == targetPublication }
                    .configureEach {
                        onlyIf { (System.getenv("BUILD_CROSS") ?: "true") == "true" }
                    }
            }
        }
    }
}

tasks.withType<DokkaTask>().configureEach {
    moduleName.set("Saku.kt")
    moduleVersion.set(project.version.toString())

    dokkaSourceSets.configureEach {
        // ..
        // source set configuration section
        // ..

        includes.from(project.files(), "README.md")
        samples.from(project.files(), "$projectDir/src/commonTest/kotlin/")

        sourceLink {
            localDirectory.set(projectDir.resolve("src"))
            remoteUrl.set(URL("https://github.com/lizainslie/Saku.kt/tree/main/lib/src"))
            remoteLineSuffix.set("#L")
        }
    }
}

android {
    compileSdk = 33
    namespace = "org.jetbrains.compose.demo.widgets.platform"
    sourceSets["main"].manifest.srcFile("src/androidMain/AndroidManifest.xml")
    sourceSets["main"].res.srcDirs(
        "src/commonMain/resources",
        "src/androidMain/resources"
    )
    sourceSets["main"].resources.srcDirs(
        "src/commonMain/resources",
        "src/androidMain/resources"
    )

    defaultConfig {
        minSdk = 26
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_11
        targetCompatibility = JavaVersion.VERSION_11
    }
    kotlin {
        jvmToolchain(11)
    }
}
