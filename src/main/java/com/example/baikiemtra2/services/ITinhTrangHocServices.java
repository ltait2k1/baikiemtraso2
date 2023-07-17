package com.example.baikiemtra2.services;

import com.example.baikiemtra2.models.TinhTrangHoc;
import com.example.baikiemtra2.models.responobj.Respon;

import java.util.List;

public interface ITinhTrangHocServices {
    public List<TinhTrangHoc> getAllTinhTrangHoc();
    public Respon<TinhTrangHoc> themTinhTrangHoc(TinhTrangHoc tinhTrangHoc);
    public Respon<TinhTrangHoc> suaTinhTrangHoc(TinhTrangHoc tinhTrangHoc);
    public Respon<TinhTrangHoc> xoaTinhTrangHoc(int idTinhTrangHoc);
}
