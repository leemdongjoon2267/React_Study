package com.lec.spring.controller;


import com.lec.spring.domain.Post;
import com.lec.spring.domain.Write;
import com.lec.spring.service.BoardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/board")
public class BoardController {

    @Autowired
    private BoardService boardService;

    @GetMapping("/list")
    @CrossOrigin
    public List<Post> getAllPosts() {
        return boardService.getAllPosts();
    }



    // 게시글 상세 조회
    @GetMapping("/detail/{id}")
    @CrossOrigin
    public Post getPostDetail(@PathVariable Long id) {
        return boardService.detail(id); // 조회수 증가와 상세정보 반환
    }

    @PutMapping("/update")
    @CrossOrigin
    public Post updatePost(@RequestBody Write write) {
        return boardService.updatePost(write.getId(), write);
    }

    @DeleteMapping("/delete/{id}")
    @CrossOrigin
    public int deletePost(@PathVariable Long id) {
        return boardService.deletePost(id) ? 1 : 0;
    }
}