package edu.app.dao.fragments.leccion1

import android.graphics.Typeface
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.FrameLayout
import android.widget.ImageButton
import android.widget.LinearLayout
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.widget.Toolbar
import edu.app.dao.R
import edu.app.dao.databinding.FragmentIndiceBinding
import edu.app.dao.fragments.Tao
import edu.app.dao.fragments.leccion1.ui.theme.Leccion1Lectura1
import edu.app.dao.fragments.leccion1.ui.theme.Leccion1PalabrasNuevas

class Indice : Fragment() {

    private lateinit var binding: FragmentIndiceBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentIndiceBinding.inflate(inflater, container, false)
        val toolbarText = requireActivity().findViewById<TextView>(R.id.toolbar_title)
        val toolbar = requireActivity().findViewById<FrameLayout>(R.id.frame_layout_bar_buttom)
        val flechaDevolver = requireActivity().findViewById<LinearLayout>(R.id.flecha_devolver)
        val flechaDevolverImagen = requireActivity().findViewById<ImageButton>(R.id.flecha_devolver_imagen)
        toolbarText.text = "你好"
        toolbarText.typeface = Typeface.createFromAsset(requireContext().assets, "fonts/ma_shan_zheng.ttf")
        toolbar.visibility = View.GONE
        flechaDevolver.visibility = View.VISIBLE

        flechaDevolverImagen.setOnClickListener {
            requireActivity().supportFragmentManager.popBackStack()
            val tao = Tao()
            requireActivity().supportFragmentManager.beginTransaction().apply {
                replace(R.id.fl_wrapper, tao)
                commit()
            }
        }

        binding.buttonPalabrasNuevas.setOnClickListener {
            val leccion1PalabrasNuevas = Leccion1PalabrasNuevas()
            navegarFragmento(leccion1PalabrasNuevas)
        }

        binding.buttonLectura1.setOnClickListener {
            val leccion1Lectura1 = Leccion1Lectura1()
            navegarFragmento(leccion1Lectura1)
        }

        binding.buttonLectura2.setOnClickListener {
            val leccion1Lectura2 = Leccion1Lectura2()
            navegarFragmento(leccion1Lectura2)
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

    private fun navegarFragmento(fragment: Fragment) {
        requireActivity().supportFragmentManager.beginTransaction().apply {
            replace(R.id.fl_wrapper, fragment)
            commit()
        }
    }

}