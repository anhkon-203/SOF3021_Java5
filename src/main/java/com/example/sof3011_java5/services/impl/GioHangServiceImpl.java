package com.example.sof3011_java5.services.impl;

import com.example.sof3011_java5.entities.GioHang;
import com.example.sof3011_java5.infrastructure.converter.GioHangConvert;
import com.example.sof3011_java5.models.GioHangViewModel;
import com.example.sof3011_java5.models.KhachHangViewModel;
import com.example.sof3011_java5.repositories.GioHangRepository;
import com.example.sof3011_java5.services.GioHangService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GioHangServiceImpl implements GioHangService {
    @Autowired
    private GioHangRepository gioHangRepository;
    @Autowired
    private GioHangConvert gioHangConvert;
    @Autowired
    private GioHangViewModel gioHangViewModel;

    @Override
    public void saveOrUpdate(GioHangViewModel gioHangViewModelHang) {
        GioHang gioHang = gioHangConvert.toEntity(gioHangViewModelHang);
        gioHangRepository.save(gioHang);
    }
}
