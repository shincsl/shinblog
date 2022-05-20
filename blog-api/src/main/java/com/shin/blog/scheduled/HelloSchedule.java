//package com.shin.blog.scheduled;
//
//import com.shin.blog.jooq.model.entity.ScArticle;
//import com.shin.blog.jooq.model.generated.Tables;
//import com.shin.blog.jooq.model.generated.tables.daos.ScArticleDao;
//import com.shin.blog.jooq.model.generated.tables.pojos.ScArticlePojo;
//import com.shin.blog.jooq.model.generated.tables.records.ScArticleRecord;
//import com.shin.blog.vo.Result;
//import lombok.extern.slf4j.Slf4j;
//import net.sf.jsqlparser.parser.feature.Feature;
//import org.jooq.DSLContext;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.scheduling.annotation.Async;
//import org.springframework.scheduling.annotation.EnableAsync;
//import org.springframework.scheduling.annotation.EnableScheduling;
//import org.springframework.scheduling.annotation.Scheduled;
//import org.springframework.stereotype.Component;
//
//import java.time.LocalDate;
//import java.time.LocalDateTime;
//import java.time.LocalTime;
//import java.time.format.DateTimeFormatter;
//import java.util.List;
//
//import static net.sf.jsqlparser.parser.feature.Feature.fetch;
//
///**
// * 定时任务
// * 1、@EnableScheduling 开启定时任务
// * 2、@Scheduled 注解定义定时任务
// * 异步任务
// * 1、@EnableAsync 开启异步任务
// * 2、@Async 在方法上注解定义异步任务
// */
//@Slf4j
//@Component
//@EnableAsync
//@EnableScheduling
//public class HelloSchedule {
//
//    /**
//     * 1、定时任务默认阻塞，需设置成不阻塞
//     * 1）可以让业务以异步方式运行
//     * CompletableFuture.runAsync(() -> {
//     * // 业务代码
//     * },executor);
//     * 2）支持定时任务线程池；设置TaskSchedulingProperties
//     * 3）让定时任务异步执行
//     */
//    @Autowired
//    DSLContext dslContext;
//
//    @Async
//    @Scheduled(cron = "* * * * * ?")  //cron表达式
//    public void hello() throws InterruptedException {
//        LocalDate now = LocalDate.now();
//        LocalDate plus2 = now.plusDays(2);
//
//        LocalTime min = LocalTime.MIN;
//        LocalTime max = LocalTime.MAX;
//
//        LocalDateTime s = LocalDateTime.of(now, min);
//        LocalDateTime e = LocalDateTime.of(plus2, max);
//
//        String start = s.format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
//        String end = e.format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
////        List<ScArticle> fetch = dslContext.selectFrom(Tables.SC_ARTICLE).where(Tables.SC_ARTICLE.ID.eq(1L)).fetch(r -> r.into(ScArticle.class));
//        ScArticleDao scArticleDao = new ScArticleDao(dslContext.configuration());
//        ScArticle fetch = scArticleDao.findById(1L);
//
//        Result success = Result.success(fetch);
//        System.out.println(success);
//        Thread.sleep(5000);
//    }
//}
