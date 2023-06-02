package com.example.sof3011_java5.service.impl;

import com.example.sof3011_java5.entities.ChucVu;
import com.example.sof3011_java5.entities.NSX;
import com.example.sof3011_java5.infrastructure.converter.ChucVuConvert;
import com.example.sof3011_java5.infrastructure.converter.NSXConvert;
import com.example.sof3011_java5.models.ChucVuViewModel;
import com.example.sof3011_java5.models.NSXViewModel;
import com.example.sof3011_java5.repositories.ChucVuRepository;
import com.example.sof3011_java5.repositories.NSXRepository;
import com.example.sof3011_java5.service.ChucVuService;
import com.example.sof3011_java5.service.NSXService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class ChucVuServiceImpl implements ChucVuService {
    @Autowired
    private ChucVuRepository chucVuRepository;

    @Autowired
    private ChucVuConvert chucVuConvert;


    @Override
    public List<ChucVuViewModel> findAll() {
        return chucVuConvert.listEntityToListModel(chucVuRepository.findAll());
    }

    @Override
    public ChucVu getById(UUID id) {
        if (chucVuRepository.findById(id).isPresent()) {
            return chucVuRepository.findById(id).get();
        }
        return null;
    }

    @Override
    public void saveOrUpdate(ChucVuViewModel chucVuViewModel) {
        ChucVu chucVu = chucVuConvert.toEntity(chucVuViewModel);
        if (chucVu.getId() == null) {
            chucVuRepository.save(chucVu);
        }else {
            ChucVu chucVuUpdate = chucVuRepository.findById(chucVu.getId()).get();
            chucVuUpdate.setTen(chucVu.getTen());
            chucVuRepository.save(chucVuUpdate);
        }
    }

    @Override
    public void deleteById(UUID id) {
        if (chucVuRepository.findById(id).isPresent()) {
            chucVuRepository.deleteById(id);
        }
}
    @Override
    public String maCVCount() {
        String code = "";
        List<ChucVu> list = chucVuRepository.findAll();
        if (list.isEmpty()) {
            code = "CV0001";
        } else {
            int max = 0;
            for (ChucVu chucVu : list) {
                String ma = chucVu.getMa();
                if (ma.length() >= 4) {
                    int so = Integer.parseInt(ma.substring(3));
                    if (so > max) {
                        max = so;
                    }
                }
            }
            max++;
            if (max < 10) {
                code = "CV000" + max;
            } else if (max < 100) {
                code = "CV00" + max;
            } else if (max < 1000) {
                code = "CV0" + max;
            } else {
                code = "CV" + max;
            }
        }
        return code;

    }

}


