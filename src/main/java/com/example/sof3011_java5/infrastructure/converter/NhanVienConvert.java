package com.example.sof3011_java5.infrastructure.converter;

import com.example.sof3011_java5.entities.NhanVien;
import com.example.sof3011_java5.entities.NhanVien;
import com.example.sof3011_java5.models.NhanVienViewModel;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class NhanVienConvert {
    @Autowired
    private ModelMapper modelMapper;

    public NhanVien toEntity(NhanVienViewModel NhanVienViewModel) {
        return modelMapper.map(NhanVienViewModel, NhanVien.class);
    }
    public NhanVienViewModel toModel(NhanVien NhanVien) {
        return modelMapper.map(NhanVien, NhanVienViewModel.class);
    }

    public List<NhanVienViewModel> listEntityToListModel(List<NhanVien> entityList) {
        return entityList.stream()
                .map(entity -> modelMapper.map(entity, NhanVienViewModel.class))
                .collect(Collectors.toList());
    }

}

