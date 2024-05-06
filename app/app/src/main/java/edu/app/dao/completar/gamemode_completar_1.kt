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
import androidx.core.content.ContextCompat
import edu.app.dao.R

class FragmentoCompletar : Fragment() {

    private lateinit var contextParagraphTextView: TextView
    private lateinit var submitButton: Button

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_gamemode_completar_1, container, false)
        contextParagraphTextView = view.findViewById(R.id.parrafo_completar_1)
        submitButton = view.findViewById(R.id.boton_submit_completar)

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

        // Set the SpannableString to the TextView
        contextParagraphTextView.text = spannableString

        submitButton.setOnClickListener {
            val userInput = editText.text.toString()
            val correctAnswer = "vehicula"
            if (userInput.equals(correctAnswer, ignoreCase = true)) {
                // User answered correctly
                // You can perform any actions here, like showing a toast or moving to the next question
            } else {
                // User answered incorrectly
                // You can provide feedback or let them try again
            }
        }

        return view
    }
}
