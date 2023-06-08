package com.example.sof3011_java5.services;

import com.example.sof3011_java5.entities.GioHangChiTiet;
import com.example.sof3011_java5.models.GioHangChiTietViewModel;

import java.util.List;
import java.util.UUID;

public interface GioHangChiTietService {

    public boolean save(GioHangChiTietViewModel gioHangChiTietViewModel);


    public List<GioHangChiTietViewModel> findAllByGioHangId(UUID id);

    public List<GioHangChiTietViewModel> findGioHangChiTietByGioHangId(UUID id);

    public boolean deleteById(UUID chiTietSPId, UUID gioHangId);

    public Integer soLuongSanPham(UUID idGioHang, UUID idSanPham);

    public boolean isProductExistsInCart(UUID idGioHang, UUID idSanPham);

   public GioHangChiTiet findByChiTietSpIdAndGioHangId(UUID chiTietSpId, UUID gioHangId);

    GioHangChiTiet findByGioHangIdAndChiTietSpId(UUID gioHangId, UUID chiTietSpId);
    public void deleteGioHangChiTiet(UUID id);


}
