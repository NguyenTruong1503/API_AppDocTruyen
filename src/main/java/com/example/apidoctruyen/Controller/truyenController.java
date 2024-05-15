package com.example.apidoctruyen.Controller;

import com.example.apidoctruyen.entity.Truyen;
import com.example.apidoctruyen.model.TruyenInfo;
import com.example.apidoctruyen.repository.TruyenRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController

public class truyenController {

    @Autowired
    TruyenRepository repo;
    @GetMapping("/truyen")
    public List<Truyen> getAllTruyen(){
        List<Truyen> listTruyen = repo.findAll();
        return listTruyen;
    }
    @GetMapping("/truyen/toptruyenmoi")
    public List<Truyen> getTopTruyenMoi() {
        return repo.getTruyenMoi();
    }

    @GetMapping("/truyen/toptruyen")
    public List<Truyen> getTopTruyen() {
        return repo.getTopTruyen();
    }


    @GetMapping("/theloai")
    public List<String> getAllTheLoai() {
        return repo.findAllTheLoai();
    }

    @GetMapping("/truyennewest")
    public List<TruyenInfo> getNewestTruyen() {
        List<TruyenInfo>list = repo.findNewestBooks();
        return list;
    }
}
