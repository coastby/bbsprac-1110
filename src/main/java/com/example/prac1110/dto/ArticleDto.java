package com.example.prac1110.dto;


import com.example.prac1110.entity.Article2;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
@AllArgsConstructor
public class ArticleDto {
    private Long id;
    private String title;
    private String content;

    public ArticleDto(String title, String content) {
        this.title = title;
        this.content = content;
    }

    public Article2 toEntity(){
        return new Article2(this.id, this.title, this.content);
    }
}
