package com.example.sof3011_java5.services;

import com.example.sof3011_java5.entities.KhachHang;
import com.example.sof3011_java5.models.KhachHangViewModel;
import com.example.sof3011_java5.request.LoginUserRequest;

import java.util.List;
import java.util.UUID;

public interface KhachHangService {

    public List<KhachHangViewModel> findAll();
    public KhachHang getById(UUID id);
    public void saveOrUpdate(KhachHangViewModel khachHangViewModel);

    public KhachHangViewModel register(KhachHangViewModel khachHangViewModel);
    public void deleteById(UUID id);

    public KhachHangViewModel checkLogin(LoginUserRequest loginUserRequest);
    public String maKHCount();


}
