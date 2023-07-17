package com.example.baikiemtra2.services;

import com.example.baikiemtra2.models.BaiViet;
import com.example.baikiemtra2.models.responobj.Respon;
import com.example.baikiemtra2.models.responobj.ResponList;
import org.springframework.data.domain.Page;

import java.util.List;

public interface IBaiVietServices {
    public List<BaiViet> getAllBaiViet();
    public Respon<BaiViet> themBaiViet(BaiViet baiViet);
    public Respon<BaiViet> suaBaiViet(BaiViet baiViet);
    public Respon<BaiViet> xoaBaiViet(int idBaiViet);
    public ResponList<BaiViet> timKiemBaiViet(String tenBaiViet);
    public Page<BaiViet> phanTranBaiViet(int pageNumber, int pageSize);
}
