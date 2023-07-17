package com.example.baikiemtra2.controller;

import com.example.baikiemtra2.models.DangKyHoc;
import com.example.baikiemtra2.models.responobj.Respon;
import com.example.baikiemtra2.services.imp.DangKyHocServices;
import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class DangKyHocController {
    @Autowired
    DangKyHocServices dangKyHocServices;
    @GetMapping(value = "/dangkihoc/getall")
    public List<DangKyHoc> getAllDangKyHoc()
    {
       return dangKyHocServices.getAllDangKyHoc();
    }
    @PostMapping(value = "/dangkihoc/them")
    public Respon<DangKyHoc> themDangKiHoc(@RequestBody String dangKiHoc)
    {
        Gson gson = new Gson();
        DangKyHoc dangKyHoc = gson.fromJson(dangKiHoc,DangKyHoc.class);
        return dangKyHocServices.themDangKyHoc(dangKyHoc);
    }
    @PutMapping(value = "/dangkihoc/sua")
    public Respon<DangKyHoc> suaDangKiHoc(@RequestBody String dangKiHoc)
    {
        Gson gson = new Gson();
        DangKyHoc dangKyHoc = gson.fromJson(dangKiHoc,DangKyHoc.class);
        return dangKyHocServices.suaDangKyHoc(dangKyHoc);
    }
    @DeleteMapping(value = "dangkihoc/xoa")
    public Respon<DangKyHoc> xoaDangKiHoc(@RequestParam int id)
    {
        return dangKyHocServices.xoaDangKyHoc(id);
    }
    @RequestMapping(value = "dangkihoc/getallpage", method = RequestMethod.GET)
    public Page<DangKyHoc> dangKyHocPage(@RequestParam Integer pageNumber, @RequestParam Integer pageSize)
    {
        return dangKyHocServices.getAllDangKyHocPage(pageNumber,pageSize);
    }
}
