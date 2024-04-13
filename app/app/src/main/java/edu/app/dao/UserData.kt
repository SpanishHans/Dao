package edu.app.dao


// Se crea la información que va a ir en la base de datos
data class UserData(
    val id: String? = null,
    val nameFull: String? = null,
    val username: String? = null,
    val correo: String? = null,
    val password: String? = null
)
