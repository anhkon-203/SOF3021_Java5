package com.example.sof3011_java5.repositories;

import com.example.sof3011_java5.entities.HoaDon;
import com.example.sof3011_java5.entities.HoaDonChiTiet;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface HoaDonRepository extends JpaRepository<HoaDon, UUID> {
    @Query(value = "select * from hoa_don_chi_tiet where hoa_don_id = ?1", nativeQuery = true)
    List<HoaDonChiTiet> getListByIdHoaDon(UUID hoaDonId);
}

