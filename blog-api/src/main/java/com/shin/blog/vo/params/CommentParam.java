package com.shin.blog.vo.params;

import lombok.Data;

@Data
public class CommentParam {

    private String articleId;

    private String content;

    private String parent;

    private Long toUserId;
}
