/*
This program is free software: you can redistribute it and/or modify it under the terms of the
GNU General Public License as published by the Free Software Foundation, either version 3 of
the License, or any later version.

This program is distributed in the hope that it will be useful, but WITHOUT ANY WARRANTY;
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
import edu.app.dao.databinding.PerfilPicBinding
import edu.app.dao.funciones.GlobalData

class PerfilPic : AppCompatActivity() {
    /*
    Cambiar la foto de perfil del usuario
     */

    // Binding de la vista perfil_pic.xml
    private lateinit var binding: PerfilPicBinding

    // Sirve para cambiar imagenes
    lateinit var imageUri: Uri
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        supportActionBar?.hide()
        binding = PerfilPicBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Desactiva la opción de devolver en la aplicación
        onBackPressedDispatcher.addCallback(this, object : OnBackPressedCallback(true) {
            override fun handleOnBackPressed() {
            }
        })

        // Instancia de la referencia en la base de datos
        val storageReference = FirebaseStorage.getInstance().reference

        // Carga a las partes de perfil_pic que sea de imagen.
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
        val storageReference = FirebaseStorage.getInstance().getReference("images/$fileName")

        // Coloca la imagen dentro de la base de datos en el directorio de images
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