package com.example.sof3011_java5.services;

import com.example.sof3011_java5.entities.GioHang;
import com.example.sof3011_java5.models.GioHangViewModel;
import com.example.sof3011_java5.models.KhachHangViewModel;

import java.util.UUID;

public interface GioHangService {
    public void saveOrUpdate(GioHangViewModel gioHangViewModel);
    public GioHang findByKhachHangIdAndTrangThai(UUID idKhachHang);
}
