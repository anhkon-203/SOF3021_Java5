
package com.example.sof3011_java5.infrastructure.converter;

import com.example.sof3011_java5.entities.ChucVu;
import com.example.sof3011_java5.entities.NSX;
import com.example.sof3011_java5.models.ChucVuViewModel;
import com.example.sof3011_java5.models.NSXViewModel;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class ChucVuConvert {
    @Autowired
    private ModelMapper modelMapper;

    public ChucVu toEntity(ChucVuViewModel chucVuViewModel) {
        return modelMapper.map(chucVuViewModel, ChucVu.class);
    }
    public ChucVuViewModel toModel(ChucVu chucVu) {
        return modelMapper.map(chucVu, ChucVuViewModel.class);
    }

    public List<ChucVuViewModel> listEntityToListModel(List<ChucVu> entityList) {
        return entityList.stream()
                .map(entity -> modelMapper.map(entity, ChucVuViewModel.class))
                .collect(Collectors.toList());
    }

}

