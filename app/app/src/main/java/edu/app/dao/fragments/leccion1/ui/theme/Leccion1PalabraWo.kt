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
import edu.app.dao.databinding.FragmentLeccion1PalabraWoBinding

class Leccion1PalabraWo : Fragment() {
    private lateinit var binding: FragmentLeccion1PalabraWoBinding
    private var MediaPlayer: MediaPlayer? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentLeccion1PalabraWoBinding.inflate(inflater, container, false)
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

        binding.woGif.setOnClickListener {
            if (MediaPlayer == null){
                MediaPlayer = android.media.MediaPlayer.create(requireContext(), R.raw.pronunciation_zh_wo)
            }
            MediaPlayer?.apply {
                if (isPlaying){
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
        MediaPlayer?.release()
        super.onDestroy()
    }


}