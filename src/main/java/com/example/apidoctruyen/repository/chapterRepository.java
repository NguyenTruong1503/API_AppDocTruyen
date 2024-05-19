package com.example.apidoctruyen.repository;

import com.example.apidoctruyen.entity.Chapter;
import com.example.apidoctruyen.model.ChapterModel;
import com.example.apidoctruyen.entity.Lichsudoctruyen;
import com.example.apidoctruyen.model.TruyenDto;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface chapterRepository extends JpaRepository<Chapter, Integer> {

    @Query("SELECT NEW com.example.apidoctruyen.model.ChapterModel(c.id, c.idtruyen.id, c.soluotxem,c.danhgia,c.tenchapter,c.ngaydang)\n" +
            "FROM Chapter c\n" +
            "WHERE c.id=:idchapter")
    List<ChapterModel> getOneChapter(int idchapter);
    @Query("SELECT NEW com.example.apidoctruyen.model.ChapterModel (c.id, c.idtruyen.id, c.soluotxem,c.danhgia,c.tenchapter,c.ngaydang)\n" +
            "FROM Chapter c\n" +
            "WHERE c.idtruyen.id = :id")
    List<ChapterModel> getChapterById(int id);

    @Query("SELECT c.tenchapter\n" +
            "FROM Chapter c\n" +
            "JOIN c.idtruyen t\n" +
            "WHERE t.id = :idtruyen\n" +
            "ORDER BY c.id desc limit 1 ")
    String getTenChapterNew(int idtruyen);

    @Query("SELECT c.idtruyen.id\n" +
            "FROM Chapter c\n" +
            "WHERE c.id = :id")
    int getIdTruyenByIdChapter(int id);
}
