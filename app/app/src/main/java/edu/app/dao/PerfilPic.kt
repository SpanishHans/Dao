package edu.app.dao

import android.os.Bundle
import android.os.PersistableBundle
import androidx.appcompat.app.AppCompatActivity
import edu.app.dao.databinding.PerfilPicBinding
import edu.app.dao.fragments.EditarPerfil

class PerfilPic : AppCompatActivity(){
    private lateinit var binding: PerfilPicBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        supportActionBar?.hide()
        binding = PerfilPicBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Hace que el botón de devolver se devuelva a EditarPerfil.kt
        binding.botonBack.setOnClickListener {
            finish()
        }
    }
}