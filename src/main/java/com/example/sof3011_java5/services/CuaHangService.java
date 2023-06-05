package com.example.sof3011_java5.services;

import com.example.sof3011_java5.entities.CuaHang;
import com.example.sof3011_java5.models.CuaHangViewModel;

import java.util.List;
import java.util.UUID;

public interface CuaHangService {

    public List<CuaHangViewModel> findAll();
    public CuaHang getById(UUID id);
    public void saveOrUpdate(CuaHangViewModel cuaHangViewModel);
    public void deleteById(UUID id);

    public String maCHCount();


}
