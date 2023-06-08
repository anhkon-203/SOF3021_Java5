package com.example.sof3011_java5.services.impl;

import com.example.sof3011_java5.entities.HoaDon;
import com.example.sof3011_java5.entities.NhanVien;
import com.example.sof3011_java5.infrastructure.converter.HoaDonConvert;
import com.example.sof3011_java5.models.HoaDonViewModel;
import com.example.sof3011_java5.repositories.HoaDonRepository;
import com.example.sof3011_java5.services.HoaDonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class HoaDonServiceImpl implements HoaDonService {

    @Autowired
    private HoaDonRepository hoaDonRepository;
    @Autowired
    private HoaDonConvert hoaDonConvert;

    @Override
    public String maHDCount() {
        String code = "";
        List<HoaDon> list = hoaDonRepository.findAll();
        if (list.isEmpty()) {
            code = "HD0001";
        } else {
            int max = 0;
            for (HoaDon hd : list) {
                String ma = hd.getMa();
                if (ma.length() >= 4) {
                    int so = Integer.parseInt(ma.substring(3));
                    if (so > max) {
                        max = so;
                    }
                }
            }
            max++;
            if (max < 10) {
                code = "HD000" + max;
            } else if (max < 100) {
                code = "HD00" + max;
            } else if (max < 1000) {
                code = "HD0" + max;
            } else {
                code = "HD" + max;
            }
        }
        return code;
    }

    @Override
    public void saveOrUpdate(HoaDonViewModel hoaDonViewModel) {
        HoaDon hoaDon = hoaDonConvert.toEntity(hoaDonViewModel);
        hoaDonRepository.save(hoaDon);
    }

    @Override
    public UUID save(HoaDonViewModel hoaDonViewModel) {
        HoaDon hoaDon = hoaDonConvert.toEntity(hoaDonViewModel);
        return hoaDonRepository.save(hoaDon).getId();
    }

    @Override
    public HoaDon findById(UUID id) {
        if (hoaDonRepository.findById(id).isPresent()) {
            return hoaDonRepository.findById(id).get();
        } else {
            return null;
        }
    }

    @Override
    public UUID getIDHoaDonByIdKH(UUID idKH) {
        List<UUID> idList = hoaDonRepository.findIdByKhachHangIdOrderByMaDesc(idKH);
        if (idList.isEmpty()) {
            return null;
        } else {
            return idList.get(0);
        }
    }
}
