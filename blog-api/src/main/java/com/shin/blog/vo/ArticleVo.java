package com.shin.blog.vo;

import lombok.Data;

import java.util.List;

@Data
public class ArticleVo {

//    @JsonSerialize(using = ToStringSerializer.class)
    private String id;

    private String title;

    private String summary;

    private Integer commentCounts;

    private Integer viewCounts;

    private Integer weight;
    /**
     * 创建时间
     */
    private String createTime;
    /**
     * 更新时间
     */
    private String updateTime;

    private String author;

    private String avatar;

    private ArticleBodyVo body;

    private List<TagVo> tags;

    private CategoryVo category;

}
