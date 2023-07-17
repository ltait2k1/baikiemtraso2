package com.example.baikiemtra2.services.imp;

import com.example.baikiemtra2.models.DangKyHoc;
import com.example.baikiemtra2.models.HocVien;
import com.example.baikiemtra2.models.KhoaHoc;
import com.example.baikiemtra2.models.responobj.Respon;
import com.example.baikiemtra2.models.responobj.ResponList;
import com.example.baikiemtra2.repository.IDangKyHocRepo;
import com.example.baikiemtra2.repository.IHocVienRepo;
import com.example.baikiemtra2.services.IHocVienServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.regex.Pattern;

@Service
public class HocVienServices implements IHocVienServices {
    @Autowired
    IHocVienRepo hocVienRepo;
    @Autowired
    IDangKyHocRepo dangKyHocRepo;

    @Override
    public List<HocVien> getAlHocVien() {
        return hocVienRepo.findAll();
    }

    @Override
    public Respon<HocVien> themHocVien(HocVien hocVien) {
        Respon<HocVien> respon = new Respon<>();
        String EMAIL_PATTERN = "^[a-zA-Z][\\w-]+@([\\w]+\\.[\\w]+|[\\w]+\\.[\\w]{2,}\\.[\\w]{2,})$";
        Optional<HocVien> hocVienOptional = hocVienRepo.findById(hocVien.getHocVienId());
        List<HocVien> lst1 = new ArrayList<>();
        List<HocVien> lst2 = new ArrayList<>();
        if (hocVienOptional.isEmpty())
        {
            for (HocVien x : hocVienRepo.findAll())
            {
                if (x.geteMail().equals(hocVien.geteMail())) {
                    lst1.add(x);
                    break;
                }
                if(x.getSdt().equals(hocVien.getSdt())) {
                    lst2.add(x);
                    break;
                }
            }
            if(lst1.isEmpty())
            {
                if (lst2.isEmpty())
                {
                    if(Pattern.matches(EMAIL_PATTERN,hocVien.geteMail()))
                    {
                        hocVienRepo.save(hocVien);
                        respon.setMassage("Thêm mới học viên thành công");
                        respon.setStatus(1);
                        respon.setData(hocVien);
                    }
                    else
                    {
                        respon.setStatus(6);
                        respon.setMassage("Định dạng email không đúng");
                    }
                }
                else
                {
                    respon.setStatus(6);
                    respon.setMassage("Số điện thoại đã tồn tại");
                }
            }
            else
            {
                respon.setStatus(6);
                respon.setMassage("Email đã tồn tại");
            }
        }
        else
        {
            respon.setStatus(6);
            respon.setMassage("Id học viên đã tồn tại");
        }
        return respon;
    }

    @Override
    public Respon<HocVien> suaHocVien(HocVien hocVien) {
        Respon<HocVien> respon = new Respon<>();
        String EMAIL_PATTERN = "^[a-zA-Z][\\w-]+@([\\w]+\\.[\\w]+|[\\w]+\\.[\\w]{2,}\\.[\\w]{2,})$";
        Optional<HocVien> hocVienOptional = hocVienRepo.findById(hocVien.getHocVienId());
        List<HocVien> lst1 = new ArrayList<>();
        List<HocVien> lst2 = new ArrayList<>();
        if (!hocVienOptional.isEmpty())
        {
            for (HocVien x : hocVienRepo.findAll())
            {
                if (x.geteMail().equals(hocVien.geteMail())) {
                    lst1.add(x);
                    break;
                }
                if(x.getSdt().equals(hocVien.getSdt())) {
                    lst2.add(x);
                    break;
                }
            }
            if(lst1.isEmpty())
            {
                if (lst2.isEmpty())
                {
                    if(Pattern.matches(EMAIL_PATTERN,hocVien.geteMail()))
                    {
                        hocVienRepo.save(hocVien);
                        respon.setMassage("Thêm mới học viên thành công");
                        respon.setStatus(1);
                        respon.setData(hocVien);
                    }
                    else
                    {
                        respon.setStatus(6);
                        respon.setMassage("Định dạng email không đúng");
                    }
                }
                else
                {
                    respon.setStatus(6);
                    respon.setMassage("Số điện thoại đã tồn tại");
                }
            }
            else
            {
                respon.setStatus(6);
                respon.setMassage("Email đã tồn tại");
            }
        }
        else
        {
            respon.setStatus(6);
            respon.setMassage("Id học viên không tồn tại");
        }
        return respon;
    }

    @Override
    public Respon<HocVien> xoaHocVien(int idHocVien) {
        Respon<HocVien> respon = new Respon<>();
        Optional<HocVien> optionalHocVien = hocVienRepo.findById(idHocVien);
        if(!optionalHocVien.isEmpty())
        {
            for(DangKyHoc x : dangKyHocRepo.findAll())
            {
                if(x.getHocVien().getHocVienId() == idHocVien)
                    dangKyHocRepo.delete(x);
            }
            respon.setMassage("Xoá thành học viên");
            respon.setStatus(1);
            respon.setData(hocVienRepo.findById(idHocVien).get());
            hocVienRepo.deleteById(idHocVien);
        }
        else
        {
            respon.setStatus(2);
            respon.setMassage("Id học viên không tồn tại");
        }
        return respon;
    }

    @Override
    public ResponList<HocVien> timHocVienTheoTen(String tenHocVien) {
        ResponList<HocVien> responList = new ResponList<>();
        List<HocVien> list = new ArrayList<>();
        for (HocVien x : hocVienRepo.findAll())
        {
            if (x.getHoTen().toLowerCase().contains(tenHocVien.toLowerCase()))
                list.add(x);
        }
        if (!list.isEmpty())
        {
            responList.setMassage("Tìm thấy danh sách học viên có tên là "+tenHocVien);
            responList.setData(list);
            responList.setStatus(1);
        }
        else
        {
            responList.setStatus(2);
            responList.setMassage("Không tìm thấy  học viên có tên " +tenHocVien);
        }
        return responList;
    }

    @Override
    public ResponList<HocVien> timHocVienEmail(String eMail) {
        ResponList<HocVien> responList = new ResponList<>();
        List<HocVien> list = new ArrayList<>();
        for (HocVien x : hocVienRepo.findAll())
        {
            if (x.geteMail().toLowerCase().equals(eMail.toLowerCase()))
                list.add(x);
        }
        if (!list.isEmpty())
        {
            responList.setMassage("Tìm thấy danh sách học viên có email là "+eMail);
            responList.setData(list);
            responList.setStatus(1);
        }
        else
        {
            responList.setStatus(2);
            responList.setMassage("Không tìm thấy  học viên có email là " + eMail);
        }
        return responList;
    }

    @Override
    public Page<HocVien> phanTrangHocVien(int pageNumber, int pageSize) {
        return hocVienRepo.findAll(PageRequest.of(pageNumber,pageSize));
    }
}
