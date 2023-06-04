package com.example.sof3011_java5.service;

import com.example.sof3011_java5.entities.ChiTietSp;
import com.example.sof3011_java5.entities.NhanVien;
import com.example.sof3011_java5.models.ChiTietSPViewModel;
import com.example.sof3011_java5.models.NhanVienViewModel;

import java.util.List;
import java.util.UUID;

public interface ChiTietSanPhamService {
    public List<ChiTietSPViewModel> findAll();
    public ChiTietSp getById(UUID id);
    public void saveOrUpdate(ChiTietSPViewModel chiTietSPViewModel);
    public void deleteById(UUID id);

}
