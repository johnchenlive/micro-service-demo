package com.abc.demo.service.manage;

import org.springframework.boot.actuate.endpoint.annotation.Endpoint;
import org.springframework.boot.actuate.endpoint.annotation.ReadOperation;
import org.springframework.boot.actuate.health.Health;
import org.springframework.boot.actuate.health.Status;

/**
 * {@link Endpoint} to expose application {@link Status}.
 * It always returns UP status meaning service end-point is up and running.
 */
@Endpoint(id = "status")
public class StatusEndpoint {

  @ReadOperation
  public Health status() {
    return Health.up().build();
  }
}