package com.example.prac1110.controller;

import com.example.prac1110.dto.ArticleDto;
import com.example.prac1110.entity.Article2;
import com.example.prac1110.repository.ArticleRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/articles")
@Slf4j
public class ArticleController {
    ArticleRepository articleRepository;

    public ArticleController(ArticleRepository articleRepository) {
        this.articleRepository = articleRepository;
    }

    @GetMapping(value = "/new")
    public String toForm(){
        return "articles/new";
    }
    @PostMapping(value = "/posts")
    public String createArticle(ArticleDto articleDto){
        log.info(articleDto.toString());
        Article2 saved = articleRepository.save(articleDto.toEntity());
        log.info("id : {}가 저장되었습니다.", saved.getId());
        return "articles/new";
    }
    @GetMapping(value = "/{id}")
    public String showArticle(@PathVariable Long id, Model model){
        Optional<Article2> article2Optional = articleRepository.findById(id);
        if(!article2Optional.isEmpty()){
            model.addAttribute("article", article2Optional.get());
        } else {
            model.addAttribute("id", id);
            return "articles/error";
        }
        return "articles/show";
    }
    @GetMapping(value = "/list")
    public String showList(Model model){
        List<Article2> articles = articleRepository.findAll();
        model.addAttribute("articles", articles);
        return "articles/list";
    }
    @GetMapping(value = "/{id}/edit")
    public String toEdit(@PathVariable Long id, Model model){
        Optional<Article2> article2Optional = articleRepository.findById(id);
        if(!article2Optional.isEmpty()){
            model.addAttribute("article", article2Optional.get());
        } else {
            model.addAttribute("id", id);
            return "articles/error";
        }
        return "articles/edit";
    }
    @PostMapping(value = "/edit")
    public String editSave(ArticleDto articleDto){
        log.info(articleDto.getTitle());
        Article2 saved = articleRepository.save(articleDto.toEntity());
        log.info("{}, {}", saved.getId(), saved.getTitle());
        return "redirect:/articles/list";
    }
}
