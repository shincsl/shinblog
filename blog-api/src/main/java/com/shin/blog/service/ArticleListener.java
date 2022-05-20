package com.shin.blog.service;

import com.alibaba.fastjson.JSON;
import com.rabbitmq.client.Channel;
import com.shin.blog.constants.MqConstants;
import com.shin.blog.dao.mapper.ArticleMapper;
import com.shin.blog.dao.pojo.Article;
import com.shin.blog.service.impl.ArticleCopy;
import com.shin.blog.vo.ArticleVo;
import org.elasticsearch.action.index.IndexRequest;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.xcontent.XContentType;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
public class ArticleListener {

    @Autowired
    ArticleMapper articleMapper;

    @Autowired
    RestHighLevelClient restHighLevelClient;

    @Autowired
    ArticleCopy articleCopy;

    /**
     * 监听文章新增或修改的业务
     */
    @RabbitListener(queues = MqConstants.INSERT_QUEUE)
    public void listenArticleInsertOrUpdate(Long articleId, Channel channel, Message message) {
        try {
            Article article = articleMapper.selectById(articleId);
            if (article == null) {
                return;
            }
            ArticleVo articleVo = articleCopy.copy(article,true,true,true,true);
            // 插入到es中
            IndexRequest request = new IndexRequest("articles");
            request.id(String.valueOf(articleVo.getId()));
            request.source(JSON.toJSONString(articleVo), XContentType.JSON);
            restHighLevelClient.index(request, RequestOptions.DEFAULT);
            //手动ack
            channel.basicAck(message.getMessageProperties().getDeliveryTag(), false);
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
