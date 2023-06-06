package com.example.sof3011_java5.infrastructure.converter;

import com.example.sof3011_java5.entities.ChiTietSp;
import com.example.sof3011_java5.entities.GioHangChiTiet;
import com.example.sof3011_java5.models.ChiTietSPViewModel;
import com.example.sof3011_java5.models.GioHangChiTietViewModel;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class GioHangChiTietConvert {
    @Autowired
    private ModelMapper modelMapper;

    public GioHangChiTiet toEntity(GioHangChiTietViewModel gioHangChiTietViewModel) {
        return modelMapper.map(gioHangChiTietViewModel, GioHangChiTiet.class);
    }
    public GioHangChiTietViewModel toModel(GioHangChiTiet gioHangChiTiet) {
        return modelMapper.map(gioHangChiTiet, GioHangChiTietViewModel.class);
    }

    public List<GioHangChiTietViewModel> listEntityToListModel(List<GioHangChiTiet> entityList) {
        return entityList.stream()
                .map(entity -> modelMapper.map(entity, GioHangChiTietViewModel.class))
                .collect(Collectors.toList());
    }

}

