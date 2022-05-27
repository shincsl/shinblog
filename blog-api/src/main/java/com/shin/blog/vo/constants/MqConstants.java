package com.shin.blog.vo.constants;

public class MqConstants {

    /**
     * 交换机
     */
    public static final String EXCHANGE_NAME = "direct_blog_exchange";

    /**
     * 新增或修改队列
     */
    public static final String INSERT_QUEUE = "blog.insert.queue";

    /**
     * 删除队列
     */
    public static final String DELETE_QUEUE = "blog.delete.queue";

    /**
     * 新增或修改队列的ROUTING_KEY
     */
    public static final String INSERT_ROUTING_KEY = "blog.insert";

    /**
     * 删除队列的ROUTING_KEY
     */
    public static final String DELETE_ROUTING_KEY = "blog.delete";
}
