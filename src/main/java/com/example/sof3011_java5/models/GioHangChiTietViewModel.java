package com.example.sof3011_java5.models;

import com.example.sof3011_java5.entities.*;
import jakarta.persistence.Column;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.*;
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
public class GioHangChiTietViewModel {
    private GioHang gioHang;
    private ChiTietSp chiTietSp;
    private Integer soLuongTon;
    private BigDecimal donGia;
    private BigDecimal donGiaKhiGiam;

}
