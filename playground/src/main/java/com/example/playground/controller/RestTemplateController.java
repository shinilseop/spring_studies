package com.example.playground.controller;

import com.example.playground.service.RestTemplateService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RequiredArgsConstructor
@RestController
@RequestMapping("/resttemplate")
public class RestTemplateController {

  private final RestTemplateService restTemplateService;

  @GetMapping
  public boolean applicationHealthCheckConnector() {
    return restTemplateService.applicationHealthCheck("http://localhost:5001");
  }
}
