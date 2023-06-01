package com.example.sof3011_java5.models;

import com.example.sof3011_java5.entities.ChucVu;
import com.example.sof3011_java5.entities.CuaHang;
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
    private String ho;
    private String tenDem;
    private String ten;
    private String gioiTinh;
    private Date ngaySinh;
    private String diaChi;
    private String sdt;
    private String matKhau;
    private String email;
    private CuaHang cuaHang;
    private ChucVu chucVu;
    private int trangThai;
}
