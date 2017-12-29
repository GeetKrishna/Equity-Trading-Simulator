package com.bababroker.dao;

import java.util.List;

import com.bababroker.model.Block;



public interface BlockDAO extends
GenericDAO<Block, Long> {
	public List<Block> getStatusBlock(String status);
	Block saveB(Block block);
	void updateB(Block block);
	Block findByIdB(Long id);
	List<Block> findAllB(Block block);
	void deleteB(Block block);
}
