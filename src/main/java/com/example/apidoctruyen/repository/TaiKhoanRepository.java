package com.example.apidoctruyen.repository;

import com.example.apidoctruyen.entity.Noidungchapter;
import com.example.apidoctruyen.entity.Taikhoan;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TaiKhoanRepository extends JpaRepository<Taikhoan, Integer> {
}
