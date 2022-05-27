package com.shin.blog.service;

import com.alibaba.fastjson.JSON;
import com.rabbitmq.client.Channel;
import com.shin.blog.vo.constants.MqConstants;
import com.shin.blog.jooq.model.entity.ScArticle;
import com.shin.blog.jooq.model.generated.tables.daos.ScArticleDao;
import com.shin.blog.service.impl.ArticleCopy;
import org.elasticsearch.action.index.IndexRequest;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.xcontent.XContentType;
import org.jooq.DSLContext;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.core.MessageProperties;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
public class ArticleListener {

    @Autowired
    RestHighLevelClient restHighLevelClient;

    @Autowired
    ArticleCopy articleCopy;

    @Autowired
    DSLContext dslContext;

    /**
     * 监听文章新增或修改的业务
     */
    @RabbitListener(queues = MqConstants.INSERT_QUEUE)
    public void listenArticleInsertOrUpdate(String articleId, Channel channel, Message message) {
        try {
            ScArticleDao articleDao = new ScArticleDao(dslContext.configuration());
            ScArticle article = articleDao.fetchOneById(articleId);
            if (article == null) {
                return;
            }
            ScArticle articleVo = articleCopy.copy(article, true, true, true, true);
            // 插入到es中
            IndexRequest request = new IndexRequest("articles");
            request.id(articleVo.getId());
            request.source(JSON.toJSONString(articleVo), XContentType.JSON);
            restHighLevelClient.index(request, RequestOptions.DEFAULT);
            //手动ack
            MessageProperties properties = message.getMessageProperties();
            long deliveryTag = properties.getDeliveryTag();
            channel.basicAck(deliveryTag, false);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 监听文章删除的业务
     */
//    @RabbitListener(queues = MqConstants.DELETE_QUEUE)
//    public void listenArticleDelete(Long articleId) {
//        try {
//            Article article = articleMapper.selectById(articleId);
//            if (article == null) {
//                System.out.println("文章id不存在");
//                return;
//            }
//            // 插入到es中
//            DeleteRequest request = new DeleteRequest("articles", String.valueOf(article.getId()));
//            restHighLevelClient.delete(request, RequestOptions.DEFAULT);
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//    }

}
