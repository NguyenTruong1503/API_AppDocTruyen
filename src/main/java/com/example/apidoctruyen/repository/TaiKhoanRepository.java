package com.example.apidoctruyen.repository;
import com.example.apidoctruyen.entity.Noidungchapter;
import com.example.apidoctruyen.entity.Taikhoan;
import com.example.apidoctruyen.model.TaiKhoanDto;
import com.example.apidoctruyen.model.TruyenDto;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface TaiKhoanRepository extends JpaRepository<Taikhoan, Integer> {

    @Query("select NEW com.example.apidoctruyen.model.TaiKhoanDto(tk.id,tk.email,tk.hoten,tk.dienthoai,tk.diemthuong) from Taikhoan tk where tk.email = :email")
    public Optional<TaiKhoanDto> findByEmail(@Param("email") String email);

}
