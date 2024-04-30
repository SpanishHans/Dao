package edu.app.dao

import android.graphics.Typeface
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.GridLayout
import android.widget.LinearLayout
import android.widget.TextView

class GameFragment : Fragment() {

    private lateinit var targetSentenceTextView: TextView
    private lateinit var characterBarLayout: LinearLayout
    private lateinit var keyboardGridLayout: GridLayout

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_gamemode_ordenar, container, false)
        targetSentenceTextView = view.findViewById(R.id.targetSentenceTextView)
        characterBarLayout = view.findViewById(R.id.characterBarLayout)
        keyboardGridLayout = view.findViewById(R.id.keyboardGridLayout)
        setupKeyboard()
        val flechaDevolver = requireActivity().findViewById<LinearLayout>(R.id.flecha_devolver)
        flechaDevolver.visibility = View.VISIBLE
        return view
    }

    private fun setupKeyboard() {
        val keyboardCharacters = listOf(
            '你', '好', '吗', '？'
        )


        keyboardCharacters.forEach { char ->
            val button = Button(requireContext())
            button.text = char.toString()
            button.typeface = Typeface.createFromAsset(requireContext().assets,"fonts/ma_shan_zheng.ttf")
            button.textSize = 40F
            button.setOnClickListener {
                characterBarLayout.addView(Button(requireContext()).apply {
                    text = char.toString()
                    typeface = Typeface.createFromAsset(requireContext().assets,"fonts/ma_shan_zheng.ttf")
                    textSize = 40F
                    setOnClickListener { characterBarLayout.removeView(this) }
                })
                keyboardGridLayout.removeView(button)
            }
            keyboardGridLayout.addView(button)
        }
    }
}