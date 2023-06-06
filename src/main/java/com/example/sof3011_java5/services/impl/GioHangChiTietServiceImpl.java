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
}