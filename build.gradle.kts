import io.spring.gradle.dependencymanagement.dsl.DependencyManagementExtension
import org.gradle.jvm.tasks.Jar
import ru.vyarus.gradle.plugin.quality.QualityExtension

buildscript {
    repositories {
        maven("https://plugins.gradle.org/m2/")
        mavenLocal()
        jcenter()
    }

    dependencies {
        classpath("com.jfrog.bintray.gradle:gradle-bintray-plugin:1.8.4")
        classpath("gradle.plugin.com.github.spotbugs:spotbugs-gradle-plugin:1.6.5")
        classpath("io.spring.gradle:dependency-management-plugin:1.0.6.RELEASE")
        classpath("ru.vyarus:gradle-quality-plugin:3.2.0")
    }
}

val linkScmUrl by extra("https://github.com/qameta/java-clients")

val gradleScriptDir by extra("${rootProject.projectDir}/gradle")

tasks.existing(Wrapper::class) {
    gradleVersion = "4.10.2"
    distributionType = Wrapper.DistributionType.ALL
}

plugins {
    java
}

java {
    sourceCompatibility = JavaVersion.VERSION_1_8
    targetCompatibility = JavaVersion.VERSION_1_8
}

tasks.withType(JavaCompile::class) {
    options.encoding = "UTF-8"
}

configure(listOf(rootProject)) {
    description = "Java clients"

}

configure(subprojects) {
    val project = this
    group = "io.qameta.clients"
    version = version

    apply(plugin = "java")
    apply(plugin = "maven")
    apply(plugin = "io.spring.dependency-management")
    apply(plugin = "ru.vyarus.quality")

    configure<DependencyManagementExtension> {
        imports {
            mavenBom("com.fasterxml.jackson:jackson-bom:2.9.7")
            mavenBom("org.junit:junit-bom:5.3.1")
        }
        dependencies {
            dependency("com.google.testing.compile:compile-testing:0.15")
            dependency("com.squareup.okhttp3:okhttp:3.10.0")
            dependency("com.squareup.retrofit2:retrofit:2.4.0")
            dependency("commons-io:commons-io:2.6")
            dependency("org.apache.commons:commons-lang3:3.7")
        }
    }

    tasks.named<Jar>("jar") {
        manifest {
            attributes(mapOf(
                    "Implementation-Title" to project.name,
                    "Implementation-Version" to project.version
            ))
        }
    }

    tasks.named<Test>("test") {
        systemProperty("org.slf4j.simpleLogger.defaultLogLevel", "debug")
    }

    configure<QualityExtension> {
        configDir = "$gradleScriptDir/quality-configs"
        pmdVersion = "6.9.0"
    }

    val sourceSets = project.the<SourceSetContainer>()

    val sourceJar by tasks.creating(Jar::class) {
        from(sourceSets.getByName("main").allJava)
        classifier = "sources"
    }

    val javadocJar by tasks.creating(Jar::class) {
        from(tasks.getByName("javadoc"))
        classifier = "javadoc"
    }

    tasks.withType(Javadoc::class) {
        (options as StandardJavadocDocletOptions).addStringOption("Xdoclint:none", "-quiet")
    }

    artifacts.add("archives", sourceJar)
    artifacts.add("archives", javadocJar)

    repositories {
        jcenter()
        mavenLocal()
    }
}