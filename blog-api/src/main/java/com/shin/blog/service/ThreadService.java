package com.shin.blog.service;

import com.baomidou.mybatisplus.core.conditions.update.LambdaUpdateWrapper;
import com.shin.blog.constants.MqConstants;
import com.shin.blog.dao.mapper.ArticleMapper;
import com.shin.blog.dao.pojo.Article;
import org.elasticsearch.client.RestHighLevelClient;
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
    public void updateArticleViewCount(ArticleMapper articleMapper, Article article) {
        int oldViewCounts = article.getViewCounts();
        Article articleUpdate = new Article();
        int viewCounts = oldViewCounts + 1;
        articleUpdate.setViewCounts(viewCounts);
        LambdaUpdateWrapper<Article> updateWrapper = new LambdaUpdateWrapper<>();
        updateWrapper.eq(Article::getId, article.getId());
        updateWrapper.eq(Article::getViewCounts, oldViewCounts);
        articleMapper.update(articleUpdate, updateWrapper);

        // 发送消息
        rabbitTemplate.convertAndSend(MqConstants.EXCHANGE_NAME, MqConstants.INSERT_ROUTING_KEY, article.getId());
        try {
            Thread.sleep(2000);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
