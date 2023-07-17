package com.example.baikiemtra2.repository;

import com.example.baikiemtra2.models.LoaiKhoaHoc;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ILoaiKhoaHocRepo extends JpaRepository<LoaiKhoaHoc,Integer> {
}
