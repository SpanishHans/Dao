package edu.app.dao.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import edu.app.dao.R
import edu.app.dao.databinding.FragmentBackgroundPicBinding

class BackgroundPic : Fragment() {

    private lateinit var binding: FragmentBackgroundPicBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentBackgroundPicBinding.inflate(inflater, container, false)
        return binding.root
    }

}