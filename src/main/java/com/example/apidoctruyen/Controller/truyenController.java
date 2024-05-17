package com.example.apidoctruyen.Controller;

import com.example.apidoctruyen.entity.Truyen;
import com.example.apidoctruyen.model.TruyenInfo;

import com.example.apidoctruyen.repository.truyenRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController

public class truyenController {

    @Autowired
    truyenRepository repo;

    @GetMapping("/truyen")
    public List<Truyen> getAllTruyen() {
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


    @GetMapping("/truyen/truyennewest")
    public List<TruyenInfo> getNewestTruyen() {
        List<TruyenInfo> list = repo.findNewestComics();
        return list;
    }

    // tôi muốn lấy truyennewest theo theloai
    @GetMapping("/truyen/truyennewest/{theloai}")
    public List<TruyenInfo> getNewestTruyenByTheLoai(@PathVariable String theloai) {
        List<TruyenInfo> list = repo.findNewestComicsByTheLoai(theloai);
        return list;
    }

    //findVotesComic
    @GetMapping("/truyen/truyenvotes")
    public List<TruyenInfo> getVotesTruyen() {
        List<TruyenInfo> list = repo.findVotesComic();
        return list;
    }

    // lay truyenvotes theo the loai
    @GetMapping("/truyen/truyenvotes/{theloai}")
    public List<TruyenInfo> getVotesTruyenByTheLoai(@PathVariable String theloai) {
        List<TruyenInfo> list = repo.findVotesComicByTheLoai(theloai);
        return list;
    }

    @GetMapping("/truyen/truyenview")
    public List<TruyenInfo> getTruyenView() {
        List<TruyenInfo> list = repo.findViewComic();
        return list;
    }

    @GetMapping("/truyen/truyenview/{theloai}")
    public List<TruyenInfo> getTruyenViewByTheLoai(@PathVariable String theloai) {
        List<TruyenInfo> list = repo.findViewComicByTheLoai(theloai);
        return list;
    }


}
