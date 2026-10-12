package com.example.baitapmoi

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity

class ChinhSuaCongViecActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_chinh_sua_cong_viec)

        val edtSuaTen = findViewById<EditText>(R.id.edtSuaTen)
        val edtSuaMoTa = findViewById<EditText>(R.id.edtSuaMoTa)
        val btnLuu = findViewById<Button>(R.id.btnLuu)

        val currentTen = intent.getStringExtra("TEN_CU")
        val currentMoTa = intent.getStringExtra("MOTA_CU")
        edtSuaTen.setText(currentTen)
        edtSuaMoTa.setText(currentMoTa)

        btnLuu.setOnClickListener {
            val resultIntent = Intent().apply {
                putExtra("TEN_MOI", edtSuaTen.text.toString())
                putExtra("MOTA_MOI", edtSuaMoTa.text.toString())
            }
            setResult(RESULT_OK, resultIntent)
            finish()
        }
    }
}