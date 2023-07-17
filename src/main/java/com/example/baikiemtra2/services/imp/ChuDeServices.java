package com.example.baikiemtra2.services.imp;

import com.example.baikiemtra2.models.BaiViet;
import com.example.baikiemtra2.models.ChuDe;
import com.example.baikiemtra2.models.responobj.Respon;
import com.example.baikiemtra2.repository.IBaiVietRepo;
import com.example.baikiemtra2.repository.IChuDeRepo;
import com.example.baikiemtra2.services.IChuDeServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ChuDeServices implements IChuDeServices {
    @Autowired
    IChuDeRepo chuDeRepo;
    @Autowired
    IBaiVietRepo baiVietRepo;
    @Override
    public List<ChuDe> getAllChuDe() {
        return chuDeRepo.findAll() ;
    }

    @Override
    public Respon<ChuDe> themChuDe(ChuDe chuDe) {
        Respon<ChuDe> respon = new Respon<>();
        Optional<ChuDe> optionalChuDe = chuDeRepo.findById(chuDe.getChuDeId());
        if(optionalChuDe.isEmpty())
        {
           chuDeRepo.save(chuDe);
            respon.setMassage("Thêm mới chủ đề thành công");
            respon.setData(chuDe);
            respon.setStatus(1);
        }
        else
        {
            respon.setStatus(2);
            respon.setMassage("Id chủ đề đã tồn tại");
        }
        return respon;
    }

    @Override
    public Respon<ChuDe> suaChuDe(ChuDe chuDe) {
        Respon<ChuDe> respon = new Respon<>();
        Optional<ChuDe> optionalChuDe = chuDeRepo.findById(chuDe.getChuDeId());
        if(!optionalChuDe.isEmpty())
        {
            chuDeRepo.save(chuDe);
            respon.setMassage("Sửa chủ đề thành công");
            respon.setData(chuDe);
            respon.setStatus(1);
        }
        else
        {
            respon.setStatus(2);
            respon.setMassage("Id chủ đề không tồn tại");
        }
        return respon;
    }

    @Override
    public Respon<ChuDe> xoaChuDe(int idChuDe) {
        Respon<ChuDe> respon = new Respon<>();
        Optional<ChuDe> optionalChuDe = chuDeRepo.findById(idChuDe);
        if(!optionalChuDe.isEmpty())
        {
            for(BaiViet x : baiVietRepo.findAll())
            {
                if(x.getChuDe().getChuDeId() == idChuDe)
                    baiVietRepo.delete(x);
            }
            respon.setMassage("Xoá thành công chủ đề");
            respon.setStatus(1);
            respon.setData(chuDeRepo.findById(idChuDe).get());
            chuDeRepo.deleteById(idChuDe);
        }
        else
        {
            respon.setStatus(2);
            respon.setMassage("Id chủ đề không tồn tại");
        }
        return respon;
    }

    @Override
    public Page<ChuDe> phanTrangChuDe(int pageNumber, int pageSize) {
        return chuDeRepo.findAll(PageRequest.of(pageNumber,pageSize));
    }
}
