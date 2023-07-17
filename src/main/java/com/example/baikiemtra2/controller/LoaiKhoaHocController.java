package com.example.baikiemtra2.controller;

import com.example.baikiemtra2.models.LoaiKhoaHoc;
import com.example.baikiemtra2.models.responobj.Respon;
import com.example.baikiemtra2.services.imp.LoaiKhoaHocServices;
import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class LoaiKhoaHocController {
    @Autowired
    LoaiKhoaHocServices loaiKhoaHocServices;
    @GetMapping(value = "/loaikhoahoc/getall")
    public List<LoaiKhoaHoc> getAllLoaiKhoaHoc()
    {
        return loaiKhoaHocServices.getAllLoaiKhoaHoc();
    }

    @PostMapping(value = "/loaikhoahoc/them")
    public Respon<LoaiKhoaHoc> themLoaiKhoaHoc(@RequestBody String loaiKhoaHoc)
    {
        Gson gson = new Gson();
        LoaiKhoaHoc loaiKhoaHocThem = gson.fromJson(loaiKhoaHoc, LoaiKhoaHoc.class);
        return loaiKhoaHocServices.themLoaiKhoaHoc(loaiKhoaHocThem);
    }

    @PutMapping(value = "/loaikhoahoc/sua")
    public Respon<LoaiKhoaHoc> suaLoaiKhoaHoc(@RequestBody String loaiKhoaHoc)
    {
        Gson gson = new Gson();
        LoaiKhoaHoc loaiKhoaHocSua = gson.fromJson(loaiKhoaHoc, LoaiKhoaHoc.class);
        return loaiKhoaHocServices.suaLoaiKhoaHoc(loaiKhoaHocSua);
    }

    @DeleteMapping(value = "/loaikhoahoc/xoa")
    public Respon<LoaiKhoaHoc> xoaLoaiKhoaHoc(@RequestParam int idLoaiKhoaHoc)
    {
        return loaiKhoaHocServices.xoaLoaiKhoaHoc(idLoaiKhoaHoc);
    }
}
