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

        // Define the paragraph text with the fill-in-the-blank word
        val paragraph = "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Nullam sit amet velit nec est gravida [vehicula]. Nam id bibendum ipsum. Duis eleifend orci sit amet urna dapibus, vitae pretium urna pulvinar. Sed ultricies tellus eget nibh fringilla, nec consectetur lacus tempor. Phasellus nec malesuada risus."

        // Create a SpannableString for the paragraph with the fill-in-the-blank word as an EditText
        val spannableString = SpannableString(paragraph)
        val fillWordStart = paragraph.indexOf("[")
        val fillWordEnd = paragraph.indexOf("]") + 1
        val editText = EditText(requireContext())
        editText.hint = "Fill in the missing word"
        editText.setBackgroundColor(ContextCompat.getColor(requireContext(), android.R.color.transparent))
        spannableString.setSpan(editText, fillWordStart, fillWordEnd, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE)
        val callback = object : OnBackPressedCallback(true){
            override fun handleOnBackPressed() {
            }
        }
        requireActivity().onBackPressedDispatcher.addCallback(viewLifecycleOwner, callback)
        // Set the SpannableString to the TextView
        contextParagraphTextView.text = spannableString

        submitButton.setOnClickListener {
            val userInput = mutableListOf<String>()
            val correctAnswer = listOf<String>()
        }

        return binding.root
    }
}
