package com.example.apidoctruyen.Controller;

import com.example.apidoctruyen.entity.Taikhoan;
import com.example.apidoctruyen.model.TaiKhoanDto;
import com.example.apidoctruyen.repository.TaiKhoanRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class TaiKhoanController {
    @Autowired
    TaiKhoanRepository taiKhoanRepository;

    @GetMapping("/taikhoan/{email}")
    public Optional<TaiKhoanDto> findByEmail(@PathVariable String email){
        return taiKhoanRepository.findByEmail(email);
    }

    @GetMapping("/taikhoan")
    public List<TaiKhoanDto> findByLoaiTk(){
        return taiKhoanRepository.findByLoaiTk();
    }

    // lay taikhoan theo email
    @GetMapping("/timtaikhoan/{email}")
    public List<TaiKhoanDto> getTaiKhoanByEmail(@PathVariable String email) {
        return taiKhoanRepository.getByEmail(email);
    }

    // cap nhat loaitk kiểu int theo id
    @PutMapping ("/taikhoan/{id}/{loaitk}")
    public Taikhoan updateLoaiTk(@PathVariable Integer id, @PathVariable Integer loaitk){
        Taikhoan taikhoan = taiKhoanRepository.findById(id).orElse(null);
        if (taikhoan == null) {
            return null;
        }
        taikhoan.setLoaitk(loaitk);
        return taiKhoanRepository.save(taikhoan);
    }

    //@PostMapping("/truyen")
    //    public Truyen addTruyen(@RequestBody Truyen truyen) {
    //        return repo.save(truyen);
    //    }
    @PostMapping("/taikhoan")
    public Taikhoan addTaiKhoan(@RequestBody Taikhoan taikhoan) {
        return taiKhoanRepository.save(taikhoan);
    }
}
