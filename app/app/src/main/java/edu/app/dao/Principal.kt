package edu.app.dao

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import androidx.navigation.fragment.findNavController
import edu.app.dao.databinding.FragmentPrincipalBinding


class Principal : Fragment() {

    private lateinit var binding: FragmentPrincipalBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val root = inflater.inflate(R.layout.principal, container, false)

        val btnYop = root.findViewById<ImageButton>(R.id.Wo)

//        btnYop.setOnClickListener {
//            findNavController().navigate(R.id.action_principal_to_yop2)
//        }

        return root
    }

}