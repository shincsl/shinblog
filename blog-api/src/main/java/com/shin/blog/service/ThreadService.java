package com.shin.blog.service;

import com.shin.blog.vo.constants.MqConstants;
import com.shin.blog.jooq.model.entity.ScArticle;
import com.shin.blog.jooq.model.generated.Tables;
import com.shin.blog.jooq.model.generated.tables.TScArticle;
import org.elasticsearch.client.RestHighLevelClient;
import org.jooq.DSLContext;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

@Component
public class ThreadService {

    @Autowired
    RestHighLevelClient restHighLevelClient;

    @Autowired
    RabbitTemplate rabbitTemplate;

    @Async("taskExecutor")
    public void updateArticleViewCount(DSLContext dslContext, ScArticle article) {
        int oldViewCounts = article.getViewCounts();
        int viewCounts = oldViewCounts + 1;
        TScArticle articleUpdate = Tables.SC_ARTICLE;
        dslContext.update(articleUpdate)
                .set(articleUpdate.VIEW_COUNTS,viewCounts)
                .where(articleUpdate.ID.eq(article.getId()))
                .and(articleUpdate.VIEW_COUNTS.eq(oldViewCounts))
                .execute();

        // 发送消息
        rabbitTemplate.convertAndSend(MqConstants.EXCHANGE_NAME, MqConstants.INSERT_ROUTING_KEY, article.getId());
        try {
            Thread.sleep(2000);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
