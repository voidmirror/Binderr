package org.voidmirror.own.config;

import io.r2dbc.spi.Connection;
import io.r2dbc.spi.ConnectionFactories;
import io.r2dbc.spi.ConnectionFactory;
import io.r2dbc.spi.ConnectionFactoryOptions;
import io.r2dbc.spi.Option;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.r2dbc.connection.init.ConnectionFactoryInitializer;
import org.springframework.r2dbc.connection.init.ResourceDatabasePopulator;
import reactor.core.publisher.Mono;

import java.nio.file.Paths;

@Configuration
public class R2dbcConfig {

    @Bean
    ConnectionFactoryInitializer initializer(ConnectionFactory connectionFactory) {

        ConnectionFactoryInitializer initializer = new ConnectionFactoryInitializer();
        initializer.setConnectionFactory(connectionFactory);
        initializer.setDatabasePopulator(new ResourceDatabasePopulator(new ClassPathResource("schema.sql")));

        return initializer;
    }

//    @Bean
//    public ConnectionFactory connectionFactory() {
//
//        ConnectionFactoryOptions options = ConnectionFactoryOptions.builder()
//                .option(Option.valueOf("DRIVER"), "h2")
//                .option(Option.valueOf("PROTOCOL"), "file")
//                .option(Option.valueOf("USER"), "user")
//                .option(Option.valueOf("PASSWORD"), "pass")
//                .option(Option.valueOf("DATABASE"), "r2dbc:h2:file://../../../resources/usdb")
//                .option(Option.valueOf("DB_CLOSE_DELAY"), "-1")
//                .build();
//
//        ConnectionFactory connectionFactory = ConnectionFactories.get(options);
//        return connectionFactory;



//        Mono<Connection> connectionMono = Mono.from(connectionFactory.create());
//        connectionMono.subscribe();

//        ConnectionFactory connectionFactory = ConnectionFactories.get("r2dbc:h2:file://../../../resources/usdb");
//        Publisher<? extends Connection> connectionPublisher = connectionFactory.create();
//    }
}
