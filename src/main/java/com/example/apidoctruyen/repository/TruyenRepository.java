package com.example.apidoctruyen.repository;

import com.example.apidoctruyen.entity.Truyen;
import com.example.apidoctruyen.model.TruyenInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface TruyenRepository extends JpaRepository<Truyen, Integer> {
    @Query(value = "SELECT DISTINCT t.theloai FROM Truyen t")
    List<String> findAllTheLoai();

    @Query("SELECT NEW com.example.apidoctruyen.model.TruyenInfo(t.id, tk.tongluotxem, tk.sosaotb, t.tentruyen, c.ngaydang, t.theloai, t.linkanh)\n" +
            "FROM Truyen t\n" +
            "JOIN t.chapters c\n" +
            "JOIN t.thongkes tk\n" +
            "WHERE c.tenchapter = 'Chapter 1'\n" +
            "ORDER BY c.ngaydang DESC")
    List<TruyenInfo> findNewestBooks();

}
