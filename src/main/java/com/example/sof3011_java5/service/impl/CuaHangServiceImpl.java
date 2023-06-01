package com.example.sof3011_java5.service.impl;

import com.example.sof3011_java5.entities.CuaHang;
import com.example.sof3011_java5.infrastructure.converter.CuaHangConvert;
import com.example.sof3011_java5.models.CuaHangViewModel;
import com.example.sof3011_java5.repositories.CuaHangRepository;
import com.example.sof3011_java5.service.CuaHangService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
@Service
public class CuaHangServiceImpl implements CuaHangService {
    
    @Autowired
    private CuaHangRepository cuaHangRepository;
    
    @Autowired
    private CuaHangConvert cuaHangConvert;
    @Override
    public List<CuaHangViewModel> findAll() {
        return cuaHangConvert.listEntityToListModel(cuaHangRepository.findAll());
    }

    @Override
    public CuaHang getById(UUID id) {
        if (cuaHangRepository.findById(id).isPresent()) {
            return cuaHangRepository.findById(id).get();
        } else {
            return null;
        }
    }

    @Override
    public void saveOrUpdate(CuaHangViewModel cuaHangViewModel) {
        CuaHang cuaHang = cuaHangConvert.toEntity(cuaHangViewModel);
        if (cuaHang.getId() == null) {
            cuaHangRepository.save(cuaHang);
        } else {
            if (cuaHangRepository.findById(cuaHang.getId()).isPresent()) {
                CuaHang editCuaHang = cuaHangRepository.findById(cuaHang.getId()).get();
                editCuaHang.setTen(cuaHang.getTen());
                editCuaHang.setDiaChi(cuaHang.getDiaChi());
                editCuaHang.setThanhPho(cuaHang.getThanhPho());
                editCuaHang.setQuocGia(cuaHang.getQuocGia());
                cuaHangRepository.save(editCuaHang);
            }
        }
    }

    @Override
    public void deleteById(UUID id) {
        if (cuaHangRepository.findById(id).isPresent()) {
            cuaHangRepository.deleteById(id);
        }
    }

    @Override
    public String maCHCount() {
        String code = "";
        List<CuaHang> list = cuaHangRepository.findAll();
        if (list.isEmpty()) {
            code = "CH00001";
        } else {
            int max = 0;
            for (CuaHang cuaHang : list) {
                String ma = cuaHang.getMa();
                if (ma.length() >= 4) {
                    int so = Integer.parseInt(ma.substring(3));
                    if (so > max) {
                        max = so;
                    }
                }
            }
            max++;
            if (max < 10) {
                code = "CH000" + max;
            } else if (max < 100) {
                code = "CH00" + max;
            } else if (max < 1000) {
                code = "CH0" + max;
            } else {
                code = "CH" + max;
            }
        }
        return code;
    }
}
