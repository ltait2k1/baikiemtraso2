package com.example.baikiemtra2.services.imp;

import com.example.baikiemtra2.models.DangKyHoc;
import com.example.baikiemtra2.models.KhoaHoc;
import com.example.baikiemtra2.models.LoaiKhoaHoc;
import com.example.baikiemtra2.models.responobj.Respon;
import com.example.baikiemtra2.repository.IDangKyHocRepo;
import com.example.baikiemtra2.repository.IKhoaHocRepo;
import com.example.baikiemtra2.repository.ILoaiKhoaHocRepo;
import com.example.baikiemtra2.services.ILoaiKhoaHocServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LoaiKhoaHocServices implements ILoaiKhoaHocServices {
    @Autowired
    ILoaiKhoaHocRepo loaiKhoaHocRepo;
    @Autowired
    IKhoaHocRepo khoaHocRepo;
    @Autowired
    IDangKyHocRepo dangKyHocRepo;
    @Override
    public List<LoaiKhoaHoc> getAllLoaiKhoaHoc() {
        return loaiKhoaHocRepo.findAll();
    }

    @Override
    public Respon<LoaiKhoaHoc> themLoaiKhoaHoc(LoaiKhoaHoc loaiKhoaHoc) {
        Respon<LoaiKhoaHoc> respon = new Respon<>();
        Optional<LoaiKhoaHoc> optionalLoaiKhoaHoc = loaiKhoaHocRepo.findById(loaiKhoaHoc.getLoaiKhoaHocId());
        if(optionalLoaiKhoaHoc.isEmpty())
        {
            loaiKhoaHocRepo.save(loaiKhoaHoc);
            respon.setMassage("Thêm mới loại khoá học thành công");
            respon.setData(loaiKhoaHoc);
            respon.setStatus(1);
        }
        else
        {
            respon.setStatus(2);
            respon.setMassage("Id loại khoá học đã tồn tại");
        }
        return respon;
    }

    @Override
    public Respon<LoaiKhoaHoc> suaLoaiKhoaHoc(LoaiKhoaHoc loaiKhoaHoc) {
        Respon<LoaiKhoaHoc> respon = new Respon<>();
        Optional<LoaiKhoaHoc> optionalLoaiKhoaHoc = loaiKhoaHocRepo.findById(loaiKhoaHoc.getLoaiKhoaHocId());
        if(!optionalLoaiKhoaHoc.isEmpty())
        {
            loaiKhoaHocRepo.save(loaiKhoaHoc);
            respon.setMassage("Sửa loại khoá học thành công");
            respon.setData(loaiKhoaHoc);
            respon.setStatus(1);
        }
        else
        {
            respon.setStatus(2);
            respon.setMassage("Id loại khoá học không tồn tại");
        }
        return respon;
    }

    @Override
    public Respon<LoaiKhoaHoc> xoaLoaiKhoaHoc(int idLoaiKhoaHoc) {
        Respon<LoaiKhoaHoc> respon = new Respon<>();
        Optional<LoaiKhoaHoc> optionalLoaiKhoaHoc = loaiKhoaHocRepo.findById(idLoaiKhoaHoc);
        if(!optionalLoaiKhoaHoc.isEmpty())
        {
            for(DangKyHoc x : dangKyHocRepo.findAll())
            {
                if(x.getKhoaHoc().getLoaiKhoaHoc().getLoaiKhoaHocId() == idLoaiKhoaHoc)
                    dangKyHocRepo.delete(x);
            }
            for (KhoaHoc x : khoaHocRepo.findAll())
            {
                if(x.getLoaiKhoaHoc().getLoaiKhoaHocId() == idLoaiKhoaHoc)
                    khoaHocRepo.delete(x);
            }
            respon.setMassage("Xoá thành công loại khoá học");
            respon.setStatus(1);
            respon.setData(loaiKhoaHocRepo.findById(idLoaiKhoaHoc).get());
            loaiKhoaHocRepo.deleteById(idLoaiKhoaHoc);
        }
        else
        {
            respon.setStatus(2);
            respon.setMassage("Id loại khoá học không tồn tại");
        }
        return respon;
    }
}
