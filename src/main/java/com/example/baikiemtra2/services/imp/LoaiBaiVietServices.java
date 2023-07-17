package com.example.baikiemtra2.services.imp;

import com.example.baikiemtra2.models.*;
import com.example.baikiemtra2.models.responobj.Respon;
import com.example.baikiemtra2.repository.IBaiVietRepo;
import com.example.baikiemtra2.repository.IChuDeRepo;
import com.example.baikiemtra2.repository.ILoaiBaiVietRepo;
import com.example.baikiemtra2.services.ILoaiBaiVietServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LoaiBaiVietServices implements ILoaiBaiVietServices {
    @Autowired
    ILoaiBaiVietRepo loaiBaiVietRepo;
    @Autowired
    IChuDeRepo chuDeRepo;
    @Autowired
    IBaiVietRepo baiVietRepo;
    @Override
    public List<LoaiBaiViet> getAllLoaiBaiViet() {
        return loaiBaiVietRepo.findAll();
    }

    @Override
    public Respon<LoaiBaiViet> themLoaiBaiViet(LoaiBaiViet loaiBaiViet) {
        Respon<LoaiBaiViet> respon = new Respon<>();
        Optional<LoaiBaiViet> optionalLoaiBaiViet = loaiBaiVietRepo.findById(loaiBaiViet.getLoaiBaiVietId());
        if(optionalLoaiBaiViet.isEmpty())
        {
            loaiBaiVietRepo.save(loaiBaiViet);
            respon.setMassage("Thêm mới loại bài viết thành công");
            respon.setData(loaiBaiViet);
            respon.setStatus(1);
        }
        else
        {
            respon.setStatus(2);
            respon.setMassage("Id loại bài viết đã tồn tại");
        }
        return respon;
    }

    @Override
    public Respon<LoaiBaiViet> suaLoaiBaiViet(LoaiBaiViet loaiBaiViet) {
        Respon<LoaiBaiViet> respon = new Respon<>();
        Optional<LoaiBaiViet> optionalLoaiBaiViet = loaiBaiVietRepo.findById(loaiBaiViet.getLoaiBaiVietId());
        if(!optionalLoaiBaiViet.isEmpty())
        {
            loaiBaiVietRepo.save(loaiBaiViet);
            respon.setMassage("Sửa loại bài viết thành công");
            respon.setData(loaiBaiViet);
            respon.setStatus(1);
        }
        else
        {
            respon.setStatus(2);
            respon.setMassage("Id loại bài viết không tồn tại");
        }
        return respon;
    }

    @Override
    public Respon<LoaiBaiViet> xoaLoaiBaiViet(int idLoaiBaiViet) {
        Respon<LoaiBaiViet> respon = new Respon<>();
        Optional<LoaiBaiViet> optionalLoaiBaiViet = loaiBaiVietRepo.findById(idLoaiBaiViet);
        if(!optionalLoaiBaiViet.isEmpty())
        {
            for(BaiViet x : baiVietRepo.findAll())
            {
                if(x.getChuDe().getLoaiBaiViet().getLoaiBaiVietId() == idLoaiBaiViet)
                    baiVietRepo.delete(x);
            }
            for (ChuDe x : chuDeRepo.findAll())
            {
                if(x.getLoaiBaiViet().getLoaiBaiVietId() == idLoaiBaiViet)
                    chuDeRepo.delete(x);
            }
            respon.setMassage("Xoá thành công loại khoá học");
            respon.setStatus(1);
            respon.setData(loaiBaiVietRepo.findById(idLoaiBaiViet).get());
            loaiBaiVietRepo.deleteById(idLoaiBaiViet);
        }
        else
        {
            respon.setStatus(2);
            respon.setMassage("Id loại bài viết không tồn tại");
        }
        return respon;
    }

    @Override
    public Page<LoaiBaiViet> phanTrangLoaiBaiViet(int pageNumber, int pageSize) {
        return loaiBaiVietRepo.findAll(PageRequest.of(pageNumber,pageSize));
    }
}
