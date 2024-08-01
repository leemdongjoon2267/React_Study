package com.lec.spring.service;

import com.lec.spring.domain.Post;
import com.lec.spring.domain.Write;
import com.lec.spring.reposiptory.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class BoardServiceImpl implements BoardService {

    @Autowired
    private PostRepository postRepository;

    @Override
    public List<Post> getAllPosts() {
        return postRepository.findAll();
    }

    @Override
    public Optional<Post> getPostById(Long id) {
        return postRepository.findById(id);
    }

    @Override
    @Transactional
    public Post detail(Long id) {
        Post post = postRepository.findById(id).orElseThrow(() -> new RuntimeException("Post not found with id " + id));
        post.setViewCnt(post.getViewCnt() == null ? 1L : post.getViewCnt() + 1);
        return postRepository.save(post);
    }

    @Override
    public Post createPost(Write write) {
        Post post = new Post();
        post.setUser(write.getUser());
        post.setSubject(write.getSubject());
        post.setContent(write.getContent());
        post.setRegDate(LocalDateTime.now());
        post.setViewCnt(0L);
        return postRepository.save(post);
    }

    @Override
    public Post updatePost(Long id, Write write) {
        Post post = postRepository.findById(id).orElseThrow(() -> new RuntimeException("Post not found with id " + id));
        post.setSubject(write.getSubject());
        post.setContent(write.getContent());
        return postRepository.save(post);
    }

    @Override
    public boolean deletePost(Long id) {
        if (postRepository.existsById(id)) {
            postRepository.deleteById(id);
            return true;
        }
        return false;
    }
}
