package edu.app.dao

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity


class WelcomeToApp : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.welcome_to_app_layout)
        val botonRegistro = findViewById<Button>(R.id.button_welcome_register)

        botonRegistro.setOnClickListener {
            val intent = Intent(this, RegisterToApp::class.java)
            startActivity(intent)
        }

    }
}