package com.example.baitapmoi

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity

class ChiTietCongViecActivity : AppCompatActivity() {
    private lateinit var tvChiTietTen: TextView
    private lateinit var tvChiTietMoTa: TextView
    private lateinit var btnChinhSua: Button

    // Đăng ký Activity Result API đúng cú pháp
    private val editLauncher = registerForActivityResult(
        ActivityResultContracts.StartActivityForResult()
    ) { result ->
        if (result.resultCode == RESULT_OK) {
            val data = result.data
            val tenMoi = data?.getStringExtra("TEN_MOI")
            val moTaMoi = data?.getStringExtra("MOTA_MOI")

            tvChiTietTen.text = "Ten cong viec: $tenMoi"
            tvChiTietMoTa.text = "Mo ta: $moTaMoi"
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_chi_tiet_cong_viec)

        tvChiTietTen = findViewById(R.id.tvChiTietTen)
        tvChiTietMoTa = findViewById(R.id.tvChiTietMoTa)
        btnChinhSua = findViewById(R.id.btnChinhSua)

        val tenCV = intent.getStringExtra("TEN_CONG_VIEC")
        val moTa = intent.getStringExtra("MO_TA")

        tvChiTietTen.text = "Ten cong viec: $tenCV"
        tvChiTietMoTa.text = "Mo ta: $moTa"

        btnChinhSua.setOnClickListener {
            val intent = Intent(this, ChinhSuaCongViecActivity::class.java).apply {
                putExtra("TEN_CU", tenCV)
                putExtra("MOTA_CU", moTa)
            }
            editLauncher.launch(intent)
        }
    }
}