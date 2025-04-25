package com.app.blog.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.app.blog.entity.Post;
import com.app.blog.repository.PostRepository;


@Controller
@RequestMapping("/blog")
public class BlogController {

    @Autowired
    private PostRepository postRepository;

    @GetMapping
    public String blog(Model model) {
        
        List<Post> posts = postRepository.findAll();

        model.addAttribute("posts", posts);

        return "blog";

    }
    
}
