description = "Kotlin Scripting Compiler JS Plugin"

plugins {
    kotlin("jvm")
    id("jps-compatible")
}

dependencies {
    compileOnly(project(":compiler:frontend"))
    compileOnly(project(":compiler:psi"))
    compileOnly(project(":compiler:plugin-api"))
    compileOnly(project(":compiler:cli"))
    compileOnly(project(":compiler:backend.js"))
    compileOnly(project(":core:descriptors.runtime"))
    compileOnly(project(":compiler:ir.tree.impl"))
    compileOnly(project(":kotlin-reflect-api"))
    api(project(":kotlin-scripting-common"))
    api(project(":kotlin-scripting-js"))
    api(project(":kotlin-util-klib"))
    api(project(":kotlin-scripting-compiler"))
    api(kotlinStdlib())
    compileOnly(intellijCore())

    testApi(project(":compiler:frontend"))
    testApi(project(":compiler:plugin-api"))
    testApi(project(":compiler:util"))
    testApi(project(":compiler:cli"))
    testApi(project(":compiler:cli-common"))
    testApi(project(":compiler:backend.js"))
    testApi(projectTests(":compiler:tests-common"))
    testApi(commonDependency("junit:junit"))

    testImplementation(intellijCore())
}

sourceSets {
    "main" { projectDefault() }
    "test" { projectDefault() }
}

tasks.withType<org.jetbrains.kotlin.gradle.dsl.KotlinCompile<*>> {
    kotlinOptions {
        freeCompilerArgs = freeCompilerArgs - "-progressive" + "-Xskip-metadata-version-check"
    }
}

publish()

runtimeJar()
sourcesJar()
javadocJar()

testsJar()