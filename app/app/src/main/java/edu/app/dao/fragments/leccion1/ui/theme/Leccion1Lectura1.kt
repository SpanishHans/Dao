package edu.app.dao.fragments.leccion1.ui.theme

import android.graphics.Typeface
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.FrameLayout
import android.widget.ImageButton
import android.widget.LinearLayout
import android.widget.TextView
import androidx.fragment.app.Fragment
import edu.app.dao.R
import edu.app.dao.databinding.FragmentIndiceBinding
import edu.app.dao.databinding.FragmentLeccion1Lectura1Binding
import edu.app.dao.databinding.FragmentLeccion1PalabrasNuevasBinding
import edu.app.dao.fragments.Tao
import edu.app.dao.fragments.leccion1.Indice

class Leccion1Lectura1 : Fragment() {

    private lateinit var binding: FragmentLeccion1Lectura1Binding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentLeccion1Lectura1Binding.inflate(inflater, container, false)
        val toolbarText = requireActivity().findViewById<TextView>(R.id.toolbar_title)
        val toolbar = requireActivity().findViewById<FrameLayout>(R.id.frame_layout_bar_buttom)
        val flechaDevolver = requireActivity().findViewById<LinearLayout>(R.id.flecha_devolver)
        val flechaDevolverImagen =
            requireActivity().findViewById<ImageButton>(R.id.flecha_devolver_imagen)
        toolbarText.text = "你好-课文"
        toolbarText.typeface =
            Typeface.createFromAsset(requireContext().assets, "fonts/ma_shan_zheng.ttf")
        toolbar.visibility = View.GONE
        flechaDevolver.visibility = View.VISIBLE

        flechaDevolverImagen.setOnClickListener {
            requireActivity().supportFragmentManager.popBackStack()
            val indice = Indice()
            requireActivity().supportFragmentManager.beginTransaction().apply {
                replace(R.id.fl_wrapper, indice)
                commit()
            }
        }

        return binding.root
    }

}