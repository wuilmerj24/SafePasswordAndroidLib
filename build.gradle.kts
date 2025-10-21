plugins {
    alias(libs.plugins.android.library)
    alias(libs.plugins.kotlin.android)

    id("maven-publish")
}

android {
    namespace = "wuilmerj24.dev.safepasswordandroidlib"
    compileSdk = 36

    defaultConfig {
        minSdk = 24

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        consumerProguardFiles("consumer-rules.pro")
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_11
        targetCompatibility = JavaVersion.VERSION_11
    }
    kotlinOptions {
        jvmTarget = "11"
    }
}

dependencies {
    implementation("net.java.dev.jna:jna:5.18.1@aar")
}

afterEvaluate {
    publishing{
        publications{
            register<MavenPublication>("release"){
                groupId = "wuilmerj24.dev"
                artifactId = "safepasswordandroidlib"
                version = "1.0.2"

                from(components["release"])

                pom {
                    name.set("Safe Password rust lib-android lib")
                    description.set("rust lib inside android lib")
                    url.set("https://github.com/wuilmerj24/SafePasswordAndroidLib.git")
                    licenses {
                        license {
                            name.set("Apache-2.0 license")
                            url.set("https://github.com/wuilmerj24/SafePasswordAndroidLib/blob/main/LICENSE")
                            distribution.set("repo")
                        }
                    }
                    developers {
                        developer {
                            id.set("Wuilmerj24")
                            name.set("Wuiler")
                        }
                    }

                    scm {
                        connection.set("scm:git:github.com/wuilmerj24/SafePasswordAndroidLib.git")
                        developerConnection.set("scm:git:ssh://github.com/wuilmerj24/SafePasswordAndroidLib.git")
                        url.set("https://github.com/wuilmerj24/SafePasswordAndroidLib.git")
                    }
                }
            }
        }
        repositories{
            maven  {
                name = "GitHubPackages"
                url =  uri("https://maven.pkg.github.com/wuilmerj24/SafePasswordAndroidLib")
                credentials{
                    username = project.findProperty("GITHUB_USER") as String? ?: System.getenv("GITHUB_USER")
                    password = project.findProperty("GITHUB_TOKEN") as String? ?: System.getenv("GITHUB_TOKEN")
                }
            }
        }
    }
}