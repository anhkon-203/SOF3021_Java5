package com.example.sof3011_java5.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Component;

import java.io.Serializable;
import java.util.UUID;
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Component
public class HoaDonChiTietId implements Serializable {
    private UUID hoaDon;
    private UUID chiTietSP;
}
