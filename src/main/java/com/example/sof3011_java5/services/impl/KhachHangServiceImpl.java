package com.example.sof3011_java5.services.impl;

import com.example.sof3011_java5.entities.KhachHang;
import com.example.sof3011_java5.infrastructure.converter.KhachHangConvert;
import com.example.sof3011_java5.models.KhachHangViewModel;
import com.example.sof3011_java5.repositories.KhachHangRepository;
import com.example.sof3011_java5.services.KhachHangService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
@Service
public class KhachHangServiceImpl implements KhachHangService {
    @Autowired
    private KhachHangRepository khachHangRepository;
    @Autowired
    private KhachHangConvert khachHangConvert;
    @Override
    public List<KhachHangViewModel> findAll() {
        return khachHangConvert.listEntityToListModel(khachHangRepository.findAll());
    }

    @Override
    public KhachHang getById(UUID id) {
        if (khachHangRepository.findById(id).isPresent()) {
            return khachHangRepository.findById(id).get();
        }
        return null;
    }

    @Override
    public void saveOrUpdate(KhachHangViewModel khachHangViewModel) {
        KhachHang khachHang = khachHangConvert.toEntity(khachHangViewModel);
        khachHangRepository.save(khachHang);
    }

    @Override
    public void deleteById(UUID id) {
        if (khachHangRepository.findById(id).isPresent()) {
            khachHangRepository.deleteById(id);
        }
    }

    @Override
    public String maKHCount() {
        String code = "";
        List<KhachHang> list = khachHangRepository.findAll();
        if (list.isEmpty()) {
            code = "KH0001";
        } else {
            int max = 0;
            for (KhachHang khachHang : list) {
                String ma = khachHang.getMa();
                if (ma.length() >= 4) {
                    int so = Integer.parseInt(ma.substring(3));
                    if (so > max) {
                        max = so;
                    }
                }
            }
            max++;
            if (max < 10) {
                code = "KH000" + max;
            } else if (max < 100) {
                code = "KH00" + max;
            } else if (max < 1000) {
                code = "KH0" + max;
            } else {
                code = "KH" + max;
            }
        }
        return code;
    }
}
