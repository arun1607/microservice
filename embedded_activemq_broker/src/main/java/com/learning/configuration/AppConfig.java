package com.learning.configuration;

import org.apache.activemq.ActiveMQConnectionFactory;
import org.apache.activemq.broker.BrokerService;
import org.apache.activemq.command.ActiveMQTopic;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.DependsOn;
import org.springframework.jms.core.JmsTemplate;

import javax.jms.TextMessage;

/**
 * Created by amits on 27/09/15.
 */
@Configuration
public class AppConfig {

    @Bean(initMethod = "start",name = "broker")
    public BrokerService broker() throws Exception {
        BrokerService brokerService = new BrokerService();
        brokerService.setBrokerName("Microservice");
        brokerService.addConnector("tcp://localhost:61616");
        brokerService.setUseJmx(false);
        brokerService.setPersistent(true);
        return brokerService;
    }
    @Bean
    @DependsOn("broker")
    public ActiveMQConnectionFactory activeMQConnectionFactory() {
        return new ActiveMQConnectionFactory("tcp://localhost:61616");
    }


    @Bean
    public JmsTemplate jmsTemplate(ActiveMQConnectionFactory activeMQConnectionFactory) {
        return new JmsTemplate(activeMQConnectionFactory);
    }
}
