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
import edu.app.dao.databinding.FragmentLeccion1PalabraLuYuPingBinding
import edu.app.dao.databinding.FragmentLeccion1PalabraNiBinding

class Leccion1PalabraLuYuPing : Fragment() {

    private lateinit var binding: FragmentLeccion1PalabraLuYuPingBinding
    private var luMediaPlayer: MediaPlayer? = null
    private var yuMediaPlayer: MediaPlayer? = null
    private var pingMediaPlayer: MediaPlayer? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentLeccion1PalabraLuYuPingBinding.inflate(inflater, container, false)
        val toolbarText = requireActivity().findViewById<TextView>(R.id.toolbar_title)
        val flechaDevolverImagen = requireActivity().findViewById<ImageButton>(R.id.flecha_devolver_imagen)
        toolbarText.text = "你好-生词"
        toolbarText.textSize = 35F
        toolbarText.typeface = Typeface.createFromAsset(requireContext().assets, "fonts/ma_shan_zheng.ttf")

        flechaDevolverImagen.setOnClickListener {
            requireActivity().supportFragmentManager.popBackStack()
            val palabrasNuevas = Leccion1PalabrasNuevas()
            requireActivity().supportFragmentManager.beginTransaction().apply {
                replace(R.id.fl_wrapper, palabrasNuevas)
                commit()
            }
        }

        binding.luGif.setOnClickListener {
            if (luMediaPlayer == null) {
                luMediaPlayer = MediaPlayer.create(requireContext(), R.raw.pronunciation_zh_lu)
            }
            luMediaPlayer?.apply {
                if (isPlaying) {
                    pause()
                    seekTo(0)
                } else {
                    start()
                }
            }
        }

        binding.yuGif.setOnClickListener {
            if (yuMediaPlayer == null) {
                yuMediaPlayer = MediaPlayer.create(requireContext(), R.raw.pronunciation_zh_yu)
            }
            yuMediaPlayer?.apply {
                if (isPlaying) {
                    pause()
                    seekTo(0)
                } else {
                    start()
                }
            }
        }

        binding.pingGif.setOnClickListener {
            if (pingMediaPlayer == null) {
                pingMediaPlayer = MediaPlayer.create(requireContext(), R.raw.pronunciation_zh_ping)
            }
            pingMediaPlayer?.apply {
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
        luMediaPlayer?.release()
        yuMediaPlayer?.release()
        pingMediaPlayer?.release()
        super.onDestroy()
    }
}