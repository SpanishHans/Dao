package edu.app.dao.fragments.leccion1

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import edu.app.dao.R
import edu.app.dao.databinding.FragmentLeccion1EjerciciosFoneticaBinding

class Leccion1EjerciciosFonetica : Fragment() {

    private lateinit var binding: FragmentLeccion1EjerciciosFoneticaBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentLeccion1EjerciciosFoneticaBinding.inflate(inflater, container, false)

        return binding.root
    }

}