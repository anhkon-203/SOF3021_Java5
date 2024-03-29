package com.example.sof3011_java5.repositories;

import com.example.sof3011_java5.entities.GioHang;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.UUID;
@Repository
public interface GioHangRepository extends JpaRepository<GioHang, UUID> {
    @Query("select gh from GioHang gh where gh.khachHang.Id=:idKhachHang and gh.trangThai=0")
     public GioHang findByKhachHangIdAndTrangThai(UUID idKhachHang);
}
