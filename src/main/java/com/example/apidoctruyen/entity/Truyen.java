package com.example.apidoctruyen.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "truyen")
@Data

@AllArgsConstructor

@NoArgsConstructor
public class Truyen {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "tentruyen")
    private String tentruyen;

    @Column(name = "tacgia")
    private String tacgia;

    @Column(name = "mota")
    private String mota;

    @Column(name = "theloai")
    private String theloai;

    @Column(name = "linkanh")
    private String linkanh;

    @Column(name = "trangthai")
    private Integer trangthai;

    @Column(name = "key_search")
    private String keySearch;

//    @OneToMany(mappedBy = "truyen")
//    private List<Chapter> chapters;
//
//    @OneToMany(mappedBy = "truyen")
//    private List<Thongke> thongkes;

    @OneToMany(mappedBy = "idtruyen")
    private Set<Chapter> chapters = new LinkedHashSet<>();

    @OneToMany(mappedBy = "idtruyen")
    private Set<Thongke> thongkes = new LinkedHashSet<>();

}
