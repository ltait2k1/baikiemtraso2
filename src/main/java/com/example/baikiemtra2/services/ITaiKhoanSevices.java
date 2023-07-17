package com.example.baikiemtra2.services;

import com.example.baikiemtra2.models.TaiKhoan;
import com.example.baikiemtra2.models.responobj.Respon;
import com.example.baikiemtra2.models.responobj.ResponList;
import org.springframework.data.domain.Page;

import java.util.List;

public interface ITaiKhoanSevices {
    public List<TaiKhoan> getAllTaiKhoan();
    public Respon<TaiKhoan> themTaiKhoan(TaiKhoan taiKhoan);
    public Respon<TaiKhoan> suaTaiKhoan(TaiKhoan taiKhoan);
    public Respon<TaiKhoan> xoaTaiKhoan(int idTaiKhoan);
    public ResponList<TaiKhoan> timTaiKhoan(String tenKTaiKhoan);
    public Page<TaiKhoan> phanTrangTaiKhoan(int pageNumber, int pageSize);
}
