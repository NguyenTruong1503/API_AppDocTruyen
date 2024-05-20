package com.example.apidoctruyen.Controller;

import com.example.apidoctruyen.entity.Danhgia;
import com.example.apidoctruyen.model.TruyenDto;
import com.example.apidoctruyen.repository.BinhLuanRepository;
import com.example.apidoctruyen.repository.DanhGiaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class DanhGiaController {
    @Autowired
    DanhGiaRepository repo;
    @GetMapping("/truyen/gettbdanhgia/{id}")
    public Double getTruyenById(@PathVariable int id) {
        Double danhgia = repo.getAverageRatingByTruyenId(id);
        return danhgia;
    }
    // cap nhat so sao theo idchapter va idtaikhoan trong bảng danhgia
//    @PutMapping ("/danhgia/{idchapter}/{idtaikhoan}/{sosao}")
//    public void updateDanhGia(@PathVariable Integer idchapter, @PathVariable Integer idtaikhoan, @PathVariable Integer sosao){
//        repo.updateDanhGia(idchapter, idtaikhoan, sosao);
//    }

    @PutMapping ("/danhgia/{idchapter}/{idtaikhoan}/{sosao}")
    public void updateDanhGia(@PathVariable Integer idchapter, @PathVariable Integer idtaikhoan, @PathVariable Double sosao){
        Danhgia danhgia = repo.findByIdchapterAndIdtaikhoan(idchapter, idtaikhoan);
        if (danhgia != null) {
            danhgia.setSosao(sosao);
            repo.save(danhgia);
        }
    }
}
