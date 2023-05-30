package com.example.sof3011_java5.infrastructure.converter;

import com.example.sof3011_java5.entities.NSX;
import com.example.sof3011_java5.models.NSXViewModel;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class NSXConvert {
    @Autowired
    private ModelMapper modelMapper;

    public NSX toEntity(NSXViewModel nsxViewModel) {
        return modelMapper.map(nsxViewModel, NSX.class);
    }
    public NSXViewModel toModel(NSX nsx) {
        return modelMapper.map(nsx, NSXViewModel.class);
    }

    public List<NSXViewModel> listEntityToListModel(List<NSX> entityList) {
        return entityList.stream()
                .map(entity -> modelMapper.map(entity, NSXViewModel.class))
                .collect(Collectors.toList());
    }

}

