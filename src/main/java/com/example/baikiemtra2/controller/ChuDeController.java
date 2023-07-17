package com.example.baikiemtra2.controller;

import com.example.baikiemtra2.models.ChuDe;
import com.example.baikiemtra2.models.responobj.Respon;
import com.example.baikiemtra2.services.imp.ChuDeServices;
import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ChuDeController {
    @Autowired
    ChuDeServices chuDeServices;
    @GetMapping(value = "/chude/getall")
    public List<ChuDe> getAllChuDe()
    {
        return chuDeServices.getAllChuDe();
    }

    @PostMapping(value = "/chude/them")
    public Respon<ChuDe> themChuDe(@RequestBody String chuDe)
    {
        Gson gson = new Gson();
        ChuDe chuDeThem = gson.fromJson(chuDe, ChuDe.class);
        return chuDeServices.themChuDe(chuDeThem);
    }

    @PutMapping(value = "/chude/sua")
    public Respon<ChuDe> suaChuDe(@RequestBody String chuDe)
    {
        Gson gson = new Gson();
        ChuDe chuDeSua = gson.fromJson(chuDe, ChuDe.class);
        return chuDeServices.suaChuDe(chuDeSua);
    }

    @DeleteMapping(value = "/chude/xoa")
    public Respon<ChuDe> xoaChuDe(@RequestParam int idChuDe)
    {
        return chuDeServices.xoaChuDe(idChuDe);
    }

    @GetMapping(value = "/chude/phantrang")
    public Page<ChuDe> phanTrangChuDe(@RequestParam int pageNumber, int pageSize)
    {
        return chuDeServices.phanTrangChuDe(pageNumber,pageSize);
    }
}
