package com.example.baikiemtra2.services;

import com.example.baikiemtra2.models.BaiViet;
import com.example.baikiemtra2.models.KhoaHoc;
import com.example.baikiemtra2.models.responobj.Respon;
import com.example.baikiemtra2.models.responobj.ResponList;
import org.springframework.data.domain.Page;

import java.util.List;

public interface IKhoaHocServices {
    public List<KhoaHoc> getAllKhoaHoc();
    public Respon<KhoaHoc> themKhoaHoc(KhoaHoc khoaHoc);
    public Respon<KhoaHoc> suaKhoaHoc(KhoaHoc khoaHoc);
    public Respon<KhoaHoc> xoaKhoaHoc(int idKhoaHoc);
    public ResponList<KhoaHoc> timKhoaHoc(String tenKhoaHoc);
    public Page<KhoaHoc> phanTrangKhoaHoc(int pageNumber, int pageSize);
}
