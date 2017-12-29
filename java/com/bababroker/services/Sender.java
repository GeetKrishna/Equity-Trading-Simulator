package com.bababroker.services;

import java.io.StringWriter;
import java.util.List;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.Session;
import javax.naming.NamingException;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.core.MessageCreator;
import org.springframework.stereotype.Component;



import com.bababroker.model.Block;
import com.bababroker.testjms.JmsBlock;







@Component("sender")
public class Sender {

	@Autowired
	private JmsTemplate jmsTemplate;

	/*public void setJmsTemplate(JmsTemplate jmsTemplate) {
		this.jmsTemplate = jmsTemplate;
	}*/

	public boolean sendToJMS(JmsBlock resultList) throws JMSException,
			NamingException, JAXBException {

		final JAXBContext jaxbContext = JAXBContext
				.newInstance(JmsBlock.class);
		StringWriter writer = new StringWriter();
		/*BlockPojo a= null;
		BlockListPojo lister = new BlockListPojo();
		lister.setBlock(resultList);*/
		
		jaxbContext.createMarshaller().marshal(resultList, writer);
			final String msgToSend = writer.toString();
			System.out.println(msgToSend);
			System.out.println(jmsTemplate);
			jmsTemplate.send(new MessageCreator() {
				public Message createMessage(Session session)
						throws JMSException {
					//System.out.println(msgToSend);
					return session.createObjectMessage(msgToSend);
				}
			});
		
			  
		return true;

	}

}
