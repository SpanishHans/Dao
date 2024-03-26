package edu.app.dao

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

class WelcomeToApp : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.welcome_to_app_layout)

        val botonLogin = findViewById<Button>(R.id.welcome_button_login)

        botonLogin.setOnClickListener {
            val intent = Intent(this, LoginToApp::class.java)
            startActivity(intent)
        }

        val botonRegistro = findViewById<Button>(R.id.welcome_button_register)

        botonRegistro.setOnClickListener {
            val intent = Intent(this, RegisterToApp::class.java)
            startActivity(intent)
        }
    }
}