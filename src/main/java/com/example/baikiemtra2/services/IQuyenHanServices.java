package com.example.baikiemtra2.services;

import com.example.baikiemtra2.models.QuyenHan;
import com.example.baikiemtra2.models.responobj.Respon;
import org.springframework.data.domain.Page;

import java.util.List;

public interface IQuyenHanServices {
    public List<QuyenHan> getAllQuyenHan();
    public Respon<QuyenHan> themQuyenHan(QuyenHan quyenHan);
    public Respon<QuyenHan> suaQuyenHan(QuyenHan quyenHan);
    public Respon<QuyenHan> xoaQuyenHan(int idQuyenHan);
    public Page<QuyenHan> phanTrangQuyenHan(int pageNumber, int pageSize);
}
