package edu.app.dao.fragments

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import edu.app.dao.R

import edu.app.dao.databinding.PrincipalBinding


/*
----------------------------------------------
|Recordar:                                   |
|    Corregir Muchas cosas jfdslkajkld       |
----------------------------------------------
 */
class InicioPrincipal : AppCompatActivity() {


    private lateinit var binding: PrincipalBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        supportActionBar?.hide()
        binding = PrincipalBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Instancias de los fragmentos para luego ser utilizados
        val kongFragment = kong()
        val yopFragment = yop()
        val taoFragment = Tao()
        val murallaFragment = Muralla()

        makeCurrentFragment(kongFragment)

        binding.navigationBarButtom.setOnItemSelectedListener{
            when (it.itemId){
                R.id.ic_Kong -> makeCurrentFragment(kongFragment)
                R.id.ic_wo -> makeCurrentFragment(yopFragment)
                R.id.ic_tao -> makeCurrentFragment(taoFragment)
                R.id.ic_muralla -> makeCurrentFragment(murallaFragment)
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
