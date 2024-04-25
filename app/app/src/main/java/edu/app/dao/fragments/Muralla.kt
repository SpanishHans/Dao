package edu.app.dao.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.appcompat.widget.Toolbar
import edu.app.dao.R
import edu.app.dao.databinding.FragmentMurallaBinding


class Muralla : Fragment() {

    private lateinit var binding: FragmentMurallaBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Infla el layout: fragment_muralla.xml para el fragmento
        binding = FragmentMurallaBinding.inflate(inflater, container, false)

        // Define la barra de tareas superior y hace que el título cambie a "Tú Camino"
        val toolbar = requireActivity().findViewById<Toolbar>(R.id.toolbar)
        val toolbarText = requireActivity().findViewById<TextView>(R.id.toolbar_title)
        toolbarText.text = "Tú Camino"
        toolbar.setOnClickListener {
            null
        }

        return binding.root
    }


}