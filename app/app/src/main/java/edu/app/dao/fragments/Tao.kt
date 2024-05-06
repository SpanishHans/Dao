package edu.app.dao.fragments

import android.graphics.Typeface
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.FrameLayout
import android.widget.LinearLayout
import android.widget.TextView
import androidx.activity.OnBackPressedCallback
import androidx.appcompat.widget.Toolbar
import androidx.fragment.app.replace
import edu.app.dao.R
import edu.app.dao.databinding.FragmentTaoBinding
import edu.app.dao.fragments.leccion1.Indice


class Tao : Fragment() {

    private lateinit var binding: FragmentTaoBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Infla el layout: fragment_tao.xml para el fragmento
        binding = FragmentTaoBinding.inflate(inflater, container, false)

        // Define la barra de tareas superior y hace que el título cambie a "Entrenar"
        val toolbar = requireActivity().findViewById<FrameLayout>(R.id.frame_layout_bar_buttom)
        val toolbarText = requireActivity().findViewById<TextView>(R.id.toolbar_title)
        val toolbarUp = requireActivity().findViewById<Toolbar>(R.id.toolbar)
        val flechaDevolver = requireActivity().findViewById<LinearLayout>(R.id.flecha_devolver)
        toolbarText.text = "Lecciones"
        toolbarText.typeface = Typeface.createFromAsset(requireContext().assets, "fonts/helvetica_neue_bold.ttf")
        toolbar.visibility = View.VISIBLE
        flechaDevolver.visibility = View.GONE
        val callback = object : OnBackPressedCallback(true){
            override fun handleOnBackPressed() {
            }
        }
        val indice = Indice()
        requireActivity().onBackPressedDispatcher.addCallback(viewLifecycleOwner, callback)

        toolbarUp.setOnClickListener {
            null
        }




        binding.leccion1.setOnClickListener {
            requireActivity().supportFragmentManager.beginTransaction().apply {
                replace(R.id.fl_wrapper, indice)
                commit()
            }
        }

        binding.leccion2.setOnClickListener {
            requireActivity().supportFragmentManager.beginTransaction().apply {
                replace(R.id.fl_wrapper,  indice)
                commit()
            }
        }

        binding.leccion3.setOnClickListener {
            requireActivity().supportFragmentManager.beginTransaction().apply {
                replace(R.id.fl_wrapper, indice)
                commit()
            }
        }

        binding.leccion4.setOnClickListener {
            requireActivity().supportFragmentManager.beginTransaction().apply {
                replace(R.id.fl_wrapper, indice)
                commit()
            }
        }




        return binding.root
    }


}