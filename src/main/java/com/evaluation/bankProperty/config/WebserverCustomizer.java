package com.evaluation.bankProperty.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.server.WebServerFactoryCustomizer;
import org.springframework.boot.web.servlet.server.ConfigurableServletWebServerFactory;
import org.springframework.stereotype.Component;

@Component
public class WebserverCustomizer implements WebServerFactoryCustomizer<ConfigurableServletWebServerFactory>
{

    @Value("${SMS_PLATFORM_CONTEXT_PATH:}")
    private String serverContextPath;

    @Value("${SMS_PLATFORM_PORT:8088}")
    private String serverPort;

    @Override
    public void customize(ConfigurableServletWebServerFactory factory)
    {
        factory.setContextPath(serverContextPath);
        factory.setPort(Integer.parseInt(serverPort));
    }

}
