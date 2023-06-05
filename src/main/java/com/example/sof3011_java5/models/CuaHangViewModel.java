package com.example.sof3011_java5.models;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Component;

import java.util.UUID;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Component
public class CuaHangViewModel {
    private UUID id;
    private String ma;
    @NotBlank(message = "Không được để trống")
    private String ten;
    @NotBlank(message = "Không được để trống")
    private String diaChi;
    @NotBlank(message = "Không được để trống")
    private String thanhPho;
    @NotBlank(message = "Không được để trống")
    private String quocGia;

}
