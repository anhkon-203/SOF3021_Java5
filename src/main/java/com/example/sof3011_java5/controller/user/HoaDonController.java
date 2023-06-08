package com.example.sof3011_java5.controller.user;

import com.example.sof3011_java5.entities.GioHangChiTiet;
import com.example.sof3011_java5.entities.HoaDon;
import com.example.sof3011_java5.entities.HoaDonChiTiet;
import com.example.sof3011_java5.infrastructure.converter.*;
import com.example.sof3011_java5.models.*;
import com.example.sof3011_java5.repositories.GioHangChiTietRepository;
import com.example.sof3011_java5.services.*;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.sql.Date;
import java.time.LocalDate;
import java.util.*;

@Controller
@RequestMapping("/user")
public class HoaDonController {
    @Autowired
    HttpSession session;
    @Autowired
    private KhachHangViewModel khachHangViewModel;
    @Autowired
    private GioHangViewModel gioHangViewModel;
    @Autowired
    private GioHangChiTietViewModel gioHangChiTietViewModel;
    @Autowired
    private GioHangConvert gioHangConvert;
    @Autowired
    private GioHangService gioHangService;
    @Autowired
    private GioHangChiTietConvert gioHangChiTietConvert;
    @Autowired
    private GioHangChiTietRepository gioHangChiTietRepository;
    @Autowired
    private ChiTietSanPhamService chiTietSanPhamService;
    @Autowired
    private GioHangChiTietService gioHangChiTietService;
    @Autowired
    private ChiTietSPConvert chiTietSPConvert;
    @Autowired
    private ChiTietSPViewModel chiTietSPViewModel;
    @Autowired
    private GioHangChiTiet gioHangChiTiet;
    @Autowired
    private HoaDonConvert hoaDonConvert;
    @Autowired
    private HoaDonViewModel hoaDonViewModel;
    @Autowired
    private HoaDonService hoaDonService;
    @Autowired
    private KhachHangConvert khachHangConvert;
    @Autowired
    private HoaDonChiTietConvert hoaDonChiTietConvert;
    @Autowired
    private HoaDonChiTietService hoaDonChiTietService;

    @PostMapping("/hoa-don")
    public String store(
            @RequestParam("phone") String phone,
            @RequestParam("address") String address,
            @RequestParam("name") String name,
            HoaDonViewModel hoaDonViewModel,
            HoaDonChiTietViewModel hoaDonChiTietViewModel
    ) {

        KhachHangViewModel khachHang = (KhachHangViewModel) session.getAttribute("user");
        gioHangViewModel = gioHangConvert.toModel(gioHangService.findByKhachHangIdAndTrangThai(khachHang.getId()));
        List<GioHangChiTietViewModel> listGioHangChiTiet = gioHangChiTietService.findGioHangChiTietByGioHangId(gioHangViewModel.getId());
        HoaDon hoaDon = hoaDonConvert.toEntity(hoaDonViewModel);
        hoaDon.setMa(hoaDonService.maHDCount());
        hoaDon.setKhachHang(khachHangConvert.toEntity(khachHang));
        hoaDon.setTenNguoiNhan(name);
        hoaDon.setDiaChi(address);
        hoaDon.setSdt(phone);
        LocalDate localDate = LocalDate.now();
        hoaDon.setNgayTao(Date.valueOf(localDate));
        hoaDon.setTinhTrang(0);
        UUID idHoaDon = hoaDonService.save(hoaDonConvert.toModel(hoaDon));

        HoaDon hoaDonSaved = hoaDonService.findById(idHoaDon);

        if (listGioHangChiTiet != null) {
            for (GioHangChiTietViewModel gioHangChiTietViewModel : listGioHangChiTiet) {
                HoaDonChiTiet hoaDonChiTiet = hoaDonChiTietConvert.toEntity(hoaDonChiTietViewModel);
                hoaDonChiTiet.setHoaDon(hoaDonSaved);
                hoaDonChiTiet.setChiTietSp(gioHangChiTietViewModel.getChiTietSp());
                hoaDonChiTiet.setSoLuongTon(gioHangChiTietViewModel.getSoLuongTon());
                hoaDonChiTiet.setDonGia(gioHangChiTietViewModel.getDonGia());
                hoaDonChiTietService.saveOrUpdate(hoaDonChiTietConvert.toModel(hoaDonChiTiet));
            }
            gioHangChiTietService.deleteGioHangChiTiet(gioHangViewModel.getId());
        }


        return "redirect:/user/gio-hang";
    }

    @GetMapping("/hoa-don/index")
    public String index(Model model) {
        KhachHangViewModel khachHang = (KhachHangViewModel) session.getAttribute("user");
        UUID idHoaDon = hoaDonService.getIDHoaDonByIdKH(khachHang.getId());
        List<HoaDonChiTietViewModel> listHoaDonChiTietViewModel = hoaDonChiTietService.getListByIdHoaDon(idHoaDon);
        Map<String, List<HoaDonChiTietViewModel>> mapHoaDonChiTietViewModel = new HashMap<>();
        for (HoaDonChiTietViewModel hd : listHoaDonChiTietViewModel) {
            if (mapHoaDonChiTietViewModel.containsKey(hd.getHoaDon().getMa())) {
                mapHoaDonChiTietViewModel.get(hd.getHoaDon().getMa()).add(hd);
            } else {
                List<HoaDonChiTietViewModel> newList = new ArrayList<>();
                newList.add(hd);
                mapHoaDonChiTietViewModel.put(hd.getHoaDon().getMa(), newList);
            }
        }
        model.addAttribute("mapHoaDonChiTietViewModel", mapHoaDonChiTietViewModel);

        return "user/hoa-don/order";
    }
}
