package com.example.apidoctruyen.Controller;

import com.example.apidoctruyen.entity.Truyen;
import com.example.apidoctruyen.model.TruyenDto;
import com.example.apidoctruyen.model.TruyenInfo;

import com.example.apidoctruyen.repository.truyenRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController

public class truyenController {

    @Autowired
    truyenRepository repo;

    @GetMapping("/truyen")
    public List<TruyenDto> getAllTruyen() {
        List<TruyenDto> listTruyen = repo.getAllTruyen();
        return listTruyen;
    }

    @GetMapping("/truyen/toptruyenmoi")
    public List<TruyenDto> getTopTruyenMoi() {
        Pageable topFive = PageRequest.of(0, 5);
        return repo.getTruyenMoi(topFive);
    }

    @GetMapping("/truyen/toptruyen")
    public List<TruyenDto> getTop5Truyen() {
        Pageable topFive = PageRequest.of(0, 5);
        return repo.getTopTruyen(topFive);
    }

    @GetMapping("/theloai")
    public List<String> getAllTheLoai() {
        return repo.findAllTheLoai();
    }


    @GetMapping("/truyennewest")
    public List<TruyenInfo> getNewestTruyen() {
        List<TruyenInfo> list = repo.findNewestBooks();
        return list;
    }
}
