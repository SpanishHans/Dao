package edu.app.dao.fragments.leccion1.ui.theme

import android.graphics.Typeface
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import edu.app.dao.R
import edu.app.dao.databinding.FragmentLeccion1PalabrasNuevasBinding


class Leccion1PalabrasNuevas : Fragment() {

    private lateinit var binding: FragmentLeccion1PalabrasNuevasBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentLeccion1PalabrasNuevasBinding.inflate(inflater, container, false)
        val toolbarText = requireActivity().findViewById<TextView>(R.id.toolbar_title)
        toolbarText.text = "Nuevas palabras"
        toolbarText.typeface = Typeface.createFromAsset(requireContext().assets, "fonts/helvetica_neue_bold.ttf")

        return binding.root
    }

}