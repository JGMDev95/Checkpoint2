package com.talma.spotify.activities

import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import com.talma.spotify.R
import com.talma.spotify.models.RecuperaModel
import android.widget.Toast

val listUserContact = listOf(
    RecuperaModel("1234@gmail.com"),
    RecuperaModel("12345@gmail.com")
)
class RecuperaPassActivity : AppCompatActivity() {
    private lateinit var userMail: EditText
    private lateinit var btnSend: Button


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_recuperapassword)

        userMail = findViewById(R.id.txtEmailUser)
        btnSend = findViewById(R.id.btnSendMail)

        btnSend.setOnClickListener {
            when {
                userMail.text.toString() == "" -> Toast.makeText(
                    this,
                    R.string.error_mail,
                    Toast.LENGTH_SHORT
                ).show()
                else -> {
                    val recuperaModel = RecuperaModel(userMail.text.toString())
                    val recuperaModels = if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
                        listUserContact.stream()
                            .filter { user -> user.userMail == recuperaModel.userMail }.findFirst()
                            .orElse(null)
                    } else {
                        var find: RecuperaModel? = null
                        for (user in listUserContact) {
                            if (user.userMail == recuperaModel.userMail) {
                                find = user
                            }
                        }
                        find
                    }
                    if (recuperaModels != null){
                        Toast.makeText(this, R.string.txtsend_mail, Toast.LENGTH_SHORT).show()
                    } else {
                        Toast.makeText(this, R.string.mailWrong, Toast.LENGTH_SHORT).show()
                    }
                }

            }
        }
    }
}


