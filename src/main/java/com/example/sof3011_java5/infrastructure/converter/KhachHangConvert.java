package com.example.sof3011_java5.infrastructure.converter;

import com.example.sof3011_java5.entities.DongSp;
import com.example.sof3011_java5.entities.KhachHang;
import com.example.sof3011_java5.models.DongSPViewModel;
import com.example.sof3011_java5.models.KhachHangViewModel;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;
@Component
public class KhachHangConvert {
    @Autowired
    private ModelMapper modelMapper;

    public KhachHang toEntity(KhachHangViewModel khachHangViewModel) {
        return modelMapper.map(khachHangViewModel, KhachHang.class);
    }

    public KhachHangViewModel toModel(KhachHang khachHang) {
        return modelMapper.map(khachHang, KhachHangViewModel.class);
    }

    public List<KhachHangViewModel> listEntityToListModel(List<KhachHang> entityList) {
        return entityList.stream()
                .map(entity -> modelMapper.map(entity, KhachHangViewModel.class))
                .collect(Collectors.toList());
    }
}
