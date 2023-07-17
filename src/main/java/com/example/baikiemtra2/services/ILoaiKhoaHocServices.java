package com.example.baikiemtra2.services;

import com.example.baikiemtra2.models.LoaiKhoaHoc;
import com.example.baikiemtra2.models.responobj.Respon;
import jdk.dynalink.linker.LinkerServices;

import java.util.List;

public interface ILoaiKhoaHocServices {
    public List<LoaiKhoaHoc> getAllLoaiKhoaHoc();
    public Respon<LoaiKhoaHoc> themLoaiKhoaHoc(LoaiKhoaHoc loaiKhoaHoc);
    public Respon<LoaiKhoaHoc> suaLoaiKhoaHoc(LoaiKhoaHoc loaiKhoaHoc);
    public Respon<LoaiKhoaHoc> xoaLoaiKhoaHoc(int idLoaiKhoaHoc);



}
