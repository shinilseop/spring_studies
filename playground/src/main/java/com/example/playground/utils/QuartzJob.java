package com.example.playground.utils;

import java.time.LocalDateTime;
import lombok.extern.slf4j.Slf4j;
import org.quartz.Job;
import org.quartz.JobBuilder;
import org.quartz.JobDetail;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.quartz.PersistJobDataAfterExecution;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Slf4j
@PersistJobDataAfterExecution
public class QuartzJob implements Job {

  @Override
  public void execute(JobExecutionContext context) throws JobExecutionException {
//    log.info("[{}] job-detail-key:{}, fired-time:{}, num:{}", LocalDateTime.now(),
//        context.getJobDetail().getKey(), context.getFireTime(),
//        context.getJobDetail().getJobDataMap().getInt("num"));
    log.info("[{}] num:{}", LocalDateTime.now(), context.getJobDetail().getJobDataMap().getInt("num"));
    context.getJobDetail().getJobDataMap().put("num", context.getJobDetail().getJobDataMap().getInt("num")+1);
  }
}
