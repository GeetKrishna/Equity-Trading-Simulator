package com.bababroker.client;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.bababroker.dao.BlockDAO;
import com.bababroker.dao.BlockDAOImpl;
import com.bababroker.model.Block;
import com.bababroker.services.ExecutionServices;

public class TestExecutionClient1 {

	@Autowired
	private static ExecutionServices exe;
	public static void main(String[] args) {
		/*BlockDAO<Block, Long> blockDAO = new BlockDAOImpl<Block, Long>(
				JPATemplate.getEntityManager(), Block.class);*/
		
		//exe.startExecution();
		/*BlockDAO<Block, Long> blockDAO = new BlockDAOImpl<Block, Long>(
				JPATemplate.getEntityManager(), Block.class);
		List<Block> blocks= new ArrayList<Block>();
		
		blocks.addAll(blockDAO.getStatusBlock("Partially Executed"));
		System.out.println(blocks);*/
	}

}
