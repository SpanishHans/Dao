package edu.app.dao

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import edu.app.dao.databinding.LoginToAppLayoutBinding
import edu.app.dao.databinding.RegisterToAppLayoutBinding

class RegisterToApp : AppCompatActivity() {

    /*
        Declaración del binding con el layout register_to_app_layout
        El nombre RegisterToAppLayoutBinding sale del archivo .xml
        mencionado anteriormente y se genera automáticamente.
     */
    private lateinit var binding: RegisterToAppLayoutBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // Se utiliza el binding para inflar la vista y meterse como raiz
        binding = RegisterToAppLayoutBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
}