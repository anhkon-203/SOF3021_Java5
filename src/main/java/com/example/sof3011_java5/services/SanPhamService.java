package com.example.sof3011_java5.services;

import com.example.sof3011_java5.entities.SanPham;
import com.example.sof3011_java5.models.SanPhamViewModel;

import java.nio.file.Path;
import java.util.List;
import java.util.UUID;

public interface SanPhamService {

    public List<SanPhamViewModel> findAll();
    public SanPham getById(UUID id);
    public void saveOrUpdate(SanPhamViewModel sanPhamViewModel, Path path);
    public void deleteById(UUID id);

    public String maSPcount();


}
