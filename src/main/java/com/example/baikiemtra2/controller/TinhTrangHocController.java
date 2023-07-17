package com.example.baikiemtra2.controller;

import com.example.baikiemtra2.models.TinhTrangHoc;
import com.example.baikiemtra2.models.responobj.Respon;
import com.example.baikiemtra2.services.imp.TinhTrangHocServices;
import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class TinhTrangHocController {
    @Autowired
    TinhTrangHocServices tinhTrangHocServices;
    @GetMapping(value = "/tinhtranghoc/getall")
    public List<TinhTrangHoc> getAllLoaiKhoaHoc()
    {
        return tinhTrangHocServices.getAllTinhTrangHoc();
    }

    @PostMapping(value = "/tinhtranghoc/them")
    public Respon<TinhTrangHoc> themLoaiKhoaHoc(@RequestBody String tinhTrangHoc)
    {
        Gson gson = new Gson();
        TinhTrangHoc tinhTrangHocThem = gson.fromJson(tinhTrangHoc, TinhTrangHoc.class);
        return tinhTrangHocServices.themTinhTrangHoc(tinhTrangHocThem);
    }

    @PutMapping(value = "/tinhtranghoc/sua")
    public Respon<TinhTrangHoc> suaLoaiKhoaHoc(@RequestBody String tinhTrangHoc)
    {
        Gson gson = new Gson();
        TinhTrangHoc tinhTrangHocSua = gson.fromJson(tinhTrangHoc, TinhTrangHoc.class);
        return tinhTrangHocServices.suaTinhTrangHoc(tinhTrangHocSua);
    }

    @DeleteMapping(value = "/tinhtranghoc/xoa")
    public Respon<TinhTrangHoc> xoaLoaiKhoaHoc(@RequestParam int idTinhTrangHoc)
    {
        return tinhTrangHocServices.xoaTinhTrangHoc(idTinhTrangHoc);
    }
}
