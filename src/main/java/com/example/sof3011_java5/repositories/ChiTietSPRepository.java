package com.example.sof3011_java5.repositories;

import com.example.sof3011_java5.entities.ChiTietSp;
import com.example.sof3011_java5.entities.ChucVu;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface ChiTietSPRepository extends JpaRepository<ChiTietSp, UUID> {

    @Query("select c from ChiTietSp c where c.Id = ?1")
    List<ChiTietSp> findBySanPhamId(UUID id);

    @Query("select c from ChiTietSp c where c.dongSp.ten = ?1")
    List<ChiTietSp> findByTenDongSP(String tenDongSP);

    @Query("select c.dongSp.ten from ChiTietSp c where c.Id = ?1")
    String findTenDongSP(UUID id);

    @Query("select c.soLuongTon from ChiTietSp c where c.Id = ?1")
    Integer getSoLuong(UUID idChiTietSp);
    @Modifying
    @Query("update ChiTietSp c set c.soLuongTon = ?1 where c.Id = ?2")
    Integer updateSoLuong(Integer soLuong, UUID idChiTietSp);
}
