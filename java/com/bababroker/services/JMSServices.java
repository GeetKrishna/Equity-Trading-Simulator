package com.bababroker.services;

import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.listener.MessageListenerContainer;

public class JMSServices implements Job {

                @Autowired
                private MessageListenerContainer listenerContainer;

                public void execute(JobExecutionContext arg0) throws JobExecutionException {
                                //System.out.println("jms stopped");
                                listenerContainer.stop();
                }

                
}
