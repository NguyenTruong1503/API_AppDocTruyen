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

    // updateDanhGia
    @Query("UPDATE Danhgia d SET d.sosao = :sosao WHERE d.idchapter.id = :idchapter AND d.idtaikhoan.id = :idtaikhoan")
    void updateDanhGia(Integer idchapter, Integer idtaikhoan, Integer sosao);

    @Query("SELECT d FROM Danhgia d WHERE d.idchapter.id = :idchapter AND d.idtaikhoan.id = :idtaikhoan")
    Danhgia findByIdchapterAndIdtaikhoan(Integer idchapter, Integer idtaikhoan);

}
