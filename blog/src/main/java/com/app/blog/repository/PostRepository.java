package com.app.blog.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.app.blog.entity.Post;


public interface PostRepository extends JpaRepository<Post, Long> {
    
}
