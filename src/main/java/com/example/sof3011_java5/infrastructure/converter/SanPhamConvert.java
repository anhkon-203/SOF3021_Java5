package com.example.sof3011_java5.infrastructure.converter;

import com.example.sof3011_java5.entities.SanPham;
import com.example.sof3011_java5.models.SanPhamViewModel;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class SanPhamConvert {
    @Autowired
    private ModelMapper modelMapper;

    public SanPham toEntity(SanPhamViewModel sanPhamViewModel) {
        return modelMapper.map(sanPhamViewModel, SanPham.class);
    }
    public SanPhamViewModel toModel(SanPham sanPham) {
        return modelMapper.map(sanPham, SanPhamViewModel.class);
    }

    public List<SanPhamViewModel> listEntityToListModel(List<SanPham> entityList) {
        return entityList.stream()
                .map(entity -> modelMapper.map(entity, SanPhamViewModel.class))
                .collect(Collectors.toList());
    }

}

