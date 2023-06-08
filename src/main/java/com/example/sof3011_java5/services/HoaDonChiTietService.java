package com.example.sof3011_java5.services;

import com.example.sof3011_java5.models.HoaDonChiTietViewModel;

import java.util.List;
import java.util.UUID;

public interface HoaDonChiTietService {

    public List<HoaDonChiTietViewModel> getListByIdHoaDon(UUID HoaDonId);

    public void saveOrUpdate(HoaDonChiTietViewModel hoaDonChiTietViewModel);



}
