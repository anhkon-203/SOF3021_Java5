package com.example.sof3011_java5.request;

import com.example.sof3011_java5.entities.ChiTietSp;
import com.example.sof3011_java5.entities.HoaDon;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Component;

import java.io.Serializable;
import java.util.UUID;
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Component
public class HoaDonChiTietId implements Serializable {
    private HoaDon hoaDon;

    private ChiTietSp chiTietSp;
}
