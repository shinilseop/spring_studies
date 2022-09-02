package com.example.playground.utils;

import java.time.LocalDateTime;
import lombok.extern.slf4j.Slf4j;
import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.context.annotation.Configuration;

@Slf4j
@Configuration
public class QuartzTest implements Job {

  @Override
  public void execute(JobExecutionContext context) throws JobExecutionException {
    log.info("now :: " + LocalDateTime.now());
  }
}
