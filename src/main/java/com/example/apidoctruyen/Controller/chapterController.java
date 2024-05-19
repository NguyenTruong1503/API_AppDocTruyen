package com.example.apidoctruyen.Controller;

import com.example.apidoctruyen.model.ChapterModel;
import com.example.apidoctruyen.model.TruyenDto;
import com.example.apidoctruyen.repository.chapterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

@RestController
public class chapterController {

    @Autowired
    chapterRepository chapterRepository;

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

}
