package com.abc.demo.service.manage;

import javax.inject.Inject;

import org.springframework.boot.actuate.endpoint.annotation.ReadOperation;
import org.springframework.boot.actuate.endpoint.web.WebEndpointResponse;
import org.springframework.boot.actuate.endpoint.web.annotation.EndpointWebExtension;
import org.springframework.boot.actuate.health.Health;
import org.springframework.boot.actuate.health.HealthStatusHttpMapper;

@EndpointWebExtension(endpoint = StatusEndpoint.class)
public class StatusEndpointWebExtension {

  private StatusEndpoint delegate;
  private HealthStatusHttpMapper statusMapper;

  @Inject
  public StatusEndpointWebExtension(StatusEndpoint delegate, HealthStatusHttpMapper statusMapper) {
    this.delegate = delegate;
    this.statusMapper = statusMapper;
  }

  @ReadOperation
  public WebEndpointResponse<Health> info() {
    Health health = this.delegate.status();
    return new WebEndpointResponse<>(health, statusMapper.mapStatus(health.getStatus()));
  }
}