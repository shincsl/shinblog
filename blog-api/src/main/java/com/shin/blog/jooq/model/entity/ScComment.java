package com.shin.blog.jooq.model.entity;


import com.shin.blog.jooq.model.generated.tables.pojos.ScCommentPojo;
import lombok.Data;

import java.util.List;

@Data
public class ScComment extends ScCommentPojo {
    private ScSysUser author;

    private List<ScComment> childrens;

    private ScSysUser toUser;
}