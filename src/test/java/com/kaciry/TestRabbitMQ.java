package com.kaciry;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @author Kaciry Smith
 * @create 2021-08-01 4:40 下午
 */
@SpringBootTest(classes = SpringbootRabbitmqApplication.class)
@RunWith(SpringRunner.class)
public class TestRabbitMQ {

    @Autowired
    private RabbitTemplate rabbitTemplate;


    // hello world 模型
    @Test
    public void testHelloWorld() {
        rabbitTemplate.convertAndSend("hello", "hello world");
    }

    // work 模型 公平型模型，轮训消费，能者多劳需要额外配置
    @Test
    public void testWork() {
        for (int i = 0; i < 10; i++) {
            rabbitTemplate.convertAndSend("work", "work模型");
        }
    }

    // Fanout 广播模型(需要交换机)
    @Test
    public void testFanout(){
        rabbitTemplate.convertAndSend("logs","","Fanout模型");
    }

    // Routing 路由模型
    @Test
    public void testRouter(){
        rabbitTemplate.convertAndSend("directs","error","发送error的key的路由信息");
    }

    // Topics 订阅、动态路由模式
    @Test
    public void testTopic(){
        rabbitTemplate.convertAndSend("topics","user.save","user save 路由消息");
    }
}
