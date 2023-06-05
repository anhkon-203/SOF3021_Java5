package com.example.sof3011_java5.services;

import com.example.sof3011_java5.entities.NhanVien;
import com.example.sof3011_java5.models.NhanVienViewModel;
import com.example.sof3011_java5.request.LoginAdminRequest;

import java.util.List;
import java.util.UUID;

public interface NhanVienService {

    public List<NhanVienViewModel> findAll();
    public NhanVien getById(UUID id);
    public void saveOrUpdate(NhanVienViewModel nhanVienViewModel);
    public void deleteById(UUID id);
    public NhanVienViewModel checkLogin(LoginAdminRequest loginAdminRequest);
    public String maNVCount();
}
