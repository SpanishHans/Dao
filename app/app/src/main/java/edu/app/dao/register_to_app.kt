package edu.app.dao

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.FirebaseApp
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener
import edu.app.dao.databinding.RegisterToAppLayoutBinding

class RegisterToApp : AppCompatActivity() {

    /*
        Declaración del binding con el layout register_to_app_layout
        El nombre RegisterToAppLayoutBinding sale del archivo .xml
        mencionado anteriormente y se genera automáticamente.
     */
    private lateinit var binding: RegisterToAppLayoutBinding
    /*
    Aquí se declara las bases de datos, esto luego toca hacer un sync en el gradle para que se
    pueda utilizar la FirebaseDatabase junto con la otra variable
     */
    private lateinit var firebaseDataBase: FirebaseDatabase
    private lateinit var databaseReference: DatabaseReference

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // Se utiliza el binding para inflar la vista y meterse como raiz
        binding = RegisterToAppLayoutBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Se inicializan las variables para guardarse en la base de datos
        firebaseDataBase = FirebaseDatabase.getInstance()
        /*
            Usuarios es el nombre de una base de datos, entonces cuando se quiera llamar la
            base de datos, toca tener en cuenta el nombre Usuarios
         */
        databaseReference = firebaseDataBase.reference.child("Usuarios")

        binding.registerButtonRegistrarse.setOnClickListener {
            val signupFullname = binding.registerNombre.text.toString()
            val signupUsername = binding.registerUsuario.text.toString()
            val signupCorreo = binding.registerEmail.text.toString()
            val signupPassword = binding.registerPassword.text.toString()

            if (signupFullname.isNotEmpty() && signupUsername.isNotEmpty()
                && signupCorreo.isNotEmpty() && signupPassword.isNotEmpty()){
                registrarUsuario(signupFullname, signupUsername, signupCorreo, signupPassword)
            }else{
                Toast.makeText(this@RegisterToApp, "Todos los campos son obligatorios", Toast.LENGTH_SHORT).show()
            }
        }

        binding.buttonLoginVolver.setOnClickListener {
            startActivity(Intent(this@RegisterToApp, LoginToApp::class.java))
            finish()
        }
    }


    // Se va a crear la función registrar usuario
    private fun registrarUsuario(nameFull: String, username: String, correo: String, password: String){
        /*
        Argumentos:
            nameFull: type -> String
            password: type -> String
         */
        databaseReference.orderByChild("nameFull").equalTo(nameFull).addListenerForSingleValueEvent(object : ValueEventListener{
            override fun onDataChange(dataSnapshot: DataSnapshot) {
                if (!dataSnapshot.exists()){
                    val id = databaseReference.push().key
                    val userData = UserData(id, nameFull, username, correo, password)
                    databaseReference.child(id!!).setValue(userData)
                    Toast.makeText(this@RegisterToApp, "Registro Exitoso!", Toast.LENGTH_SHORT).show()
                    startActivity(Intent(this@RegisterToApp, WelcomeToApp::class.java))
                    finish()
                } else{
                    Toast.makeText(this@RegisterToApp, "El usuario ya existe", Toast.LENGTH_SHORT).show()

                }
            }

            override fun onCancelled(databaseError: DatabaseError) {
                Toast.makeText(this@RegisterToApp, "Error en la base de datos: ${databaseError.message}", Toast.LENGTH_SHORT).show()
            }
        })
    }
}