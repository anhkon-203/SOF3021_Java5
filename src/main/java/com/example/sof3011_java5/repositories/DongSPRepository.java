package com.example.sof3011_java5.repositories;

import com.example.sof3011_java5.entities.DongSp;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface DongSPRepository extends JpaRepository<DongSp, UUID> {

}
