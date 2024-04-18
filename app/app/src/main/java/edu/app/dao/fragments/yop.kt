package edu.app.dao.fragments

import android.os.Bundle
import android.content.Context
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.widget.Toolbar
import edu.app.dao.R
import edu.app.dao.databinding.FragmentYopBinding
import edu.app.dao.databinding.PrincipalBinding


class yop : Fragment() {

    private lateinit var binding: FragmentYopBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentYopBinding.inflate(inflater, container, false)
        val toolbar = requireActivity().findViewById<Toolbar>(R.id.toolbar)

        val toolbarText = requireActivity().findViewById<TextView>(R.id.toolbar_title)
        toolbarText.text = "Editar Perfil"

        binding.backgroundProfile.setOnClickListener {
            Toast.makeText(requireContext(), "Has dado click en la imagen!", Toast.LENGTH_SHORT).show()
        }

        toolbar.setOnClickListener {
            Toast.makeText(requireContext(), "Has dado click en Editar Perfil!", Toast.LENGTH_SHORT).show()
        }

        return binding.root
    }

}