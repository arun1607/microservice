package com.learning.configuration;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.learning.event.Event;
import lombok.extern.log4j.Log4j;
import org.apache.activemq.ActiveMQConnectionFactory;
import org.apache.activemq.camel.component.ActiveMQComponent;
import org.apache.activemq.camel.component.ActiveMQConfiguration;
import org.apache.activemq.pool.PooledConnectionFactory;
import org.apache.camel.CamelContext;
import org.apache.camel.Exchange;
import org.apache.camel.RoutesBuilder;
import org.apache.camel.TypeConversionException;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.component.jms.JmsConfiguration;
import org.apache.camel.support.TypeConverterSupport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.jms.connection.JmsTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;

/**
 * Created by amits on 27/09/15.
 */
@Configuration
@Log4j
public class AppConfig {

    @Autowired
    private CamelContext camelContext;

    @Autowired
    private Environment environment;

    @Bean
    RoutesBuilder myRouter() {

        String topic = environment.getProperty("queue.name");
        String clientId = environment.getProperty("jms.clientId");
        String subscriptionName = environment.getProperty("jms.durable.subscription.name");

        return new RouteBuilder() {
            @Override
            public void configure() throws Exception {
                from("activemq:topic:" + topic + "?clientId=" + clientId + "&durableSubscriptionName=" + subscriptionName).beanRef("shipmentEventHandler", "handleEvent");
            }
        };
    }

    @Bean
    public ActiveMQComponent activeMQComponent() {

        ActiveMQComponent activeMQComponent = new ActiveMQComponent(jmsConfiguration());
        camelContext.addComponent("activemq", activeMQComponent);
        camelContext.getTypeConverterRegistry().addTypeConverter(Event.class, String.class, new EventTypeConverter());
        return activeMQComponent;
    }

    @Bean
    public ActiveMQConfiguration jmsConfiguration() {
        ActiveMQConfiguration activeMQConfiguration = new ActiveMQConfiguration();
        activeMQConfiguration.setTransacted(true);
        activeMQConfiguration.setCacheLevelName("CACHE_CONSUMER");
        activeMQConfiguration.setMaxConcurrentConsumers(1);
        activeMQConfiguration.setConcurrentConsumers(1);
        return activeMQConfiguration;
    }

    @Bean
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }


    private static class EventTypeConverter extends TypeConverterSupport {
        @Override
        public <T> T convertTo(Class<T> type, Exchange exchange, Object value) throws TypeConversionException {
            ObjectMapper objectMapper = new ObjectMapper();
            Event event = null;
            try {
                event = objectMapper.readValue((String) value, Event.class);
            } catch (IOException e) {
                log.error("Error occurred in parsing event", e);
            }
            return (T) event;
        }
    }
}
