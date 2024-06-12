/*
    This file is part of Dao

    Dao is free software: you can redistribute it and/or modify it under the terms of the
    GNU General Public License as published by the Free Software Foundation, either version 3 of
    the License, or any later version.

    Dao is distributed in the hope that it will be useful, but WITHOUT ANY WARRANTY;
    without even the implied warranty of MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See
    the GNU General Public License for more details.

    You should have received a copy of the GNU General Public License along with this program. If
    not, see <https://www.gnu.org/licenses/>.
 */
package edu.app.dao.fragments
/*
    Esta es la tabla UserData para la base de datos, pasos para correr la base de datos:
    1. En la pestaña de Tools en android studio, dar clic en la parte de Firebase
    2. En el menú desplegable dar clic en Realtime Database -> Get started with Realtime Database
    3. Connect to Firebase
    4. Cuando se esté en la web toca seguir los pasos intuitios que hay... Crear todo eso y más cosas
    5. Si se requiere de ver la base de datos, se recomienda ir a la opción de Realtime Database
    después de haber dado clic en el proyecto y ahí se pueden mirar los datos que se han registrado
 */

// Se crea la información que va a ir en la base de datos
data class UserData(
    val id: String? = null,
    val nameFull: String? = null,
    var username: String? = null,
    val correo: String? = null,
    val password: String? = null,
    var victoriasKong: Int = 0,
    var aciertosTao: Int = 0,
    var description: String? = ""
)
