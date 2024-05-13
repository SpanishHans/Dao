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
import androidx.activity.OnBackPressedCallback
import androidx.core.content.ContextCompat
import edu.app.dao.R
import edu.app.dao.databinding.FragmentGamemodeCompletar1Binding

class FragmentoCompletar : Fragment() {
    private lateinit var binding: FragmentGamemodeCompletar1Binding
    private lateinit var contextParagraphTextView: TextView
    private lateinit var submitButton: Button

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentGamemodeCompletar1Binding.inflate(inflater, container, false)
        contextParagraphTextView = binding.textoEjCompletar5Parte2
        submitButton = binding.botonSubmitCompletar


        submitButton.setOnClickListener {
            val userInput = mutableListOf<String>()
            val correctAnswer = listOf<String>()
        }

        return binding.root
    }
}
