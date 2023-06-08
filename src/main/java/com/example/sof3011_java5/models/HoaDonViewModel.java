
package com.example.sof3011_java5.models;

import com.example.sof3011_java5.entities.*;

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
public class HoaDonViewModel {
    private UUID Id;
    private KhachHang khachHang;

    private NhanVien nhanVien;
    private String ma;

    private Date ngayTao;

    private Date ngayThanhToan;

    private Date ngayShip;
    private Date ngayNhan;

    private int tinhTrang;

    private String tenNguoiNhan;
    private String diaChi;

    private String sdt;

    public String getTinhTrang() {
        if (tinhTrang == 0){
            return "Chờ giao hàng";
        }else if (tinhTrang == 1){
            return "Đang giao hàng";
        }   else if (tinhTrang == 2){
            return "Đã Nhận hàng";
        }else {
            return "Không xác định";
        }
    }
}
