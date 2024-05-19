package com.example.apidoctruyen.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class NoiDungChapterDto {
    private Integer id;
    private Integer idchapter;
    private String linkanh;
}
