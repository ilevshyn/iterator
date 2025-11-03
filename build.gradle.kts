import org.gradle.internal.os.OperatingSystem

plugins {
    id("java")
    id("application")
    id("org.graalvm.buildtools.native") version "0.11.1"
}

group = "edu.io"
version = "1.0"

repositories {
    mavenCentral()
}

dependencies {
    testImplementation(platform("org.junit:junit-bom:5.10.0"))
    testImplementation("org.junit.jupiter:junit-jupiter")
    testRuntimeOnly("org.junit.platform:junit-platform-launcher")
}

tasks.test {
    useJUnitPlatform()
}

tasks.jar {
    manifest {
        attributes["Main-Class"] = "edu.io.Main"
    }
}

application {
    mainClass.set("edu.io.Main")

    applicationName = "itx"
}

tasks {
    jar {
        archiveBaseName.set("itx")
        archiveVersion.set("")
        archiveClassifier.set("")
    }
}

tasks.register<Exec>("packageApp") {
    dependsOn("installDist")

    commandLine(
        "jpackage",
        "--name", "itx",
        "--input", "$buildDir/install/itx/lib",
        "--main-jar", "itx.jar",
        "--main-class", "edu.io.Main",
        "--dest", "$buildDir/jpackage",
        "--type", "app-image"
    )
}
