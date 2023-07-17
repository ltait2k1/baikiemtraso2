package com.example.baikiemtra2.services;

import com.example.baikiemtra2.models.HocVien;
import com.example.baikiemtra2.models.KhoaHoc;
import com.example.baikiemtra2.models.responobj.Respon;
import com.example.baikiemtra2.models.responobj.ResponList;
import org.springframework.data.domain.Page;


import java.util.List;

public interface IHocVienServices {
    public List<HocVien> getAlHocVien();
    public Respon<HocVien> themHocVien(HocVien hocVien);
    public Respon<HocVien> suaHocVien(HocVien hocVien);
    public Respon<HocVien> xoaHocVien(int idHocVien);
    public ResponList<HocVien> timHocVienTheoTen(String tenHocVien);
    public ResponList<HocVien> timHocVienEmail(String eMail);
    public Page<HocVien> phanTrangHocVien(int pageNumber, int pageSize);
}
