package com.example.sof3011_java5.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Component;

import java.io.Serializable;
import java.sql.Date;
import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "HoaDon")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Component
public class HoaDon implements Serializable {

    @Id
    @Column(name="Id")
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID Id;

    @ManyToOne
    @JoinColumn(name = "idKH")
    private KhachHang khachHang;

    @ManyToOne
    @JoinColumn(name = "idNV")
    private NhanVien nhanVien;

    @Column(name = "Ma")
    private String ma;

    @Column(name = "NgayTao")
    private Date ngayTao;

    @Column(name = "NgayThanhToan")
    private Date ngayThanhToan;

    @Column(name = "NgayShip")
    private Date ngayShip;

    @Column(name = "NgayNhan")
    private Date ngayNhan;

    @Column(name = "TinhTrang")
    private int tinhTrang;

    @Column(name = "TenNguoiNhan")
    private String tenNguoiNhan;

    @Column(name = "DiaChi")
    private String diaChi;

    @Column(name = "Sdt")
    private String sdt;

    @OneToMany(mappedBy = "hoaDon", fetch = FetchType.LAZY)
    private List<HoaDonChiTiet> listHoaDonChiTiet;

//    public String getTinhTrang() {
//        if (tinhTrang == 0){
//            return "Chờ giao hàng";
//        }else if (tinhTrang == 1){
//            return "Đang giao hàng";
//    }   else if (tinhTrang == 2){
//            return "Đã Nhận hàng";
//        }else {
//            return "Không xác định";
//        }
//    }
}
