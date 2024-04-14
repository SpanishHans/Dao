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
        Declaración del binding con el layout welcome
        El nombre WelcomeToAppLayoutBinding sale del archivo .xml
        mencionado anteriormente y se genera automáticamente.
     */
    private lateinit var binding: LoginToAppLayoutBinding

    /*
    Aquí se declara las bases de datos, esto luego toca hacer un sync en el gradle para que se
    pueda utilizar la FirebaseDatabase junto con la otra variable
     */
    private lateinit var firebaseDatabase: FirebaseDatabase
    private lateinit var databaseReference: DatabaseReference

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Se utiliza el binding para inflar la vista y meterse como raiz
        binding = LoginToAppLayoutBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Se inicializan las variables para guardarse en la base de datos
        firebaseDatabase = FirebaseDatabase.getInstance()

        /*
            Usuarios es el nombre de tabla en la base de datos, entonces cuando se quiera llamar la
            base de datos, toca tener en cuenta el nombre Usuarios
         */
        databaseReference = firebaseDatabase.reference.child("Usuarios")

        /*
            Las siguientes líneas guardan en diferentes variables los datos del usuario al momento
            que se le da clic al botón de iniciar sesión dentro de la aplicación.
            También verifica que todos los campos estén llenos.
            En este caso se tienen dos variables; loginUsername y loginPassword
         */
        binding.loginButtonLogin.setOnClickListener {
            val loginUsername = binding.loginUsuario.text.toString()
            val loginPassword = binding.loginPassword.text.toString()

            // Si no están vacíos manda los valores a la función loginUser, si no, salta un aviso.
            if (loginUsername.isNotEmpty() && loginPassword.isNotEmpty()){
                loginUser(loginUsername, loginPassword)
            } else {
                Toast.makeText(this@LoginToApp, "Todos los campos deben ser llenados", Toast.LENGTH_SHORT).show()
            }
        }

        // Se accede al id del botón de inicio del  login y al presionar se dirige a la vista WelcomeToApp
        val botonRegistro =  binding.loginButtonLogin
        botonRegistro.setOnClickListener {
            val intent = Intent(this, WelcomeToApp::class.java)
            startActivity(intent)
        }
    }

    // Creación de la función para hacer el login
    private fun loginUser(username: String, password: String){
        /*
        Argumentos:
            username: type -> String
            password: type -> String
        ¿Qué hace?:
            1. Verifica que los datos que han sido proporcionados son los correctos con los que se
                tiene en la base de datos y si sí, entonces sale un aviso de "Inicio exitoso!" y
                redirige a la vista de WelcomeToApp.
            2. Si los datos del usuario son incorrectos, es decir, no coinciden con los que hay en la
                base de datos entonces sale un aviso en la pantalla del usuario informando de
                un "Inicio fallido!"
            3. En caso de que ocurra algún error en la base de datos, este va a imprimir el error
         */

        databaseReference.orderByChild("username").equalTo(username).addListenerForSingleValueEvent(object : ValueEventListener {
            override fun onDataChange(dataSnapshot: DataSnapshot) {
                if (dataSnapshot.exists()){
                    for (userSnapshot in dataSnapshot.children){
                        val userData = userSnapshot.getValue(UserData::class.java)

                        if (userData != null && userData.password == password){
                            Toast.makeText(this@LoginToApp, "Inicio exitoso!", Toast.LENGTH_SHORT).show()

                            /*
                                -------------------- IMPORTANTE --------------------
                                Recodar cambiar la vista WelcomeToApp a las que se tengan en el inicio
                                para después de hacer el login, aquí después de presionar el login se
                                redirige a la vista WelcomeToApp, se deja así de momento para evitar
                                conflictos y que funcione el botón de iniciar sesión.
                                ----------------------------------------------------
                             */
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