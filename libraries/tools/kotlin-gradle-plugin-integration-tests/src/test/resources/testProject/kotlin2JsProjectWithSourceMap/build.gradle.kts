import org.jetbrains.kotlin.gradle.dsl.KotlinJsCompile
import org.jetbrains.kotlin.gradle.plugin.KotlinJsCompilerType
import org.jetbrains.kotlin.gradle.targets.js.ir.KotlinJsIrLink

plugins {
    kotlin("js")
}

repositories {
    mavenLocal()
    mavenCentral()
}

allprojects {
    apply(plugin = "org.jetbrains.kotlin.js")

    repositories {
        mavenLocal()
        mavenCentral()
    }
}

val useIrBackend = findProperty("kotlin.js.useIrBackend") == true

val backend = if (useIrBackend) {
    KotlinJsCompilerType.IR
} else {
    KotlinJsCompilerType.LEGACY
}

project("lib") {
    kotlin {
        js(backend) {
            browser()
        }
    }
}

project("app") {
    kotlin {
        js(backend) {
            browser()
            binaries.executable()
        }
        dependencies {
            implementation(project(":lib"))
        }
    }

    fun KotlinJsCompile.configureOutput() {
        kotlinOptions {
            outputFile = "${buildDir}/kotlin2js/main/app.js"
            sourceMap = true
            sourceMapEmbedSources = "never"
        }
    }

    if (useIrBackend) {
        tasks.named<KotlinJsIrLink>("compileProductionExecutableKotlinJs") {
            configureOutput()
        }
    } else {
        tasks.withType<KotlinJsCompile>() {
            configureOutput()
        }
    }
}
