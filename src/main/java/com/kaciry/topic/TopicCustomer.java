package com.kaciry.topic;

import org.springframework.amqp.rabbit.annotation.Exchange;
import org.springframework.amqp.rabbit.annotation.Queue;
import org.springframework.amqp.rabbit.annotation.QueueBinding;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * @author Kaciry Smith
 * @create 2021-08-01 5:23 下午
 */
@Component
public class TopicCustomer {

    @RabbitListener(bindings = {
            @QueueBinding(
                    value = @Queue,
                    exchange = @Exchange(type = "topic", value = "topics"),
                    key = {"user.save","user.*"}
            )
    })
    public void receiver1(String msg){
        System.out.println("Message1 : " + msg);
    }

    @RabbitListener(bindings = {
            @QueueBinding(
                    value = @Queue,
                    exchange = @Exchange(type = "topic", name = "topics"),
                    key = {"order.#"}
            )
    })
    public void receiver2(String msg){
        System.out.println("Message2 : " + msg);
    }
}
