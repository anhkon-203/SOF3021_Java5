package com.example.sof3011_java5.services;

import com.example.sof3011_java5.entities.ChiTietSp;
import com.example.sof3011_java5.models.ChiTietSPViewModel;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.UUID;

public interface ChiTietSanPhamService {
    public List<ChiTietSPViewModel> findAll();
    public ChiTietSp getById(UUID id);
    public void saveOrUpdate(ChiTietSPViewModel chiTietSPViewModel);
    public void deleteById(UUID id);

    public List<ChiTietSPViewModel> findBySanPhamId(UUID id);

    public List<ChiTietSPViewModel> findByTenDongSP(String tenDongSP);

    public String findTenDongSP(UUID id);

    public Integer getSoLuong(UUID idChiTietSp);
    public void updateSoLuong(Integer soLuong, UUID idChiTietSp);

    public Page<ChiTietSPViewModel> findAllPage(Pageable pageable);




}
