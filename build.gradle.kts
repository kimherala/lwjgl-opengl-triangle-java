plugins {
    id("java")
    id("com.gradleup.shadow") version "9.0.0-beta8"

}

group = "xyz.kimherala"
version = "0.0.1-SNAPSHOT"

val lwjglVersion = "3.4.0-SNAPSHOT"
val lwjglNatives = "natives-linux"

repositories {
    mavenCentral()
    maven("https://oss.sonatype.org/content/repositories/snapshots/")
}

dependencies {
    //testImplementation(platform("org.junit:junit-bom:5.10.0"))
    //testImplementation("org.junit.jupiter:junit-jupiter")
    implementation(platform("org.lwjgl:lwjgl-bom:$lwjglVersion"))

    implementation("org.lwjgl", "lwjgl")
    implementation("org.lwjgl", "lwjgl-assimp")
    implementation("org.lwjgl", "lwjgl-glfw")
    implementation("org.lwjgl", "lwjgl-openal")
    implementation("org.lwjgl", "lwjgl-opengl")
    implementation("org.lwjgl", "lwjgl-stb")
    runtimeOnly("org.lwjgl", "lwjgl", classifier = lwjglNatives)
    runtimeOnly("org.lwjgl", "lwjgl-assimp", classifier = lwjglNatives)
    runtimeOnly("org.lwjgl", "lwjgl-glfw", classifier = lwjglNatives)
    runtimeOnly("org.lwjgl", "lwjgl-openal", classifier = lwjglNatives)
    runtimeOnly("org.lwjgl", "lwjgl-opengl", classifier = lwjglNatives)
    runtimeOnly("org.lwjgl", "lwjgl-stb", classifier = lwjglNatives)
}

tasks.shadowJar {
    archiveClassifier.set("")  // optional: to avoid the default '-all' suffix
    archiveFileName.set("lwjgltesting.jar")
    minimize()
    manifest {
        attributes["Main-Class"] = "xyz.kimherala.lwjgltesting.Main"
    }
}

tasks.register("copyResources", Copy::class) {
    from("src/main/resources/") // Source directory
    into("build/resources/") // Destination directory
}

/*tasks.named("processResources").configure {
    //dependsOn("copyResources")
}*/


tasks.build {
    dependsOn(tasks.shadowJar)
}


/*
tasks.test {
    useJUnitPlatform()
}
*/