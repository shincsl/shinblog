package com.shin.blog.vo.params;

import com.shin.blog.jooq.model.entity.ScCategory;
import com.shin.blog.jooq.model.entity.ScTag;
import lombok.Data;

import java.util.List;

@Data
public class ArticleParam {

    private String id;

    private ArticleBodyParam body;

    private ScCategory category;

    private String summary;

    private List<ScTag> tags;

    private String title;
}
