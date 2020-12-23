// Top-level build file where you can add configuration options common to all sub-projects/modules.
buildscript {
    repositories {
        google()
        jcenter()
    }
    dependencies {
        classpath("com.android.tools.build:gradle:${Versions.buildGradleTool}")
        classpath(kotlin("gradle-plugin", version = Versions.kotlin))
        classpath("com.diffplug.spotless:spotless-plugin-gradle:${Versions.spotless}")
        // NOTE: Do not place your application dependencies here; they belong
        // in the individual module build.gradle files
    }
}

plugins {
    id("com.diffplug.gradle.spotless") version "3.27.1"
}

allprojects {
    repositories {
        google()
        jcenter()
    }
}

val ktlintVer = "0.36.0"
apply(plugin = "com.diffplug.gradle.spotless")
spotless {
    kotlin {
        target("**/*.kt")
        ktlint(ktlintVer).userData(
            mapOf("max_line_length" to "100", "disabled_rules" to "import-ordering")
        )
        trimTrailingWhitespace()
        indentWithSpaces()
        endWithNewline()
    }
    kotlinGradle {
        // same as kotlin, but for .gradle.kts files (defaults to '*.gradle.kts')
        target("**/*.gradle.kts")
        ktlint(ktlintVer)
    }
}
