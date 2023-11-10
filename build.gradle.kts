@file:Suppress("MagicNumber", "SpellCheckingInspection")

import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
  kotlin("jvm") version "1.9.20"
  checkstyle
  id("com.github.sherter.google-java-format") version "0.9"
  id("org.jmailen.kotlinter") version "4.0.0"
  id("com.github.cs124-illinois.questioner") version "2023.11.0"
  id("com.github.ben-manes.versions") version "0.49.0"
  id("io.gitlab.arturbosch.detekt") version "1.23.3"
}
repositories {
  mavenLocal()
  mavenCentral()
  maven("https://jitpack.io")
  maven("https://maven.codeawakening.com")
}
dependencies {
  implementation("com.github.cs124-illinois.questioner:lib:2023.11.0")
}
tasks.withType<Test> {
  useJUnitPlatform()
  enableAssertions = true
  jvmArgs(
    "-ea", "-Xms4G", "-Xmx8G", "--enable-preview", "-XX:+UseZGC",
    "-Dfile.encoding=UTF-8",
    "-XX:-OmitStackTraceInFastThrow",
    "--add-opens", "java.base/java.lang=ALL-UNNAMED",
    "--add-opens", "java.base/java.util=ALL-UNNAMED",
    "--add-exports", "jdk.compiler/com.sun.tools.javac.api=ALL-UNNAMED",
    "--add-exports", "jdk.compiler/com.sun.tools.javac.file=ALL-UNNAMED",
    "--add-exports", "jdk.compiler/com.sun.tools.javac.parser=ALL-UNNAMED",
    "--add-exports", "jdk.compiler/com.sun.tools.javac.tree=ALL-UNNAMED",
    "--add-exports", "jdk.compiler/com.sun.tools.javac.util=ALL-UNNAMED",
    "--add-exports", "java.management/sun.management=ALL-UNNAMED"
  )
}
googleJavaFormat {
  toolVersion = "1.15.0"
}
checkstyle {
  toolVersion = "10.12.4"
}
tasks.dependencyUpdates {
  fun String.isNonStable() = !(
    listOf("RELEASE", "FINAL", "GA", "JRE").any { uppercase().contains(it) }
      || "^[0-9,.v-]+(-r)?$".toRegex().matches(this)
    )
  rejectVersionIf { candidate.version.isNonStable() }
  gradleReleaseChannel = "current"
}
detekt {
  buildUponDefaultConfig = true
}
tasks.check {
  dependsOn("detekt", "checkstyleMain", "googleJavaFormat", "test")
}
questioner {
  seed = 124
  maxMutationCount = 256
}
tasks.withType<KotlinCompile> {
  kotlinOptions {
    jvmTarget = JavaVersion.VERSION_17.toString()
  }
}
tasks.detekt {
  dependsOn(tasks.generateQuestionMetatests)
}
java {
  toolchain {
    languageVersion.set(JavaLanguageVersion.of(17))
  }
}
