package com.example.baikiemtra2.models;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;

import java.util.Set;

@Entity
@Table(name = "loaibaiviet")
public class LoaiBaiViet {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "loaibaivietid")
    private int loaiBaiVietId;

    @Column(name = "tenloai")
    private String tenLoai;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "loaiBaiViet", cascade = CascadeType.ALL)
    @JsonManagedReference
    private Set<ChuDe> chuDes;

    public int getLoaiBaiVietId() {
        return loaiBaiVietId;
    }

    public void setLoaiBaiVietId(int loaiBaiVietId) {
        this.loaiBaiVietId = loaiBaiVietId;
    }

    public String getTenLoai() {
        return tenLoai;
    }

    public void setTenLoai(String tenLoai) {
        this.tenLoai = tenLoai;
    }

    public Set<ChuDe> getChuDes() {
        return chuDes;
    }

    public void setChuDes(Set<ChuDe> chuDes) {
        this.chuDes = chuDes;
    }
}
