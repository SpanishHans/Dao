package edu.app.dao.fragments.leccion1.ui.theme

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
import androidx.appcompat.widget.Toolbar
import edu.app.dao.R
import edu.app.dao.databinding.FragmentLeccion1PalabrasNuevasBinding
import edu.app.dao.fragments.leccion1.Indice


class Leccion1PalabrasNuevas : Fragment() {

    private lateinit var binding: FragmentLeccion1PalabrasNuevasBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentLeccion1PalabrasNuevasBinding.inflate(inflater, container, false)
        val toolbar = requireActivity().findViewById<FrameLayout>(R.id.frame_layout_bar_buttom)
        val toolbarText = requireActivity().findViewById<TextView>(R.id.toolbar_title)
        val devolverFlecha = requireActivity().findViewById<LinearLayout>(R.id.flecha_devolver)
        val flechaDevolverImagen =
            requireActivity().findViewById<ImageButton>(R.id.flecha_devolver_imagen)
        toolbarText.text = "Palabras nuevas"
        toolbarText.textSize = 30F
        toolbarText.typeface =
            Typeface.createFromAsset(requireContext().assets, "fonts/helvetica_neue_bold.ttf")
        devolverFlecha.visibility = View.VISIBLE

        flechaDevolverImagen.setOnClickListener {
            requireActivity().supportFragmentManager.popBackStack()
            val indice = Indice()
            requireActivity().supportFragmentManager.beginTransaction().apply {
                replace(R.id.fl_wrapper, indice)
                commit()
            }
        }

        binding.linearLayoutTu.setOnClickListener {
            val palabraNi = Leccion1PalabraNi()
            requireActivity().supportFragmentManager.beginTransaction().apply {
                replace(R.id.fl_wrapper, palabraNi)
                commit()
            }
        }

        binding.linearLayoutLuyu.setOnClickListener {
            val palabraLuYu = Leccion1PalabraLuYuPing()
            requireActivity().supportFragmentManager.beginTransaction().apply {
                replace(R.id.fl_wrapper, palabraLuYu)
                commit()
            }
        }

        binding.linearLayoutLibo.setOnClickListener {
            val palabraLiBo = Leccion1PalabraLiBo()
            requireActivity().supportFragmentManager.beginTransaction().apply {
                replace(R.id.fl_wrapper, palabraLiBo)
                commit()
            }
        }

        binding.linearLayoutBien.setOnClickListener {
            val palabraHao = Leccion1PalabraHao()
            requireActivity().supportFragmentManager.beginTransaction().apply {
                replace(R.id.fl_wrapper, palabraHao)
                commit()
            }
        }

        binding.linearLayoutMa.setOnClickListener {
            val palabraMa = Leccion1PalabraMa()
            requireActivity().supportFragmentManager.beginTransaction().apply {
                replace(R.id.fl_wrapper, palabraMa)
                commit()
            }
        }

        binding.linearLayoutWo.setOnClickListener {
            val palabraWo = Leccion1PalabraWo()
            requireActivity().supportFragmentManager.beginTransaction().apply {
                replace(R.id.fl_wrapper, palabraWo)
                commit()
            }
        }



        return binding.root
    }


}