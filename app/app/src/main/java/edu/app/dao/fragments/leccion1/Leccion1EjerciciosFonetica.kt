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
        val flechaDevolverImagen = requireActivity().findViewById<ImageButton>(R.id.flecha_devolver_imagen)
        toolbarText.text = "你好-语音练习"
        toolbarText.typeface = Typeface.createFromAsset(requireContext().assets, "fonts/ma_shan_zheng.ttf")
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


        return binding.root
    }
    private fun reproducirSonido(soundId: Int){
        val mediaPlayer = MediaPlayer.create(requireContext(), soundId)
        mediaPlayer.start()

        mediaPlayer.setOnCompletionListener {
            mediaPlayer.release()
        }
    }
}