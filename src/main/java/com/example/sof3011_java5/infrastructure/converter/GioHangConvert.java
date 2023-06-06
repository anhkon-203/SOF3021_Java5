package com.example.sof3011_java5.infrastructure.converter;

import com.example.sof3011_java5.entities.ChiTietSp;
import com.example.sof3011_java5.entities.GioHang;
import com.example.sof3011_java5.models.ChiTietSPViewModel;
import com.example.sof3011_java5.models.GioHangViewModel;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class GioHangConvert {
    @Autowired
    private ModelMapper modelMapper;

    public GioHang toEntity(GioHangViewModel gioHangViewModel) {
        return modelMapper.map(gioHangViewModel, GioHang.class);
    }
    public GioHangViewModel toModel(GioHang gioHang) {
        return modelMapper.map(gioHang, GioHangViewModel.class);
    }

    public List<GioHangViewModel> listEntityToListModel(List<GioHang> entityList) {
        return entityList.stream()
                .map(entity -> modelMapper.map(entity, GioHangViewModel.class))
                .collect(Collectors.toList());
    }

}

