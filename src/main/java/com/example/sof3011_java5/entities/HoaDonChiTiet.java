package com.example.sof3011_java5.entities;

import com.example.sof3011_java5.request.HoaDonChiTietId;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Component;

import java.io.Serializable;
import java.math.BigDecimal;

@Entity
@IdClass(HoaDonChiTietId.class)
@Table(name = "HoaDonChiTiet")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Component
public class HoaDonChiTiet implements Serializable {

    @Id
    @ManyToOne
    @JoinColumn(name = "idHoaDon")
    private HoaDon hoaDon;

    @Id
    @ManyToOne
    @JoinColumn(name = "idChiTietSp")
    private ChiTietSp chiTietSp;

    @Column(name = "SoLuong")
    private Integer soLuongTon;

    @Column(name = "DonGia", columnDefinition = "Decimal(20,0)")
    private BigDecimal donGia;


}
