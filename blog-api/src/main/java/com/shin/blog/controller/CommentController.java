package com.shin.blog.controller;

import com.shin.blog.service.CommentService;
import com.shin.blog.vo.Result;
import com.shin.blog.vo.params.CommentParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("comments")
public class CommentController {

    @Autowired
    CommentService commentService;

    @GetMapping("article/{id}")
    public Result comments(@PathVariable("id") Long id){
        return commentService.commentByArticleId(id);
    }

    @PostMapping("create/change")
    public Result comment(@RequestBody CommentParam commentParam){
        return commentService.comment(commentParam);
    }
}
