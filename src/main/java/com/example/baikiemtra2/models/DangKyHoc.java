package com.example.baikiemtra2.models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;

import java.util.Date;
import java.util.Set;

@Entity
@Table(name = "dangkyhoc")
public class DangKyHoc {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "dangkyhocid")
    private int dangKyHocId;

    @Column(name = "ngaydangky")
    private Date ngayDangKy;

    @Column(name = "ngaybatdau")
    private Date ngayBatDau;

    @Column(name = "ngaykethuc")
    private Date ngayKetThuc;

   @ManyToOne
    @JoinColumn(name = "taikhoanid",nullable = false, referencedColumnName = "taikhoanId")
    @JsonBackReference
    private TaiKhoan taiKhoan;

    @ManyToOne
    @JoinColumn(name = "tinhtranghocid",nullable = false, referencedColumnName = "tinhtranghocid")
    @JsonBackReference
    private TinhTrangHoc tinhTrangHoc;

    @ManyToOne
    @JoinColumn(name = "hocvienid",nullable = false, referencedColumnName = "hocvienid")
    @JsonBackReference
    private HocVien hocVien;

    @ManyToOne
    @JoinColumn(name = "khoahocid",nullable = false, referencedColumnName = "khoahocid")
    @JsonBackReference
    private KhoaHoc khoaHoc;

    public int getDangKyHocId() {
        return dangKyHocId;
    }

    public void setDangKyHocId(int dangKyHocId) {
        this.dangKyHocId = dangKyHocId;
    }

    public Date getNgayDangKy() {
        return ngayDangKy;
    }

    public void setNgayDangKy(Date ngayDangKy) {
        this.ngayDangKy = ngayDangKy;
    }

    public Date getNgayBatDau() {
        return ngayBatDau;
    }

    public void setNgayBatDau(Date ngayBatDau) {
        this.ngayBatDau = ngayBatDau;
    }

    public Date getNgayKetThuc() {
        return ngayKetThuc;
    }

    public void setNgayKetThuc(Date ngayKetThuc) {
        this.ngayKetThuc = ngayKetThuc;
    }

    public TaiKhoan getTaiKhoan() {
        return taiKhoan;
    }

    public void setTaiKhoan(TaiKhoan taiKhoan) {
        this.taiKhoan = taiKhoan;
    }

    public TinhTrangHoc getTinhTrangHoc() {
        return tinhTrangHoc;
    }

    public void setTinhTrangHoc(TinhTrangHoc tinhTrangHoc) {
        this.tinhTrangHoc = tinhTrangHoc;
    }

    public HocVien getHocVien() {
        return hocVien;
    }

    public void setHocVien(HocVien hocVien) {
        this.hocVien = hocVien;
    }

    public KhoaHoc getKhoaHoc() {
        return khoaHoc;
    }

    public void setKhoaHoc(KhoaHoc khoaHoc) {
        this.khoaHoc = khoaHoc;
    }
}
