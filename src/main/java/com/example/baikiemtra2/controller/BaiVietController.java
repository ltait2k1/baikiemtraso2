package com.example.baikiemtra2.controller;

import com.example.baikiemtra2.models.BaiViet;
import com.example.baikiemtra2.models.responobj.Respon;
import com.example.baikiemtra2.models.responobj.ResponList;
import com.example.baikiemtra2.services.imp.BaiVietServices;
import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class BaiVietController {
    @Autowired
    BaiVietServices baiVietServices;
    @GetMapping(value = "/baiviet/getall")
    public List<BaiViet> getAllBaiViet()
    {
        return baiVietServices.getAllBaiViet();
    }

    @PostMapping(value = "/baiviet/them")
    public Respon<BaiViet> themBaiViet(@RequestBody String baiViet)
    {
        Gson gson = new Gson();
        BaiViet baiVietThem = gson.fromJson(baiViet,BaiViet.class);
        return baiVietServices.themBaiViet(baiVietThem);
    }

    @PutMapping(value = "/baiviet/sua")
    public Respon<BaiViet> suaBaiViet(@RequestBody String baiViet)
    {
        Gson gson = new Gson();
        BaiViet baiVietSua = gson.fromJson(baiViet,BaiViet.class);
        return baiVietServices.suaBaiViet(baiVietSua);
    }

    @DeleteMapping(value = "baiviet/xoa")
    public Respon<BaiViet> xoaBaiViet(@RequestParam int idBaiViet)
    {
        return baiVietServices.xoaBaiViet(idBaiViet);
    }
    @GetMapping(value = "/baiviet/timkiem")
    public ResponList<BaiViet> timKiemBaiViet(@RequestParam String tenBaiViet)
    {
        return baiVietServices.timKiemBaiViet(tenBaiViet);
    }

    @GetMapping(value = "/baiviet/phantrang")
    public Page<BaiViet> phanTrangQuyenHan(@RequestParam int pageNumber, int pageSize)
    {
        return baiVietServices.phanTranBaiViet(pageNumber,pageSize);
    }
}
