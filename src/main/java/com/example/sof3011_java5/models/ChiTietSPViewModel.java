package com.example.sof3011_java5.models;

import com.example.sof3011_java5.entities.DongSp;
import com.example.sof3011_java5.entities.MauSac;
import com.example.sof3011_java5.entities.NSX;
import com.example.sof3011_java5.entities.SanPham;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.format.annotation.NumberFormat;
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
    @Min(value = 1, message = "Không được để trống")
    @Max(value = 100, message = "số lượng không quá 100")
    @NotNull(message = "Không được để trống")
    private int namBaoHanh;
    @Size(min = 1, max = 200, message = "số lượng ký tự lớn hơn 1 và nhỏ hơn 200")
    @NotBlank(message = "Không được để trống")
    private String moTa;
    @Min(value = 1, message = "Không được để trống")
    @Max(value = 1000, message = "số ký tự không quá 1000")
    @NotNull(message = "Không được để trống")
    private Integer soLuongTon;
    @DecimalMin(value = "0.0", message = "Giá nhập không được nhỏ hơn 0")
    @DecimalMax(value = "1000000000.0", message = "Giá nhập không được lớn hơn 1000000000")
    @NotNull(message = "Không được để trống")
    private BigDecimal giaNhap;
    @DecimalMin(value = "0.0", message = "Giá bán không được nhỏ hơn 0")
    @DecimalMax(value = "1000000000.0", message = "Giá nhập không được lớn hơn 1000000000")
    @NotNull(message = "Không được để trống")
    private BigDecimal giaBan;
    @NotNull(message = "Không được để trống")
    private SanPham sanPham;
    @NotNull(message = "Không được để trống")
    private NSX nsx;
    @NotNull(message = "Không được để trống")
    private MauSac mauSac;
    @NotNull(message = "Không được để trống")
    private DongSp dongSp;
}
