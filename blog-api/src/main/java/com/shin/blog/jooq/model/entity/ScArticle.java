package com.shin.blog.jooq.model.entity;


import com.shin.blog.jooq.model.generated.tables.pojos.ScArticlePojo;
import com.shin.blog.vo.ArticleBodyVo;
import lombok.Data;

import java.util.List;

@Data
public class ScArticle extends ScArticlePojo {

    private String author;

    private String avatar;

    private ArticleBodyVo body;

    private List<ScTag> tags;

    private ScCategory category;
}