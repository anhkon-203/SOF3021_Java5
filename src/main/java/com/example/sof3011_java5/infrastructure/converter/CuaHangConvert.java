package com.example.sof3011_java5.infrastructure.converter;

import com.example.sof3011_java5.entities.CuaHang;
import com.example.sof3011_java5.entities.CuaHang;
import com.example.sof3011_java5.models.CuaHangViewModel;
import com.example.sof3011_java5.models.CuaHangViewModel;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class CuaHangConvert {
    @Autowired
    private ModelMapper modelMapper;

    public CuaHang toEntity(CuaHangViewModel cuaHangViewModel) {
        return modelMapper.map(cuaHangViewModel, CuaHang.class);
    }
    public CuaHangViewModel toModel(CuaHang cuaHang) {
        return modelMapper.map(cuaHang, CuaHangViewModel.class);
    }

    public List<CuaHangViewModel> listEntityToListModel(List<CuaHang> entityList) {
        return entityList.stream()
                .map(entity -> modelMapper.map(entity, CuaHangViewModel.class))
                .collect(Collectors.toList());
    }

}

