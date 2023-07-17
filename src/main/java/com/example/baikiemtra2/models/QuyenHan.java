package com.example.baikiemtra2.models;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;

import java.util.Set;

@Entity
@Table(name = "quyenhan")
public class QuyenHan {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "quyenhanid")
    private int quyenHanId;

    @Column(name = "tenquyenhan")
    private String tenQuyenHan;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "quyenHan", cascade = CascadeType.ALL)
    @JsonManagedReference
    private Set<TaiKhoan> taiKhoans;

    public int getQuyenHanId() {
        return quyenHanId;
    }

    public void setQuyenHanId(int quyenHanId) {
        this.quyenHanId = quyenHanId;
    }

    public String getTenQuyenHan() {
        return tenQuyenHan;
    }

    public void setTenQuyenHan(String tenQuyenHan) {
        this.tenQuyenHan = tenQuyenHan;
    }

    public Set<TaiKhoan> getTaiKhoans() {
        return taiKhoans;
    }

    public void setTaiKhoans(Set<TaiKhoan> taiKhoans) {
        this.taiKhoans = taiKhoans;
    }
}
