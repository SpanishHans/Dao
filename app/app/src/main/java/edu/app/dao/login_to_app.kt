package edu.app.dao

import android.content.Intent
import android.graphics.Color
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.FirebaseApp
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener
import edu.app.dao.databinding.LoginToAppLayoutBinding
import edu.app.dao.databinding.WelcomeToAppLayoutBinding

class LoginToApp : AppCompatActivity() {
    /*
        Declaración del binding con el layout welcome_to_app_layout
        El nombre WelcomeToAppLayoutBinding sale del archivo .xml
        mencionado anteriormente y se genera automáticamente.
     */
    private lateinit var binding: LoginToAppLayoutBinding
    private lateinit var firebaseDatabase: FirebaseDatabase
    private lateinit var databaseReference: DatabaseReference
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // Se utiliza el binding para inflar la vista y meterse como raiz
        binding = LoginToAppLayoutBinding.inflate(layoutInflater)
        setContentView(binding.root)

        firebaseDatabase = FirebaseDatabase.getInstance()
        databaseReference = firebaseDatabase.reference.child("Usuarios")

        binding.loginButtonLogin.setOnClickListener {
            val loginUsername = binding.loginUsuario.text.toString()
            val loginPassword = binding.loginPassword.text.toString()

            if (loginUsername.isNotEmpty() && loginPassword.isNotEmpty()){
                loginUser(loginUsername, loginPassword)
            } else {
                Toast.makeText(this@LoginToApp, "Todos los campos deben ser llenados", Toast.LENGTH_SHORT).show()
            }
        }

        // Se accede al id del botón de inicio del  login
        val botonRegistro =  binding.loginButtonLogin
        botonRegistro.setOnClickListener {
            val intent = Intent(this, WelcomeToApp::class.java)
            startActivity(intent)
        }
    }

    private fun loginUser(username: String, password: String){
        databaseReference.orderByChild("username").equalTo(username).addListenerForSingleValueEvent(object : ValueEventListener {
            override fun onDataChange(dataSnapshot: DataSnapshot) {
                if (dataSnapshot.exists()){
                    for (userSnapshot in dataSnapshot.children){
                        val userData = userSnapshot.getValue(UserData::class.java)

                        if (userData != null && userData.password == password){
                            Toast.makeText(this@LoginToApp, "Inicio existoso!", Toast.LENGTH_SHORT).show()
                            startActivity(Intent(this@LoginToApp, WelcomeToApp::class.java))
                            finish()
                            return
                        }
                    }
                }
                Toast.makeText(this@LoginToApp, "Inicio fallido!", Toast.LENGTH_SHORT).show()

            }

            override fun onCancelled(databaseError: DatabaseError) {
                Toast.makeText(this@LoginToApp, "Error en la base de datos ${databaseError.message}", Toast.LENGTH_SHORT).show()
            }
        })
    }

}