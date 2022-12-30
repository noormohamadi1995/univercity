package com.example.univercity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import com.google.android.material.button.MaterialButton

class DashbordActivity : AppCompatActivity() {
    var btnReserve : MaterialButton? = null
    var btnAddQouta : MaterialButton? = null
    var btnKarnameh : MaterialButton? = null
    var btnSurvivors : MaterialButton? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dashbord)

        btnReserve = findViewById(R.id.btnRezerve)
        btnAddQouta = findViewById(R.id.btnAddQouta)
        btnKarnameh = findViewById(R.id.btnKarname)
        btnSurvivors = findViewById(R.id.btnSurvivors)

        btnReserve?.setOnClickListener {
            val intent = Intent(this@DashbordActivity,FoodListActivity::class.java)
            startActivity(intent)
        }

        btnAddQouta?.setOnClickListener {
            Toast.makeText(this,btnAddQouta?.text,Toast.LENGTH_SHORT).show()
        }

        btnKarnameh?.setOnClickListener {
            Toast.makeText(this,btnKarnameh?.text,Toast.LENGTH_SHORT).show()
        }

        btnSurvivors?.setOnClickListener {
            Toast.makeText(this,btnSurvivors?.text,Toast.LENGTH_SHORT).show()
        }
    }
}