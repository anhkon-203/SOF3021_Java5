package com.example.sof3011_java5.infrastructure.converter;

import com.example.sof3011_java5.entities.ChiTietSp;
import com.example.sof3011_java5.entities.NhanVien;
import com.example.sof3011_java5.models.ChiTietSPViewModel;
import com.example.sof3011_java5.models.NhanVienViewModel;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class ChiTietSPConvert {
    @Autowired
    private ModelMapper modelMapper;

    public ChiTietSp toEntity(ChiTietSPViewModel chiTietSPViewModel) {
        return modelMapper.map(chiTietSPViewModel, ChiTietSp.class);
    }
    public ChiTietSPViewModel toModel(ChiTietSp chiTietSp) {
        return modelMapper.map(chiTietSp, ChiTietSPViewModel.class);
    }

    public List<ChiTietSPViewModel> listEntityToListModel(List<ChiTietSp> entityList) {
        return entityList.stream()
                .map(entity -> modelMapper.map(entity, ChiTietSPViewModel.class))
                .collect(Collectors.toList());
    }

}

