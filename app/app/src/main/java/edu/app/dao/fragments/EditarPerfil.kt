package edu.app.dao.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.widget.Toolbar
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener
import edu.app.dao.R
import edu.app.dao.databinding.FragmentEditarPerfilBinding
import edu.app.dao.funciones.GlobalData

class EditarPerfil : Fragment() {

    private lateinit var binding: FragmentEditarPerfilBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentEditarPerfilBinding.inflate(inflater, container, false)

        val database: FirebaseDatabase = FirebaseDatabase.getInstance()
        val refUsuarios: DatabaseReference = database.getReference("Usuarios").child(GlobalData.idCurrent)

        val toolbar = requireActivity().findViewById<Toolbar>(R.id.toolbar)
        val toolbarText = requireActivity().findViewById<TextView>(R.id.toolbar_title)
        toolbarText.text = "Información personal"
        toolbarText.textSize = 30F

        binding.buttonGuardar.setOnClickListener {
            val newUserName = binding.nombreUsuarioEditar.text.toString()
            val nuevosDatos = hashMapOf<String, Any>(
                "username" to newUserName
            )

            refUsuarios.updateChildren(nuevosDatos).addOnSuccessListener {
                Toast.makeText(requireContext(), "Datos actualizados con éxito!", Toast.LENGTH_SHORT).show()
            }
            .addOnFailureListener { error ->
                Toast.makeText(requireContext(), "Error: $error", Toast.LENGTH_SHORT).show()
            }
        }




        return binding.root
    }

}