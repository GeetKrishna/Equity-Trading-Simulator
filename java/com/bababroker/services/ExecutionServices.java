package com.bababroker.services;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.jms.listener.MessageListenerContainer;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.bababroker.dao.BlockDAO;
import com.bababroker.dao.BlockDAOImpl;
import com.bababroker.dao.ConfigurationInfoDAO;
import com.bababroker.dao.ConfigurationInfoDAOImpl;
import com.bababroker.dao.ExecutionDAO;
import com.bababroker.dao.ExecutionDAOImpl;
import com.bababroker.dao.SecurityDAO;
import com.bababroker.dao.UserDAO;
import com.bababroker.dao.UserDAOImpl;
import com.bababroker.model.Block;
import com.bababroker.model.ConfigurationInfo;
import com.bababroker.model.Execution;
import com.bababroker.model.Security;
import com.bababroker.model.UserT;

@Component
public class ExecutionServices implements Job,ApplicationContextAware {

	private int numberOfExecution;
	private int securitiesToBeExecuted;
	private int priceSpread;
	private int probablityOfExecution;
	private int timeInterval;

	private Block block;
	
	
	@Autowired
	private BlockDAO blockdao;

	@Autowired
	private ExecutionDAO executiondao;

	@Autowired
	private ApplicationContext applicationContext;

	
	private static ApplicationContext ctx;
	public ExecutionServices(Block block) {
		this.block = block;

	}

	public ExecutionServices() {
		
		// TODO Auto-generated constructor stub
	}

	public void execute(JobExecutionContext arg0) throws JobExecutionException {
		// TODO Auto-generated method stub
		blockdao = (BlockDAO)ctx.getBean(BlockDAO.class);
		executiondao = (ExecutionDAO)ctx.getBean(ExecutionDAO.class);
		 ExecutorService executorService = Executors.newCachedThreadPool();

			List<Block> blocks = new ArrayList<Block>();
			System.out.println("start execution blockdao " + blockdao);
			blocks.addAll(blockdao.getStatusBlock("NEW"));
			// List<ExecutionServices> executions = new
			// ArrayList<ExecutionServices>();
			for (Block block : blocks) {
				ExecutionAlgorithm exe =  new ExecutionAlgorithm(block.getBlockid());
				//exe.executeBlockAlgorithm();
				// executions.add(exe);
				 executorService.submit(exe);
			}
	}

	public void setApplicationContext(ApplicationContext arg0)
			throws BeansException {
//		System.out.println(" ctx ->"+applicationContext);
		ctx = applicationContext;

		
	}
}
