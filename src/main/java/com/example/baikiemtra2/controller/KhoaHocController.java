package com.example.baikiemtra2.controller;


import com.example.baikiemtra2.models.KhoaHoc;
import com.example.baikiemtra2.models.responobj.Respon;
import com.example.baikiemtra2.models.responobj.ResponList;
import com.example.baikiemtra2.services.imp.KhoaHocServices;
import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class KhoaHocController {
    @Autowired
    KhoaHocServices khoaHocServices;
    @GetMapping(value = "/khoahoc/getall")
    public List<KhoaHoc> getAllKhoaHoc()
    {
        return khoaHocServices.getAllKhoaHoc();
    }

    @PostMapping(value = "/khoahoc/them")
    public Respon<KhoaHoc> themKhoaHoc(@RequestBody String khoaHoc)
    {
        Gson gson = new Gson();
        KhoaHoc khoaHocThem = gson.fromJson(khoaHoc,KhoaHoc.class);
        return khoaHocServices.themKhoaHoc(khoaHocThem);
    }

    @PutMapping(value = "/khoahoc/sua")
    public Respon<KhoaHoc> suaKhoaHoc(@RequestBody String khoaHoc)
    {
        Gson gson = new Gson();
        KhoaHoc khoaHocSua = gson.fromJson(khoaHoc,KhoaHoc.class);
        return khoaHocServices.suaKhoaHoc(khoaHocSua);
    }

    @DeleteMapping(value = "/khoahoc/xoa")
    public Respon<KhoaHoc> xoaKhoaHoc(@RequestParam int idKhoaHoc)
    {
        return khoaHocServices.xoaKhoaHoc(idKhoaHoc);
    }
    @GetMapping(value = "/khoahoc/timkiem")
    public ResponList<KhoaHoc> timKhoaHoc(@RequestParam String tenKhoaHoc)
    {
        return khoaHocServices.timKhoaHoc(tenKhoaHoc);
    }
    @GetMapping(value = "/khoahoc/phantrang")
    public Page<KhoaHoc> phanTrangKhoaHoc(@RequestParam int pageNumber, int pageSize)
    {
        return khoaHocServices.phanTrangKhoaHoc(pageNumber,pageSize);
    }
}
