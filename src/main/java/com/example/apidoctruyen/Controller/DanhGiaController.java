package com.example.apidoctruyen.Controller;

import com.example.apidoctruyen.entity.Chapter;
import com.example.apidoctruyen.entity.Danhgia;
import com.example.apidoctruyen.model.TruyenDto;
import com.example.apidoctruyen.repository.BinhLuanRepository;
import com.example.apidoctruyen.repository.DanhGiaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

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
    @PutMapping("/updatedanhgia/{idchapter}/{idtaikhoan}/{sosao}")
    public ResponseEntity<String> updateDanhGia(
            @PathVariable int idchapter,
            @PathVariable int idtaikhoan,
            @PathVariable double sosao) {

        Optional<Danhgia> optionalDanhGia = repo.findByIdChapterAndIdTaiKhoan(idchapter, idtaikhoan);

        if (optionalDanhGia.isPresent()) {
            Danhgia danhGia = optionalDanhGia.get();
            danhGia.setSosao(sosao);
            repo.save(danhGia);
            return ResponseEntity.ok("Update successful");
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("DanhGia not found");
        }
    }
}
