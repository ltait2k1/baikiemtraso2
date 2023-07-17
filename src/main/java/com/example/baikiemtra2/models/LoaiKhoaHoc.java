package com.example.baikiemtra2.models;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;

import java.util.Set;

@Entity
@Table(name = "loaikhoahoc")
public class LoaiKhoaHoc {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "loaikhoahocid")
    private int loaiKhoaHocId;

    @Column(name = "tenloai")
    private String tenLoai;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "loaiKhoaHoc", cascade = CascadeType.ALL)
    @JsonManagedReference
    private Set<KhoaHoc> khoaHocs;

    public int getLoaiKhoaHocId() {
        return loaiKhoaHocId;
    }

    public void setLoaiKhoaHocId(int loaiKhoaHocId) {
        this.loaiKhoaHocId = loaiKhoaHocId;
    }

    public String getTenLoai() {
        return tenLoai;
    }

    public void setTenLoai(String tenLoai) {
        this.tenLoai = tenLoai;
    }

    public Set<KhoaHoc> getKhoaHocs() {
        return khoaHocs;
    }

    public void setKhoaHocs(Set<KhoaHoc> khoaHocs) {
        this.khoaHocs = khoaHocs;
    }
}
