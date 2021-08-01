package com.kaciry.work;

import org.springframework.amqp.rabbit.annotation.Queue;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * @author Kaciry Smith
 * @create 2021-08-01 4:53 下午
 */
@Component

public class workCustomer {

    // 一个消费者
    @RabbitListener(queuesToDeclare = @Queue("work"))
    public void receive1(String msg){
        System.out.println("Message1 : " + msg);
    }

    @RabbitListener(queuesToDeclare = @Queue("work"))
    public void receive2(String msg){
        System.out.println("Message2 : " + msg);
    }


}
