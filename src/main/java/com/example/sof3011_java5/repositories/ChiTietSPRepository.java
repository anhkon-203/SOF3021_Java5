package com.example.sof3011_java5.repositories;

import com.example.sof3011_java5.entities.ChiTietSp;
import com.example.sof3011_java5.entities.ChucVu;
import com.example.sof3011_java5.entities.GioHangChiTiet;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.TypedQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.UUID;

@Repository
public interface ChiTietSPRepository extends JpaRepository<ChiTietSp, UUID> {
    @Autowired
    EntityManager entityManager = null;

    @Query("select c from ChiTietSp c where c.Id = ?1")
    List<ChiTietSp> findBySanPhamId(UUID id);

    @Query("select c from ChiTietSp c where c.dongSp.ten = ?1")
    List<ChiTietSp> findByTenDongSP(String tenDongSP);

    @Query("select c.dongSp.ten from ChiTietSp c where c.Id = ?1")
    String findTenDongSP(UUID id);

    @Query("select c.soLuongTon from ChiTietSp c where c.Id = ?1")
    Integer getSoLuong(UUID idChiTietSp);


    @Modifying
    @Query("update ChiTietSp c set c.soLuongTon=?1 where c.Id=?2")
    void updateSoLuong(Integer soLuong, UUID idChiTietSp);


//    @Transactional
//    public boolean insertGioHangChiTiet(GioHangChiTiet gioHangChiTiet) {
//        EntityTransaction transaction = entityManager.getTransaction();
//        try {
//            transaction.begin();
//            String hql = "SELECT g FROM GioHangChiTiet g WHERE g.gioHang.Id = :idGioHang AND g.chiTietSp.Id = :idChiTietSp";
//            TypedQuery<GioHangChiTiet> query = entityManager.createQuery(hql, GioHangChiTiet.class);
//            query.setParameter("idGioHang", gioHangChiTiet.getGioHang().getId());
//            query.setParameter("idChiTietSp", gioHangChiTiet.getChiTietSp().getId());
//            List<GioHangChiTiet> gioHangChiTietList = query.getResultList();
//            GioHangChiTiet existingGioHangChiTiet = null;
//            if (!gioHangChiTietList.isEmpty()) {
//                existingGioHangChiTiet = gioHangChiTietList.get(0);
//            }
//            if (existingGioHangChiTiet != null) {
//                existingGioHangChiTiet.setSoLuongTon(existingGioHangChiTiet.getSoLuongTon() + gioHangChiTiet.getSoLuongTon());
//                entityManager.merge(existingGioHangChiTiet);
//            } else {
//                entityManager.persist(gioHangChiTiet);
//            }
//            transaction.commit();
//            return true;
//        } catch (Exception e) {
//            e.printStackTrace();
//            transaction.rollback();
//            return false;
//        }
//    }
}

