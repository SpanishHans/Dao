package edu.app.dao

import android.app.ProgressDialog
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.widget.Toast
import androidx.activity.OnBackPressedCallback
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide
import com.google.firebase.storage.FirebaseStorage
import edu.app.dao.databinding.PerfilPicBinding
import edu.app.dao.funciones.GlobalData

class PerfilPic : AppCompatActivity() {
    private lateinit var binding: PerfilPicBinding
    lateinit var imageUri: Uri
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        supportActionBar?.hide()
        binding = PerfilPicBinding.inflate(layoutInflater)
        setContentView(binding.root)
        onBackPressedDispatcher.addCallback(this, object : OnBackPressedCallback(true) {
            override fun handleOnBackPressed() {
            }
        })

        val storageReference = FirebaseStorage.getInstance().reference

        storageReference.child("images/${GlobalData.idCurrent}").downloadUrl.addOnSuccessListener { uri ->
            Glide.with(this@PerfilPic)
                .load(uri)
                .into(binding.imageUser)
        }.addOnFailureListener {
            Glide.with(this@PerfilPic)
                .load(R.drawable.pic_default)
                .into(binding.imageUser)
        }

        // Hace que el botón de devolver se devuelva a EditarPerfil.kt
        binding.botonBack.setOnClickListener {
            finish()
        }

        // Botón para seleccionar la imagen del dispositivo
        binding.buttonSeleccionar.setOnClickListener {
            selectImage()
        }

        // Botón para subir la imagen a la base de datos y que se actualice
        binding.buttonGuardar.setOnClickListener {
            uploadImage()
        }
    }

    private fun uploadImage() {
        val progressDialog = ProgressDialog(this)
        progressDialog.setMessage("Subiendo imagen...")
        progressDialog.setCancelable(false)
        progressDialog.show()

        val fileName = "${GlobalData.idCurrent}"
        val storageReference = FirebaseStorage.getInstance().getReference("images/$fileName")

        storageReference.putFile(imageUri).addOnSuccessListener {
            Toast.makeText(this@PerfilPic, "Imagen subida correctamente!", Toast.LENGTH_SHORT)
                .show()
            finish()
            if (progressDialog.isShowing) progressDialog.dismiss()
        }.addOnFailureListener { error ->
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

        if (requestCode == 100 && resultCode == RESULT_OK) {
            imageUri = data?.data!!
            binding.imageUser.setImageURI(imageUri)
        }
    }


}