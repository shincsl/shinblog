package com.shin.blog.service;

import com.shin.blog.jooq.model.entity.ScTag;
import com.shin.blog.vo.Result;

import java.util.List;

public interface TagService {

    List<ScTag> findTagsByArticleId(String articleId);

    Result hots(int limit);

    /**
     * 查询所有文章标签
     * @return
     */
    Result findAll();

    Result findAllDetail();

    Result findAllDetailById(String id);
}
