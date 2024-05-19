package com.example.apidoctruyen.repository;

import com.example.apidoctruyen.entity.Chapter;
import com.example.apidoctruyen.model.ChapterDto;
import com.example.apidoctruyen.model.NoiDungChapterDto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ChapterRepository extends JpaRepository<Chapter,Integer> {
    @Query("SELECT NEW com.example.apidoctruyen.model.ChapterDto (c.id,c.idtruyen.id, c.tenchapter, c.ngaydang, c.soluotxem, c.danhgia)\n" +
            "FROM Chapter c\n" +
            "WHERE c.idtruyen.id = :id")
    List<ChapterDto> getChapterById(int id);


    @Query("SELECT NEW com.example.apidoctruyen.model.ChapterDto (c.id,c.idtruyen.id, c.tenchapter, c.ngaydang, c.soluotxem, c.danhgia)\n" +
            "FROM Chapter c\n" +
            "WHERE c.id = :id")
    List<ChapterDto> getChapterContentById(int id);

    //select * from noidungchapter where idchapter="+id
    @Query("SELECT NEW com.example.apidoctruyen.model.NoiDungChapterDto (c.id,c.idchapter.id,c.linkanh)\n" +
            "FROM Noidungchapter c\n" +
            "WHERE c.idchapter.id = :id")
    List<NoiDungChapterDto> getLinkChapterById(int id);

}
