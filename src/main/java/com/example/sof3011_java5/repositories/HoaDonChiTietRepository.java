package com.example.sof3011_java5.repositories;

import com.example.sof3011_java5.entities.HoaDon;
import com.example.sof3011_java5.request.HoaDonChiTietId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface HoaDonChiTietRepository extends JpaRepository<HoaDon, HoaDonChiTietId> {
}

