package com.example.third_seminar.controller;

import com.example.third_seminar.request.PostCreateRequest;
import com.example.third_seminar.request.PostUpdateRequest;
import com.example.third_seminar.response.PostGetResponse;
import com.example.third_seminar.service.PostService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/api/posts")
@RequiredArgsConstructor
public class PostController {
    private static final String CUSTOM_AUTH_ID = "X-Auth-Id";

    private final PostService postService;

    @GetMapping("{postId}")
    public ResponseEntity<PostGetResponse> getPostById(@PathVariable Long postId) {
        return ResponseEntity.ok(postService.getById(postId));
    }

    @GetMapping
    public ResponseEntity<List<PostGetResponse>> getPosts(@RequestHeader(CUSTOM_AUTH_ID) Long memberId) {
        return ResponseEntity.ok(postService.getPosts(memberId));
    }

    @PostMapping
    public ResponseEntity<Void> createPost(@RequestHeader(CUSTOM_AUTH_ID) Long memberId, @RequestBody PostCreateRequest request) {
        URI location = URI.create("/api/post/" + postService.create(request, memberId));
        return ResponseEntity.created(location).build();
    }

    @PatchMapping("{postId}")
    public ResponseEntity<Void> updatePost(@PathVariable Long postId, @RequestBody PostUpdateRequest request) {
        postService.editContent(postId, request);
        return ResponseEntity.noContent().build();
        // "204 No Content" 요청이 성공했지만 응답 본문이 없음
    }

    @DeleteMapping("{postId}")
    public ResponseEntity<Void> deletePost(@PathVariable Long postId) {
        postService.deleteById(postId);
        return ResponseEntity.noContent().build();
    }
}