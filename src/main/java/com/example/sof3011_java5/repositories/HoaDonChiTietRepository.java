package com.example.sof3011_java5.repositories;

import com.example.sof3011_java5.entities.HoaDon;
import com.example.sof3011_java5.entities.HoaDonChiTiet;
import com.example.sof3011_java5.request.HoaDonChiTietId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;


@Repository
public interface HoaDonChiTietRepository extends JpaRepository<HoaDonChiTiet, HoaDonChiTietId> {
    @Query("select hdct from HoaDonChiTiet hdct where hdct.hoaDon.Id = ?1")
    List<HoaDonChiTiet> getListByIdHoaDon(UUID hoaDonId);
}

