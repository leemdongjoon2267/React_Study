package com.lec.spring.controller;

import com.lec.spring.domain.Post;
import com.lec.spring.domain.Write;
import com.lec.spring.service.BoardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/board")
public class WriteController {

    @Autowired
    private BoardService boardService;

    @PostMapping("/write")
    @CrossOrigin
    public Post createPost(@RequestBody Write write) {
        return boardService.createPost(write);
    }
}
