package com.example.sof3011_java5.controller.user;

import com.example.sof3011_java5.entities.ChiTietSp;
import com.example.sof3011_java5.entities.GioHangChiTiet;
import com.example.sof3011_java5.entities.KhachHang;
import com.example.sof3011_java5.infrastructure.converter.ChiTietSPConvert;
import com.example.sof3011_java5.infrastructure.converter.GioHangChiTietConvert;
import com.example.sof3011_java5.infrastructure.converter.GioHangConvert;
import com.example.sof3011_java5.models.ChiTietSPViewModel;
import com.example.sof3011_java5.models.GioHangChiTietViewModel;
import com.example.sof3011_java5.models.GioHangViewModel;
import com.example.sof3011_java5.models.KhachHangViewModel;
import com.example.sof3011_java5.services.ChiTietSanPhamService;
import com.example.sof3011_java5.services.GioHangChiTietService;
import com.example.sof3011_java5.services.GioHangService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.List;
import java.util.UUID;

@Controller
@RequestMapping("/user")
public class GioHangController {
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
    private ChiTietSanPhamService chiTietSanPhamService;
    @Autowired
    private GioHangChiTietService gioHangChiTietService;
    @Autowired
    private ChiTietSPConvert chiTietSPConvert;
    @Autowired
    private ChiTietSPViewModel chiTietSPViewModel;
    @Autowired
    private GioHangChiTiet gioHangChiTiet;

    @GetMapping("/gio-hang")
    public String index(Model model) {
        KhachHangViewModel khachHang = (KhachHangViewModel) session.getAttribute("user");
        gioHangViewModel = gioHangConvert.toModel(gioHangService.findByKhachHangIdAndTrangThai(khachHang.getId()));
        List<GioHangChiTietViewModel> listGioHangChiTiet = gioHangChiTietService.findGioHangChiTietByGioHangId(gioHangViewModel.getId());
        model.addAttribute("listGioHangChiTiet", listGioHangChiTiet);
        model.addAttribute("view", "/views/user/gio-hang/gioHang.jsp");
        return "user/layout";
    }

    @PostMapping("/gio-hang/{id}")
    public String store(
            @PathVariable("id") UUID idChiTietSp,
            @RequestParam("soLuong") Integer soLuong
    ) {

        KhachHangViewModel khachHang = (KhachHangViewModel) session.getAttribute("user");
        gioHangViewModel = gioHangConvert.toModel(gioHangService.findByKhachHangIdAndTrangThai(khachHang.getId()));
        gioHangChiTiet.setGioHang(gioHangConvert.toEntity(gioHangViewModel));
        ChiTietSp chiTietSp = chiTietSanPhamService.getById(idChiTietSp);
        gioHangChiTiet.setChiTietSp(chiTietSp);
        BigDecimal giaBan = chiTietSp.getGiaBan();
        BigDecimal soLuongTon = BigDecimal.valueOf(chiTietSp.getSoLuongTon());
        BigDecimal donGia = giaBan.multiply(soLuongTon);
        gioHangChiTiet.setDonGia(donGia);
        gioHangChiTiet.setSoLuongTon(soLuong);
        Integer soLuongUpdate = chiTietSanPhamService.getSoLuong(idChiTietSp) - soLuong;
        chiTietSp.setSoLuongTon(soLuongUpdate);
        chiTietSanPhamService.saveOrUpdate(chiTietSPConvert.toModel(chiTietSp));
        gioHangChiTietService.save(gioHangChiTietConvert.toModel(gioHangChiTiet));
        return "redirect:/user/gio-hang";
    }

    @GetMapping("/gio-hang/delete/{id}")
    public String delete(@PathVariable("id") UUID id) {
        ChiTietSp chiTietSp = chiTietSanPhamService.getById(id);
        KhachHangViewModel khachHang = (KhachHangViewModel) session.getAttribute("user");
        gioHangViewModel = gioHangConvert.toModel(gioHangService.findByKhachHangIdAndTrangThai(khachHang.getId()));
        Integer soLuongSanPham = chiTietSanPhamService.getSoLuong(id);
        Integer soLuongSPGioHang = gioHangChiTietService.soLuongSanPham(gioHangViewModel.getId(), id);
        Integer soLuongUpdate = soLuongSanPham + soLuongSPGioHang;
        gioHangChiTietService.deleteById(id, gioHangViewModel.getId());
        chiTietSp.setSoLuongTon(soLuongUpdate);
        chiTietSanPhamService.saveOrUpdate(chiTietSPConvert.toModel(chiTietSp));
        return "redirect:/user/gio-hang";
    }
}
