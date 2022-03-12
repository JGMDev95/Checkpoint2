package com.talma.spotify.activities

import android.content.Intent
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.annotation.RequiresApi
import com.talma.spotify.R
import com.talma.spotify.models.LoginModel
import com.talma.spotify.models.PlaylistModel

val userList = listOf(
    LoginModel("Jgm1", "123456"),
    LoginModel("Jgm2", "123456")
)

class LoginActivity : AppCompatActivity() {
    private lateinit var btnLogin: Button
    private lateinit var btnRecuperaPass: Button
    private lateinit var txtGetUser: TextView
    private lateinit var txtGetPassword: TextView

    @RequiresApi(Build.VERSION_CODES.N)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        Log.d("activities", "onCreate Login")

        btnLogin = findViewById(R.id.btnLogin)
        txtGetUser = findViewById(R.id.txtGetUser)
        txtGetPassword = findViewById(R.id.txtGetPassword)
        btnRecuperaPass = findViewById(R.id.btnRecuperaPass)

        val btnLogin =findViewById<Button>(R.id.btnLogin)
        btnLogin.setOnClickListener {
            when {
                txtGetUser.text.toString() == "" -> Toast.makeText(
                    this,
                    R.string.error_user,
                    Toast.LENGTH_SHORT
                ).show()
                txtGetPassword.text.toString() == "" -> Toast.makeText(
                    this,
                    R.string.error_pass,
                    Toast.LENGTH_SHORT
                ).show()
                //else -> Toast.makeText(this, R.string.login_success, Toast.LENGTH_SHORT).show()
                else -> {
                    val userModel =
                        LoginModel(txtGetUser.text.toString(), txtGetPassword.text.toString())
                    val userModels = if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
                        userList.stream()
                            .filter { user -> user.userName == userModel.userName && user.userPassword == userModel.userPassword }
                            .findFirst().orElse(null)
                    } else {
                        var find: LoginModel? = null
                        for (user in userList) {
                            if (user.userName == userModel.userName && user.userPassword == userModel.userPassword) {
                                find = user
                            }
                        }
                        find
                    }
                    if (userModels != null) {
                        Toast.makeText(this, R.string.login_success, Toast.LENGTH_SHORT).show()
                        val intent = Intent( this, MainActivity::class.java)
                        startActivity(intent)
                    } else {
                        Toast.makeText(this, R.string.login_failed, Toast.LENGTH_SHORT).show()
                    }
                }
            }
        }

        btnRecuperaPass.setOnClickListener {
            val intent = Intent( this, RecuperaPassActivity::class.java)
            startActivity(intent)
        }
    }
}