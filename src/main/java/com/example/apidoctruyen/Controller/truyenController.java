package com.example.apidoctruyen.Controller;

import com.example.apidoctruyen.entity.Truyen;
import com.example.apidoctruyen.repository.truyenRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController

public class truyenController {
    @Autowired
    truyenRepository repo;
    @GetMapping("/truyen")
    public List<Truyen> getAllTruyen(){
        List<Truyen> listTruyen = repo.findAll();
        return listTruyen;
    }


}
