package com.shin.blog.service;

import com.shin.blog.vo.CategoryVo;
import com.shin.blog.vo.Result;

public interface CategoryService {

    CategoryVo findCategoryById(Long categoryId);

    Result findAll();

    Result findAllDetail();

    Result findAllDetailById(Long id);
}
