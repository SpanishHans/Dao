package edu.app.dao

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import edu.app.dao.databinding.FragmentPrincipalBinding
import edu.app.dao.databinding.PrincipalBinding
import edu.app.dao.ui.theme.kong

class InicioPrincipal : AppCompatActivity() {

    private lateinit var binding: FragmentPrincipalBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        supportActionBar?.hide()
        binding = FragmentPrincipalBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val kongFragment = kong()
        val yopFragment = yop()


        makeCurrentFragment(kongFragment)

        binding.navigationBarButtom.setOnItemSelectedListener{
            when (it.itemId){
                R.id.ic_Kong -> makeCurrentFragment(kongFragment)
                R.id.ic_wo -> makeCurrentFragment(yopFragment)
            }
            true
        }

    }

    private fun makeCurrentFragment(fragment: Fragment){
        supportFragmentManager.beginTransaction().apply {
            replace(R.id.fl_wrapper, fragment)
            commit()
        }
    }
}
