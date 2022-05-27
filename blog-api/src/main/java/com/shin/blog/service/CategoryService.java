package com.shin.blog.service;

import com.shin.blog.jooq.model.entity.ScCategory;
import com.shin.blog.vo.Result;

public interface CategoryService {

    ScCategory findCategoryById(String categoryId);

    Result findAll();

    Result findAllDetail();

    Result findAllDetailById(String id);
}
