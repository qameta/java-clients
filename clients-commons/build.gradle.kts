description = "Clients Commons"


dependencies {
    annotationProcessor("org.projectlombok:lombok")

    compile("com.squareup.okhttp3:okhttp")
    compile("com.squareup.retrofit2:converter-jackson")
    compile("com.squareup.retrofit2:retrofit")
    compile("commons-io:commons-io")
    compile("org.apache.commons:commons-lang3")

    compileOnly("org.projectlombok:lombok")
    compileOnly("com.google.code.findbugs:annotations")
    testCompile("org.apache.commons:commons-lang3")
    testCompile("com.google.testing.compile:compile-testing")
}

tasks.named<Jar>("jar") {
    manifest {
        attributes(mapOf(
                "Automatic-Module-Name" to "io.qameta.clients.commons"
        ))
    }
}
