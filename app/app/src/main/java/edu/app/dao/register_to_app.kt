/*
This program is free software: you can redistribute it and/or modify it under the terms of the
GNU General Public License as published by the Free Software Foundation, either version 3 of
the License, or any later version.

This program is distributed in the hope that it will be useful, but WITHOUT ANY WARRANTY;
without even the implied warranty of MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See
the GNU General Public License for more details.

You should have received a copy of the GNU General Public License along with this program. If
not, see <https://www.gnu.org/licenses/>.
 */
package edu.app.dao

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.activity.OnBackPressedCallback
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener
import edu.app.dao.databinding.RegisterBinding
import edu.app.dao.fragments.UserData
import edu.app.dao.funciones.isOnline


class RegisterToApp : AppCompatActivity() {
    /*
        Declaración del binding con el layout register
        El nombre RegisterToAppLayoutBinding sale del archivo .xml
        mencionado anteriormente y se genera automáticamente.
     */
    private lateinit var binding: RegisterBinding

    /*
    Aquí se declara las bases de datos, esto luego toca hacer un sync en el gradle para que se
    pueda utilizar la FirebaseDatabase junto con la otra variable
     */
    private lateinit var firebaseDataBase: FirebaseDatabase
    private lateinit var databaseReference: DatabaseReference

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Oculta la barra de arriba que se ve feísima
        supportActionBar?.hide()

        // Desactiva la opción de devolver en la aplicación
        onBackPressedDispatcher.addCallback(this, object : OnBackPressedCallback(true) {
            override fun handleOnBackPressed() {
            }
        })

        // Se utiliza el binding para inflar la vista y meterse como raiz
        binding = RegisterBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Se inicializan las variables para guardarse en la base de datos
        firebaseDataBase = FirebaseDatabase.getInstance()

        /*
            Usuarios es el nombre de tabla en la base de datos, entonces cuando se quiera llamar la
            base de datos, toca tener en cuenta el nombre Usuarios
         */
        databaseReference = firebaseDataBase.reference.child("Usuarios")


        /*
            Las siguientes líneas guardan en diferentes variables los datos del usuario al momento
            que se le da clic al botón de registrarse dentro de la aplicación.
            También se encargan de verificar que todos los campos estén llenos.
            En este caso se tienen cuatro variables; signupFullname, signupUsername, signupCorreo y
            signupPassword
         */
        binding.registerButtonRegistrarse.setOnClickListener {
            val signupFullname = binding.registerNombre.text.toString()
            val signupUsername = binding.registerUsuario.text.toString()
            val signupCorreo = binding.registerEmail.text.toString()
            val signupPassword = binding.registerPassword.text.toString()

            // Verifica la conección a internet del usuario e imprime un aviso en cano de que no esté conectado.
            if (!isOnline(this)) {
                Toast.makeText(this, "No estás conectado a internet!", Toast.LENGTH_SHORT).show()
            }

            // Si no están vacíos manda los valores a la función registrarUsuario, si no, salta un aviso.
            if (signupFullname.isNotEmpty() && signupUsername.isNotEmpty()
                && signupCorreo.isNotEmpty() && signupPassword.isNotEmpty()
            ) {
                registrarUsuario(signupFullname, signupUsername, signupCorreo, signupPassword)
            } else {
                Toast.makeText(
                    this@RegisterToApp,
                    "Todos los campos son obligatorios",
                    Toast.LENGTH_SHORT
                ).show()
            }
        }

        // Se dirige a la actividad de Login al momento de clickear en el botón correspondiente
        binding.botonDevolver.setOnClickListener {
            startActivity(Intent(this@RegisterToApp, WelcomeToApp::class.java))
            finish()
        }
    }


    // Función para registrar el usuario en la base de datos
    private fun registrarUsuario(
        nameFull: String,
        username: String,
        correo: String,
        password: String
    ) {
        /*
        Argumentos:
            nameFull: type -> String
            username: type -> String
            correo: type -> String
            password: type -> String
        ¿Qué hace?:
            1. Registra los datos de los usuarios que se pasaron como argumento y los registra dentro
                del firebase en la base de datos local. Después devuelve al usuario al WelcomeToApp
                y sale un mensaje en la pantalla de "Registro Exitoso!"
            2. Si los datos de los usuarios ya se encuentran registrados en la base de datos
                entonces va a salir un anuncio de "El usuario ya existe" en la pantalla del usuario.
            3. En caso de que ocurra algún error en la base de datos, este va a imprimir el error
         */

        databaseReference.orderByChild("nameFull").equalTo(nameFull)
            .addListenerForSingleValueEvent(object : ValueEventListener {
                override fun onDataChange(dataSnapshot: DataSnapshot) {
                    if (!dataSnapshot.exists()) {
                        val id = databaseReference.push().key
                        val userData = UserData(id, nameFull, username, correo, password)
                        databaseReference.child(id!!).setValue(userData)
                        Toast.makeText(this@RegisterToApp, "Registro Exitoso!", Toast.LENGTH_SHORT)
                            .show()
                        startActivity(Intent(this@RegisterToApp, WelcomeToApp::class.java))
                        finish()
                    } else {
                        Toast.makeText(
                            this@RegisterToApp,
                            "El usuario ya existe",
                            Toast.LENGTH_SHORT
                        ).show()

                    }
                }

                // Excepción de error en la base de datos
                override fun onCancelled(databaseError: DatabaseError) {
                    Toast.makeText(
                        this@RegisterToApp,
                        "Error en la base de datos: ${databaseError.message}",
                        Toast.LENGTH_SHORT
                    ).show()
                }
            })
    }
}