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
package edu.app.dao

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import android.net.ConnectivityManager
import android.net.NetworkCapabilities
import android.os.Build
import android.renderscript.Sampler.Value
import android.util.Log
import androidx.activity.OnBackPressedCallback

import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener
import com.google.firebase.database.getValue
import edu.app.dao.databinding.LoginBinding
import edu.app.dao.fragments.InicioPrincipal
import edu.app.dao.fragments.UserData
import edu.app.dao.funciones.GlobalData
import edu.app.dao.funciones.isOnline


class LoginToApp : AppCompatActivity() {
    /*
        Declaración del binding con el layout welcome
        El nombre WelcomeToAppLayoutBinding sale del archivo .xml
        mencionado anteriormente y se genera automáticamente.
     */
    private lateinit var binding: LoginBinding

    /*
    Aquí se declara las bases de datos, esto luego toca hacer un sync en el gradle para que se
    pueda utilizar la FirebaseDatabase junto con la otra variable
     */
    private lateinit var firebaseDatabase: FirebaseDatabase
    private lateinit var databaseReference: DatabaseReference
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Desactiva la opción de devolverse en la vista
        onBackPressedDispatcher.addCallback(this, object : OnBackPressedCallback(true) {
            override fun handleOnBackPressed() {
            }
        })

        // Oculta la parte de arriba que se vía feísima
        supportActionBar?.hide()

        // Se utiliza el binding para inflar la vista y meterse como raiz
        binding = LoginBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Se inicializan las variables para guardarse en la base de datos
        firebaseDatabase = FirebaseDatabase.getInstance()

        /*
            Usuarios es el nombre de tabla en la base de datos, entonces cuando se quiera llamar la
            base de datos, toca tener en cuenta el nombre Usuarios
         */
        databaseReference = firebaseDatabase.reference.child("Usuarios")

        /*
            Las siguientes líneas guardan en diferentes variables los datos del usuario al momento
            que se le da clic al botón de iniciar sesión dentro de la aplicación.
            También verifica que todos los campos estén llenos.
            En este caso se tienen dos variables; loginUsername y loginPassword
         */
        binding.loginButtonLogin.setOnClickListener {
            val loginUsername = binding.loginUsuario.text.toString()
            val loginPassword = binding.loginPassword.text.toString()

            // Verifica la conección a internet del usuario e imprime un aviso en cano de que no esté conectado.
            if (!isOnline(this)) {
                Toast.makeText(this, "No estás conectado a internet!", Toast.LENGTH_SHORT).show()
            }
            // Si no están vacíos manda los valores a la función loginUser, si no, salta un aviso.
            if (loginUsername.isNotEmpty() && loginPassword.isNotEmpty()) {
                loginUser(loginUsername, loginPassword)
            } else {
                Toast.makeText(
                    this@LoginToApp,
                    "Todos los campos deben ser llenados",
                    Toast.LENGTH_SHORT
                ).show()
            }
        }


        // Se accede al id del botón de inicio del  login y al presionar se dirige a la vista WelcomeToApp
        binding.botonDevolverLogin.setOnClickListener {
            val intent = Intent(this, WelcomeToApp::class.java)
            startActivity(intent)
        }
    }


    // Creación de la función para hacer el login
    private fun loginUser(username: String, password: String) {
        /*
        Argumentos:
            username: type -> String
            password: type -> String
        ¿Qué hace?:
            1. Verifica que los datos que han sido proporcionados son los correctos con los que se
                tiene en la base de datos y si sí, entonces sale un aviso de "Inicio exitoso!" y
                redirige a la vista de WelcomeToApp.
            2. Si los datos del usuario son incorrectos, es decir, no coinciden con los que hay en la
                base de datos entonces sale un aviso en la pantalla del usuario informando de
                un "Inicio fallido!"
            3. En caso de que ocurra algún error en la base de datos, este va a imprimir el error
         */
        databaseReference.orderByChild("username").equalTo(username)
            .addListenerForSingleValueEvent(object : ValueEventListener {
                override fun onDataChange(dataSnapshot: DataSnapshot) {
                    if (dataSnapshot.exists()) {
                        for (userSnapshot in dataSnapshot.children) {
                            val userData = userSnapshot.getValue(UserData::class.java)
                            if (userData != null && userData.password == password) {
                                // Aquí guarda la id del usuario actual en la variable idCurrent de
                                // la clase GlobalData, esto es re IMPORTANTE
                                GlobalData.idCurrent = userData.id.toString()
                                Toast.makeText(
                                    this@LoginToApp,
                                    "Inicio exitoso!",
                                    Toast.LENGTH_SHORT
                                ).show()
                                startActivity(Intent(this@LoginToApp, InicioPrincipal::class.java))
                                finish()
                                return
                            }
                        }
                    }
                    Toast.makeText(this@LoginToApp, "Credenciales incorrectas!", Toast.LENGTH_SHORT)
                        .show()

                }

                override fun onCancelled(databaseError: DatabaseError) {
                    Toast.makeText(
                        this@LoginToApp,
                        "Error en la base de datos ${databaseError.message}",
                        Toast.LENGTH_SHORT
                    ).show()

                }
            })
    }


}