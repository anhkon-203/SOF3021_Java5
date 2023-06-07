package com.example.sof3011_java5.controller.user;

import com.example.sof3011_java5.entities.ChiTietSp;
import com.example.sof3011_java5.entities.GioHangChiTiet;
import com.example.sof3011_java5.infrastructure.converter.ChiTietSPConvert;
import com.example.sof3011_java5.infrastructure.converter.GioHangChiTietConvert;
import com.example.sof3011_java5.infrastructure.converter.GioHangConvert;
import com.example.sof3011_java5.models.ChiTietSPViewModel;
import com.example.sof3011_java5.models.GioHangChiTietViewModel;
import com.example.sof3011_java5.models.GioHangViewModel;
import com.example.sof3011_java5.models.KhachHangViewModel;
import com.example.sof3011_java5.repositories.GioHangChiTietRepository;
import com.example.sof3011_java5.services.ChiTietSanPhamService;
import com.example.sof3011_java5.services.GioHangChiTietService;
import com.example.sof3011_java5.services.GioHangService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
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
            @RequestParam("soLuong") Integer soLuong,
            GioHangChiTiet gioHangChiTiet1
    ) {
        KhachHangViewModel khachHang = (KhachHangViewModel) session.getAttribute("user");
        GioHangViewModel gioHangViewModel = gioHangConvert.toModel(gioHangService.findByKhachHangIdAndTrangThai(khachHang.getId()));

        // Kiểm tra xem sản phẩm đã có trong giỏ hàng hay chưa
        GioHangChiTiet gioHangChiTiet = gioHangChiTietService.findByChiTietSpIdAndGioHangId(idChiTietSp, gioHangViewModel.getId());
        ChiTietSp chiTietSp = chiTietSanPhamService.getById(idChiTietSp);
        if (gioHangChiTiet != null) {
            // Sản phẩm đã tồn tại trong giỏ hàng
            int soLuongUpdate = chiTietSanPhamService.getSoLuong(idChiTietSp) - soLuong;
            chiTietSp.setSoLuongTon(soLuongUpdate);
            gioHangChiTiet.setSoLuongTon(gioHangChiTiet.getSoLuongTon() + soLuong);
            gioHangChiTietService.save(gioHangChiTietConvert.toModel(gioHangChiTiet));
        } else {
            // Sản phẩm chưa có trong giỏ hàng, thêm sản phẩm mới
            gioHangChiTiet1.setGioHang(gioHangConvert.toEntity(gioHangViewModel));
            gioHangChiTiet1.setChiTietSp(chiTietSp);
            BigDecimal giaBan = chiTietSp.getGiaBan();
            BigDecimal soLuongTon = BigDecimal.valueOf(chiTietSp.getSoLuongTon());
            BigDecimal donGia = giaBan.multiply(soLuongTon);
            gioHangChiTiet1.setDonGia(donGia);
            gioHangChiTiet1.setSoLuongTon(soLuong);
            int soLuongUpdate = chiTietSanPhamService.getSoLuong(idChiTietSp) - soLuong;
            chiTietSp.setSoLuongTon(soLuongUpdate);
            chiTietSanPhamService.saveOrUpdate(chiTietSPConvert.toModel(chiTietSp));
            gioHangChiTietService.save(gioHangChiTietConvert.toModel(gioHangChiTiet1));
        }

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
    @PostMapping("/gio-hang/{id}/increase")
    public String increaseQuantity(@PathVariable("id") UUID idChiTietSp) {
        // Lấy đối tượng GioHangChiTiet từ database
        ChiTietSp chiTietSp = chiTietSanPhamService.getById(idChiTietSp);
        KhachHangViewModel khachHang = (KhachHangViewModel) session.getAttribute("user");
        GioHangViewModel gioHangViewModel = gioHangConvert.toModel(gioHangService.findByKhachHangIdAndTrangThai(khachHang.getId()));
        GioHangChiTiet gioHangChiTiet = gioHangChiTietService.findByChiTietSpIdAndGioHangId(idChiTietSp, gioHangViewModel.getId());
        if (gioHangChiTiet != null) {
            chiTietSp.setSoLuongTon(chiTietSp.getSoLuongTon() - 1);
            gioHangChiTiet.setSoLuongTon(gioHangChiTiet.getSoLuongTon() + 1);
            gioHangChiTietService.save(gioHangChiTietConvert.toModel(gioHangChiTiet));
            chiTietSanPhamService.saveOrUpdate(chiTietSPConvert.toModel(chiTietSp));
        }
        return "redirect:/user/gio-hang";
    }

    @PostMapping("/gio-hang/{id}/decrease")
    public String decreaseQuantity(@PathVariable("id") UUID idChiTietSp) {
        // Lấy đối tượng GioHangChiTiet từ database
        ChiTietSp chiTietSp = chiTietSanPhamService.getById(idChiTietSp);
        KhachHangViewModel khachHang = (KhachHangViewModel) session.getAttribute("user");
        GioHangViewModel gioHangViewModel = gioHangConvert.toModel(gioHangService.findByKhachHangIdAndTrangThai(khachHang.getId()));
        GioHangChiTiet gioHangChiTiet = gioHangChiTietService.findByChiTietSpIdAndGioHangId(idChiTietSp, gioHangViewModel.getId());
        if (gioHangChiTiet != null && gioHangChiTiet.getSoLuongTon() > 1) {
            chiTietSp.setSoLuongTon(chiTietSp.getSoLuongTon() + 1);
            gioHangChiTiet.setSoLuongTon(gioHangChiTiet.getSoLuongTon() - 1);
            gioHangChiTietService.save(gioHangChiTietConvert.toModel(gioHangChiTiet));
            chiTietSanPhamService.saveOrUpdate(chiTietSPConvert.toModel(chiTietSp));
        }
        return "redirect:/user/gio-hang";
    }
}
