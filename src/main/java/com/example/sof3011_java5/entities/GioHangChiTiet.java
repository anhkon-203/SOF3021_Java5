package com.example.sof3011_java5.entities;

import com.example.sof3011_java5.request.GioHangChiTietId;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Component;

import java.io.Serializable;
import java.math.BigDecimal;

@Entity
@IdClass(GioHangChiTietId.class)
@Table(name = "GioHangChiTiet")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Component
public class GioHangChiTiet implements Serializable {

    @Id
    @ManyToOne
    @JoinColumn(name = "idGioHang")
    private GioHang gioHang;

    @Id
    @ManyToOne
    @JoinColumn(name = "idChiTietSp")
    private ChiTietSp chiTietSp;

    @Column(name = "SoLuong")
    private Integer soLuongTon;

    @Column(name = "DonGia")
    private BigDecimal donGia;

    @Column(name = "DonGiaKhiGiam")
    private BigDecimal donGiaKhiGiam;


}
