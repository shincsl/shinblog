package com.shin.blog.vo.params;

import lombok.Data;

@Data
public class PageParams {

    private int page = 1;

    private int pageSize = 10;

    private String categoryId;

    private String tagId;
}
