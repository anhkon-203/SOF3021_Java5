package com.example.sof3011_java5.services.impl;

import com.example.sof3011_java5.entities.HoaDonChiTiet;
import com.example.sof3011_java5.infrastructure.converter.HoaDonChiTietConvert;
import com.example.sof3011_java5.models.HoaDonChiTietViewModel;
import com.example.sof3011_java5.repositories.HoaDonChiTietRepository;
import com.example.sof3011_java5.repositories.HoaDonRepository;
import com.example.sof3011_java5.services.HoaDonChiTietService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class HoaDonChiTietServiceImpl implements HoaDonChiTietService {
    @Autowired
    private HoaDonChiTietConvert hoaDonChiTietConvert;
    @Autowired
    private HoaDonChiTietRepository hoaDonChiTietRepository;
    @Override
    public List<HoaDonChiTietViewModel> getListByIdHoaDon(UUID HoaDonId) {
         return hoaDonChiTietConvert.listEntityToListModel(hoaDonChiTietRepository.getListByIdHoaDon(HoaDonId));
    }

    @Override
    public void saveOrUpdate(HoaDonChiTietViewModel hoaDonChiTietViewModel) {
        HoaDonChiTiet hoaDonChiTiet = hoaDonChiTietConvert.toEntity(hoaDonChiTietViewModel);
        hoaDonChiTietRepository.save(hoaDonChiTiet);
    }
}
