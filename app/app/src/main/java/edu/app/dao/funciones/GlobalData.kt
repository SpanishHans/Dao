/*
    Copyright (C) 2024 Alvarado Ludwig & Martinez Juan Jos�

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