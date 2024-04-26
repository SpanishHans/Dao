package edu.app.dao.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.widget.Toolbar
import edu.app.dao.R
import edu.app.dao.databinding.FragmentTaoBinding
import edu.app.dao.fragments.leccion1.Indice
import org.w3c.dom.Text


class Tao : Fragment() {

    private lateinit var binding: FragmentTaoBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Infla el layout: fragment_tao.xml para el fragmento
        binding = FragmentTaoBinding.inflate(inflater, container, false)

        // Define la barra de tareas superior y hace que el título cambie a "Entrenar"
        val toolbar = requireActivity().findViewById<Toolbar>(R.id.toolbar)
        val toolbarText = requireActivity().findViewById<TextView>(R.id.toolbar_title)
        toolbarText.text = "Lecciones"
        toolbar.setOnClickListener {
            null
        }

        binding.leccion1.setOnClickListener {
            Toast.makeText(requireContext(), "Pulsaste en la lección 1!", Toast.LENGTH_SHORT).show()
            val indice = Indice()
            requireActivity().supportFragmentManager.beginTransaction().apply {
                replace(R.id.fl_wrapper, indice)
                commit()
            }
        }




        return binding.root
    }


}