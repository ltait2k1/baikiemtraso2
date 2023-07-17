package com.example.baikiemtra2.services;

import com.example.baikiemtra2.models.LoaiBaiViet;
import com.example.baikiemtra2.models.responobj.Respon;
import org.springframework.data.domain.Page;

import java.util.List;
public interface ILoaiBaiVietServices {
    public List<LoaiBaiViet> getAllLoaiBaiViet();
    public Respon<LoaiBaiViet> themLoaiBaiViet(LoaiBaiViet loaiBaiViet);
    public Respon<LoaiBaiViet> suaLoaiBaiViet(LoaiBaiViet loaiBaiViet);
    public Respon<LoaiBaiViet> xoaLoaiBaiViet(int idLoaiBaiViet);
    public Page<LoaiBaiViet> phanTrangLoaiBaiViet(int pageNumber, int pageSize);
}
