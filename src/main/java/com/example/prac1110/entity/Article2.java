package com.example.prac1110.entity;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Getter
public class Article2 {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NonNull
    private String title;
    private String content;

    public Article2(@NonNull String title, String content) {
        this.title = title;
        this.content = content;
    }
}
