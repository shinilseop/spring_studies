package com.example.playground.utils;

import java.time.LocalDateTime;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class ScheduledTest {
  @Scheduled(fixedDelay = 1000)
  public void scheduledTest() {
    log.info("job test : "+ LocalDateTime.now());
  }
}
