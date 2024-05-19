package com.example.apidoctruyen.repository;

import com.example.apidoctruyen.entity.Binhluan;
import com.example.apidoctruyen.entity.Chapter;
import com.example.apidoctruyen.model.ChapterDto;
import com.example.apidoctruyen.model.TruyenDto;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ChapterRepository extends JpaRepository<Chapter, Integer> {
    @Query("SELECT SUM(c.soluotxem) FROM Chapter c WHERE c.idtruyen.id = :idtruyen")
    Long sumSoluotxemByTruyenId(int idtruyen);
    @Query("SELECT NEW com.example.apidoctruyen.model.ChapterDto (t.id, t.idtruyen.id, t.tenchapter, t.ngaydang, t.soluotxem, t.danhgia)\n" +
            "FROM Chapter t\n" +
            " where t.idtruyen.id = :id" )
    List<ChapterDto> getChapterByIdTruyen(int id);
    @Query("SELECT NEW com.example.apidoctruyen.model.ChapterDto (t.id, t.idtruyen.id, t.tenchapter, t.ngaydang, t.soluotxem, t.danhgia)\n FROM Chapter t WHERE t.id = :id")
    List<ChapterDto> findTenById(int id);

    @Query("select c.id from Chapter c where c.idtruyen.id=:id and c.tenchapter='Chapter 1'")

    int getMinIdChapter(int id);
    @Query("select c.id from Chapter c where c.idtruyen.id=:id order by c.id desc limit 1")

    int getMaxIdChapter(int id);


}
