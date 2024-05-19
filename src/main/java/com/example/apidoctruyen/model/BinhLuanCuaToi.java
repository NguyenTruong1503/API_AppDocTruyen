package com.example.apidoctruyen.model;

import com.example.apidoctruyen.entity.Chapter;
import com.example.apidoctruyen.entity.Taikhoan;
import jakarta.persistence.*;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BinhLuanCuaToi {
    private Integer id;
    private Integer idchapter;
    private Integer idtaikhoan;
    private String noidung;
    private LocalDate ngaydang;
    private Integer trangthai;

}
