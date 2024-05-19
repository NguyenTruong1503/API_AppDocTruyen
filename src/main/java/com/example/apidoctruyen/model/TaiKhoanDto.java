package com.example.apidoctruyen.model;

import com.example.apidoctruyen.entity.*;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Nationalized;

import java.util.LinkedHashSet;
import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TaiKhoanDto {
    private Integer id;
    private String email;
    private String hoten;
    private String dienthoai;
    private Integer diemthuong;
}
