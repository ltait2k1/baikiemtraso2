package com.example.baikiemtra2.services.imp;

import com.example.baikiemtra2.models.*;
import com.example.baikiemtra2.models.responobj.Respon;
import com.example.baikiemtra2.models.responobj.ResponList;
import com.example.baikiemtra2.repository.IBaiVietRepo;
import com.example.baikiemtra2.repository.IDangKyHocRepo;
import com.example.baikiemtra2.repository.ITaiKhoanRepo;
import com.example.baikiemtra2.services.ITaiKhoanSevices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.regex.Pattern;

@Service
public class TaiKhoanServices implements ITaiKhoanSevices {
    @Autowired
    ITaiKhoanRepo taiKhoanRepo;
    @Autowired
    IBaiVietRepo baiVietRepo;
    @Autowired
    IDangKyHocRepo dangKyHocRepo;

    @Override
    public List<TaiKhoan> getAllTaiKhoan() {
        return taiKhoanRepo.findAll();
    }

    @Override
    public Respon<TaiKhoan> themTaiKhoan(TaiKhoan taiKhoan) {
        Respon<TaiKhoan> respon = new Respon<>();
        String PASSWORD_PATTERN = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=])(?=\\S+$).{8,}$";
        Optional<TaiKhoan> taiKhoanOptional = taiKhoanRepo.findById(taiKhoan.getTaiKhoanId());
        List<TaiKhoan> lst = new ArrayList<>();
        if (taiKhoanOptional.isEmpty()) {
            for (TaiKhoan x : taiKhoanRepo.findAll()) {
                if (x.getTaiKhoan().equals(taiKhoan.getTaiKhoan())) {
                    lst.add(x);
                    break;
                }
            }
            if (lst.isEmpty()) {
                if (Pattern.matches(PASSWORD_PATTERN, taiKhoan.getMatKhau())) {
                    taiKhoanRepo.save(taiKhoan);
                    respon.setMassage("Thêm mới tài khoản thành công");
                    respon.setStatus(1);
                    respon.setData(taiKhoan);
                } else {
                    respon.setStatus(6);
                    respon.setMassage("Mật khẩu phải có ít nhất 1 chữ cái viết hoa, 1 chữ số, 1 kí tự đặc biệt, từ 8-20 kí tự");
                }
            } else {
                respon.setStatus(6);
                respon.setMassage("Tài khoản đã tồn tại");
            }
        }
        else
        {
            respon.setStatus(6);
            respon.setMassage("Id tài khoản  đã tồn tại");
        }
        return respon;
    }

    @Override
    public Respon<TaiKhoan> suaTaiKhoan(TaiKhoan taiKhoan) {
        Respon<TaiKhoan> respon = new Respon<>();
        String PASSWORD_PATTERN = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[!@#&()–[{}]:;',?/*~$^+=<>]).{8,20}$";
        Optional<TaiKhoan> taiKhoanOptional = taiKhoanRepo.findById(taiKhoan.getTaiKhoanId());
        List<TaiKhoan> lst = new ArrayList<>();
        if (!taiKhoanOptional.isEmpty()) {
            for (TaiKhoan x : taiKhoanRepo.findAll()) {
                if (x.getTaiKhoan().equals(taiKhoan.getTaiKhoan())) {
                    lst.add(x);
                    break;
                }
            }
            if (lst.isEmpty()) {
                if (Pattern.matches(PASSWORD_PATTERN, taiKhoan.getMatKhau())) {
                    taiKhoanRepo.save(taiKhoan);
                    respon.setMassage("Sửa tài khoản thành công");
                    respon.setStatus(1);
                    respon.setData(taiKhoan);
                } else {
                    respon.setStatus(6);
                    respon.setMassage("Mật khẩu phải có ít nhất 1 chữ cái viết hoa, 1 chữ số, 1 kí tự đặc biệt, từ 8-20 kí tự");
                }
            } else {
                respon.setStatus(6);
                respon.setMassage("Tài khoản đã tồn tại");
            }
        }
        else
        {
            respon.setStatus(6);
            respon.setMassage("Id tài khoản không tồn tại");
        }
        return respon;
    }

    @Override
    public Respon<TaiKhoan> xoaTaiKhoan(int idTaiKhoan) {
        Respon<TaiKhoan> respon = new Respon<>();
        Optional<TaiKhoan> optionalTaiKhoan = taiKhoanRepo.findById(idTaiKhoan);
        if(!optionalTaiKhoan.isEmpty())
        {
            for(BaiViet x : baiVietRepo.findAll())
            {
                if(x.getTaiKhoan().getTaiKhoanId() == idTaiKhoan)
                    baiVietRepo.delete(x);
            }
            for (DangKyHoc x : dangKyHocRepo.findAll())
            {
                if(x.getTaiKhoan().getTaiKhoanId() == idTaiKhoan)
                    dangKyHocRepo.delete(x);
            }
            respon.setMassage("Xoá thành công tài khoản");
            respon.setStatus(1);
            respon.setData(taiKhoanRepo.findById(idTaiKhoan).get());
            taiKhoanRepo.deleteById(idTaiKhoan);
        }
        else
        {
            respon.setStatus(2);
            respon.setMassage("Id tài khoản không tồn tại");
        }
        return respon;
    }

    @Override
    public ResponList<TaiKhoan> timTaiKhoan(String tenTaiKhoan) {
        ResponList<TaiKhoan> responList = new ResponList<>();
        List<TaiKhoan> list = new ArrayList<>();
        for (TaiKhoan x : taiKhoanRepo.findAll())
        {
            if (x.getTaiKhoan().toLowerCase().equals(tenTaiKhoan.toLowerCase()))
                list.add(x);
        }
        if (!list.isEmpty())
        {
            responList.setMassage("Tìm thấy tài khoản "+ tenTaiKhoan);
            responList.setData(list);
            responList.setStatus(1);
        }
        else
        {
            responList.setStatus(2);
            responList.setMassage("Không tìm thấy tài khoản " +tenTaiKhoan);
        }
        return responList;
    }

    @Override
    public Page<TaiKhoan> phanTrangTaiKhoan(int pageNumber, int pageSize) {
        return taiKhoanRepo.findAll(PageRequest.of(pageNumber,pageSize));
    }
}
