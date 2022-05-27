package com.shin.blog.service.impl;

import com.shin.blog.jooq.model.entity.ScCategory;
import com.shin.blog.jooq.model.generated.Tables;
import com.shin.blog.jooq.model.generated.tables.TScCategory;
import com.shin.blog.jooq.model.generated.tables.daos.ScCategoryDao;
import com.shin.blog.service.CategoryService;
import com.shin.blog.vo.Result;
import org.jooq.DSLContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryServiceImpl implements CategoryService {

    @Autowired
    DSLContext dslContext;

    @Override
    public ScCategory findCategoryById(String categoryId) {
        ScCategoryDao scCategoryDao = new ScCategoryDao(dslContext.configuration());
        ScCategory scCategory = scCategoryDao.fetchOneById(categoryId);
        return scCategory;
    }

    @Override
    public Result findAll() {
        TScCategory category = Tables.SC_CATEGORY;
        List<ScCategory> scCategories = dslContext.select(category.ID, category.CATEGORY_NAME).from(category).fetchInto(ScCategory.class);
        //页面交互的对象
        return Result.success(scCategories);
    }

    @Override
    public Result findAllDetail() {
        List<ScCategory> scCategories = dslContext.select().from(Tables.SC_CATEGORY).fetchInto(ScCategory.class);
        //页面交互的对象
        return Result.success(scCategories);
    }

    @Override
    public Result findAllDetailById(String id) {
        ScCategoryDao scCategoryDao = new ScCategoryDao(dslContext.configuration());
        ScCategory scCategory = scCategoryDao.fetchOneById(id);
        return Result.success(scCategory);
    }


}
