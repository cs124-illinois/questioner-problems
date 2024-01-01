import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
  kotlin("jvm") version "1.9.22"
  checkstyle
  id("com.github.sherter.google-java-format") version "0.9"
  id("org.jmailen.kotlinter") version "4.1.1"
  id("org.cs124.questioner") version "2024.1.0"
  id("com.github.ben-manes.versions") version "0.50.0"
  id("io.gitlab.arturbosch.detekt") version "1.23.4"
}
repositories {
  mavenLocal()
  mavenCentral()
  maven("https://maven.codeawakening.com")
}
tasks.withType<Test> {
  useJUnitPlatform()
  enableAssertions = true
  environment["JEED_USE_CACHE"] = "true"
  jvmArgs(
    "-ea", "--enable-preview", "-Xmx4G", "-XX:+UseZGC",
    "-Dfile.encoding=UTF-8", "-XX:-OmitStackTraceInFastThrow",
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
  toolVersion = "1.18.1"
}
checkstyle {
  toolVersion = "10.12.6"
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
  dependsOn("detekt", "checkstyleMain", "googleJavaFormat", "lintKotlinMain")
}
tasks.getByName("saveQuestions") {
  mustRunAfter("detekt", "checkstyleMain", "googleJavaFormat", "lintKotlinMain")
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
java {
  toolchain {
    languageVersion.set(JavaLanguageVersion.of(17))
  }
}
configurations.checkstyle {
  resolutionStrategy.capabilitiesResolution.withCapability("com.google.collections:google-collections") {
    select("com.google.guava:guava:0")
  }
}