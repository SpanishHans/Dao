package edu.app.dao.completar

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import android.widget.EditText

import android.text.SpannableString
import android.text.Spanned
import android.view.WindowManager
import android.widget.FrameLayout
import android.widget.Toast
import androidx.activity.OnBackPressedCallback
import androidx.core.content.ContextCompat
import androidx.fragment.app.replace
import edu.app.dao.R
import edu.app.dao.databinding.FragmentGamemodeCompletar1Binding
import edu.app.dao.fragments.Kong
import edu.app.dao.fragments.Muralla

class FragmentoCompletar : Fragment() {
    private lateinit var binding: FragmentGamemodeCompletar1Binding
    private lateinit var contextParagraphTextView: TextView
    private lateinit var submitButton: Button
    private lateinit var continueButton: Button

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        activity?.window?.setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_ADJUST_RESIZE)
        binding = FragmentGamemodeCompletar1Binding.inflate(inflater, container, false)
        submitButton = binding.botonSubmitCompletar
        continueButton = binding.buttonContinuar
        continueButton.visibility = View.GONE
        var correctUser: Int = 0
        val userInput = mutableListOf<EditText>(
            binding.textoEjCompletar1Input,
            binding.textoEjCompletar2Input,
            binding.textoEjCompletar3Input,
            binding.textoEjCompletar4Input,
            binding.textoEjCompletar5Input
        )
        val correctAnswer = listOf<String>("力波", "你好", "吗", "呢", "好")
        val toolbar = requireActivity().findViewById<FrameLayout>(R.id.frame_layout_bar_buttom)

        toolbar.visibility = View.GONE
        submitButton.setOnClickListener {
            continueButton.visibility = View.VISIBLE
            for (i in correctAnswer.indices) {
                if (userInput[i].text.toString() == correctAnswer[i]) {
                    correctUser += 1
                    userInput[i].backgroundTintList =
                        ContextCompat.getColorStateList(requireContext(), R.color.green_correct)
                } else {
                    userInput[i].backgroundTintList =
                        ContextCompat.getColorStateList(requireContext(), R.color.red_incorrect)
                }
            }
            Toast.makeText(
                requireContext(),
                "Has completado correctamente $correctUser oraciones de ${correctAnswer.size}",
                Toast.LENGTH_SHORT
            ).show()
            submitButton.isEnabled = false
        }

        continueButton.setOnClickListener {
            val mahjong = Kong()
            requireActivity().supportFragmentManager.beginTransaction().apply {
                replace(R.id.fl_wrapper, mahjong)
                commit()
            }

        }



        return binding.root
    }
}
