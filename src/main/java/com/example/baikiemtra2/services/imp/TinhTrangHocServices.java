package com.example.baikiemtra2.services.imp;

import com.example.baikiemtra2.models.DangKyHoc;
import com.example.baikiemtra2.models.KhoaHoc;
import com.example.baikiemtra2.models.LoaiKhoaHoc;
import com.example.baikiemtra2.models.TinhTrangHoc;
import com.example.baikiemtra2.models.responobj.Respon;
import com.example.baikiemtra2.repository.IDangKyHocRepo;
import com.example.baikiemtra2.repository.ITinhTrangHocRepo;
import com.example.baikiemtra2.services.ITinhTrangHocServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TinhTrangHocServices implements ITinhTrangHocServices {
    @Autowired
    ITinhTrangHocRepo tinhTrangHocRepo;
    @Autowired
    IDangKyHocRepo dangKyHocRepo;
    @Override
    public List<TinhTrangHoc> getAllTinhTrangHoc() {
        return tinhTrangHocRepo.findAll();
    }

    @Override
    public Respon<TinhTrangHoc> themTinhTrangHoc(TinhTrangHoc tinhTrangHoc) {
        Respon<TinhTrangHoc> respon = new Respon<>();
        Optional<TinhTrangHoc> optionalTinhTrangHoc = tinhTrangHocRepo.findById(tinhTrangHoc.getTinhTrangHocId());
        if(optionalTinhTrangHoc.isEmpty())
        {
            tinhTrangHocRepo.save(tinhTrangHoc);
            respon.setMassage("Thêm mới tình trạng học thành công");
            respon.setData(tinhTrangHoc);
            respon.setStatus(1);
        }
        else
        {
            respon.setStatus(2);
            respon.setMassage("Id tình trạng học đã tồn tại");
        }
        return respon;
    }

    @Override
    public Respon<TinhTrangHoc> suaTinhTrangHoc(TinhTrangHoc tinhTrangHoc) {
        Respon<TinhTrangHoc> respon = new Respon<>();
        Optional<TinhTrangHoc> optionalTinhTrangHoc = tinhTrangHocRepo.findById(tinhTrangHoc.getTinhTrangHocId());
        if(!optionalTinhTrangHoc.isEmpty())
        {
            tinhTrangHocRepo.save(tinhTrangHoc);
            respon.setMassage("Sửa tình trạng học thành công");
            respon.setData(tinhTrangHoc);
            respon.setStatus(1);
        }
        else
        {
            respon.setStatus(2);
            respon.setMassage("Id tình trạng học không tồn tại");
        }
        return respon;
    }

    @Override
    public Respon<TinhTrangHoc> xoaTinhTrangHoc(int idTinhTrangHoc) {
        Respon<TinhTrangHoc> respon = new Respon<>();
        Optional<TinhTrangHoc> optionalTinhTrangHoc = tinhTrangHocRepo.findById(idTinhTrangHoc);
        if(!optionalTinhTrangHoc.isEmpty())
        {
            for(DangKyHoc x : dangKyHocRepo.findAll())
            {
                if(x.getTinhTrangHoc().getTinhTrangHocId() == idTinhTrangHoc)
                    dangKyHocRepo.delete(x);
            }
            respon.setMassage("Xoá thành công tình trạng học");
            respon.setStatus(1);
            respon.setData(tinhTrangHocRepo.findById(idTinhTrangHoc).get());
            tinhTrangHocRepo.deleteById(idTinhTrangHoc);
        }
        else
        {
            respon.setStatus(2);
            respon.setMassage("Id tình trạng học không tồn tại");
        }
        return respon;
    }
}
