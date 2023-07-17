package com.example.baikiemtra2.services.imp;

import com.example.baikiemtra2.models.*;
import com.example.baikiemtra2.models.responobj.Respon;
import com.example.baikiemtra2.repository.IBaiVietRepo;
import com.example.baikiemtra2.repository.IDangKyHocRepo;
import com.example.baikiemtra2.repository.IQuyenHanRepo;
import com.example.baikiemtra2.repository.ITaiKhoanRepo;
import com.example.baikiemtra2.services.IQuyenHanServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class QuyenHanServices implements IQuyenHanServices {
    @Autowired
    IQuyenHanRepo quyenHanRepo;
    @Autowired
    ITaiKhoanRepo taiKhoanRepo;
    @Autowired
    IBaiVietRepo baiVietRepo;
    @Autowired
    IDangKyHocRepo dangKyHocRepo;
    @Override
    public List<QuyenHan> getAllQuyenHan() {
        return quyenHanRepo.findAll();
    }

    @Override
    public Respon<QuyenHan> themQuyenHan(QuyenHan quyenHan) {
        Respon<QuyenHan> respon = new Respon<>();
        Optional<QuyenHan> optionalQuyenHan = quyenHanRepo.findById(quyenHan.getQuyenHanId());
        if(optionalQuyenHan.isEmpty())
        {
            quyenHanRepo.save(quyenHan);
            respon.setMassage("Thêm mới quyền hạn thành công");
            respon.setData(quyenHan);
            respon.setStatus(1);
        }
        else
        {
            respon.setStatus(2);
            respon.setMassage("Id quyền hạn đã tồn tại");
        }
        return respon;
    }

    @Override
    public Respon<QuyenHan> suaQuyenHan(QuyenHan quyenHan) {
        Respon<QuyenHan> respon = new Respon<>();
        Optional<QuyenHan> optionalQuyenHan = quyenHanRepo.findById(quyenHan.getQuyenHanId());
        if(!optionalQuyenHan.isEmpty())
        {
            quyenHanRepo.save(quyenHan);
            respon.setMassage("Sửa quyền hạn thành công");
            respon.setData(quyenHan);
            respon.setStatus(1);
        }
        else
        {
            respon.setStatus(2);
            respon.setMassage("Id quyền hạn không tồn tại");
        }
        return respon;
    }

    @Override
    public Respon<QuyenHan> xoaQuyenHan(int idQuyenHan) {
        Respon<QuyenHan> respon = new Respon<>();
        Optional<QuyenHan> optionalQuyenHan= quyenHanRepo.findById(idQuyenHan);
        if(!optionalQuyenHan.isEmpty())
        {
            for(DangKyHoc x : dangKyHocRepo.findAll())
            {
                if(x.getTaiKhoan().getQuyenHan().getQuyenHanId() == idQuyenHan)
                    dangKyHocRepo.delete(x);
            }
            for (BaiViet x : baiVietRepo.findAll())
            {
                if(x.getTaiKhoan().getQuyenHan().getQuyenHanId() == idQuyenHan)
                    baiVietRepo.delete(x);
            }
            for (TaiKhoan x: taiKhoanRepo.findAll())
            {
                if(x.getQuyenHan().getQuyenHanId() == idQuyenHan)
                taiKhoanRepo.delete(x);
            }
            respon.setMassage("Xoá thành công quyền hạn");
            respon.setStatus(1);
            respon.setData(quyenHanRepo.findById(idQuyenHan).get());
            quyenHanRepo.deleteById(idQuyenHan);
        }
        else
        {
            respon.setStatus(2);
            respon.setMassage("Id quyền hạn không tồn tại");
        }
        return respon;
    }

    @Override
    public Page<QuyenHan> phanTrangQuyenHan(int pageNumber, int pageSize) {
        return quyenHanRepo.findAll(PageRequest.of(pageNumber,pageSize));
    }
}
