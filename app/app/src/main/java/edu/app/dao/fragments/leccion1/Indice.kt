package edu.app.dao.fragments.leccion1

import android.graphics.Typeface
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import edu.app.dao.R
import edu.app.dao.databinding.FragmentIndiceBinding

class Indice : Fragment() {

    private lateinit var binding: FragmentIndiceBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentIndiceBinding.inflate(inflater, container, false)
        val toolbarText = requireActivity().findViewById<TextView>(R.id.toolbar_title)
        toolbarText.text = "你好"

        toolbarText.typeface = Typeface.createFromAsset(requireContext().assets, "fonts/ma_shan_zheng.ttf")

        binding.buttonPalabrasNuevas.setOnClickListener {
            Toast.makeText(requireContext(), "Clic en Palabras nuevas", Toast.LENGTH_SHORT).show()
        }

        binding.buttonLectura1.setOnClickListener {
            Toast.makeText(requireContext(), "Clic en lectura 1", Toast.LENGTH_SHORT).show()
        }

        binding.buttonLectura2.setOnClickListener {
            Toast.makeText(requireContext(), "Clic en lectura 2", Toast.LENGTH_SHORT).show()
        }

        binding.buttonNotas.setOnClickListener {
            Toast.makeText(requireContext(), "Clic en notas", Toast.LENGTH_SHORT).show()
        }

        binding.buttonFonetica.setOnClickListener {
            Toast.makeText(requireContext(), "Clic en ejercicios de fonética", Toast.LENGTH_SHORT).show()
        }

        binding.buttonConversacion.setOnClickListener {
            Toast.makeText(requireContext(), "Clic en práctica de conversacion", Toast.LENGTH_SHORT).show()
        }

        binding.buttonFonetica.setOnClickListener {
            Toast.makeText(requireContext(), "Clic en fonética", Toast.LENGTH_SHORT).show()
        }

        binding.buttonGramatica.setOnClickListener {
            Toast.makeText(requireContext(), "Clic en gramática", Toast.LENGTH_SHORT).show()
        }


        return binding.root
    }

}