package com.example.sof3011_java5.services;

import com.example.sof3011_java5.entities.ChucVu;
import com.example.sof3011_java5.models.ChucVuViewModel;

import java.util.List;
import java.util.UUID;

public interface ChucVuService {

    public List<ChucVuViewModel> findAll();
    public ChucVu getById(UUID id);
    public void saveOrUpdate(ChucVuViewModel chucVuViewModel);
    public void deleteById(UUID id);

    public String maCVCount();


}
