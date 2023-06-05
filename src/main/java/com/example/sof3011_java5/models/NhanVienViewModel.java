package com.example.sof3011_java5.models;

import com.example.sof3011_java5.entities.ChucVu;
import com.example.sof3011_java5.entities.CuaHang;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Component;

import java.sql.Date;
import java.util.UUID;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Component
public class NhanVienViewModel {
    private UUID id;
    private String ma;
    @NotBlank(message = "Không được để trống")
    private String ho;
    @NotBlank(message = "Không được để trống")
    private String tenDem;
    @NotBlank(message = "Không được để trống")
    private String ten;
    @NotBlank(message = "Không được để trống")
    private String gioiTinh;
    @NotNull(message = "Không được để trống")
    private Date ngaySinh;
    @NotBlank(message = "Không được để trống")
    private String diaChi;
    @NotBlank(message = "Không được để trống")
    private String sdt;
    @NotBlank(message = "Không được để trống")
    private String matKhau;
    @NotBlank(message = "Không được để trống")
    @Email(message = "Email không đúng định dạng")
    private String email;
    @NotNull(message = "Không được để trống")
    private CuaHang cuaHang;
    @NotNull(message = "Không được để trống")
    private ChucVu chucVu;
    @NotNull(message = "Không được để trống")
    private int trangThai;
}
