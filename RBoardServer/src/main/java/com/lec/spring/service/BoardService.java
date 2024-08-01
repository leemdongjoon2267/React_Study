package com.lec.spring.service;

import com.lec.spring.domain.Post;
import com.lec.spring.domain.Write;

import java.util.List;
import java.util.Optional;

public interface BoardService {
    // 글 목록 조회
    List<Post> getAllPosts();

    // 특정 id의 글 조회 (조회수 증가 포함)
    Post detail(Long id);

    // 특정 id의 글 조회 (조회수 증가 없음)
    Optional<Post> getPostById(Long id);

    // 글 작성
    Post createPost(Write write);

    // 특정 id의 글 수정
    Post updatePost(Long id, Write write);

    // 특정 id의 글 삭제
    boolean deletePost(Long id);

}
