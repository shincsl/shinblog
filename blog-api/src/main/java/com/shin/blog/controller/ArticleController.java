package com.shin.blog.controller;

import com.shin.blog.common.aop.LogAnnotation;
import com.shin.blog.common.cache.Cache;
import com.shin.blog.service.ArticleService;
import com.shin.blog.vo.Result;
import com.shin.blog.vo.params.ArticleParam;
import com.shin.blog.vo.params.PageParams;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CachePut;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;

@RestController
@CacheConfig(cacheNames = "articles")
@RequestMapping("articles")
public class ArticleController {

    @Autowired
    ArticleService articleService;

    /**
     * 首页 文章列表
     *
     * @param pageParams
     * @return
     */
    @PostMapping
    //加上此注解 代表要对此接口记录日志
    @LogAnnotation(module = "文章", operator = "获取文章列表")
//    @Cache(expire = 5 * 60 * 1000, name = "listArticle")
    @CachePut(key = "#root.methodName + #pageParams.toString()")
    public Result listArticle(@RequestBody PageParams pageParams) throws IOException {
        return articleService.listArticle(pageParams);
    }

    @PostMapping("view/{id}")
    public Result findArticleById(@PathVariable("id") Long articleId) {
        return articleService.findArticleById(articleId);
    }

    @PostMapping("publish")
    public Result publish(@RequestBody ArticleParam articleParam) {
        return articleService.publish(articleParam);
    }

    @PostMapping("search/{keyword}/{page}/{pageSize}")
    public Result searchArticle(@PathVariable("keyword") String keyword,@PathVariable("page") int page,@PathVariable("pageSize") int pageSize) throws Exception{
        return articleService.searchArticle(keyword,page,pageSize);
    }

    @PostMapping("findArticle/{userId}")
    public Result findArticleByUserId(@PathVariable("userId") Long userId) {
        return articleService.findArticleByUserId(userId);
    }
}
