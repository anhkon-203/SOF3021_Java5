package com.example.sof3011_java5.models;


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

public class KhachHangViewModel {
    private UUID Id;
    private String ma;
    @NotBlank(message = "Không được để trống")
    private String ten;
    @NotBlank(message = "Không được để trống")
    private String tenDem;
    @NotBlank(message = "Không được để trống")
    private String ho;
    private Date ngaySinh;
    private String diaChi;
    private String thanhPho;
    private String quocGia;
    private String sdt;
    @NotBlank(message = "Không được để trống")
    private String matKhau;
    @NotBlank(message = "Không được để trống")
    @Email(message = "Email không đúng định dạng")
    private String email;

}
