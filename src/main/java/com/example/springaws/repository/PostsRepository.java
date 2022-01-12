package com.example.springaws.repository;

import com.example.springaws.domain.Posts;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PostsRepository extends JpaRepository<Posts, Long> {

    List<Posts> findAllByOrderByIdDesc();
}
