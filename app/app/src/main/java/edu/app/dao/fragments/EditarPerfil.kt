/*
    This file is part of Dao

    Dao is free software: you can redistribute it and/or modify it under the terms of the
    GNU General Public License as published by the Free Software Foundation, either version 3 of
    the License, or any later version.

    Dao is distributed in the hope that it will be useful, but WITHOUT ANY WARRANTY;
    without even the implied warranty of MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See
    the GNU General Public License for more details.

    You should have received a copy of the GNU General Public License along with this program. If
    not, see <https://www.gnu.org/licenses/>.
 */
package edu.app.dao.fragments

import android.content.Intent
import android.graphics.drawable.Drawable
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.activity.OnBackPressedCallback
import androidx.appcompat.widget.Toolbar
import androidx.core.content.ContextCompat
import com.bumptech.glide.Glide
import com.bumptech.glide.request.target.CustomTarget
import com.bumptech.glide.request.transition.Transition
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.storage.FirebaseStorage
import edu.app.dao.FondoPic
import edu.app.dao.PerfilPic
import edu.app.dao.R
import edu.app.dao.databinding.FragmentEditarPerfilBinding
import edu.app.dao.funciones.GlobalData

class EditarPerfil : Fragment() {

    private lateinit var binding: FragmentEditarPerfilBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Binding para controlar los elementos del fragment_editar_perfil.xml
        binding = FragmentEditarPerfilBinding.inflate(inflater, container, false)

        // Instancia de la base de datos
        val database: FirebaseDatabase = FirebaseDatabase.getInstance()

        // Referencia a la base de datos con los datos de la ID que se capturó en la clase GlobalData
        val refUsuarios: DatabaseReference =
            database.getReference("Usuarios").child(GlobalData.idCurrent)

        // Referencia al almacenamiento de la base de atos
        val storageReference = FirebaseStorage.getInstance().reference

        // Instancia del fragmento anterior (yop.kt)
        val yop = yop()

        // Permite cambiar el título de la barra de texto y también el tamaño de la letra de este
        val toolbar = requireActivity().findViewById<Toolbar>(R.id.toolbar)
        val toolbarText = requireActivity().findViewById<TextView>(R.id.toolbar_title)
        toolbarText.text = "Información personal"
        toolbarText.textSize = 30F

        val callback = object : OnBackPressedCallback(true) {
            override fun handleOnBackPressed() {
            }
        }
        requireActivity().onBackPressedDispatcher.addCallback(viewLifecycleOwner, callback)

        // Carga la foto de perfil que se tienen guardada con el usuario. Si no se encuentra nada
        // entonces carga una imagen por defecto (la gris toda fea)
        storageReference.child("images/${GlobalData.idCurrent}").downloadUrl.addOnSuccessListener { uri ->
            Glide.with(this@EditarPerfil)
                .load(uri)
                .into(binding.profilePhotoUser)
        }.addOnFailureListener {
            Glide.with(this@EditarPerfil)
                .load(R.drawable.pic_default)
                .into(binding.profilePhotoUser)
        }

        // Carga el fondo de perfil que tiene guardado el usuario. Si no encuentra nada en Firebase
        // entonces carga la imagen por defecto (gran muralla China)
        storageReference.child("fondos/${GlobalData.idCurrent}").downloadUrl.addOnSuccessListener { uri ->
            Glide.with(this@EditarPerfil)
                .load(uri)
                .into(object : CustomTarget<Drawable>() {
                    override fun onResourceReady(
                        resource: Drawable,
                        transition: Transition<in Drawable>?
                    ) {
                        binding.backgroundProfile.background = resource
                    }

                    override fun onLoadCleared(placeholder: Drawable?) {
                        // No hacer nada
                    }
                })
        }.addOnFailureListener {
            val defaultImageResId = R.drawable.the_great_wall_of_china
            binding.backgroundProfile.setBackgroundResource(defaultImageResId)
        }


        // Cuando se le da clic a la toolbar superior se devuelve al fragmento de yop.kt
        toolbar.setOnClickListener {
            (activity as InicioPrincipal).makeCurrentFragment(yop)
        }

        // Cambia los datos en la base de datos con los que se tengan en los campos llenados de
        // esta parte de editar perfil. Se cambian todos los campos en la base de datos
        binding.buttonGuardar.setOnClickListener {
            val newUserName = binding.nombreUsuarioEditar.text.toString()
            val newPassword = binding.contrasenaUsuarioEditar.text.toString()
            val newNombre = binding.nombreCompletoEditar.text.toString()
            val newDescription = binding.presentacionEditar.text.toString()

            // Verifica si los campos están vacíos y asigna valores solo si no están vacíos
            val nuevosDatos = hashMapOf<String, Any>()
            if (newUserName.isNotEmpty()) nuevosDatos["username"] = newUserName
            if (newPassword.isNotEmpty()) nuevosDatos["password"] = newPassword
            if (newNombre.isNotEmpty()) nuevosDatos["nameFull"] = newNombre
            if (newDescription.isNotEmpty()) nuevosDatos["description"] = newDescription

            // Actualiza los datos en la base de datos solo si hay campos no vacíos
            if (nuevosDatos.isNotEmpty()) {
                refUsuarios.updateChildren(nuevosDatos)
                    .addOnSuccessListener {
                        Toast.makeText(
                            requireContext(),
                            "Datos actualizados con éxito!",
                            Toast.LENGTH_SHORT
                        ).show()
                    }
                    .addOnFailureListener { error ->
                        Toast.makeText(requireContext(), "Error: $error", Toast.LENGTH_SHORT).show()
                    }
            } else {
                // No hay campos para actualizar
                Toast.makeText(requireContext(), "No hay cambios para guardar", Toast.LENGTH_SHORT)
                    .show()
            }

        }

        // Al hacer clic sobre la foto de perfil lo lleva a la actividad para cambiar la foto
        binding.profilePhotoUser.setOnClickListener {
            val intent = Intent(activity, PerfilPic::class.java)
            startActivity(intent)
        }

        // Al hacer clic sobre el fondo lo lleva a la actividad para cambiar el fondo
        binding.backgroundProfile.setOnClickListener {
            startActivity(Intent(activity, FondoPic::class.java))
        }


        return binding.root
    }


}