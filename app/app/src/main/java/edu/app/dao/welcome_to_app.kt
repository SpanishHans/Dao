package edu.app.dao

import android.content.Context
import android.content.Intent
import android.net.ConnectivityManager
import android.net.NetworkCapabilities
import android.os.Bundle
import android.util.Log
import android.view.View
import android.view.Window
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.ui.graphics.Color
import androidx.core.content.ContextCompat
import edu.app.dao.databinding.WelcomeBinding
// La función isOnline se llama desde el paquete de Funciones.kt y ahí se encuentra, la pongo para simplificar código
import edu.app.dao.funciones.isOnline

class WelcomeToApp : AppCompatActivity() {

    /*
        Declaración del binding con el layout welcome
        El nombre WelcomeToAppLayoutBinding sale del archivo .xml
        mencionado anteriormente y se genera automáticamente.
     */
    private lateinit var binding: WelcomeBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Oculta una parte de arriba que se ve feísima (Barra de acción)
        supportActionBar?.hide()

        // Se utiliza el binding para inflar la vista y meterse como raiz
        binding = WelcomeBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Inicializa como variable el botón de iniciar sesión
        val botonLogin = binding.welcomeButtonLogin


        // Si está conectado a internet entonces pasa al Login, si no, imprime un aviso
        botonLogin.setOnClickListener {
            if (isOnline(this)) {
                val intent = Intent(this, LoginToApp::class.java)
                startActivity(intent)
            } else {
                Toast.makeText(this, "No estás conectado a internet!", Toast.LENGTH_SHORT).show()
            }
        }

        // Se accede al id del botón de inicio registrar a través del binding
        val botonRegistro = binding.welcomeButtonRegister

        // Si está conectado a internet entonces pasa al Register, si no, imprime un aviso
        botonRegistro.setOnClickListener {
            if (isOnline(this)) {
                val intent = Intent(this, RegisterToApp::class.java)
                startActivity(intent)
            } else {
                Toast.makeText(this, "No estás conectado a internet!", Toast.LENGTH_SHORT).show()
            }
        }


    }
}