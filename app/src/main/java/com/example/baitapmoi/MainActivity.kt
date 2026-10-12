package com.example.baitapmoi

import android.os.Bundle
import android.widget.EditText
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    private lateinit var edtTenCongViec: EditText
    private lateinit var edtMoTa: EditText
    private lateinit var btnTaoCongViec: Button
    private lateinit var btnXemDanhSach: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        edtTenCongViec = findViewById(R.id.edtTenCongViec)
        edtMoTa = findViewById(R.id.edtMoTa)
        btnTaoCongViec = findViewById(R.id.btnTaoCongViec)
        btnXemDanhSach = findViewById(R.id.btnXemDanhSach)

        btnTaoCongViec.setOnClickListener {
            val tenCV = edtTenCongViec.text.toString()
            val moTa = edtMoTa.text.toString()
            Toast.makeText(this, "Da nhap: $tenCV", Toast.LENGTH_SHORT).show()
        }

        btnXemDanhSach.setOnClickListener {
            Toast.makeText(this, "Chuc nang xem danh sach dang phat trien", Toast.LENGTH_SHORT).show()
        }
    }
}