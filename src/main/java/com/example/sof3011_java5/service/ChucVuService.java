package com.example.sof3011_java5.service;

import com.example.sof3011_java5.entities.ChucVu;
import com.example.sof3011_java5.entities.NSX;
import com.example.sof3011_java5.models.ChucVuViewModel;
import com.example.sof3011_java5.models.NSXViewModel;

import java.util.List;
import java.util.UUID;

public interface ChucVuService {

    public List<ChucVuViewModel> findAll();
    public ChucVu getById(UUID id);
    public void saveOrUpdate(ChucVuViewModel chucVuViewModel);
    public void deleteById(UUID id);

    public String maCVCount();


}
