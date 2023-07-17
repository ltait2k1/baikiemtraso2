package com.example.baikiemtra2.models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.databind.DatabindException;
import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name = "baiviet")
public class BaiViet {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "baivietid")
    private int baiVietId;

    @Column(name = "tenbaiviet")
    private String tenBaiViet;

    @Column(name = "thoigiantao")
    private Date thoiGianTao;

    @Column(name = "tentacgia")
    private String tenTacGia;

    @Column(name = "noidung")
    private String noiDung;

    @Column(name = "noidungngan")
    private String noiDungNgan;

    @Column(name = "hinhanh")
    private String hinhAnh;

    @ManyToOne
    @JoinColumn(name = "chudeid",nullable = false, referencedColumnName = "chuDeId")
    @JsonBackReference
    private ChuDe chuDe;

    @ManyToOne
    @JoinColumn(name = "taikhoanid",nullable = false, referencedColumnName = "taiKhoanId")
    @JsonBackReference
    private TaiKhoan taiKhoan;

    public int getBaiVietId() {
        return baiVietId;
    }

    public void setBaiVietId(int baiVietId) {
        this.baiVietId = baiVietId;
    }

    public String getTenBaiViet() {
        return tenBaiViet;
    }

    public void setTenBaiViet(String tenBaiViet) {
        this.tenBaiViet = tenBaiViet;
    }

    public Date getThoiGianTao() {
        return thoiGianTao;
    }

    public void setThoiGianTao(Date thoiGianTao) {
        this.thoiGianTao = thoiGianTao;
    }

    public String getTenTacGia() {
        return tenTacGia;
    }

    public void setTenTacGia(String tenTacGia) {
        this.tenTacGia = tenTacGia;
    }

    public String getNoiDung() {
        return noiDung;
    }

    public void setNoiDung(String noiDung) {
        this.noiDung = noiDung;
    }

    public String getNoiDungNgan() {
        return noiDungNgan;
    }

    public void setNoiDungNgan(String noiDungNgan) {
        this.noiDungNgan = noiDungNgan;
    }

    public String getHinhAnh() {
        return hinhAnh;
    }

    public void setHinhAnh(String hinhAnh) {
        this.hinhAnh = hinhAnh;
    }

    public ChuDe getChuDe() {
        return chuDe;
    }

    public void setChuDe(ChuDe chuDe) {
        this.chuDe = chuDe;
    }

    public TaiKhoan getTaiKhoan() {
        return taiKhoan;
    }

    public void setTaiKhoan(TaiKhoan taiKhoan) {
        this.taiKhoan = taiKhoan;
    }
}
