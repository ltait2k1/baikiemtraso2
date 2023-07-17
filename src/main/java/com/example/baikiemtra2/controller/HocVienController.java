package com.example.baikiemtra2.controller;

import com.example.baikiemtra2.models.HocVien;
import com.example.baikiemtra2.models.responobj.Respon;
import com.example.baikiemtra2.models.responobj.ResponList;
import com.example.baikiemtra2.services.imp.HocVienServices;
import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class HocVienController {
    @Autowired
    HocVienServices hocVienServices;
    @GetMapping(value = "/hocvien/getall")
    public List<HocVien> getAllHocVien()
    {
        return hocVienServices.getAlHocVien();
    }
    @PostMapping(value = "/hocvien/them")
    public Respon<HocVien> themHocVien(@RequestBody String hocVien)
    {
        Gson gson = new Gson();
        HocVien hocVienThem = gson.fromJson(hocVien,HocVien.class);
        return hocVienServices.themHocVien(hocVienThem);
    }
    @PutMapping(value = "/hocvien/sua")
    public Respon<HocVien> suaHocVien(@RequestBody String hocVien)
    {
        Gson gson = new Gson();
        HocVien hocVienSua = gson.fromJson(hocVien,HocVien.class);
        return hocVienServices.suaHocVien(hocVienSua);
    }
    @DeleteMapping(value = "hocvien/xoa")
    public Respon<HocVien> xoaKhoaHoc(@RequestParam int idHocVien)
    {
        return hocVienServices.xoaHocVien(idHocVien);
    }
    @GetMapping(value = "/hocvien/timkiemten")
    public ResponList<HocVien> timHocVienTen(@RequestParam String tenHocVien)
    {
        return hocVienServices.timHocVienTheoTen(tenHocVien);
    }
    @GetMapping(value = "/hocvien/timkiememail")
    public ResponList<HocVien> timHocVienEmail(@RequestParam String Email)
    {
        return hocVienServices.timHocVienEmail(Email);
    }
    @GetMapping(value = "/hocvien/phantrang")
    public Page<HocVien> phanTrangHocVien(@RequestParam int pageNumber, int pageSize)
    {
        return hocVienServices.phanTrangHocVien(pageNumber, pageSize);
    }

}
