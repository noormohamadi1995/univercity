package com.example.univercity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.google.android.material.button.MaterialButton
import com.google.android.material.textfield.TextInputEditText

class ForgotPasswordActivity : AppCompatActivity() {
    var edtEmail : TextInputEditText? = null
    var btnSabt : MaterialButton? = null
    var edtCode : TextInputEditText? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_forgot_password)

        edtEmail = findViewById(R.id.edt_email)
        btnSabt = findViewById(R.id.btnSabt)
        edtCode = findViewById(R.id.edt_code)

        btnSabt?.setOnClickListener {
            val res = edtEmail?.text.toString()
            if (res.isEmpty()){
                Toast.makeText(this,"ورودی نمیتواند خالی باشد.", Toast.LENGTH_SHORT).show()
            }
        }
    }
}