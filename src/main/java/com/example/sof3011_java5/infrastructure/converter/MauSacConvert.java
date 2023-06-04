package com.example.sof3011_java5.infrastructure.converter;

import com.example.sof3011_java5.entities.DongSp;
import com.example.sof3011_java5.entities.MauSac;
import com.example.sof3011_java5.models.DongSPViewModel;
import com.example.sof3011_java5.models.MauSacViewModel;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class MauSacConvert {
    @Autowired
    private ModelMapper modelMapper;

    public MauSac toEntity(MauSacViewModel mauSacViewModel) {
        return modelMapper.map(mauSacViewModel, MauSac.class);
    }
    public MauSacViewModel toModel(MauSac mauSac) {
        return modelMapper.map(mauSac, MauSacViewModel.class);
    }

    public List<MauSacViewModel> listEntityToListModel(List<MauSac> entityList) {
        return entityList.stream()
                .map(entity -> modelMapper.map(entity, MauSacViewModel.class))
                .collect(Collectors.toList());
    }

}

