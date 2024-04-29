package edu.app.dao.fragments.leccion1.ui.theme

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import edu.app.dao.databinding.FragmentLeccion1Lectura1Binding
import edu.app.dao.databinding.FragmentLeccion1PalabrasNuevasBinding

class Leccion1Lectura1 : Fragment() {

    private lateinit var binding: FragmentLeccion1Lectura1Binding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentLeccion1Lectura1Binding.inflate(inflater, container, false)
        binding.prueba.text = "Estoy en la Lectura!"
        return binding.root
    }

}