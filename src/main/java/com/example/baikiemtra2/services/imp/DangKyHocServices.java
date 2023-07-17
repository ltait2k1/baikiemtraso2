package com.example.baikiemtra2.services.imp;

import com.example.baikiemtra2.models.BaiViet;
import com.example.baikiemtra2.models.DangKyHoc;
import com.example.baikiemtra2.models.KhoaHoc;
import com.example.baikiemtra2.models.TinhTrangHoc;
import com.example.baikiemtra2.models.responobj.Respon;
import com.example.baikiemtra2.models.responobj.ResponList;
import com.example.baikiemtra2.repository.IDangKyHocRepo;
import com.example.baikiemtra2.repository.IKhoaHocRepo;
import com.example.baikiemtra2.repository.ITinhTrangHocRepo;
import com.example.baikiemtra2.services.IDangKyHocServices;
import org.springframework.beans.factory.ObjectProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class DangKyHocServices implements IDangKyHocServices {
    @Autowired
    IDangKyHocRepo dangKyHocRepo;
    @Autowired
    IKhoaHocRepo khoaHocRepo;
    @Autowired
    ITinhTrangHocRepo tinhTrangHocRepo;
    @Override
    public List<DangKyHoc> getAllDangKyHoc() {
        return dangKyHocRepo.findAll();
    }

    @Override
    public Respon<DangKyHoc> themDangKyHoc(DangKyHoc dangKyHoc) {
        Respon<DangKyHoc> respon = new Respon<>();
        Optional<DangKyHoc> optionalDangKyHoc = dangKyHocRepo.findById(dangKyHoc.getDangKyHocId());
        if(optionalDangKyHoc.isEmpty())
        {
            Date date = new Date();
            dangKyHoc.setNgayDangKy(date);
            if(dangKyHoc.getTinhTrangHoc().getTinhTrangHocId() == 2)
                dangKyHoc.setNgayBatDau(date);
            else
                dangKyHoc.setNgayBatDau(date);
            KhoaHoc khoaHoc1 = khoaHocRepo.findById(dangKyHoc.getKhoaHoc().getKhoaHocId()).get();
            int temp = khoaHoc1.getThoiGianHoc();
            Calendar calendar = Calendar.getInstance();
            calendar.setTime(dangKyHoc.getNgayBatDau());
            calendar.add(Calendar.MONTH,temp);
            Date dateEnd = calendar.getTime();
            dangKyHoc.setNgayKetThuc(dateEnd);
            if (dangKyHoc.getTinhTrangHoc().getTinhTrangHocId() != 1)
            {
                KhoaHoc khoaHoc = khoaHocRepo.findById(dangKyHoc.getKhoaHoc().getKhoaHocId()).get();
                khoaHoc.setSoHocVien(khoaHoc.getSoHocVien() + 1);
                khoaHocRepo.save(khoaHoc);
            }
            dangKyHocRepo.save(dangKyHoc);
            respon.setMassage("Đăng kí thành công");
            respon.setData(dangKyHoc);
            respon.setStatus(1);
        }
        else
        {
            respon.setStatus(2);
            respon.setMassage("Đăng kí thất bại do trùng ID");
        }
        return respon;
    }

    @Override
    public Respon<DangKyHoc> suaDangKyHoc(DangKyHoc dangKyHoc) {
        Respon<DangKyHoc> respon = new Respon<>();
        Optional<DangKyHoc> optionalDangKyHoc = dangKyHocRepo.findById(dangKyHoc.getDangKyHocId());
        if(!optionalDangKyHoc.isEmpty())
        {
            Date date = new Date();
            dangKyHoc.setNgayDangKy(date);
            if(dangKyHoc.getTinhTrangHoc().getTinhTrangHocId() == 2)
                dangKyHoc.setNgayBatDau(date);
            else
                dangKyHoc.setNgayBatDau(date);
            KhoaHoc khoaHoc1 = khoaHocRepo.findById(dangKyHoc.getKhoaHoc().getKhoaHocId()).get();
            int temp = khoaHoc1.getThoiGianHoc();
            Calendar calendar = Calendar.getInstance();
            calendar.setTime(dangKyHoc.getNgayBatDau());
            calendar.add(Calendar.MONTH,temp);
            Date dateEnd = calendar.getTime();
            dangKyHoc.setNgayKetThuc(dateEnd);
            if (dangKyHoc.getTinhTrangHoc().getTinhTrangHocId() == 1)
            {
                KhoaHoc khoaHoc = khoaHocRepo.findById(dangKyHoc.getKhoaHoc().getKhoaHocId()).get();
                khoaHoc.setSoHocVien(khoaHoc.getSoHocVien() - 1);
                khoaHocRepo.save(khoaHoc);
            }
            dangKyHocRepo.save(dangKyHoc);
            respon.setMassage("Sửa thành công");
            respon.setData(dangKyHoc);
            respon.setStatus(1);
        }
        else
        {
            respon.setStatus(2);
            respon.setMassage("Sửa thất bại do ID không tồn tại");
        }
        return respon;
    }

    @Override
    public Respon<DangKyHoc> xoaDangKyHoc(int idDangKyHoc) {
        Respon<DangKyHoc> respon = new Respon<>();
        Optional<DangKyHoc> optionalDangKyHoc = dangKyHocRepo.findById(idDangKyHoc);
        if(!optionalDangKyHoc.isEmpty())
        {
            respon.setStatus(1);
            respon.setMassage("Xoá thành công");
            respon.setData(dangKyHocRepo.findById(idDangKyHoc).get());
            dangKyHocRepo.deleteById(idDangKyHoc);
        }
        else
        {
            respon.setStatus(2);
            respon.setMassage("Sửa thất bại do ID không tồn tại");
        }
        return respon;
    }

    @Override
    public Page<DangKyHoc> getAllDangKyHocPage(int pageNumber, int pageSize) {
        Pageable pageable = PageRequest.of(pageNumber,pageSize);
        return dangKyHocRepo.findAll(pageable);
    }
}
