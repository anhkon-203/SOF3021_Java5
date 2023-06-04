package com.example.sof3011_java5.infrastructure.converter;

import com.example.sof3011_java5.entities.DongSp;
import com.example.sof3011_java5.models.DongSPViewModel;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class DongSPConvert {
    @Autowired
    private ModelMapper modelMapper;

    public DongSp toEntity(DongSPViewModel dongSPViewModel) {
        return modelMapper.map(dongSPViewModel, DongSp.class);
    }
    public DongSPViewModel toModel(DongSp dongSp) {
       return modelMapper.map(dongSp, DongSPViewModel.class);
    }

    public List<DongSPViewModel> listEntityToListModel(List<DongSp> entityList) {
        return entityList.stream()
                .map(entity -> modelMapper.map(entity, DongSPViewModel.class))
                .collect(Collectors.toList());
    }

}

