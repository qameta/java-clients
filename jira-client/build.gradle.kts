description = "Jira client"

dependencies {

}

tasks.named<Jar>("jar") {
    manifest {
        attributes(mapOf(
                "Automatic-Module-Name" to "io.qameta.clients.jira"
        ))
    }
}