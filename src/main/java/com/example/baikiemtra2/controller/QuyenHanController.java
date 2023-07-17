package com.example.baikiemtra2.controller;

import com.example.baikiemtra2.models.QuyenHan;
import com.example.baikiemtra2.models.responobj.Respon;
import com.example.baikiemtra2.services.imp.QuyenHanServices;
import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;


import java.util.List;

@RestController
public class QuyenHanController {
    @Autowired
    QuyenHanServices quyenHanServices;
    @GetMapping(value = "/quyenhan/getall")
    public List<QuyenHan> getAllQuyenHan()
    {
        return quyenHanServices.getAllQuyenHan();
    }

    @PostMapping(value = "/quyenhan/them")
    public Respon<QuyenHan> themQuyenHan(@RequestBody String quyenHan)
    {
        Gson gson = new Gson();
        QuyenHan quyenHanThem = gson.fromJson(quyenHan, QuyenHan.class);
        return quyenHanServices.themQuyenHan(quyenHanThem);
    }

    @PostMapping(value = "/quyenhan/sua")
    public Respon<QuyenHan> suaQuyenHan(@RequestBody String quyenHan)
    {
        Gson gson = new Gson();
        QuyenHan quyenHanSua = gson.fromJson(quyenHan, QuyenHan.class);
        return quyenHanServices.suaQuyenHan(quyenHanSua);
    }

    @DeleteMapping(value = "/quyenhan/xoa")
    public Respon<QuyenHan> xoaLoaiKhoaHoc(@RequestParam int idQuyenHan)
    {
        return quyenHanServices.xoaQuyenHan(idQuyenHan);
    }
    @GetMapping(value = "/quyenhan/phantrang")
    public Page<QuyenHan> phanTrangQuyenHan(@RequestParam int pageNumber, int pageSize)
    {
        return quyenHanServices.phanTrangQuyenHan(pageNumber,pageSize);
    }
}
