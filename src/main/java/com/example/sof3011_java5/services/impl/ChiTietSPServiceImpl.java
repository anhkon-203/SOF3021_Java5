package com.example.sof3011_java5.services.impl;

import com.example.sof3011_java5.entities.ChiTietSp;
import com.example.sof3011_java5.infrastructure.converter.ChiTietSPConvert;
import com.example.sof3011_java5.models.ChiTietSPViewModel;
import com.example.sof3011_java5.repositories.ChiTietSPRepository;
import com.example.sof3011_java5.services.ChiTietSanPhamService;
import org.springframework.beans.factory.annotation.Autowired;
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
        if (chiTietSPRepository.findById(id).isPresent()){
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
        if (chiTietSPRepository.findById(id).isPresent()){
            chiTietSPRepository.deleteById(id);
        }
    }
}
