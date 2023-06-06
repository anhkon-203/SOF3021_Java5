package com.example.sof3011_java5.repositories;

import com.example.sof3011_java5.entities.GioHang;
import com.example.sof3011_java5.entities.GioHangChiTiet;
import com.example.sof3011_java5.request.GioHangChiTietId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;


@Repository
public interface GioHangChiTietRepository extends JpaRepository<GioHangChiTiet, GioHangChiTietId> {
    @Query("select g from GioHangChiTiet g where g.gioHang.Id = ?1" )
    List<GioHangChiTiet> findAllByGioHangId(UUID id);
}
