import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    id("org.springframework.boot") version "2.7.4"
    id("io.spring.dependency-management") version "1.0.14.RELEASE"
    kotlin("jvm") version "1.7.20"
    kotlin("plugin.spring") version "1.7.20"
    id("org.jetbrains.kotlin.plugin.jpa") version "1.7.20" apply false
}

allprojects {
    group = "com.stringconcat"
    version = "0.0.1-SNAPSHOT"

    repositories {
        mavenCentral()
        maven { url = uri("https://repo.spring.io/milestone") }
        maven { url = uri("https://repo.spring.io/snapshot") }
    }

    tasks.withType<KotlinCompile> {
        kotlinOptions {
            freeCompilerArgs = listOf("-Xjsr305=strict")
            jvmTarget = "1.8"
        }
    }

}

java.sourceCompatibility = JavaVersion.VERSION_1_8

dependencies {
    // spring modules
    implementation("org.springframework.boot:spring-boot-starter-webflux")
    implementation("org.springframework.boot:spring-boot-starter-data-jpa")
    implementation("org.springframework.boot:spring-boot-starter-data-rest")

    // kotlin
    implementation("org.jetbrains.kotlin:kotlin-reflect")
    implementation("org.jetbrains.kotlin:kotlin-stdlib-jdk8")

    implementation(project(":persistence"))
    implementation(project(":useCase"))
    implementation(project(":task"))
    implementation(project(":rest"))
    implementation(project(":neuralNetwork"))

    // dev tools
    developmentOnly("org.springframework.boot:spring-boot-devtools")

    // persistence
    runtimeOnly("com.h2database:h2")

    // tests
    testCompileOnly("org.junit.jupiter:junit-jupiter-api:5.9.1")
    testImplementation("org.springframework.boot:spring-boot-starter-test") {
        exclude(group = "org.junit.vintage", module = "junit-vintage-engine")
    }
    testImplementation("io.projectreactor:reactor-test")
}

tasks.test {
    useJUnitPlatform()
}