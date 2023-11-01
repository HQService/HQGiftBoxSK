plugins {
    kotlin("jvm") version "1.7.21"
}

group = "kr.cosine.giftboxsk"
version = "1.0.0"

repositories {
    maven("https://maven.hqservice.kr/repository/maven-public/")
    maven("https://repo.skriptlang.org/releases")
}

dependencies {
    compileOnly("org.spigotmc", "spigot-api", "1.18.2-R0.1-SNAPSHOT")
    compileOnly("com.github.SkriptLang", "Skript", "2.7.1")

    compileOnly("kr.hqservice", "hqframework-bukkit-core", "1.0.1-SNAPSHOT") { exclude("org.spigotmc", "spigot-api") }
    compileOnly("kr.hqservice", "hqframework-bukkit-inventory", "1.0.1-SNAPSHOT") { exclude("org.spigotmc", "spigot-api") }
    compileOnly("kr.hqservice", "hqframework-bukkit-command", "1.0.1-SNAPSHOT") { exclude("org.spigotmc", "spigot-api") }
    compileOnly("kr.hqservice", "hqframework-bukkit-nms", "1.0.1-SNAPSHOT") { exclude("org.spigotmc", "spigot-api") }
    compileOnly("kr.hqservice", "hqgiftbox-api", "1.0.0")

    testImplementation(kotlin("test"))
    testImplementation(kotlin("reflect"))
}

tasks {
    test {
        useJUnitPlatform()
    }
    jar {
        archiveFileName.set("${rootProject.name}-${rootProject.version}.jar")
        destinationDirectory.set(file("D:\\서버\\1.19.4 - 개발\\plugins"))
    }
}