package com.example.baikiemtra2.models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;

import java.util.Set;

@Entity
@Table(name = "chude")
public class ChuDe {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "chudeid")
    private int chuDeId;

    @Column(name = "tenchude")
    private String tenChude;

    @Column(name = "noidung")
    private String noiDung;

    @ManyToOne
    @JoinColumn(name = "loaibaivietid",nullable = false, referencedColumnName = "loaiBaiVietId")
    @JsonBackReference
    private LoaiBaiViet loaiBaiViet;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "chuDe", cascade = CascadeType.ALL)
    @JsonManagedReference
    private Set<BaiViet> baiViets;

    public int getChuDeId() {
        return chuDeId;
    }

    public void setChuDeId(int chuDeId) {
        this.chuDeId = chuDeId;
    }

    public String getTenChude() {
        return tenChude;
    }

    public void setTenChude(String tenChude) {
        this.tenChude = tenChude;
    }

    public String getNoiDung() {
        return noiDung;
    }

    public void setNoiDung(String noiDung) {
        this.noiDung = noiDung;
    }

    public LoaiBaiViet getLoaiBaiViet() {
        return loaiBaiViet;
    }

    public void setLoaiBaiViet(LoaiBaiViet loaiBaiViet) {
        this.loaiBaiViet = loaiBaiViet;
    }

    public Set<BaiViet> getBaiViets() {
        return baiViets;
    }

    public void setBaiViets(Set<BaiViet> baiViets) {
        this.baiViets = baiViets;
    }
}
