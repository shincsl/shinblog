package com.shin.blog.service;

import com.shin.blog.vo.Result;
import com.shin.blog.vo.params.CommentParam;

public interface CommentService {

    /**
     * 根据文章id查询所有的评论列表
     * @param id
     * @return
     */
    Result commentByArticleId(String id);

    Result comment(CommentParam commentParam);
}
