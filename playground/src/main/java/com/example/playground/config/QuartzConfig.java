package com.example.playground.config;

import com.example.playground.utils.QuartzJob;
import java.util.Collections;
import javax.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.quartz.JobBuilder;
import org.quartz.JobDataMap;
import org.quartz.JobDetail;
import org.quartz.SchedulerException;
import org.quartz.SimpleScheduleBuilder;
import org.quartz.SimpleTrigger;
import org.quartz.Trigger;
import org.quartz.TriggerBuilder;
import org.quartz.TriggerKey;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.quartz.SchedulerFactoryBean;

@RequiredArgsConstructor
@Configuration
public class QuartzConfig {

  private final SchedulerFactoryBean schedulerFactoryBean;

  @PostConstruct
  public void scheduled() throws SchedulerException {
    JobDataMap jobDataMap1 = new JobDataMap(Collections.singletonMap("num", 1));
    JobDetail job1 = jobDetail("hello1", "hello-group", "This is JobDetail 1.", jobDataMap1);
    SimpleTrigger trigger1 = trigger("trigger1", "trigger-group", "This is SimpleTrigger 1.");
    schedulerFactoryBean.getObject().scheduleJob(job1, trigger1);

//    JobDataMap jobDataMap2 = new JobDataMap(Collections.singletonMap("num", 2));
//    JobDetail job2 = jobDetail("hello2", "hello-group", "This is JobDetail 2.", jobDataMap2);
//    SimpleTrigger trigger2 = trigger("trigger2", "trigger-group", "This is SimpleTrigger 2.");
//    schedulerFactoryBean.getObject().scheduleJob(job2, trigger2);
  }

  public JobDetail jobDetail(String name, String group, String description, JobDataMap jobDataMap) {
    return JobBuilder.newJob(QuartzJob.class)
        .withIdentity(name, group)
        .withDescription(description)
        .usingJobData(jobDataMap)
        .build();
  }

  public SimpleTrigger trigger(String name, String group, String description) {
    return TriggerBuilder.newTrigger()
        .withIdentity(name, group)
        .withSchedule(SimpleScheduleBuilder.repeatSecondlyForever())
        .withDescription(description)
        .build();
  }
}
