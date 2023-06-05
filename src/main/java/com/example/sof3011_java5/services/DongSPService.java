package com.example.sof3011_java5.services;

import com.example.sof3011_java5.entities.DongSp;
import com.example.sof3011_java5.models.DongSPViewModel;

import java.util.List;
import java.util.UUID;

public interface DongSPService {

    public List<DongSPViewModel> getAll();
    public DongSp getById(UUID id);
    public void saveOrUpdate(DongSPViewModel dongSPViewModel);
    public void deleteById(UUID id);

    public String maDSPCount();


}
