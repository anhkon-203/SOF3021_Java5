
package com.example.sof3011_java5.infrastructure.converter;

import com.example.sof3011_java5.entities.ChucVu;
import com.example.sof3011_java5.entities.HoaDon;
import com.example.sof3011_java5.models.ChucVuViewModel;
import com.example.sof3011_java5.models.HoaDonViewModel;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class HoaDonConvert {
    @Autowired
    private ModelMapper modelMapper;

    public HoaDon toEntity(HoaDonViewModel hoaDonViewModel) {
        return modelMapper.map(hoaDonViewModel, HoaDon.class);
    }
    public HoaDonViewModel toModel(HoaDon hoaDon) {
        return modelMapper.map(hoaDon, HoaDonViewModel.class);
    }

    public List<HoaDonViewModel> listEntityToListModel(List<HoaDon> entityList) {
        return entityList.stream()
                .map(entity -> modelMapper.map(entity, HoaDonViewModel.class))
                .collect(Collectors.toList());
    }

}

