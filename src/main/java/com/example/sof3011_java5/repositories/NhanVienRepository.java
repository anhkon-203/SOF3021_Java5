package com.example.sof3011_java5.repositories;
import com.example.sof3011_java5.entities.NhanVien;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface  NhanVienRepository extends JpaRepository<NhanVien, UUID> {
    @Query("select nv from NhanVien nv where nv.email =:email and nv.matKhau =:password")
    public NhanVien login(String email, String password);
}
