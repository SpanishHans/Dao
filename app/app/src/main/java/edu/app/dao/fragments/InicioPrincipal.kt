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
        // Oculta la barra de acción
        supportActionBar?.hide()

        // Se coloca el Layout: principal.xml como raíz
        binding = PrincipalBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Instancias de los fragmentos para luego ser utilizados
        val kongFragment = kong()
        val yopFragment = yop()
        val taoFragment = Tao()
        val murallaFragment = Muralla()

        // Hacer que cuando se inicie esta actividad, que el fragmento que diriga sea el de Kong (Dojo)
        makeCurrentFragment(kongFragment)

        // Controla la navegación a las diferentes secciones de la aplicación.
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

    // Función para hacer que se ponga el fragmento
    private fun makeCurrentFragment(fragment: Fragment){
        supportFragmentManager.beginTransaction().apply {
            replace(R.id.fl_wrapper, fragment)
            commit()
        }
    }
}
