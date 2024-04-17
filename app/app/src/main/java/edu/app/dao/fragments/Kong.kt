package edu.app.dao.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.appcompat.widget.Toolbar
import edu.app.dao.R
import edu.app.dao.databinding.FragmentKongBinding


class kong : Fragment() {

    private lateinit var binding: FragmentKongBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentKongBinding.inflate(inflater, container, false)
        val toolbar = requireActivity().findViewById<Toolbar>(R.id.toolbar)

        val toolbarText = requireActivity().findViewById<TextView>(R.id.toolbar_title)
        toolbarText.text = "Templo"

        return binding.root
    }

}