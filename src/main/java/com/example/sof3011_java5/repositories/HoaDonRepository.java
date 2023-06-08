package com.example.sof3011_java5.repositories;

import com.example.sof3011_java5.entities.HoaDon;
import com.example.sof3011_java5.entities.HoaDonChiTiet;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface HoaDonRepository extends JpaRepository<HoaDon, UUID> {

    @Query("SELECT hd.Id FROM HoaDon hd WHERE hd.khachHang.Id = :idKH order by hd.ma desc")
    List<UUID> findIdByKhachHangIdOrderByMaDesc( UUID idKH);
}

