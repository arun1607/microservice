package com.learning;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.jms.core.JmsTemplate;

import javax.jms.TextMessage;

/**
 * Hello world!
 */
@SpringBootApplication
public class EmbeddedBrokerStarter implements InitializingBean{
    @Autowired
    private JmsTemplate jmsTemplate;

    @Value("${queue.name}")
    private String topicName;

    public static void main(String[] args) throws Exception {
        SpringApplication.run(EmbeddedBrokerStarter.class, args);
        while (true) {

        }
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        jmsTemplate.send(topicName, session -> {
            TextMessage textMessage = session.createTextMessage();
            textMessage.setText("");
            return textMessage;
        });
    }
}
