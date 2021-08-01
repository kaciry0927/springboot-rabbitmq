package com.kaciry.route;

import org.springframework.amqp.rabbit.annotation.Exchange;
import org.springframework.amqp.rabbit.annotation.Queue;
import org.springframework.amqp.rabbit.annotation.QueueBinding;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * @author Kaciry Smith
 * @create 2021-08-01 5:14 下午
 */
@Component
public class RouteCusmoter {

    @RabbitListener(bindings = {
            @QueueBinding(
                    value = @Queue,
                    exchange = @Exchange(value = "directs",type = "direct"),
                    key = {"info","error","warn"}
            )
    })
    public void receiver1(String msg){
        System.out.println("Message1 : " + msg);
    }

    @RabbitListener(bindings = {
            @QueueBinding(
                    value = @Queue,
                    exchange = @Exchange(value = "directs",type = "direct"),
                    key = {"warn"}
            )
    })
    public void receiver2(String msg){
        System.out.println("Message2 : " + msg);
    }

    @RabbitListener(bindings = {
            @QueueBinding(
                    value = @Queue,
                    exchange = @Exchange(value = "directs", type = "direct"),
                    key = {"error"}
            )
    })
    public void receiver3(String msg) {
        System.out.println("Message3 : " + msg);
    }
}
