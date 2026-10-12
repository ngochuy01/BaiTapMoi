package com.example.baitapmoi

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity

class ChiTietCongViecActivity : AppCompatActivity() {
    private lateinit var tvChiTietMa: TextView
    private lateinit var tvChiTietTen: TextView
    private lateinit var tvChiTietMoTa: TextView
    private lateinit var tvChiTietTrangThai: TextView
    private lateinit var btnHoanThanh: Button
    private lateinit var btnChinhSua: Button

    private var congViec: CongViec? = null

    private val editLauncher = registerForActivityResult(
        ActivityResultContracts.StartActivityForResult()
    ) { result ->
        if (result.resultCode == RESULT_OK) {
            val data = result.data
            congViec?.tenCongViec = data?.getStringExtra("TEN_MOI") ?: ""
            congViec?.moTa = data?.getStringExtra("MOTA_MOI") ?: ""
            capNhatGiaoDien()
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_chi_tiet_cong_viec)

        tvChiTietMa = findViewById(R.id.tvChiTietMa)
        tvChiTietTen = findViewById(R.id.tvChiTietTen)
        tvChiTietMoTa = findViewById(R.id.tvChiTietMoTa)
        tvChiTietTrangThai = findViewById(R.id.tvChiTietTrangThai)
        btnHoanThanh = findViewById(R.id.btnHoanThanh)
        btnChinhSua = findViewById(R.id.btnChinhSua)

        // Nhận đối tượng CongViec từ Intent
        congViec = intent.getSerializableExtra("OBJECT_CV") as? CongViec
        capNhatGiaoDien()

        // Xử lý nút Hoàn thành (Yêu cầu 3)
        btnHoanThanh.setOnClickListener {
            congViec?.trangThai = true
            capNhatGiaoDien()
        }

        btnChinhSua.setOnClickListener {
            val intent = Intent(this, ChinhSuaCongViecActivity::class.java).apply {
                putExtra("TEN_CU", congViec?.tenCongViec)
                putExtra("MOTA_CU", congViec?.moTa)
            }
            editLauncher.launch(intent)
        }
    }

    // Hàm cập nhật hiển thị trạng thái dựa vào laDaHoanThanh() (Yêu cầu 5)
    private fun capNhatGiaoDien() {
        congViec?.let {
            tvChiTietMa.text = "Mã công việc: ${it.maCongViec}"
            tvChiTietTen.text = "Tên công việc: ${it.tenCongViec}"
            tvChiTietMoTa.text = "Mô tả: ${it.moTa}"

            val trangThaiText = if (it.laDaHoanThanh()) "Đã hoàn thành" else "Chưa hoàn thành"
            tvChiTietTrangThai.text = "Trạng thái: $trangThaiText"
        }
    }
}