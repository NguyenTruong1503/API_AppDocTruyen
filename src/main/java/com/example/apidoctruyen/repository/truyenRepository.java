package com.example.apidoctruyen.repository;

import com.example.apidoctruyen.entity.Truyen;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface truyenRepository extends JpaRepository<Truyen, Integer> {
    @Query(value = "SELECT TOP 4 truyen.*, chapter.id AS chapter_id, chapter.idtruyen AS chapter_idtruyen, chapter.tenchapter AS chapter_tenchapter, chapter.ngaydang AS chapter_ngaydang " +
            "FROM truyen " +
            "INNER JOIN chapter ON truyen.id = chapter.idtruyen " +
            "WHERE chapter.tenchapter = 'Chapter 1' " +
            "ORDER BY chapter.ngaydang DESC",
            nativeQuery = true)
    List<Truyen> getTruyenMoi();

    @Query(value = "SELECT * FROM truyen WHERE id IN (" +
            "SELECT id FROM (" +
            "SELECT truyen.id, ROW_NUMBER() OVER (ORDER BY thongke.tongluotxem DESC) AS rn " +
            "FROM truyen " +
            "INNER JOIN thongke ON truyen.id = thongke.idtruyen " +
            ") AS subquery WHERE rn <= 5" +
            ")", nativeQuery = true)
    List<Truyen> getTopTruyen();

}
