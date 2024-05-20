package com.example.apidoctruyen.Controller;


import com.example.apidoctruyen.entity.Chapter;

import com.example.apidoctruyen.entity.Danhgia;
import com.example.apidoctruyen.entity.Taikhoan;
import com.example.apidoctruyen.model.TruyenDto;
import com.example.apidoctruyen.repository.BinhLuanRepository;
import com.example.apidoctruyen.repository.DanhGiaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class DanhGiaController {
    @Autowired
    DanhGiaRepository repo;
    @GetMapping("/truyen/gettbdanhgia/{id}")
    public Double getTruyenById(@PathVariable int id) {
        Double danhgia = repo.getAverageRatingByTruyenId(id);
        return danhgia;
    }

    @GetMapping("/truyen/gettbdanhgiatheochapter/{id}")
    public Double gettbdanhgiatheochapter(@PathVariable int id) {
        Double danhgia = repo.getAverageRatingByIdChapter(id);
        return danhgia;
    }
    @GetMapping("/getidbychapterandtk/{idchapter}/{idtaikhoan}")
    public List<Integer> getIDByChapterAndTK(@PathVariable int idchapter, @PathVariable int idtaikhoan){
        return repo.getIDByChapterAndTK(idchapter, idtaikhoan);
    }
    
    @PutMapping ("/danhgia/{idchapter}/{idtaikhoan}/{sosao}")
    public void updateDanhGia(@PathVariable Integer idchapter, @PathVariable Integer idtaikhoan, @PathVariable Double sosao){
        Danhgia danhgia = repo.findByIdchapterAndIdtaikhoan(idchapter, idtaikhoan);
        if (danhgia != null) {
            danhgia.setSosao(sosao);
            repo.save(danhgia);
        }
    }
    // them sosao vao table danhgia theo idchapter va idtaikhoan
//    @PostMapping("/danhgia/{idchapter}/{idtaikhoan}/{sosao}")
//    public ResponseEntity<Danhgia> addDanhGia(@PathVariable Integer idchapter, @PathVariable Integer idtaikhoan, @PathVariable Double sosao) {
//        Danhgia danhgia = new Danhgia();
//        Chapter chapter = new Chapter();
//        Taikhoan taikhoan = new Taikhoan();
//
//        danhgia.setIdchapter(idchapter);
//        danhgia.setIdtaikhoan(idtaikhoan);
//        danhgia.setSosao(sosao);
//        repo.save(danhgia);
//        return new ResponseEntity<>(danhgia, HttpStatus.CREATED);
//    }

}
