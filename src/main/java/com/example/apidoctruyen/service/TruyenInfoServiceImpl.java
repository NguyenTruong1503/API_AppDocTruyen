package com.example.apidoctruyen.service;

import com.example.apidoctruyen.model.TruyenInfo;
import com.example.apidoctruyen.repository.TruyenRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class TruyenInfoServiceImpl implements TruyenInfoService{
    @Autowired
    private TruyenRepository truyenRepository;

    @Override
    public List<TruyenInfo> getNewestBooks() {
        return truyenRepository.findNewestBooks();
    }
}
