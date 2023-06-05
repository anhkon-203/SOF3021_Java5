package com.example.sof3011_java5.services.impl;

import com.example.sof3011_java5.entities.DongSp;
import com.example.sof3011_java5.infrastructure.converter.DongSPConvert;
import com.example.sof3011_java5.models.DongSPViewModel;
import com.example.sof3011_java5.repositories.DongSPRepository;
import com.example.sof3011_java5.services.DongSPService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class DongSPServiceImpl implements DongSPService {
    @Autowired
    private DongSPRepository dongSpRepository;

    @Autowired
    private DongSPConvert dongSPConvert;

    @Override
    public List<DongSPViewModel> getAll() {
        if (dongSpRepository.findAll().size() > 0) {
            return dongSPConvert.listEntityToListModel(dongSpRepository.findAll());
        } else {
            return null;
        }
    }

    @Override
    public DongSp getById(UUID id) {
        if (dongSpRepository.findById(id).isPresent()) {
            return dongSpRepository.findById(id).get();
        } else {
            return null;
        }
    }

    @Override
    public void saveOrUpdate(DongSPViewModel dongSPViewModel) {
       DongSp dongSp = dongSPConvert.toEntity(dongSPViewModel);
        dongSpRepository.save(dongSp);
    }

    @Override
    public void deleteById(UUID id) {
        if (dongSpRepository.findById(id).isPresent()) {
            dongSpRepository.deleteById(id);
        }
    }

    @Override
    public String maDSPCount() {
        String code = "";
        List<DongSp> list = dongSpRepository.findAll();
        if (list.isEmpty()) {
            code = "DSP0001";
        } else {
            int max = 0;
            for (DongSp dongSp : list) {
                String ma = dongSp.getMa();
                if (ma.length() >= 4) {
                    int so = Integer.parseInt(ma.substring(3));
                    if (so > max) {
                        max = so;
                    }
                }
            }
            max++;
            if (max < 10) {
                code = "DSP000" + max;
            } else if (max < 100) {
                code = "DSP00" + max;
            } else if (max < 1000) {
                code = "DSP0" + max;
            } else {
                code = "DSP" + max;
            }
        }
        return code;
    }

}
