package com.example.apidoctruyen.repository;

import com.example.apidoctruyen.entity.Binhluan;
import com.example.apidoctruyen.entity.Danhgia;
import com.example.apidoctruyen.model.TruyenDto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface DanhGiaRepository extends JpaRepository<Danhgia, Integer> {
    @Query("SELECT round(avg(d.sosao), 2) FROM Danhgia d WHERE d.idchapter.id IN (SELECT c.id FROM Chapter c WHERE c.idtruyen.id = :idtruyen)")
    Double getAverageRatingByTruyenId(int idtruyen);
}
