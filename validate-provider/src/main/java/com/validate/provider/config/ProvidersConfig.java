package com.validate.provider.config;

import com.validate.provider.model.Providers;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
@EnableConfigurationProperties
@ConfigurationProperties("/")
public class ProvidersConfig {

    public List<Providers> getProviders() {
        return providers;
    }

    public void setProviders(List<Providers> providers) {
        this.providers = providers;
    }

    public List<Providers> providers;

    @Override
    public String toString() {
        return "ProvidersConfig{" +
                "providers=" + providers +
                "}";
    }
}
