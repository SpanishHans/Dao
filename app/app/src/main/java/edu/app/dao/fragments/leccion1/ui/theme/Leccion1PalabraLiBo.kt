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
import edu.app.dao.databinding.FragmentLeccion1PalabraLiBoBinding

class Leccion1PalabraLiBo : Fragment() {

    private lateinit var binding: FragmentLeccion1PalabraLiBoBinding
    private var liMediaplayer: MediaPlayer? = null
    private var boMediaPlayer: MediaPlayer? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentLeccion1PalabraLiBoBinding.inflate(inflater, container, false)
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

        binding.liGif.setOnClickListener {
            if (liMediaplayer == null) {
                liMediaplayer = MediaPlayer.create(requireContext(), R.raw.pronunciation_zh_li)
            }
            liMediaplayer?.apply {
                if (isPlaying) {
                    pause()
                    seekTo(0)
                } else {
                    start()
                }
            }
        }

        binding.boGif.setOnClickListener {
            if (boMediaPlayer == null) {
                boMediaPlayer = MediaPlayer.create(requireContext(), R.raw.pronunciation_zh_bo)
            }
            boMediaPlayer?.apply {
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

    override fun onDestroy() {
        liMediaplayer?.release()
        boMediaPlayer?.release()
        super.onDestroy()
    }

}