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
import edu.app.dao.databinding.FragmentYopBinding
import edu.app.dao.funciones.GlobalData


class yop : Fragment() {

    private lateinit var binding: FragmentYopBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Infla el layout: fragment_yop.xml para el fragmento
        binding = FragmentYopBinding.inflate(inflater, container, false)

        // Instancia la base de datos
        val database: FirebaseDatabase = FirebaseDatabase.getInstance()

        // Hace que hagarre la referencia de "Usuarios"
        val refUsuarios: DatabaseReference = database.getReference("Usuarios")

        // Define la barra de tareas superior y hace que el título cambie a "Editar Perfil"
        val toolbar = requireActivity().findViewById<Toolbar>(R.id.toolbar)
        val toolbarText = requireActivity().findViewById<TextView>(R.id.toolbar_title)
        toolbarText.text = "Editar Perfil"


        // Cuando se haga clic en la imagen de fondo (Cover) esta imprima un mensaje en la pantalla del usuario en forma de Toast
        binding.backgroundProfile.setOnClickListener {
            Toast.makeText(requireContext(), "Has dado click en la imagen!", Toast.LENGTH_SHORT).show()
        }

        // Cuando se hace clic en la barra de tareas superior cambia al fragmento de EditarPerfil.kt
        toolbar.setOnClickListener {
            Toast.makeText(requireContext(), "Has dado click en Editar Perfil!", Toast.LENGTH_SHORT).show()
            val editarPerfil = EditarPerfil()
            navegarEditarPerfil(editarPerfil)
        }

        // Cuando se hace clic en la foto de perfil, esta muestra un aviso
        binding.profilePhotoUser.setOnClickListener {
            Toast.makeText(requireContext(), "Has dado clic en 毛泽东!", Toast.LENGTH_SHORT).show()
        }
        /*
           Basicamente, lo que hace es que coloca en el fragment_yop.xml los campos de:
           username, descripción, victorias en Kong, aciertos en tao. Esos datos son los que están
           asociados al usuario a través de su ID, la ID está guardada en una clase global de datos
         */
        refUsuarios.child(GlobalData.idCurrent).addListenerForSingleValueEvent(object : ValueEventListener{
            override fun onDataChange(dataSnapshot: DataSnapshot) {
                val usuario = dataSnapshot.getValue(UserData::class.java)
                binding.username.text = usuario?.username
                binding.descripcionPerfilUsuario.text = usuario?.description
                binding.buttonEstadisticaKong.text = usuario?.victoriasKong.toString()
                binding.buttonEstadisticaTao.text = usuario?.aciertosTao.toString()
            }

            override fun onCancelled(error: DatabaseError) {
                Toast.makeText(requireContext(), "Error :(", Toast.LENGTH_SHORT).show()
            }
        })



        return binding.root
    }

    // Función que permite cambiar el layout de la actividad por el de un nuevo fragmento
    // Se va a utilizar para el fragmento de EditarPerfil.kt aunque se abre la posibilidad para otro
    private fun navegarEditarPerfil(fragment: Fragment) {
        requireActivity().supportFragmentManager.beginTransaction().apply {
            replace(R.id.fl_wrapper, fragment)
            commit()
        }
    }

}