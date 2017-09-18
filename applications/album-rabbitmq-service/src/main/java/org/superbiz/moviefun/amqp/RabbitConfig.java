package org.superbiz.moviefun.amqp;

import org.springframework.amqp.rabbit.connection.CachingConnectionFactory;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.integration.dsl.IntegrationFlow;
import org.springframework.integration.dsl.IntegrationFlows;
import org.springframework.integration.dsl.amqp.Amqp;

/**
 * Created by kshitizkriskrishna on 9/17/17.
 */
@Configuration
public class RabbitConfig {

    @Value("${rabbitmq.queue}") String rabbitMqQueue;
    @Value("${rabbitmq.uri}") String rabbitMqUri;

    @Bean
    public IntegrationFlow amqpInbound(ConnectionFactory connectionFactory, AlbumsUpdateMessageConsumer consumer) {
        return IntegrationFlows
            .from(Amqp.inboundAdapter(connectionFactory, rabbitMqQueue))
            .handle(consumer::consume)
            .get();
    }

    @Bean
    public ConnectionFactory connectionFactory() {
        CachingConnectionFactory factory = new CachingConnectionFactory();
        factory.setUri(rabbitMqUri);
        return factory;
    }
}
