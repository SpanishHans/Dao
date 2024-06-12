/*
This program is free software: you can redistribute it and/or modify it under the terms of the
GNU General Public License as published by the Free Software Foundation, either version 3 of
the License, or any later version.

This program is distributed in the hope that it will be useful, but WITHOUT ANY WARRANTY;
without even the implied warranty of MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See
the GNU General Public License for more details.

You should have received a copy of the GNU General Public License along with this program. If
not, see <https://www.gnu.org/licenses/>.
 */
package edu.app.dao.fragments

import android.graphics.Typeface
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.ViewTreeObserver
import android.widget.FrameLayout
import android.widget.LinearLayout
import android.widget.TextView
import androidx.activity.OnBackPressedCallback
import androidx.appcompat.widget.Toolbar
import edu.app.dao.completar.FragmentoCompletar
import edu.app.dao.R
import edu.app.dao.databinding.FragmentKongBinding


class Kong : Fragment() {

    private lateinit var binding: FragmentKongBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Infla el layout: fragment_muralla.xml para el fragmento
        binding = FragmentKongBinding.inflate(inflater, container, false)

        // Define la barra de tareas superior y hace que el título cambie a "Tú Camino"
        val toolbar = requireActivity().findViewById<FrameLayout>(R.id.frame_layout_bar_buttom)
        val toolbarUp = requireActivity().findViewById<Toolbar>(R.id.toolbar)
        val toolbarText = requireActivity().findViewById<TextView>(R.id.toolbar_title)
        val flechaDevolver = requireActivity().findViewById<LinearLayout>(R.id.flecha_devolver)
        toolbarText.text = "Mahjong"
        toolbarText.typeface =
            Typeface.createFromAsset(requireContext().assets, "fonts/helvetica_neue_bold.ttf")
        toolbar.visibility = View.VISIBLE
        flechaDevolver.visibility = View.GONE
        val callback = object : OnBackPressedCallback(true) {
            override fun handleOnBackPressed() {
            }
        }
        requireActivity().onBackPressedDispatcher.addCallback(viewLifecycleOwner, callback)



        binding.m12.setOnClickListener {
            val gamemodeOrdenar = FragmentoCompletar()
            fragmentoNav(gamemodeOrdenar)
        }

        return binding.root
    }

    private fun fragmentoNav(fragment: Fragment) {
        requireActivity().supportFragmentManager.beginTransaction().apply {
            replace(R.id.fl_wrapper, fragment)
            commit()
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.scrollDomino.viewTreeObserver.addOnGlobalLayoutListener(object :
            ViewTreeObserver.OnGlobalLayoutListener {
            override fun onGlobalLayout() {
                binding.scrollDomino.post {
                    binding.scrollDomino.fullScroll(View.FOCUS_DOWN)
                }
                binding.scrollDomino.viewTreeObserver.removeOnGlobalLayoutListener(this)
            }
        })
    }

}