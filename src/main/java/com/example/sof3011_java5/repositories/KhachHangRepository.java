package com.example.sof3011_java5.repositories;

import com.example.sof3011_java5.entities.KhachHang;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface KhachHangRepository extends JpaRepository<KhachHang, UUID> {
        @Query("select kh from KhachHang kh where kh.email =:email and kh.matKhau =:password")
        public KhachHang login(String email, String password);
}
