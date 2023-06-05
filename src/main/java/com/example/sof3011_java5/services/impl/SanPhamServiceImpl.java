package com.example.sof3011_java5.services.impl;

import com.example.sof3011_java5.entities.SanPham;
import com.example.sof3011_java5.infrastructure.converter.SanPhamConvert;
import com.example.sof3011_java5.models.SanPhamViewModel;
import com.example.sof3011_java5.repositories.SanPhamRepository;
import com.example.sof3011_java5.services.SanPhamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.nio.file.Path;
import java.util.List;
import java.util.UUID;
@Service
public class SanPhamServiceImpl implements SanPhamService {

    @Autowired
    private SanPhamRepository sanPhamRepository;

    @Autowired
    private SanPhamConvert sanPhamConvert;
    @Override
    public List<SanPhamViewModel> findAll() {
        return sanPhamConvert.listEntityToListModel(sanPhamRepository.findAll());
    }

    @Override
    public SanPham getById(UUID id) {
        if (sanPhamRepository.findById(id).isPresent()) {
            return sanPhamRepository.findById(id).get();
        }else {
            return null;
        }

    }

    @Override
    public void saveOrUpdate(SanPhamViewModel sanPhamViewMode, Path path) {
        SanPham sanPham = sanPhamConvert.toEntity(sanPhamViewMode);
        sanPham.setSrcImage(path.toString());
        sanPhamRepository.save(sanPham);
    }

    @Override
    public void deleteById(UUID id) {
        if (sanPhamRepository.findById(id).isPresent()) {
            sanPhamRepository.deleteById(id);
        }
    }

    @Override
    public String maSPcount() {

        String code = "";
        List<SanPham> list = sanPhamRepository.findAll();
        if (list.isEmpty()) {
            code = "SP0001";
        } else {
            int max = 0;
            for (SanPham sanPham : list) {
                String ma = sanPham.getMa();
                if (ma.length() >= 4) {
                    int so = Integer.parseInt(ma.substring(3));
                    if (so > max) {
                        max = so;
                    }
                }
            }
            max++;
            if (max < 10) {
                code = "SP000" + max;
            } else if (max < 100) {
                code = "SP00" + max;
            } else if (max < 1000) {
                code = "SP0" + max;
            } else {
                code = "SP" + max;
            }
        }
        return code;
    }

}
