package com.example.sof3011_java5.services.impl;

import com.example.sof3011_java5.entities.GioHangChiTiet;
import com.example.sof3011_java5.infrastructure.converter.GioHangChiTietConvert;
import com.example.sof3011_java5.models.GioHangChiTietViewModel;
import com.example.sof3011_java5.repositories.GioHangChiTietRepository;
import com.example.sof3011_java5.services.GioHangChiTietService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;


@Service
public class GioHangChiTietServiceImpl implements GioHangChiTietService {

    @Autowired
    private GioHangChiTietConvert gioHangChiTietConvert;

    @Autowired
    private GioHangChiTietRepository gioHangChiTietRepository;
    @Override
    public boolean save(GioHangChiTietViewModel gioHangChiTietViewModel) {
        GioHangChiTiet gioHangChiTiet = gioHangChiTietConvert.toEntity(gioHangChiTietViewModel);
        if (gioHangChiTiet != null) {
            gioHangChiTietRepository.save(gioHangChiTiet);
            return true;
        }
        return false;
    }

    @Override
    public List<GioHangChiTietViewModel> findAllByGioHangId(UUID id) {
            return gioHangChiTietConvert.listEntityToListModel(gioHangChiTietRepository.findAllByGioHangId(id));
    }

    @Override
    public List<GioHangChiTietViewModel> findGioHangChiTietByGioHangId(UUID id) {
        return gioHangChiTietConvert.listEntityToListModel(gioHangChiTietRepository.findGioHangChiTietByGioHangId(id));
    }

    @Override
    public boolean deleteById(UUID chiTietSPId, UUID gioHangId) {
        GioHangChiTiet gioHangChiTiet = gioHangChiTietRepository.findByChiTietSPIdAndGioHangId(chiTietSPId, gioHangId);
        if (gioHangChiTiet != null) {
            gioHangChiTietRepository.delete(gioHangChiTiet);
            return true;
        }
        return false;
    }

    @Override
    public Integer soLuongSanPham(UUID idGioHang, UUID idSanPham) {
        return gioHangChiTietRepository.soLuongSanPham(idGioHang, idSanPham);
    }

    @Override
    public boolean isProductExistsInCart(UUID idGioHang, UUID idSanPham) {
        if (gioHangChiTietRepository.findByChiTietSPIdAndGioHangId(idSanPham, idGioHang) != null) {
            return true;
        }
        return false;
    }

    @Override
    public GioHangChiTiet findByChiTietSpIdAndGioHangId(UUID chiTietSpId, UUID gioHangId) {
        return gioHangChiTietRepository.findByChiTietSPIdAndGioHangId(chiTietSpId, gioHangId);
    }

    @Override
    public GioHangChiTiet findByGioHangIdAndChiTietSpId(UUID gioHangId, UUID chiTietSpId) {
        return gioHangChiTietRepository.findByGioHangIdAndChiTietSpId(gioHangId, chiTietSpId);
    }
}
