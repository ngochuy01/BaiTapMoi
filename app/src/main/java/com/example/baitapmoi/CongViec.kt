package com.example.baitapmoi

import java.io.Serializable

data class CongViec(
    var maCongViec: String, // Bổ sung thuộc tính mã công việc (Yêu cầu 1)
    var tenCongViec: String,
    var moTa: String,
    var trangThai: Boolean = false // false: chưa hoàn thành, true: đã hoàn thành
) : Serializable {

    // Hàm trả về chuỗi thông tin công việc
    fun layThongTinChiTiet(): String {
        val trangThaiStr = if (trangThai) "Đã hoàn thành" else "Chưa hoàn thành"
        return "Mã CV: $maCongViec\nTên: $tenCongViec\nMô tả: $moTa\nTrạng thái: $trangThaiStr"
    }

    // Bổ sung hàm laDaHoanThanh() (Yêu cầu 4)
    fun laDaHoanThanh(): Boolean {
        return trangThai
    }
}