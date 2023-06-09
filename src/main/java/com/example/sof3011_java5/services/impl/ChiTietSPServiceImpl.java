package com.example.sof3011_java5.services.impl;

import com.example.sof3011_java5.entities.ChiTietSp;
import com.example.sof3011_java5.entities.SanPham;
import com.example.sof3011_java5.infrastructure.converter.ChiTietSPConvert;
import com.example.sof3011_java5.models.ChiTietSPViewModel;
import com.example.sof3011_java5.repositories.ChiTietSPRepository;
import com.example.sof3011_java5.services.ChiTietSanPhamService;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class ChiTietSPServiceImpl implements ChiTietSanPhamService {
    @Autowired
    private ChiTietSPRepository chiTietSPRepository;
    @Autowired
    private ChiTietSPConvert chiTietSPConvert;

    @Override
    public List<ChiTietSPViewModel> findAll() {
        return chiTietSPConvert.listEntityToListModel(chiTietSPRepository.findAll());
    }

    @Override
    public ChiTietSp getById(UUID id) {
        if (chiTietSPRepository.findById(id).isPresent()) {
            return chiTietSPRepository.findById(id).get();
        }
        return null;
    }

    @Override
    public void saveOrUpdate(ChiTietSPViewModel chiTietSPViewModel) {
        ChiTietSp chiTietSp = chiTietSPConvert.toEntity(chiTietSPViewModel);
        chiTietSPRepository.save(chiTietSp);
    }


    @Override
    public void deleteById(UUID id) {
        ChiTietSp chiTietSp = chiTietSPRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Không tìm thấy sản phẩm với ID: " + id));

        try {
            chiTietSPRepository.delete(chiTietSp);
        } catch (DataIntegrityViolationException e) {
            throw new DataIntegrityViolationException("Không thể xóa sản phẩm với ID: " + id
                    + " do có bản ghi liên quan trong bảng Khác.");
        }
    }

    @Override
    public List<ChiTietSPViewModel> findBySanPhamId(UUID id) {
        return chiTietSPConvert.listEntityToListModel(chiTietSPRepository.findBySanPhamId(id));
    }

    @Override
    public List<ChiTietSPViewModel> findByTenDongSP(String tenDongSP) {
        return chiTietSPConvert.listEntityToListModel(chiTietSPRepository.findByTenDongSP(tenDongSP));
    }

    @Override
    public String findTenDongSP(UUID id) {
        return chiTietSPRepository.findTenDongSP(id);
    }

    @Override
    public Integer getSoLuong(UUID idChiTietSp) {
        return chiTietSPRepository.getSoLuong(idChiTietSp);
    }

    @Override
    public void updateSoLuong(Integer soLuong, UUID idChiTietSp) {
        chiTietSPRepository.updateSoLuong(soLuong, idChiTietSp);
    }

    @Override
    public Page<ChiTietSPViewModel> findAllPage(Pageable pageable) {
        Page<ChiTietSp> chiTietSPPage = chiTietSPRepository.findAll(pageable);
        return chiTietSPPage.map(chiTietSPConvert::toModel);
    }
}
