
package com.example.sof3011_java5.infrastructure.converter;

import com.example.sof3011_java5.entities.HoaDon;
import com.example.sof3011_java5.entities.HoaDonChiTiet;
import com.example.sof3011_java5.models.HoaDonChiTietViewModel;
import com.example.sof3011_java5.models.HoaDonViewModel;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class HoaDonChiTietConvert {
    @Autowired
    private ModelMapper modelMapper;

    public HoaDonChiTiet toEntity(HoaDonChiTietViewModel hoaDonChiTietViewModel) {
        return modelMapper.map(hoaDonChiTietViewModel, HoaDonChiTiet.class);
    }
    public HoaDonChiTietViewModel toModel(HoaDonChiTiet hoaDonChiTiet) {
        return modelMapper.map(hoaDonChiTiet, HoaDonChiTietViewModel.class);
    }

    public List<HoaDonChiTietViewModel> listEntityToListModel(List<HoaDonChiTiet> entityList) {
        return entityList.stream()
                .map(entity -> modelMapper.map(entity, HoaDonChiTietViewModel.class))
                .collect(Collectors.toList());
    }

}

