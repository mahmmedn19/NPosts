// Top-level build file where you can add configuration options common to all sub-projects/modules.
buildscript {
    repositories {
        google()
        mavenCentral()
    }
    dependencies {
        classpath ("androidx.navigation:navigation-safe-args-gradle-plugin:2.7.4")
    }
}
plugins {
    id("com.android.application") version "8.0.2" apply false
    id ("com.android.library") version "8.0.2" apply false
    id("org.jetbrains.kotlin.android") version "1.9.21" apply false
    id("com.google.dagger.hilt.android") version "2.48" apply false
}