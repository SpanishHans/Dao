/*
    Copyright (C) 2024 Alvarado Ludwig & Martinez Juan Jos�.

    This file is part of Dao.

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

import android.app.ProgressDialog
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.widget.Toast
import androidx.activity.OnBackPressedCallback
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide
import com.google.firebase.storage.FirebaseStorage
import edu.app.dao.databinding.FondoPicBinding
import edu.app.dao.databinding.PerfilPicBinding
import edu.app.dao.funciones.GlobalData

class FondoPic : AppCompatActivity() {
    /*
        Vista para cambiar la imagen del fondo del perfil
     */

    // Instancia apuntando a la vista fondo_pic.xml
    private lateinit var binding: FondoPicBinding

    // Instancia para utilizar Uri
    lateinit var imageUri: Uri
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        supportActionBar?.hide()
        binding = FondoPicBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Desactiva la parte de devolverse en la aplicación.
        onBackPressedDispatcher.addCallback(this, object : OnBackPressedCallback(true) {
            override fun handleOnBackPressed() {
            }
        })

        // Referencia para la base de datos de almacenamiento
        val storageReference = FirebaseStorage.getInstance().reference

        // Utiliza el ID global del usuario para poder guardar y cargar los datos
        storageReference.child("fondos/${GlobalData.idCurrent}").downloadUrl.addOnSuccessListener { uri ->
            // Carga la foto de perfil que se tienen en la base de datos
            Glide.with(this@FondoPic)
                .load(uri)
                .into(binding.imageUser)
        }.addOnFailureListener {
            // Carga la imagen que se tiene por defecto si no encuentra nada en la base de datos
            // (muralla China)
            Glide.with(this@FondoPic)
                .load(R.drawable.the_great_wall_of_china)
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

    // Permite subir una imagen al firebase en el directorio de fondos y guarda la imagen seleccionada
    // con el ID único del usuario.
    private fun uploadImage() {
        /*
            Mensaje mientras se está subiendo la imagen
         */
        val progressDialog = ProgressDialog(this)
        progressDialog.setMessage("Subiendo imagen...")
        progressDialog.setCancelable(false)
        progressDialog.show()

        // La imagen que se sube va a tener el ID que tiene el usuario en la base de datos.
        val fileName = "${GlobalData.idCurrent}"

        // Se obtiene la referencia de la imagen en la base de datos
        val storageReference = FirebaseStorage.getInstance().getReference("fondos/$fileName")

        // Coloca la imagen dentro de la base de datos en el directorio de images
        storageReference.putFile(imageUri).addOnSuccessListener {
            Toast.makeText(this@FondoPic, "Imagen subida correctamente!", Toast.LENGTH_SHORT).show()
            finish()
            if (progressDialog.isShowing) progressDialog.dismiss()
        }.addOnFailureListener { error ->
            if (progressDialog.isShowing) progressDialog.dismiss()
            Toast.makeText(this@FondoPic, "Error: $error", Toast.LENGTH_LONG).show()

        }
    }

    // Permite acceder a la funcionalidad del sistema de seleccionar imagenes del almacenamiento interno
    private fun selectImage() {
        /*
            Abre la parte de seleccionar imagen dentro del dispositivo
         */
        val intent = Intent()
        intent.type = "image/*"
        intent.action = Intent.ACTION_GET_CONTENT
        startActivityForResult(intent, 100)
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        /*
            Cambia la imagen actual que está en la base de datos por la que subió el usuario de últimas.
         */
        super.onActivityResult(requestCode, resultCode, data)

        if (requestCode == 100 && resultCode == RESULT_OK) {
            imageUri = data?.data!!
            binding.imageUser.setImageURI(imageUri)
        }
    }


}
