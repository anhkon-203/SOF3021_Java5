package com.example.sof3011_java5.models;

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
    private String ten;
    private String diaChi;
    private String thanhPho;
    private String quocGia;

}
