package com.example.baikiemtra2.controller;

import com.example.baikiemtra2.models.HocVien;
import com.example.baikiemtra2.models.TaiKhoan;
import com.example.baikiemtra2.models.responobj.Respon;
import com.example.baikiemtra2.models.responobj.ResponList;
import com.example.baikiemtra2.services.imp.TaiKhoanServices;
import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class TaiKhoanController {
    @Autowired
    TaiKhoanServices taiKhoanServices;
    @GetMapping(value = "/taikhoan/getall")
    public List<TaiKhoan> getAllTaiKhoan()
    {
        return taiKhoanServices.getAllTaiKhoan();
    }
    @PostMapping(value = "/taikhoan/them")
    public Respon<TaiKhoan> themTaiKhoan(@RequestBody String taiKhoan)
    {
        Gson gson = new Gson();
        TaiKhoan taiKhoanThem = gson.fromJson(taiKhoan,TaiKhoan.class);
        return taiKhoanServices.themTaiKhoan(taiKhoanThem);
    }
    @PutMapping(value = "/taikhoan/sua")
    public Respon<TaiKhoan> suaTaiKhoan(@RequestBody String taiKhoan)
    {
        Gson gson = new Gson();
        TaiKhoan taiKhoanSua = gson.fromJson(taiKhoan,TaiKhoan.class);
        return taiKhoanServices.suaTaiKhoan(taiKhoanSua);
    }
    @DeleteMapping(value = "taikhoan/xoa")
    public Respon<TaiKhoan> xoaTaiKhoan(@RequestParam int idTaiKhoan)
    {
        return taiKhoanServices.xoaTaiKhoan(idTaiKhoan);
    }
    @GetMapping(value = "/taikhoan/timkiem")
    public ResponList<TaiKhoan> timKiemTaiKhoan(@RequestParam String tenTaiKhoan)
    {
        return taiKhoanServices.timTaiKhoan(tenTaiKhoan);
    }
    @GetMapping(value = "/taikhoan/phantrang")
    public Page<TaiKhoan> phanTrangTaiKhoan(@RequestParam int pageNumber, int pageSize)
    {
        return taiKhoanServices.phanTrangTaiKhoan(pageNumber,pageSize);
    }
}
