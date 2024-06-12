/*
    This file is part of Dao

    Dao is free software: you can redistribute it and/or modify it under the terms of the
    GNU General Public License as published by the Free Software Foundation, either version 3 of
    the License, or any later version.

    Dao is distributed in the hope that it will be useful, but WITHOUT ANY WARRANTY;
    without even the implied warranty of MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See
    the GNU General Public License for more details.

    You should have received a copy of the GNU General Public License along with this program. If
    not, see <https://www.gnu.org/licenses/>.
 */
package edu.app.dao.fragments.leccion1.ui.theme

import android.graphics.Typeface
import android.media.MediaPlayer
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import android.widget.TextView
import edu.app.dao.R
import edu.app.dao.databinding.FragmentLeccion1PalabraHaoBinding

class Leccion1PalabraHao : Fragment() {

    private lateinit var binding: FragmentLeccion1PalabraHaoBinding
    private var MediaPlayer: MediaPlayer? = null
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentLeccion1PalabraHaoBinding.inflate(inflater, container, false)
        val toolbarText = requireActivity().findViewById<TextView>(R.id.toolbar_title)
        val flechaDevolverImagen =
            requireActivity().findViewById<ImageButton>(R.id.flecha_devolver_imagen)
        toolbarText.text = "你好-生词"
        toolbarText.textSize = 35F
        toolbarText.typeface =
            Typeface.createFromAsset(requireContext().assets, "fonts/ma_shan_zheng.ttf")

        flechaDevolverImagen.setOnClickListener {
            requireActivity().supportFragmentManager.popBackStack()
            val palabrasNuevas = Leccion1PalabrasNuevas()
            requireActivity().supportFragmentManager.beginTransaction().apply {
                replace(R.id.fl_wrapper, palabrasNuevas)
                commit()
            }
        }

        binding.haoGif.setOnClickListener {
            if (MediaPlayer == null) {
                MediaPlayer =
                    android.media.MediaPlayer.create(requireContext(), R.raw.pronunciation_zh_hao)
            }
            MediaPlayer?.apply {
                if (isPlaying) {
                    pause()
                    seekTo(0)
                } else {
                    start()
                }
            }
        }



        return binding.root
    }

}