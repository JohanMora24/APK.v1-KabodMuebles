package com.kabodmuebles

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.auth.FirebaseAuth

class HomeActivity : AppCompatActivity() {

    private lateinit var auth: FirebaseAuth
    private lateinit var txtWelcome: TextView
    private lateinit var btnLogout: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        auth = FirebaseAuth.getInstance()

        txtWelcome = findViewById(R.id.txtWelcome)
        btnLogout = findViewById(R.id.btnLogout)

        // Mostrar correo pasado desde login
        val emailUsuario = intent.getStringExtra("emailUsuario")
        txtWelcome.text = "Bienvenido, $emailUsuario"

        // Cerrar sesión
        btnLogout.setOnClickListener {
            auth.signOut()
            startActivity(Intent(this, MainActivity::class.java))
            finish()
        }
    }
}

