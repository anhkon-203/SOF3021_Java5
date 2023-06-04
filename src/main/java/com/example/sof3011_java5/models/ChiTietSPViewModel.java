package com.example.sof3011_java5.models;

import com.example.sof3011_java5.entities.DongSp;
import com.example.sof3011_java5.entities.MauSac;
import com.example.sof3011_java5.entities.NSX;
import com.example.sof3011_java5.entities.SanPham;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.UUID;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Component
public class ChiTietSPViewModel {
    private UUID Id;

    private int namBaoHanh;

    private String moTa;

    private Integer soLuongTon;

    private BigDecimal giaNhap;

    private BigDecimal giaBan;

    private SanPham sanPham;

    private NSX nsx;

    private MauSac mauSac;

    private DongSp dongSp;
}
