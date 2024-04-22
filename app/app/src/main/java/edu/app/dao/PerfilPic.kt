package edu.app.dao

import android.app.ProgressDialog
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.storage.FirebaseStorage
import edu.app.dao.databinding.PerfilPicBinding
import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale

class PerfilPic : AppCompatActivity(){
    private lateinit var binding: PerfilPicBinding
    lateinit var imageUri : Uri
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        supportActionBar?.hide()
        binding = PerfilPicBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Hace que el botón de devolver se devuelva a EditarPerfil.kt
        binding.botonBack.setOnClickListener {
            finish()
        }

        // Botón para seleccionar la imagen del dispositivo
        binding.buttonSeleccionar.setOnClickListener {
            selectImage()
        }

        // Botón para subir la imagen a la base de datos y que se actualice
        binding.buttonSubir.setOnClickListener {
            uploadImage()
        }
    }

    // Función para subir la imagen
    private fun uploadImage(){
        val progressDialog = ProgressDialog(this)
        progressDialog.setMessage("Subiendo imagen...")
        progressDialog.setCancelable(false)
        progressDialog.show()

        val formatter = SimpleDateFormat("yyyy_MM_dd_HH_mm_ss", Locale.getDefault())
        val now = Date()
        val fileName = formatter.format(now)
        val storageReference = FirebaseStorage.getInstance().getReference("images/$fileName")

        storageReference.putFile(imageUri).
                addOnSuccessListener {
                    binding.imageUser.setImageURI(null)
                    Toast.makeText(this@PerfilPic, "Imagen subida correctamente!", Toast.LENGTH_SHORT).show()
                    if (progressDialog.isShowing) progressDialog.dismiss()
                }.addOnFailureListener {error ->
                    if (progressDialog.isShowing) progressDialog.dismiss()
                    Toast.makeText(this@PerfilPic, "Error: $error", Toast.LENGTH_LONG).show()

        }
    }

    private fun selectImage() {
        val intent = Intent()
        intent.type = "image/*"
        intent.action = Intent.ACTION_GET_CONTENT
        startActivityForResult(intent, 100)
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        if (requestCode == 100 && resultCode == RESULT_OK){
            imageUri = data?.data!!
            binding.imageUser.setImageURI(imageUri)
        }
    }


}