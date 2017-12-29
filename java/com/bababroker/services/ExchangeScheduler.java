package com.bababroker.services;


import java.text.ParseException;

import org.quartz.JobBuilder;
import org.quartz.JobDetail;
import org.quartz.Scheduler;
import org.quartz.SchedulerException;
import org.quartz.SchedulerFactory;
import org.quartz.impl.StdSchedulerFactory;
import org.quartz.impl.triggers.CronTriggerImpl;
import org.springframework.stereotype.Component;
@Component
public class ExchangeScheduler {

	public void startExchange(){
		SchedulerFactory sf=new StdSchedulerFactory();
		try {
			Scheduler sched=sf.getScheduler();
			JobDetail job=JobBuilder.newJob(ExecutionServices.class).withIdentity("helloJob", "groupJob").build();
			JobDetail expirejob = JobBuilder.newJob(JMSServices.class).withIdentity("expireJob", "group2Job").build();
			
			CronTriggerImpl cronTrigger=new CronTriggerImpl();
			cronTrigger.setName("trigger");
			//cronTrigger.setCronExpression("0/20 10 9-16 ? * MON-FRI");
			cronTrigger.setCronExpression("*/20 * * ? * *");
			
			CronTriggerImpl cronTrigger2=new CronTriggerImpl();
			cronTrigger2.setName("expiringTrigger");
			cronTrigger2.setCronExpression("0 30 15 ? * MON-FRI");
			
			sched.start();
			
			sched.scheduleJob(job, cronTrigger);
			
			sched.scheduleJob(expirejob, cronTrigger2);
			
			
		} catch (SchedulerException e) {
			e.printStackTrace();
		} catch (ParseException e) {
			e.printStackTrace();
		}
	}
}
