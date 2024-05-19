package com.example.apidoctruyen.Controller;

import com.example.apidoctruyen.entity.Taikhoan;
import com.example.apidoctruyen.model.TaiKhoanDto;
import com.example.apidoctruyen.repository.TaiKhoanRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
public class TaiKhoanController {
    @Autowired
    TaiKhoanRepository taiKhoanRepository;



    @GetMapping("/taikhoan/{email}")
    public Optional<TaiKhoanDto> findByEmail(@PathVariable String email){
        return taiKhoanRepository.findByEmail(email);
    }
}