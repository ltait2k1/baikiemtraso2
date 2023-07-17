package com.example.baikiemtra2.services.imp;

import com.example.baikiemtra2.models.BaiViet;
import com.example.baikiemtra2.models.DangKyHoc;
import com.example.baikiemtra2.models.KhoaHoc;
import com.example.baikiemtra2.models.responobj.Respon;
import com.example.baikiemtra2.models.responobj.ResponList;
import com.example.baikiemtra2.repository.IDangKyHocRepo;
import com.example.baikiemtra2.repository.IKhoaHocRepo;
import com.example.baikiemtra2.services.IKhoaHocServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class KhoaHocServices implements IKhoaHocServices {
    @Autowired
    IKhoaHocRepo khoaHocRepo;
    @Autowired
    IDangKyHocRepo dangKyHocRepo;
    @Override
    public List<KhoaHoc> getAllKhoaHoc() {
        return khoaHocRepo.findAll();
    }

    @Override
    public Respon<KhoaHoc> themKhoaHoc(KhoaHoc khoaHoc) {
        Respon<KhoaHoc> respon = new Respon<>();
        Optional<KhoaHoc> optionalKhoaHoc = khoaHocRepo.findById(khoaHoc.getKhoaHocId());
        if(optionalKhoaHoc.isEmpty())
        {
            khoaHocRepo.save(khoaHoc);
            respon.setMassage("Thêm mới khoá học thành công");
            respon.setData(khoaHoc);
            respon.setStatus(1);
        }
        else
        {
            respon.setStatus(2);
            respon.setMassage("Id khoá học đã tồn tại");
        }
        return respon;
    }

    @Override
    public Respon<KhoaHoc> suaKhoaHoc(KhoaHoc khoaHoc) {
        Respon<KhoaHoc> respon = new Respon<>();
        Optional<KhoaHoc> optionalKhoaHoc = khoaHocRepo.findById(khoaHoc.getKhoaHocId());
        if(!optionalKhoaHoc.isEmpty())
        {
            khoaHocRepo.save(khoaHoc);
            respon.setMassage("Sửa khoá học thành công");
            respon.setData(khoaHoc);
            respon.setStatus(1);
        }
        else
        {
            respon.setStatus(2);
            respon.setMassage("Id khoá học không tồn tại");
        }
        return respon;
    }

    @Override
    public Respon<KhoaHoc> xoaKhoaHoc(int idKhoaHoc) {
        Respon<KhoaHoc> respon = new Respon<>();
        Optional<KhoaHoc> optionalKhoaHoc =khoaHocRepo.findById(idKhoaHoc);
        if(!optionalKhoaHoc.isEmpty())
        {
            for(DangKyHoc x : dangKyHocRepo.findAll())
            {
                if(x.getKhoaHoc().getKhoaHocId() == idKhoaHoc)
                    dangKyHocRepo.delete(x);
            }
            respon.setMassage("Xoá thành công khoá học");
            respon.setStatus(1);
            respon.setData(khoaHocRepo.findById(idKhoaHoc).get());
            khoaHocRepo.deleteById(idKhoaHoc);
        }
        else
        {
            respon.setStatus(2);
            respon.setMassage("Id khoá học không tồn tại");
        }
        return respon;
    }

    @Override
    public ResponList<KhoaHoc> timKhoaHoc(String tenKhoaHoc) {
        ResponList<KhoaHoc> responList = new ResponList<>();
        List<KhoaHoc> list = new ArrayList<>();
        for (KhoaHoc x : khoaHocRepo.findAll())
        {
            if (x.getTenKhoaHoc().toLowerCase().contains(tenKhoaHoc.toLowerCase()))
                list.add(x);
        }
        if (!list.isEmpty())
        {
            responList.setMassage("Tìm thấy danh sách khoá học:");
            responList.setData(list);
            responList.setStatus(1);
        }
        else
        {
            responList.setStatus(2);
            responList.setMassage("Không tìm thấy  khoá học");
        }
        return responList;
    }

    @Override
    public Page<KhoaHoc> phanTrangKhoaHoc(int pageNumber, int pageSize) {
        Pageable pageable = PageRequest.of(pageNumber,pageSize);
        return khoaHocRepo.findAll(pageable);
    }
}
