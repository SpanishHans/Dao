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
import edu.app.dao.R
import edu.app.dao.databinding.FragmentMurallaBinding
import edu.app.dao.ordenar.FragmentoOrdenar
import edu.app.dao.ordenar.GamemodeOrdenar3
import edu.app.dao.ordenar.gamemode_ordenar_2


class Muralla : Fragment() {

    private lateinit var binding: FragmentMurallaBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Infla el layout: fragment_muralla.xml para el fragmento
        binding = FragmentMurallaBinding.inflate(inflater, container, false)

        // Define la barra de tareas superior y hace que el título cambie a "Tú Camino"
        val toolbar = requireActivity().findViewById<FrameLayout>(R.id.frame_layout_bar_buttom)
        val toolbarUp = requireActivity().findViewById<Toolbar>(R.id.toolbar)
        val toolbarText = requireActivity().findViewById<TextView>(R.id.toolbar_title)
        val flechaDevolver = requireActivity().findViewById<LinearLayout>(R.id.flecha_devolver)
        toolbarText.text = "Tú Camino"

        toolbarText.typeface = Typeface.createFromAsset(requireContext().assets, "fonts/helvetica_neue_bold.ttf")
        toolbar.visibility = View.VISIBLE
        flechaDevolver.visibility = View.GONE
        val callback = object : OnBackPressedCallback(true){
            override fun handleOnBackPressed() {
            }
        }
        requireActivity().onBackPressedDispatcher.addCallback(viewLifecycleOwner, callback)



        binding.nivel1.setOnClickListener {
            val gamemodeOrdenar = FragmentoOrdenar()
            fragmentoNav(gamemodeOrdenar)
        }

        binding.nivel2.setOnClickListener {
            val gamemodeOrdenar2 = gamemode_ordenar_2()
            fragmentoNav(gamemodeOrdenar2)
        }

        binding.nivel3.setOnClickListener {
            val gamemodeOrdenar3 = GamemodeOrdenar3()
            fragmentoNav(gamemodeOrdenar3)
        }

        return binding.root
    }

        private fun fragmentoNav (fragment: Fragment){
            requireActivity().supportFragmentManager.beginTransaction().apply {
                replace(R.id.fl_wrapper,fragment)
                commit()
            }
        }

}