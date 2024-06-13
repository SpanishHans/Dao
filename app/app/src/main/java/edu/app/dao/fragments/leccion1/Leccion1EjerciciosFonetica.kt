/*
    Copyright (C) 2024 Alvarado Ludwig & Martinez Juan José

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
package edu.app.dao.fragments.leccion1

import android.graphics.Typeface
import android.media.MediaPlayer
import android.os.Bundle
import android.provider.MediaStore.Audio.Media
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.FrameLayout
import android.widget.ImageButton
import android.widget.LinearLayout
import android.widget.TextView
import androidx.activity.OnBackPressedCallback
import androidx.core.os.bundleOf
import edu.app.dao.R
import edu.app.dao.databinding.FragmentLeccion1EjerciciosFoneticaBinding

class Leccion1EjerciciosFonetica : Fragment() {

    private lateinit var binding: FragmentLeccion1EjerciciosFoneticaBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentLeccion1EjerciciosFoneticaBinding.inflate(inflater, container, false)
        val toolbarText = requireActivity().findViewById<TextView>(R.id.toolbar_title)
        val toolbar = requireActivity().findViewById<FrameLayout>(R.id.frame_layout_bar_buttom)
        val flechaDevolver = requireActivity().findViewById<LinearLayout>(R.id.flecha_devolver)
        val flechaDevolverImagen =
            requireActivity().findViewById<ImageButton>(R.id.flecha_devolver_imagen)
        toolbarText.text = "你好-语音练习"
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

        binding.button1Ba1.setOnClickListener {
            reproducirSonido(R.raw.pronunciation_zh_ba1)
        }

        binding.button1Bo1.setOnClickListener {
            reproducirSonido(R.raw.pronunciation_zh_bo1)
        }

        binding.button1Bi1.setOnClickListener {
            reproducirSonido(R.raw.pronunciation_zh_bi1)
        }

        binding.button1Bu1.setOnClickListener {
            reproducirSonido(R.raw.pronunciation_zh_bu1)
        }

        binding.button1Bin1.setOnClickListener {
            reproducirSonido(R.raw.pronunciation_zh_bin1)
        }

        binding.button1Bing1.setOnClickListener {
            reproducirSonido(R.raw.pronunciation_zh_bing1)
        }

        binding.button1Pa1.setOnClickListener {
            reproducirSonido(R.raw.pronunciation_zh_pa1)
        }

        binding.button1Po1.setOnClickListener {
            reproducirSonido(R.raw.pronunciation_zh_po1)
        }

        binding.button1Pi1.setOnClickListener {
            reproducirSonido(R.raw.pronunciation_zh_pi1)
        }

        binding.button1Pu1.setOnClickListener {
            reproducirSonido(R.raw.pronunciation_zh_pu1)
        }

        binding.button1Pin1.setOnClickListener {
            reproducirSonido(R.raw.pronunciation_zh_pin1)
        }

        binding.button1Ping1.setOnClickListener {
            reproducirSonido(R.raw.pronunciation_zh_ping1)
        }

        binding.button1Ma1.setOnClickListener {
            reproducirSonido(R.raw.pronunciation_zh_ma1)
        }

        binding.button1Mo1.setOnClickListener {
            reproducirSonido(R.raw.pronunciation_zh_mo1)
        }

        binding.button1Mi1.setOnClickListener {
            reproducirSonido(R.raw.pronunciation_zh_mi1)
        }

        binding.butto1Mu1.setOnClickListener {
            reproducirSonido(R.raw.pronunciation_zh_mu1)
        }

        binding.button1Ne1.setOnClickListener {
            reproducirSonido(R.raw.pronunciation_zh_ne1)
        }

        binding.button1Nao1.setOnClickListener {
            reproducirSonido(R.raw.pronunciation_zh_nao1)
        }

        binding.button1Nie1.setOnClickListener {
            reproducirSonido(R.raw.pronunciation_zh_nie1)
        }

        binding.button1Le1.setOnClickListener {
            reproducirSonido(R.raw.pronunciation_zh_le1)
        }

        binding.button1Lao1.setOnClickListener {
            reproducirSonido(R.raw.pronunciation_zh_lao1)
        }

        binding.button1Lie1.setOnClickListener {
            reproducirSonido(R.raw.pronunciation_zh_lie1)
        }

        binding.button1Luo1.setOnClickListener {
            reproducirSonido(R.raw.pronunciation_zh_luo1)
        }

        binding.button1He1.setOnClickListener {
            reproducirSonido(R.raw.pronunciation_zh_he1)
        }

        binding.button1Hao1.setOnClickListener {
            reproducirSonido(R.raw.pronunciation_zh_hao1)
        }

        binding.button1Huo1.setOnClickListener {
            reproducirSonido(R.raw.pronunciation_zh_huo1)
        }

        binding.button2A1.setOnClickListener {
            reproducirSonido(R.raw.pronunciation_zh_a1)
        }

        binding.button2A2.setOnClickListener {
            reproducirSonido(R.raw.pronunciation_zh_a2)
        }

        binding.button2A3.setOnClickListener {
            reproducirSonido(R.raw.pronunciation_zh_a3)
        }

        binding.button2A4.setOnClickListener {
            reproducirSonido(R.raw.pronunciation_zh_a4)
        }

        binding.button2Ni1.setOnClickListener {
            reproducirSonido(R.raw.pronunciation_zh_ni1)
        }

        binding.button2Ni2.setOnClickListener {
            reproducirSonido(R.raw.pronunciation_zh_ni2)
        }

        binding.button2Ni3.setOnClickListener {
            reproducirSonido(R.raw.pronunciation_zh_ni3)
        }

        binding.button2Ni4.setOnClickListener {
            reproducirSonido(R.raw.pronunciation_zh_ni4)
        }

        binding.button2Hao1.setOnClickListener {
            reproducirSonido(R.raw.pronunciation_zh_hao1)
        }

        binding.button2Hao2.setOnClickListener {
            reproducirSonido(R.raw.pronunciation_zh_hao2)
        }

        binding.button2Hao3.setOnClickListener {
            reproducirSonido(R.raw.pronunciation_zh_hao3)
        }

        binding.button2Hao4.setOnClickListener {
            reproducirSonido(R.raw.pronunciation_zh_hao4)
        }

        binding.button2Li1.setOnClickListener {
            reproducirSonido(R.raw.pronunciation_zh_li1)
        }

        binding.button2Li2.setOnClickListener {
            reproducirSonido(R.raw.pronunciation_zh_li2)
        }

        binding.button2Li3.setOnClickListener {
            reproducirSonido(R.raw.pronunciation_zh_li3)
        }

        binding.button2Li4.setOnClickListener {
            reproducirSonido(R.raw.pronunciation_zh_li4)
        }

        binding.button2Bo1.setOnClickListener {
            reproducirSonido(R.raw.pronunciation_zh_bo1)
        }

        binding.button2Bo2.setOnClickListener {
            reproducirSonido(R.raw.pronunciation_zh_bo2)
        }

        binding.button2Bo3.setOnClickListener {
            reproducirSonido(R.raw.pronunciation_zh_bo3)
        }

        binding.button2Bo4.setOnClickListener {
            reproducirSonido(R.raw.pronunciation_zh_bo4)
        }

        binding.button2Lin1.setOnClickListener {
            reproducirSonido(R.raw.pronunciation_zh_lin1)
        }

        binding.button2Lin2.setOnClickListener {
            reproducirSonido(R.raw.pronunciation_zh_lin2)
        }

        binding.button2Lin3.setOnClickListener {
            reproducirSonido(R.raw.pronunciation_zh_lin3)
        }

        binding.button2Lin4.setOnClickListener {
            reproducirSonido(R.raw.pronunciation_zh_lin4)
        }

        binding.button2Na1.setOnClickListener {
            reproducirSonido(R.raw.pronunciation_zh_na1)
        }

        binding.button2Na2.setOnClickListener {
            reproducirSonido(R.raw.pronunciation_zh_na2)
        }

        binding.button2Na3.setOnClickListener {
            reproducirSonido(R.raw.pronunciation_zh_na3)
        }

        binding.button2Na4.setOnClickListener {
            reproducirSonido(R.raw.pronunciation_zh_na4)
        }

        binding.button2Lu1.setOnClickListener {
            reproducirSonido(R.raw.pronunciation_zh_lu1)
        }

        binding.button2Lu2.setOnClickListener {
            reproducirSonido(R.raw.pronunciation_zh_lu2)
        }

        binding.button2Lu3.setOnClickListener {
            reproducirSonido(R.raw.pronunciation_zh_lu3)
        }

        binding.button2Lu4.setOnClickListener {
            reproducirSonido(R.raw.pronunciation_zh_lu4)
        }

        binding.button2Yu1.setOnClickListener {
            reproducirSonido(R.raw.pronunciation_zh_yu1)
        }

        binding.button2Yu2.setOnClickListener {
            reproducirSonido(R.raw.pronunciation_zh_yu2)
        }

        binding.button2Yu3.setOnClickListener {
            reproducirSonido(R.raw.pronunciation_zh_yu3)
        }

        binding.button2Yu4.setOnClickListener {
            reproducirSonido(R.raw.pronunciation_zh_yu4)
        }

        binding.button2Ping1.setOnClickListener {
            reproducirSonido(R.raw.pronunciation_zh_ping1)
        }

        binding.button2Ping2.setOnClickListener {
            reproducirSonido(R.raw.pronunciation_zh_ping2)
        }

        binding.button2Wo1.setOnClickListener {
            reproducirSonido(R.raw.pronunciation_zh_wo1)
        }

        binding.button2Wo3.setOnClickListener {
            reproducirSonido(R.raw.pronunciation_zh_wo3)
        }

        binding.button2Wo4.setOnClickListener {
            reproducirSonido(R.raw.pronunciation_zh_wo4)
        }

        binding.button2Hen2.setOnClickListener {
            reproducirSonido(R.raw.pronunciation_zh_hen2)
        }

        binding.button2Hen3.setOnClickListener {
            reproducirSonido(R.raw.pronunciation_zh_hen3)
        }

        binding.button2Hen4.setOnClickListener {
            reproducirSonido(R.raw.pronunciation_zh_hen4)
        }

        binding.button2Ye1.setOnClickListener {
            reproducirSonido(R.raw.pronunciation_zh_ye1)
        }

        binding.button2Ye2.setOnClickListener {
            reproducirSonido(R.raw.pronunciation_zh_ye2)
        }

        binding.button2Ye3.setOnClickListener {
            reproducirSonido(R.raw.pronunciation_zh_ye3)
        }

        binding.button2Ye4.setOnClickListener {
            reproducirSonido(R.raw.pronunciation_zh_ye4)
        }
        return binding.root
    }

    private fun reproducirSonido(soundId: Int) {
        val mediaPlayer = MediaPlayer.create(requireContext(), soundId)
        mediaPlayer.start()

        mediaPlayer.setOnCompletionListener {
            mediaPlayer.release()
        }
    }
}