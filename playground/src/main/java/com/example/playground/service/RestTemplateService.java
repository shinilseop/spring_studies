package com.example.playground.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpStatusCodeException;
import org.springframework.web.client.RestTemplate;

@Slf4j
@Service
public class RestTemplateService {

  public boolean applicationHealthCheck(String url) {
    RestTemplate template = new RestTemplate();
    String response = "";
    try {
      response = template.getForObject(url + "/healthz", String.class);
      log.info("healthz Result -success-> "+response);
    } catch (Exception e) {
      log.info("healthz Result -error->"+e.getMessage());
      e.printStackTrace();
      return false;
    }
    return true;
  }
}
