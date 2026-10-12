package com.example.baitapmoi

import android.os.Bundle
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class ChiTietCongViecActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_chi_tiet_cong_viec)

        val tvChiTietTen = findViewById<TextView>(R.id.tvChiTietTen)
        val tvChiTietMoTa = findViewById<TextView>(R.id.tvChiTietMoTa)

        val tenCV = intent.getStringExtra("TEN_CONG_VIEC")
        val moTa = intent.getStringExtra("MO_TA")

        tvChiTietTen.text = "Ten cong viec: $tenCV"
        tvChiTietMoTa.text = "Mo ta: $moTa"
    }
}