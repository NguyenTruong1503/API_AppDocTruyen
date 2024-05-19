package com.example.apidoctruyen.model;

import com.example.apidoctruyen.entity.*;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.LinkedHashSet;
import java.util.Set;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class ChapterDto {
        private Integer id;
        private Integer idtruyen;
        private String tenchapter;
        private LocalDate ngaydang;
        private Integer soluotxem;
        private Double danhgia;
}
