description = "Clients Commons"

dependencies {

}

tasks.named<Jar>("jar") {
    manifest {
        attributes(mapOf(
                "Automatic-Module-Name" to "io.qameta.clients.commons"
        ))
    }
}
