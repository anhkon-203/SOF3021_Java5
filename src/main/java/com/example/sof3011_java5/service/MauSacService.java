package com.example.sof3011_java5.service;

import com.example.sof3011_java5.entities.DongSp;
import com.example.sof3011_java5.entities.MauSac;
import com.example.sof3011_java5.models.DongSPViewModel;
import com.example.sof3011_java5.models.MauSacViewModel;

import java.util.List;
import java.util.UUID;

public interface MauSacService {

    public List<MauSacViewModel> findAll();
    public MauSac getById(UUID id);
    public void saveOrUpdate(MauSacViewModel mauSacViewModel);
    public void deleteById(UUID id);

    public String maMSCount();


}
