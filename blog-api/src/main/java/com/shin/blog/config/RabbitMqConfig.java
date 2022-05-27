package com.shin.blog.config;

import com.shin.blog.vo.constants.MqConstants;
import org.springframework.amqp.core.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitMqConfig {

    /**
     * 1、声明fanout交换机
     * 2、声明队列
     * 3、绑定交换机和队列
     * 4、发送消息
     */
    @Bean
    public DirectExchange directExchange() {
        return new DirectExchange(MqConstants.EXCHANGE_NAME,true,false);
    }

    @Bean
    public Queue insertQueue() {
        return new Queue(MqConstants.INSERT_QUEUE,true);
    }

    @Bean
    public Queue deleteQueue() {
        return new Queue(MqConstants.DELETE_QUEUE,true);
    }

    @Bean
    public Binding insertQueueBinding() {
        return BindingBuilder.bind(insertQueue()).to(directExchange()).with(MqConstants.INSERT_ROUTING_KEY);
    }

    @Bean
    public Binding deleteQueueBinding() {
        return BindingBuilder.bind(deleteQueue()).to(directExchange()).with(MqConstants.DELETE_ROUTING_KEY);
    }
}
