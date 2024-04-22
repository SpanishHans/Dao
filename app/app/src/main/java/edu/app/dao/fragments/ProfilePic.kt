package edu.app.dao.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import edu.app.dao.R
import edu.app.dao.databinding.FragmentProfilePicBinding

class ProfilePic : Fragment() {
    private lateinit var binding: FragmentProfilePicBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentProfilePicBinding.inflate(inflater, container, false)

        return binding.root
    }

}