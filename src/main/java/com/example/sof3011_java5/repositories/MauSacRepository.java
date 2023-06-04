package com.example.sof3011_java5.repositories;

import com.example.sof3011_java5.entities.CuaHang;
import com.example.sof3011_java5.entities.MauSac;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface MauSacRepository extends JpaRepository<MauSac, UUID> {
}
