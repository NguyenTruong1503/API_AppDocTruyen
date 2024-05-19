package com.example.apidoctruyen.Controller;

import com.example.apidoctruyen.entity.Chapter;
import com.example.apidoctruyen.model.BinhLuanTruyenDto;
import com.example.apidoctruyen.model.ChapterDto;
import com.example.apidoctruyen.repository.BinhLuanRepository;
import com.example.apidoctruyen.repository.ChapterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
public class ChapterController {
    @Autowired
    ChapterRepository repo;
    @GetMapping("/truyen/gettongluotxem/{id}")
    public Long getBinhLuan(@PathVariable int id) {
        return repo.sumSoluotxemByTruyenId(id);
    }
    @GetMapping("/truyen/getchapterbyidtruyen/{id}")
    public List<ChapterDto> getChapterByIdTruyen(@PathVariable int id){
        return repo.getChapterByIdTruyen(id);
    }
    @GetMapping("/truyen/gettenchapter/{id}")
    public List<ChapterDto> findTenById(@PathVariable int id) {
        return repo.findTenById(id);
    }
    @PutMapping("/updateLuotXem/{id}")
    public Chapter updateLuotXemChapter(@PathVariable int id) {
        Optional<Chapter> optionalChapter = repo.findById(id);
        Chapter chapter = optionalChapter.get();
        chapter.setSoluotxem(chapter.getSoluotxem() + 1);
        return repo.save(chapter);
    }
    @GetMapping("/truyen/getminidchapter/{id}")
    public int getMinIdChapter(@PathVariable int id) {
        return repo.getMinIdChapter(id);
    }
    @GetMapping("/truyen/getmaxidchapter/{id}")
    public int getMaxIdChapter(@PathVariable int id) {
        return repo.getMaxIdChapter(id);
    }

}
