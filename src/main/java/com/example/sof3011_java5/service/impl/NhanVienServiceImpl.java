package com.example.sof3011_java5.service.impl;

import com.example.sof3011_java5.entities.NhanVien;
import com.example.sof3011_java5.infrastructure.converter.NhanVienConvert;
import com.example.sof3011_java5.models.NhanVienViewModel;
import com.example.sof3011_java5.repositories.NhanVienRepository;
import com.example.sof3011_java5.service.NhanVienService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class NhanVienServiceImpl implements NhanVienService {

    @Autowired
    private NhanVienRepository nhanVienRepository;

    @Autowired
    private NhanVienConvert nhanVienConvert;

    @Override
    public List<NhanVienViewModel> findAll() {
        return nhanVienConvert.listEntityToListModel(nhanVienRepository.findAll());
    }

    @Override
    public NhanVien getById(UUID id) {
        if (nhanVienRepository.findById(id).isPresent()) {
            return nhanVienRepository.findById(id).get();
        } else {
            return null;
        }
    }

    @Override
    public void saveOrUpdate(NhanVienViewModel nhanVienViewModel) {
        NhanVien nhanVien = nhanVienConvert.toEntity(nhanVienViewModel);
        if (nhanVien.getId() == null) {
            nhanVienRepository.save(nhanVien);
        } else {
            nhanVienRepository.save(nhanVien);
        }
    }

    @Override
    public void deleteById(UUID id) {
        if (nhanVienRepository.findById(id).isPresent()) {
            nhanVienRepository.deleteById(id);
        }
    }


    @Override
    public String maNVCount() {
        String code = "";
        List<NhanVien> list = nhanVienRepository.findAll();
        if (list.isEmpty()) {
            code = "NV0001";
        } else {
            int max = 0;
            for (NhanVien nv : list) {
                String ma = nv.getMa();
                if (ma.length() >= 4) {
                    int so = Integer.parseInt(ma.substring(3));
                    if (so > max) {
                        max = so;
                    }
                }
            }
            max++;
            if (max < 10) {
                code = "NV000" + max;
            } else if (max < 100) {
                code = "NV00" + max;
            } else if (max < 1000) {
                code = "NV0" + max;
            } else {
                code = "NV" + max;
            }
        }
        return code;
    }
    }

