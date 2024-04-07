package edu.app.dao

import android.content.Intent
import android.graphics.Color
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import edu.app.dao.databinding.LoginToAppLayoutBinding

class LoginToApp : AppCompatActivity() {
    /*
        Declaración del binding con el layout welcome_to_app_layout
        El nombre WelcomeToAppLayoutBinding sale del archivo .xml
        mencionado anteriormente y se genera automáticamente.
     */
    private lateinit var binding: LoginToAppLayoutBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // Se utiliza el binding para inflar la vista y meterse como raiz
        binding = LoginToAppLayoutBinding.inflate(layoutInflater)
        // Se accede al id del botón de inicio del  login
        val botonRegistro =  binding.loginButtonLogin
        botonRegistro.setOnClickListener {
            val intent = Intent(this, BrowserActivity::class.java)
            startActivity(intent)
        }
    }
}