package com.example.sof3011_java5.services;


import com.example.sof3011_java5.entities.HoaDon;
import com.example.sof3011_java5.models.HoaDonViewModel;

import java.util.UUID;

public interface HoaDonService {
    public String maHDCount();
    public void saveOrUpdate(HoaDonViewModel hoaDonViewModel);

    public UUID save(HoaDonViewModel hoaDonViewModel);

    public HoaDon findById(UUID id);

   public UUID getIDHoaDonByIdKH(UUID id);

}
