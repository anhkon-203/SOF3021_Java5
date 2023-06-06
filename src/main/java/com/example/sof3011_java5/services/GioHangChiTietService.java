package com.example.sof3011_java5.services;

import com.example.sof3011_java5.entities.GioHangChiTiet;
import com.example.sof3011_java5.entities.SanPham;
import com.example.sof3011_java5.models.GioHangChiTietViewModel;
import com.example.sof3011_java5.models.SanPhamViewModel;

import java.nio.file.Path;
import java.util.List;
import java.util.UUID;

public interface GioHangChiTietService {

    public boolean save(GioHangChiTietViewModel gioHangChiTietViewModel);

    public List<GioHangChiTietViewModel> findAllByGioHangId(UUID id);


}
