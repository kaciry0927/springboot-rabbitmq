package com.kaciry.fanout;

import org.springframework.amqp.rabbit.annotation.Exchange;
import org.springframework.amqp.rabbit.annotation.Queue;
import org.springframework.amqp.rabbit.annotation.QueueBinding;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * @author Kaciry Smith
 * @create 2021-08-01 5:06 下午
 */
@Component
public class FanoutCustomer {

    @RabbitListener(bindings = {
            @QueueBinding(
                    value = @Queue, // 创建临时队列
                    exchange = @Exchange(value = "logs", type = "fanout") //绑定的交换机
            )})
    public void receiver1(String msg) {
        System.out.println("Fanout1 : " + msg);
    }

    @RabbitListener(bindings = {
            @QueueBinding(
                    value = @Queue, // 创建临时队列
                    exchange = @Exchange(value = "logs", type = "fanout") //绑定的交换机
            )})
    public void receiver2(String msg) {
        System.out.println("Fanout2 : " + msg);
    }

    @RabbitListener(bindings = {
            @QueueBinding(
                    value = @Queue, // 创建临时队列
                    exchange = @Exchange(value = "logs", type = "fanout") //绑定的交换机
            )})
    public void receiver3(String msg) {
        System.out.println("Fanout3 : " + msg);
    }
}
