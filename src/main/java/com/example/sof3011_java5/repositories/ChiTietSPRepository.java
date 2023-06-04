package com.example.sof3011_java5.repositories;

import com.example.sof3011_java5.entities.ChiTietSp;
import com.example.sof3011_java5.entities.ChucVu;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface ChiTietSPRepository extends JpaRepository<ChiTietSp, UUID> {

}
