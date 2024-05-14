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
import androidx.activity.OnBackPressedCallback
import edu.app.dao.R
import edu.app.dao.databinding.FragmentLeccion1PracticaConversacionBinding

class Leccion1PracticaConversacion : Fragment() {

    private lateinit var binding: FragmentLeccion1PracticaConversacionBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentLeccion1PracticaConversacionBinding.inflate(inflater, container, false)
        val toolbarText = requireActivity().findViewById<TextView>(R.id.toolbar_title)
        val toolbar = requireActivity().findViewById<FrameLayout>(R.id.frame_layout_bar_buttom)
        val flechaDevolver = requireActivity().findViewById<LinearLayout>(R.id.flecha_devolver)
        val flechaDevolverImagen =
            requireActivity().findViewById<ImageButton>(R.id.flecha_devolver_imagen)
        toolbarText.text = "你好-会话练习"
        toolbarText.typeface =
            Typeface.createFromAsset(requireContext().assets, "fonts/ma_shan_zheng.ttf")
        toolbar.visibility = View.GONE
        flechaDevolver.visibility = View.VISIBLE
        val callback = object : OnBackPressedCallback(true) {
            override fun handleOnBackPressed() {
            }
        }
        requireActivity().onBackPressedDispatcher.addCallback(viewLifecycleOwner, callback)


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