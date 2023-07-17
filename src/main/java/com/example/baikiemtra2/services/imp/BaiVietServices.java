package com.example.baikiemtra2.services.imp;

import com.example.baikiemtra2.models.BaiViet;
import com.example.baikiemtra2.models.responobj.Respon;
import com.example.baikiemtra2.models.responobj.ResponList;
import com.example.baikiemtra2.repository.IBaiVietRepo;
import com.example.baikiemtra2.services.IBaiVietServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;


import java.util.*;

@Service
public class BaiVietServices  implements IBaiVietServices {
    @Autowired
    IBaiVietRepo baiVietRepo;
    @Override
    public List<BaiViet> getAllBaiViet() {
        return baiVietRepo.findAll();
    }

    @Override
    public Respon<BaiViet> themBaiViet(BaiViet baiViet) {
        Respon<BaiViet> respon = new Respon<>();
        Optional<BaiViet> optionalBaiViet = baiVietRepo.findById(baiViet.getBaiVietId());
        if(optionalBaiViet.isEmpty())
        {
            Date date = new Date();
            baiViet.setThoiGianTao(date);
            baiVietRepo.save(baiViet);
            respon.setMassage("Thêm mới bài viết thành công");
            respon.setData(baiViet);
            respon.setStatus(1);
        }
        else
        {
            respon.setStatus(2);
            respon.setMassage("Id bài viết đã tồn tại");
        }
        return respon;
    }

    @Override
    public Respon<BaiViet> suaBaiViet(BaiViet baiViet) {
        Respon<BaiViet> respon = new Respon<>();
        Optional<BaiViet> optionalBaiViet = baiVietRepo.findById(baiViet.getBaiVietId());
        if(!optionalBaiViet.isEmpty())
        {
            Date date = new Date();
            baiViet.setThoiGianTao(date);
            baiVietRepo.save(baiViet);
            respon.setMassage("Sửa bài viết thành công");
            respon.setData(baiViet);
            respon.setStatus(1);
        }
        else
        {
            respon.setStatus(2);
            respon.setMassage("Id bài viết không tồn tại");
        }
        return respon;
    }

    @Override
    public Respon<BaiViet> xoaBaiViet(int idBaiViet) {
        Respon<BaiViet> respon = new Respon<>();
        Optional<BaiViet> optionalBaiViet = baiVietRepo.findById(idBaiViet);
        if(!optionalBaiViet.isEmpty())
        {
            respon.setMassage("Xoá thành công bài viết");
            respon.setStatus(1);
            respon.setData(baiVietRepo.findById(idBaiViet).get());
            baiVietRepo.deleteById(idBaiViet);
        }
        else
        {
            respon.setStatus(2);
            respon.setMassage("Id bài viết không tồn tại");
        }
        return respon;
    }

    @Override
    public ResponList<BaiViet> timKiemBaiViet(String tenBaiViet) {
        ResponList<BaiViet> responList = new ResponList<>();
        List<BaiViet> list = new ArrayList<>();
        for (BaiViet x : baiVietRepo.findAll())
        {
            if (x.getTenBaiViet().toLowerCase().contains(tenBaiViet.toLowerCase()))
                list.add(x);
        }
        if (!list.isEmpty())
        {
            responList.setMassage("Tìm thấy danh sách bài viết:");
            responList.setData(list);
            responList.setStatus(1);
        }
        else
        {
            responList.setStatus(2);
            responList.setMassage("Không tìm thấy bài viết");
        }
        return responList;
    }

    @Override
    public Page<BaiViet> phanTranBaiViet(int pageNumber, int pageSize) {
        return baiVietRepo.findAll(PageRequest.of(pageNumber,pageSize));
    }
}
