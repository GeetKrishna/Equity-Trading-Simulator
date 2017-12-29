package com.bababroker.services;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.Date;
import java.util.Random;

import javax.jms.JMSException;
import javax.naming.NamingException;
import javax.xml.bind.JAXBException;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.bababroker.dao.BlockDAO;
import com.bababroker.dao.ExecutionDAO;
import com.bababroker.dao.SecurityDAO;
import com.bababroker.model.Block;
import com.bababroker.model.Execution;
import com.bababroker.model.Security;
import com.bababroker.testjms.JmsBlock;

@Component
public class ExecutionAlgorithm implements Runnable, ApplicationContextAware{

	
	
	private static ApplicationContext ctx;
	
	private int numberOfExecution;
	private int securitiesToBeExecuted;
	private int priceSpread;
	private int probablityOfExecution;
	private int timeInterval;
	private Block block;
	BlockDAO blockdao;
	ExecutionDAO executiondao;
	SecurityDAO securityDAO;
	Sender sender;
	
	public ExecutionAlgorithm(Long blockid) {
		blockdao = (BlockDAO)ctx.getBean(BlockDAO.class);
		executiondao = (ExecutionDAO)ctx.getBean(ExecutionDAO.class);
		securityDAO = (SecurityDAO)ctx.getBean(SecurityDAO.class);
	this.block=	blockdao.findByIdB( blockid);
		//this.block = block;
		 
	}


	public ExecutionAlgorithm() {
		
	}


