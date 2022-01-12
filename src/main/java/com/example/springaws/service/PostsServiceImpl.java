package com.example.springaws.service;

import com.example.springaws.domain.Posts;
import com.example.springaws.domain.dto.PostsListResponseDto;
import com.example.springaws.domain.dto.PostsResponseDto;
import com.example.springaws.domain.dto.PostsSaveRequestDto;
import com.example.springaws.domain.dto.PostsUpdateRequestDto;
import com.example.springaws.repository.PostsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PostsServiceImpl implements PostsService{

    @Autowired
    PostsRepository postsRepository;

    @Override
    public Long save(PostsSaveRequestDto requestDto) {
        return postsRepository.save(requestDto.toEntity()).getId();
    }

    @Transactional
    @Override
    public Long update(Long id, PostsUpdateRequestDto requestDto) {
        Posts posts = postsRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("해당 게시글이 없습니다. id = " + id));
        posts.update(requestDto.getTitle(), requestDto.getContent());

        return id;
    }

    @Transactional
    @Override
    public void delete(Long id) {
        Posts posts = postsRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("해당 게시글이 없습니다.id=" + id ));
        postsRepository.delete(posts);
    }

    @Override
    public PostsResponseDto findById(Long id) {
        Posts posts = postsRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("해당 게시글이 없습니다. id = " + id));
        return new PostsResponseDto(posts);
    }

    @Transactional(readOnly = true)
    @Override
    public List<PostsListResponseDto> findAllDesc() {
        return postsRepository.findAllByOrderByIdDesc().stream()
                .map(PostsListResponseDto::new)
                .collect(Collectors.toList());
    }
}
