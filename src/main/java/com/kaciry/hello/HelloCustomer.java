package com.kaciry.hello;

import org.springframework.amqp.rabbit.annotation.Queue;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * @author Kaciry Smith
 * @create 2021-08-01 4:45 下午
 */
@Component
@RabbitListener(queuesToDeclare = @Queue(value = "hello", declare = "false", autoDelete = "true")) //消费者监听
public class HelloCustomer {
    @RabbitHandler
    public void receives(String message) {
        System.out.println("Message : " + message);
    }
}
