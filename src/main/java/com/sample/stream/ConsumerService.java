package com.sample.stream;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.function.Consumer;
import org.springframework.amqp.AmqpRejectAndDontRequeueException;
import org.springframework.amqp.ImmediateAcknowledgeAmqpException;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.Message;

import com.rabbitmq.client.Channel;
import com.sample.stream.model.Order;

@Configuration
public class ConsumerService {
	
	@Bean
    Consumer<Message<Order>> orderAutoConsume() {
		return message -> {
			System.out.println("Received message in AUTO ack ..." + message);
			@SuppressWarnings("unchecked")
			ArrayList<HashMap<String,?>> xdeath = (ArrayList<HashMap<String, ?>>) message.getHeaders().get("x-death");
			
			if (xdeath != null && xdeath.get(0).get("count").equals(3L)) {	
                // giving up - don't send to DLX
                //throw new ImmediateAcknowledgeAmqpException("Failed after 4 attempts");
				System.out.println("Auto Acknowledge AMQP... " + message.getPayload());
				
            } else 
            	throw new AmqpRejectAndDontRequeueException("failed");
        };
	}
}

