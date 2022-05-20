package com.shin.blog.service;

import com.shin.blog.vo.Result;
import com.shin.blog.vo.TagVo;

import java.util.List;

public interface TagService {

    List<TagVo> findTagsByArticleId(Long articleId);

    Result hots(int limit);

    /**
     * 查询所有文章标签
     * @return
     */
    Result findAll();

    Result findAllDetail();

    Result findAllDetailById(Long id);
}
