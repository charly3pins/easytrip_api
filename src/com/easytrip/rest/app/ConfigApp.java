package com.easytrip.rest.app;

import org.glassfish.jersey.server.ResourceConfig;

public class ConfigApp extends ResourceConfig {
    public ConfigApp() {
        // defineix quin package te els Services
        packages("com.easytrip.rest.services");
    }
}
