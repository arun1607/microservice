package com.learning.configuration;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.learning.event.Event;
import lombok.extern.log4j.Log4j;
import org.apache.activemq.camel.component.ActiveMQComponent;
import org.apache.camel.CamelContext;
import org.apache.camel.Exchange;
import org.apache.camel.RoutesBuilder;
import org.apache.camel.TypeConversionException;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.support.TypeConverterSupport;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
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

        return new RouteBuilder() {
            @Override
            public void configure() throws Exception {
                from("activemq:topic:"+topic).beanRef("orderEventHandler", "handleEvent");
            }

        };
    }

    @Bean
    public ActiveMQComponent activeMQComponent() {

        ActiveMQComponent activeMQComponent = new ActiveMQComponent();
        activeMQComponent.setBrokerURL("tcp://localhost:61616");
        camelContext.addComponent("activemq",activeMQComponent);
        camelContext.getTypeConverterRegistry().addTypeConverter(Event.class, String.class, new EventTypeConverter());
        return activeMQComponent;
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
