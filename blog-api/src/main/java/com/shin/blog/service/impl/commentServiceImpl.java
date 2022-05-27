package com.shin.blog.service.impl;

import com.shin.blog.jooq.model.entity.ScComment;
import com.shin.blog.jooq.model.entity.ScSysUser;
import com.shin.blog.jooq.model.generated.Tables;
import com.shin.blog.jooq.model.generated.tables.TScComment;
import com.shin.blog.jooq.model.generated.tables.records.ScCommentRecord;
import com.shin.blog.service.CommentService;
import com.shin.blog.service.SysUserService;
import com.shin.blog.utils.UUIDUtil;
import com.shin.blog.utils.UserThreadLocal;
import com.shin.blog.vo.Result;
import com.shin.blog.vo.params.CommentParam;
import org.jooq.DSLContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

@Service
public class commentServiceImpl implements CommentService {

    @Autowired
    SysUserService sysUserService;

    @Autowired
    DSLContext dslContext;

    @Override
    public Result commentByArticleId(String id) {
        TScComment comment = Tables.SC_COMMENT;
        List<ScComment> comments = dslContext.selectFrom(comment).where(comment.ARTICLE_ID.eq(id).and(comment.LEVEL.eq(1))).orderBy(comment.CREATE_TIME.desc()).fetchInto(ScComment.class);
        List<ScComment> commentList = copyList(comments);
        return Result.success(commentList);
    }

    @Override
    public Result comment(CommentParam commentParam) {
        ScSysUser sysUser = UserThreadLocal.get();
        TScComment comment = Tables.SC_COMMENT;
        ScCommentRecord commentRecord = dslContext.newRecord(comment);
        commentRecord.set(comment.ID, UUIDUtil.creatUUID());
        commentRecord.set(comment.ARTICLE_ID, commentParam.getArticleId());
        commentRecord.set(comment.AUTHOR_ID, sysUser.getId());
        commentRecord.set(comment.CONTENT, commentParam.getContent());
        commentRecord.set(comment.CREATE_TIME, new Timestamp(System.currentTimeMillis()));
        String parent = commentParam.getParent();
        if (parent == "" || parent == null) {
            commentRecord.set(comment.LEVEL, 1);
        } else {
            commentRecord.set(comment.LEVEL, 2);
        }
        commentRecord.set(comment.PARENT_ID, (parent == "" || parent == null) ? "" : parent);
        Long toUserId = commentParam.getToUserId();
        commentRecord.set(comment.TO_UID, toUserId == null ? 0 : toUserId);
        commentRecord.insert();
        return Result.success(null);
    }

    private List<ScComment> copyList(List<ScComment> comments) {
        List<ScComment> commentList = new ArrayList<>();
        for (ScComment comment : comments) {
            commentList.add(copy(comment));
        }
        return commentList;
    }

    private ScComment copy(ScComment comment) {

        Long authorId = comment.getAuthorId();
        ScSysUser userVo = sysUserService.findUserVoById(authorId);
        comment.setAuthor(userVo);
        //子评论
        Integer level = comment.getLevel();
        if (1 == level) {
            String id = comment.getId();
            List<ScComment> commentList = findCommentByParentId(id);
            comment.setChildrens(commentList);
        }
        if (level > 1) {
            Long toUid = comment.getToUid();
            ScSysUser toUserVo = sysUserService.findUserVoById(toUid);
            comment.setToUser(toUserVo);
        }
        return comment;
    }

    private List<ScComment> findCommentByParentId(String id) {
        TScComment comment = Tables.SC_COMMENT;
        List<ScComment> commentList = dslContext.selectFrom(comment).where(comment.PARENT_ID.eq(id).and(comment.LEVEL.eq(2))).fetchInto(ScComment.class);
        return copyList(commentList);
    }
}
