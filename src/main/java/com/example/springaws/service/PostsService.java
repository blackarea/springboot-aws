package com.example.springaws.service;

import com.example.springaws.domain.dto.PostsListResponseDto;
import com.example.springaws.domain.dto.PostsResponseDto;
import com.example.springaws.domain.dto.PostsSaveRequestDto;
import com.example.springaws.domain.dto.PostsUpdateRequestDto;

import java.util.List;

public interface PostsService {
    public Long save(PostsSaveRequestDto requestDto);
    public Long update(Long id, PostsUpdateRequestDto requestDto);
    public void delete(Long id);
    public PostsResponseDto findById(Long id);
    public List<PostsListResponseDto> findAllDesc();
}
