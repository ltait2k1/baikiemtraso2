package com.example.baikiemtra2.services;

import com.example.baikiemtra2.models.ChuDe;
import com.example.baikiemtra2.models.responobj.Respon;
import org.springframework.data.domain.Page;

import java.util.List;

public interface IChuDeServices {
    public List<ChuDe> getAllChuDe();
    public Respon<ChuDe> themChuDe(ChuDe chuDe);
    public Respon<ChuDe> suaChuDe(ChuDe chuDe);
    public Respon<ChuDe> xoaChuDe(int idChuDe);
    public Page<ChuDe> phanTrangChuDe(int pageNumber, int pageSize);


}
