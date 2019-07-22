package com.abc.demo.service.manage;

import org.springframework.boot.actuate.autoconfigure.endpoint.condition.ConditionalOnEnabledEndpoint;
import org.springframework.boot.actuate.health.HealthStatusHttpMapper;
import org.springframework.boot.autoconfigure.condition.ConditionalOnBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.inject.Inject;

/**
 * Auto-configuration for the {@link StatusEndpoint}.
 */
@Configuration
public class StatusEndpointAutoConfiguration {

  private HealthStatusHttpMapper healthStatusHttpMapper;

  @Inject
  public StatusEndpointAutoConfiguration(HealthStatusHttpMapper healthStatusHttpMapper) {
    this.healthStatusHttpMapper = healthStatusHttpMapper;
  }

  @Bean
  @ConditionalOnMissingBean
  @ConditionalOnEnabledEndpoint
  public StatusEndpoint statusEndpoint() {
    return new StatusEndpoint();
  }

  @Bean
  @ConditionalOnMissingBean
  @ConditionalOnBean(StatusEndpoint.class)
  public StatusEndpointWebExtension statusEndpointWebExtension() {
    return new StatusEndpointWebExtension(statusEndpoint(), healthStatusHttpMapper);
  }
}