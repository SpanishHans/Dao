package edu.app.dao.funciones
/*
    Se está utilizando esta clase de GlobalData para poder acceder a los usuarios de la base de datos
    Lo que se está haciendo es que se guarda la identificación que tiene el usuario al momento de
    iniciar sesión, esto va en la variable idCurrent, esta variable se va a utilizar en muchos
    fragmentos debido a su gran utilidad para hacer la consulta de datos mucho más fácil
 */
object GlobalData {
    var idCurrent: String = ""
}