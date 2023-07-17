package com.example.baikiemtra2.controller;

import com.example.baikiemtra2.models.LoaiBaiViet;
import com.example.baikiemtra2.models.responobj.Respon;
import com.example.baikiemtra2.services.imp.LoaiBaiVietServices;
import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class LoaiBaiVietController {
    @Autowired
    LoaiBaiVietServices loaiBaiVietServices;
    @GetMapping(value = "/loaibaiviet/getall")
    public List<LoaiBaiViet> getAllLoaiBaiViet()
    {
        return loaiBaiVietServices.getAllLoaiBaiViet();
    }

    @PostMapping(value = "/loaibaiviet/them")
    public Respon<LoaiBaiViet> themLoaiBaiViet(@RequestBody String loaiBaiViet)
    {
        Gson gson = new Gson();
        LoaiBaiViet loaiBaiVietThem = gson.fromJson(loaiBaiViet, LoaiBaiViet.class);
        return loaiBaiVietServices.themLoaiBaiViet(loaiBaiVietThem);
    }

    @PutMapping(value = "/loaibaiviet/sua")
    public Respon<LoaiBaiViet> suaLoaiKhoaHoc(@RequestBody String loaiBaiViet)
    {
        Gson gson = new Gson();
        LoaiBaiViet loaiBaiVietSua = gson.fromJson(loaiBaiViet, LoaiBaiViet.class);
        return loaiBaiVietServices.suaLoaiBaiViet(loaiBaiVietSua);
    }

    @DeleteMapping(value = "/loaibiaviet/xoa")
    public Respon<LoaiBaiViet> xoaLoaiKhoaHoc(@RequestParam int idLoaiBaiViet)
    {
        return loaiBaiVietServices.xoaLoaiBaiViet(idLoaiBaiViet);
    }
    @GetMapping(value = "/loaibaiviet/phantrang")
    public Page<LoaiBaiViet> phanTrangLoaiBaiViet(@RequestParam int pageNumber, int pageSize)
    {
        return loaiBaiVietServices.phanTrangLoaiBaiViet(pageNumber,pageSize);
    }
}
