package com.example.baikiemtra2.services;

import com.example.baikiemtra2.models.BaiViet;
import com.example.baikiemtra2.models.DangKyHoc;
import com.example.baikiemtra2.models.responobj.Respon;
import com.example.baikiemtra2.models.responobj.ResponList;
import org.springframework.data.domain.Page;

import java.util.List;

public interface IDangKyHocServices {
    public List<DangKyHoc> getAllDangKyHoc();
    public Respon<DangKyHoc> themDangKyHoc(DangKyHoc dangKyHoc);
    public Respon<DangKyHoc> suaDangKyHoc(DangKyHoc dangKyHoc);
    public Respon<DangKyHoc> xoaDangKyHoc(int idDangKyHoc);
    Page<DangKyHoc> getAllDangKyHocPage(int pageNumber, int pageSize);
}
