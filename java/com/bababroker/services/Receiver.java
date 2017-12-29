package com.bababroker.services;

import java.io.File;
import java.io.IOException;
import java.io.Reader;
import java.io.StringReader;
import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.Date;

import javax.jms.JMSException;
import javax.naming.NamingException;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.w3c.dom.Document;
import org.xml.sax.SAXException;

import com.bababroker.dao.BlockDAO;
import com.bababroker.dao.SecurityDAO;
import com.bababroker.dao.UserDAO;
import com.bababroker.model.Block;
import com.bababroker.testjms.JmsBlock;




@Component("receiver")
public class Receiver {

	@Autowired
	private BlockDAO blockDAO;
	
	@Autowired
	private SecurityDAO securityDAO;
	//@Autowired
	//ExecutionBlockService executionBlockService;

	//@Autowired
	//AutoAllocationService autoAllocationService;

	public void receiveMessage(Object messageObject) {
		System.out.println("Hello inside new recieve Message"
				+ (String) messageObject + " MESSAGE ENDS HERE");

		Reader reader = new StringReader((String) messageObject);

		
		JAXBContext jaxbContext;
		try {
			//Document doc = null;
			jaxbContext = JAXBContext.newInstance(JmsBlock.class);

			/*
			DocumentBuilderFactory docBuilderFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder docBuilder;
			try {
				docBuilder = docBuilderFactory.newDocumentBuilder();
				 doc = docBuilder.parse (new File("reader"));
			} catch (SAXException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}catch (ParserConfigurationException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			doc.getDocumentElement ().normalize ();
			System.out.println ("Root element of the doc is " + doc.getDocumentElement().getNodeName());
			*/
			JmsBlock block = (JmsBlock) jaxbContext
					.createUnmarshaller().unmarshal(reader);
			
			
		//	executionBlockService.executeRecieverBlocks(block);
		//	for(ExecutionBlockPojo exp:block.getBlock()){
//			System.out.println("Result List is " + block.getStatus());
//			System.out.println("Result List is " + block.getBlockid());
//			System.out.println("Result List is " + block.getSide());
//			System.out.println("Result List is " + block.getInitialqty());
//			System.out.println("Result List is " + block.getSymbol());   
//			System.out.println("In Block Receiver before autoallocate");
		//block.setTimereceived(new Timestamp(new Date().getTime()));
		//	block.setSecurity(securityDAO.findById("GOOG"));
			
			Block b = new Block();
			b.setExecutedqty(new BigDecimal(0));
			b.setLimitprice(block.getAvglimitprice());
			b.setBlockid(block.getBlockid());
			b.setSecurity(securityDAO.findById(block.getSymbol()));
			b.setSide(block.getSide());
			b.setStatus("NEW");
			b.setStopprice(block.getAvgstopprice());
			b.setTimeexecuted(new Timestamp(new Date().getTime()));
			b.setTimereceived(new Timestamp(new Date().getTime()));
			b.setTotalqty(block.getInitialqty());
			//b.getSecurity().getBlocks().add(b);
			
			//System.out.println(securityDAO);
			blockDAO.saveB(b);
			//securityDAO.updateS(b.getSecurity());
			
			//autoAllocationService.autoAllocate(block);
		} catch (JAXBException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
