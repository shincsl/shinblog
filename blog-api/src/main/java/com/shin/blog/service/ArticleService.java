package com.shin.blog.service;

import com.shin.blog.vo.Result;
import com.shin.blog.vo.params.ArticleParam;
import com.shin.blog.vo.params.PageParams;

public interface ArticleService {
    /**
     * 分页查询文章列表
     *
     * @param pageParams
     * @return
     */
    Result listArticle(PageParams pageParams);

    /**
     * 查看文章详情
     *
     * @param articleId
     * @return
     */
    Result findArticleById(String articleId);

    /**
     * 发布文章
     *
     * @param articleParam
     * @return
     */
    Result publish(ArticleParam articleParam);

    Result searchArticle(String keyword, int page, int pageSize) throws Exception;

    Result findArticleByUserId(Long userId);
}