	public int executeBlockAlgorithm() {

		//System.out.println("in executeblockalgo");

		synchronized (block) {
			//System.out.println("in synchronized block");
			int maxNumberOfExecution = block.getSecurity()
					.getSecurityConfigMapping().getConfigurationInfo()
					.getMaxnumexecutions().intValueExact();
			// //System.out.println(maxNumberOfExecution);
			// randInt(1, max)
			//System.out.println("max execution " + maxNumberOfExecution);

			String type;
			if (block.getLimitprice() != null) {
				type = "Limit";// to be changed to Limit

			} else
				type = "Market";
			String side = block.getSide();
			//System.out.println(block.getSide());
			numberOfExecution = randInt(1, maxNumberOfExecution);
			//System.out.println("no of exe" + numberOfExecution);
			while (numberOfExecution >= 0) {
				Execution execution = new Execution();
				if (type == "Market") {
					executeMarketBlock(block, execution);
				} else {
					if (side.equalsIgnoreCase("BUY")) {
						executeBuyLimit(block, execution);
					} else {
						executeSellLimit(block, execution);
					}
				}

//				//System.out.println("in execution qty" + execution.getQty());
//				//System.out.println("in block executed qty"
//						+ block.getExecutions());
//						//System.out.println(block.getBlockid());
//						//System.out.println(block.getSide());
//						//System.out.println(block.getExecutedqty());
//						//System.out.println(block.getExecutions());
//						//System.out.println(block.getLimitprice());
//						//System.out.println(block.getSecurity().getSecurityname());
//						//System.out.println(block.getStopprice());
//						//System.out.println(block.getTimeexecuted());
//						//System.out.println(block.getTimereceived());
//						//System.out.println(block.getTotalqty());
						//+ block.getSide()+block.getStatus()+block.getExecutedqty()+block.getExecutions()+block.getLimitprice()+block.getSecurity());
				
				/*executiondao.saveE(execution);
				blockdao.saveB(block);
				
				*/
						executiondao.saveE(execution);
						blockdao.updateB(block);
						//System.out.println("after save");
				// send for JMS
						JmsBlock jmsblock = new JmsBlock();
						jmsblock.setExecutionid(execution.getExecutionid());
						jmsblock.setBlockid(block.getBlockid());
						jmsblock.setExecutedqty(execution.getQty());
						jmsblock.setStatus(block.getStatus());
						jmsblock.setTransactionprice(execution.getPrice());
						
						sender = (Sender)ctx.getBean(Sender.class);
						try {
							sender.sendToJMS(jmsblock);
						} catch (JMSException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						} catch (NamingException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						} catch (JAXBException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
						/////
				int probpercentfullexec = block.getSecurity()
						.getSecurityConfigMapping().getConfigurationInfo()
						.getProbpercentfullexec().intValueExact();
				probablityOfExecution = randInt(0, 100);
				if (probablityOfExecution >= (100 - probpercentfullexec)) {
					numberOfExecution--;
				} else
					break;

				int maxIntervalBtwExecution = block.getSecurity()
						.getSecurityConfigMapping().getConfigurationInfo()
						.getMaxtimebtwexecutions().intValueExact();
				timeInterval = randInt(0, maxIntervalBtwExecution);
				try {
					Thread.sleep(timeInterval);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}

			return 0;
		}
	}

	
	public void executeMarketBlock(Block block, Execution execution) {
		//System.out.println("in market block "
				//+ block.getSecurity().getSecurityname());
		int remainingQuantity = block.getTotalqty().intValueExact()
				- block.getExecutedqty().intValueExact();
		//System.out.println("total" + block.getTotalqty());
		//System.out.println("exe" + block.getExecutedqty());
		securitiesToBeExecuted = randInt(1, remainingQuantity);
		//System.out.println("securities to be" + securitiesToBeExecuted);
		int lastTradedPrice = block.getSecurity().getLasttradeprice()
				.intValue();

		int maxPriceSpread = block.getSecurity().getSecurityConfigMapping()
				.getConfigurationInfo().getMaxpricespread().intValueExact();

		//System.out.println("maxpricespread " + maxPriceSpread);
		//executiondao.saveE(execution);//delete
		priceSpread = randInt(0, maxPriceSpread) * lastTradedPrice;
		int p1 = lastTradedPrice - priceSpread / 100;
		int p2 = lastTradedPrice + priceSpread / 100;
		//System.out.println("lasttraded price " + lastTradedPrice);
		//System.out.println("p1 and p2" + p1 + " " + p2);
		int marketPrice = randInt(p1, p2);
		//System.out.println("market price " + marketPrice);
		//System.out.println("works fine");
		//execution.setBlock(block);
		//block.addExecution(execution);
		execution.setPrice(new BigDecimal(marketPrice));
		execution.setQty(new BigDecimal(securitiesToBeExecuted));
		execution.setTimeofexecution(new Timestamp(new Date().getTime()));
		//executiondao.saveE(execution);

		//System.out.println("works fine1");
		//block.getExecutions().add(execution);
		block.setExecutedqty(block.getExecutedqty().add(
				new BigDecimal(securitiesToBeExecuted)));
		//System.out.println("works fine2");
		block.setTimeexecuted(new Timestamp(new Date().getTime()));
		//block.getSecurity().setLasttradeprice(new BigDecimal(marketPrice));//updation of security last traded price
		//System.out.println("works fine3");
		//securitydao.saveS(securitydao.findById(new Security(), block.getSecurity().getSecuritysymbol()));
		/*//System.out.println("last tradede price from block"
				+ block.getSecurity().getLasttradeprice());*/
		
		
		////System.out.println("exe in blocks " + block.getExecutions());
		//block.addExecution(execution);
		// block.setExecutions(executions);
		
		
		//System.out.println("block details####");
		//System.out.println(block.getBlockid());
		//System.out.println(block.getSide());
		//System.out.println(block.getExecutedqty());
		//System.out.println(block.getExecutions());
		//System.out.println(block.getLimitprice());
		//System.out.println(block.getSecurity().getSecurityname());
		//System.out.println(block.getStopprice());
		//System.out.println(block.getTimeexecuted());
		//System.out.println(block.getTimereceived());
		//System.out.println(block.getTotalqty());
		////System.out.println( "execute market block blockdao "+blockdao);
		
		//System.out.println( "execute market block blockdao "+blockdao);
		//System.out.println(block.getSecurity().getSecurityname());
		Security sec =securityDAO.findByIdS(block.getSecurity().getSecuritysymbol()); 
		//System.out.println("sec "+sec.getSecurityname());
          sec.setLasttradeprice(new BigDecimal(marketPrice));
          //System.out.println("last traded sec "+sec.getLasttradeprice());
          securityDAO.updateS(sec);
		execution.setBlock(block);
		block.getExecutions().add(execution);
		
		//System.out.println("block details #######");
		//System.out.println(execution.getExecutionid());
		//System.out.println(execution.getBlock().getBlockid());
		//System.out.println(execution.getPrice());
		//System.out.println(execution.getQty());
		//System.out.println(execution.getTimeofexecution());
		
		
		// //System.out.println("execution details "+execution.getQty());

		//System.out.println("works fine4");
		if (block.getExecutedqty().compareTo(block.getTotalqty()) == 0) {
			block.setStatus("FULLY EXECUTED");
		} else {
			block.setStatus("PARTIALLY EXECUTED");
		}

	}

	public void executeBuyLimit(Block block, Execution execution) {
		//System.out.println("in limit buy block");
		int remainingQuantity = block.getTotalqty().intValueExact()
				- block.getExecutedqty().intValueExact();
		//System.out.println("total" + block.getTotalqty());
		//System.out.println("exe" + block.getExecutedqty());
		securitiesToBeExecuted = randInt(1, remainingQuantity);

		int lastTradedPrice = block.getSecurity().getLasttradeprice()
				.intValue();

		int maxPriceSpread = block.getSecurity().getSecurityConfigMapping()
				.getConfigurationInfo().getMaxpricespread().intValueExact();
//System.out.println("maxspread "+maxPriceSpread);
		priceSpread = randInt(0, maxPriceSpread)* lastTradedPrice ;
		//System.out.println("pricespread "+priceSpread);
		// int p1 = lastTradedPrice - priceSpread / 100;
		int p1 = block.getLimitprice().intValueExact();
		int p2 = lastTradedPrice + priceSpread / 100;
		
		//System.out.println("p1 and p2" + p1 + " " + p2);
		int marketPrice = randInt(p1, p2);
//System.out.println("market price "+p1+p2);
		//System.out.println("works fine");
		//execution.setBlock(block);
		execution.setPrice(new BigDecimal(marketPrice));
		execution.setQty(new BigDecimal(securitiesToBeExecuted));
		execution.setTimeofexecution(new Timestamp(new Date().getTime()));

		block.setExecutedqty(block.getExecutedqty().add(
				new BigDecimal(securitiesToBeExecuted)));
		block.setTimeexecuted(new Timestamp(new Date().getTime()));
		block.getSecurity().setLasttradeprice(new BigDecimal(marketPrice));
		//block.getExecutions().add(execution);
		//System.out.println(block.getSecurity().getSecurityname());
		Security sec =securityDAO.findByIdS(block.getSecurity().getSecuritysymbol()); 
		//System.out.println("sec "+sec.getSecurityname());
          sec.setLasttradeprice(new BigDecimal(marketPrice));
          //System.out.println("last traded sec "+sec.getLasttradeprice());
          securityDAO.updateS(sec);
		execution.setBlock(block);
		block.getExecutions().add(execution);
		if (block.getExecutedqty().compareTo(block.getTotalqty()) == 0) {
			block.setStatus("FULLY EXECUTED");
		} else {
			block.setStatus("PARTIALLY EXECUTED");
		}

	}

	public void executeSellLimit(Block block, Execution execution) {
		//System.out.println("in limit sell block");
		int remainingQuantity = block.getTotalqty().intValueExact()
				- block.getExecutedqty().intValueExact();
		//System.out.println("total" + block.getTotalqty());
		//System.out.println("exe" + block.getExecutedqty());
		securitiesToBeExecuted = randInt(1, remainingQuantity);
//System.out.println("securities to be executed "+securitiesToBeExecuted);
		int lastTradedPrice = block.getSecurity().getLasttradeprice()
				.intValue();
//System.out.println("last traded price  "+lastTradedPrice);
		int maxPriceSpread = block.getSecurity().getSecurityConfigMapping()
				.getConfigurationInfo().getMaxpricespread().intValueExact();
//System.out.println("max price spread "+maxPriceSpread);
		priceSpread = randInt(0, maxPriceSpread) * lastTradedPrice;
		
		//System.out.println("price spread "+priceSpread);
		int p1 = lastTradedPrice - priceSpread / 100;
		int p2 = block.getLimitprice().intValueExact();
		// int p2 = lastTradedPrice + priceSpread / 100;
		//System.out.println("market price "+p1+p2);
		int marketPrice = randInt(p1, p2);
//System.out.println("market price "+marketPrice);
		//System.out.println("works fine");
		//execution.setBlock(block);
		execution.setPrice(new BigDecimal(marketPrice));
		execution.setQty(new BigDecimal(securitiesToBeExecuted));
		execution.setTimeofexecution(new Timestamp(new Date().getTime()));

		block.setExecutedqty(block.getExecutedqty().add(
				new BigDecimal(securitiesToBeExecuted)));
		block.setTimeexecuted(new Timestamp(new Date().getTime()));
		//block.getSecurity().setLasttradeprice(new BigDecimal(marketPrice));
		//System.out.println(block.getSecurity().getSecurityname());
		Security sec =securityDAO.findByIdS(block.getSecurity().getSecuritysymbol()); 
		//System.out.println("sec "+sec.getSecurityname());
          sec.setLasttradeprice(new BigDecimal(marketPrice));
          //System.out.println("last traded sec "+sec.getLasttradeprice());
          securityDAO.updateS(sec);
		//block.getExecutions().add(execution);
		execution.setBlock(block);
		block.getExecutions().add(execution);
		if (block.getExecutedqty().compareTo(block.getTotalqty()) == 0) {
			block.setStatus("FULLY EXECUTED");
		} else {
			block.setStatus("PARTIALLY EXECUTED");
		}

	}

	public static int randInt(int min, int max) {

		// NOTE: Usually this should be a field rather than a method
		// variable so that it is not re-seeded every call.

		Random rand = new Random();

		// nextInt is normally exclusive of the top value,
		// so add 1 to make it inclusive
		int randomNum = rand.nextInt(max - min + 1) + min;

		return randomNum;
	}


	public void run() {
		this.executeBlockAlgorithm();
		
	}


	public void setApplicationContext(ApplicationContext applicationContext)
			throws BeansException {
		//System.out.println(" ctx ->"+applicationContext);
		ctx = applicationContext;

		
	}

}
