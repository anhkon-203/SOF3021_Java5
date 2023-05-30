package com.example.sof3011_java5.service.impl;

import com.example.sof3011_java5.entities.NSX;
import com.example.sof3011_java5.infrastructure.converter.NSXConvert;
import com.example.sof3011_java5.models.NSXViewModel;
import com.example.sof3011_java5.repositories.NSXRepository;
import com.example.sof3011_java5.service.NSXService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
@Service
public class NSXServiceImpl implements NSXService {
    @Autowired
    private NSXRepository nsxRepository;

    @Autowired
    private NSXConvert nsxConvert;
    @Override
    public List<NSXViewModel> getAll() {
        if (nsxRepository.findAll().size() > 0) {
            return nsxConvert.listEntityToListModel(nsxRepository.findAll());
        } else {
            return null;
        }
    }

    @Override
    public NSX getById(UUID id) {
        if (nsxRepository.findById(id).isPresent()) {
            return nsxRepository.findById(id).get();
        } else {
            return null;
        }
    }

    @Override
    public boolean saveOrUpdate(NSXViewModel nsxViewModel) {
        NSX nsx = nsxConvert.toEntity(nsxViewModel);
        if (nsxViewModel.getId() == null) {
            nsxRepository.save(nsxConvert.toEntity(nsxViewModel));
            return true;
        } else {
            if (nsxRepository.findById(nsx.getId()).isPresent()) {
                NSX editNSX = nsxRepository.findById(nsx.getId()).get();
                editNSX.setTen(nsx.getTen());
                nsxRepository.save(editNSX);
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean deleteById(UUID id) {
        if (nsxRepository.findById(id).isPresent()) {
            nsxRepository.deleteById(id);
            return true;
        } else {
            return false;
        }
    }

    @Override
    public NSX getByMa(String ma) {
       if (nsxRepository.getByMa(ma) != null) {
            return nsxRepository.getByMa(ma);
        } else {
            return null;
        }
    }


}
