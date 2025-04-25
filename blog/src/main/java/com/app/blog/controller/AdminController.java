package com.app.blog.controller;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.app.blog.entity.Post;
import com.app.blog.repository.PostRepository;

@Controller
@RequestMapping("/admin")
public class AdminController {

    @Autowired
    private PostRepository postRepository;

    @GetMapping
    public String admin(Model model) {

        model.addAttribute("posts", postRepository.findAll());

        return "admin";

    }

    @PostMapping("/posts")
    public String post(@ModelAttribute Post post) {

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        String dataFormatada = LocalDateTime.now().format(formatter);  // Formata a data de agora
    
        Post post2 = new Post();

        post2.setTitulo(post.getTitulo());

        post2.setConteudo(post.getConteudo());

        post2.setDataFormat(dataFormatada); 
    

        postRepository.save(post2);
    
        return "redirect:/admin";

    }

    @GetMapping("posts/deletar/{id}")
    public String deletarPost(@PathVariable Long id) {

        postRepository.deleteById(id);

        return "redirect:/admin";
    }
    
}
