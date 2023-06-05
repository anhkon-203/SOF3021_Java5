package com.example.sof3011_java5.services.impl;

import com.example.sof3011_java5.entities.MauSac;
import com.example.sof3011_java5.infrastructure.converter.MauSacConvert;
import com.example.sof3011_java5.models.MauSacViewModel;
import com.example.sof3011_java5.repositories.MauSacRepository;
import com.example.sof3011_java5.services.MauSacService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
@Service
public class MauSacServiceImpl implements MauSacService {
    @Autowired
    private MauSacRepository mauSacRepository;
    @Autowired
    private MauSacConvert mauSacConvert;
    @Override
    public List<MauSacViewModel> findAll() {
        return mauSacConvert.listEntityToListModel(mauSacRepository.findAll());
    }

    @Override
    public MauSac getById(UUID id) {
        if (mauSacRepository.findById(id).isPresent()) {
            return mauSacRepository.findById(id).get();
        }
        return null;
    }

    @Override
    public void saveOrUpdate(MauSacViewModel mauSacViewModel) {
            MauSac mauSac = mauSacConvert.toEntity(mauSacViewModel);
            mauSacRepository.save(mauSac);
    }

    @Override
    public void deleteById(UUID id) {
        if (mauSacRepository.findById(id).isPresent()) {
            mauSacRepository.deleteById(id);
        }
    }

    @Override
    public String maMSCount() {
        String code = "";
        List<MauSac> list = mauSacRepository.findAll();
        if (list.isEmpty()) {
            code = "MS0001";
        } else {
            int max = 0;
            for (MauSac mauSac : list) {
                String ma = mauSac.getMa();
                if (ma.length() >= 4) {
                    int so = Integer.parseInt(ma.substring(3));
                    if (so > max) {
                        max = so;
                    }
                }
            }
            max++;
            if (max < 10) {
                code = "MS000" + max;
            } else if (max < 100) {
                code = "MS00" + max;
            } else if (max < 1000) {
                code = "MS0" + max;
            } else {
                code = "MS" + max;
            }
        }
        return code;
    }
    }

