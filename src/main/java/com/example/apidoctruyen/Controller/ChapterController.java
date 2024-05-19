package com.example.apidoctruyen.Controller;

import com.example.apidoctruyen.entity.Chapter;
import com.example.apidoctruyen.model.ChapterDto;
import com.example.apidoctruyen.model.ChapterModel;
import com.example.apidoctruyen.repository.ChapterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class ChapterController {

    @Autowired
    ChapterRepository chapterRepository;

    @GetMapping("/truyen/chapter/getone/{idchapter}")
    public List<ChapterModel> getOneChapter(@PathVariable int idchapter) {
        List<ChapterModel> listChapter = chapterRepository.getOneChapter(idchapter);
        return listChapter;
    }
    @GetMapping("/truyen/chapter/tenchapter/{idtruyen}")
    public String getTenChapterNew(@PathVariable int idtruyen) {
        String tenChapter = chapterRepository.getTenChapterNew(idtruyen);
        return tenChapter;
    }
    @GetMapping("/truyen/chapter/{id}")
    public List<ChapterModel> getChapterById(@PathVariable Integer id) {
        //Truyen truyen = repo.findById(id);
        List<ChapterModel> list = chapterRepository.getChapterById(id);
        return list;
    }

    @GetMapping("/truyen/chapter/getidtruyen/{id}")
    public int getIdTruyenByIdChapter(@PathVariable Integer id) {
        int idtruyen = chapterRepository.getIdTruyenByIdChapter(id);
        return idtruyen;
    }
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
