package org.voidmirror.own.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.server.ConfigurableWebServerFactory;
import org.springframework.boot.web.server.WebServerFactoryCustomizer;
import org.springframework.stereotype.Component;
import org.voidmirror.own.dao.RemoteRepository;

import java.util.Objects;

//@Component
public class ServerPortCustomizer implements WebServerFactoryCustomizer<ConfigurableWebServerFactory> {
    @Autowired
    private RemoteRepository remoteRepository;
    @Override
    public void customize(ConfigurableWebServerFactory factory) {
        System.out.println(Objects.requireNonNull(remoteRepository.findAll().blockFirst()).getUid());
        factory.setPort(-0);
    }
}
