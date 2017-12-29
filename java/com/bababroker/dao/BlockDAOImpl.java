package com.bababroker.dao;

import java.util.List;









import javax.persistence.EntityManager;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.bababroker.model.Block;


@Repository
public class BlockDAOImpl extends
		GenericDAOImpl<Block, Long>  implements BlockDAO{

	
	public BlockDAOImpl() {
		super(Block.class);
		// TODO Auto-generated constructor stub
	}

	@Transactional
	public Block saveB(Block block) {
		
		return super.save(block);
	}

	@Transactional
	public void updateB(Block block) {
		super.update(block);
		
	}


	@Transactional
	public List<Block> findAllB(Block block) {
		// TODO Auto-generated method stub
		return super.findAll();
	}

	@Transactional
	public void deleteB(Block block) {
		super.delete(block);
		
	}
	@Transactional
	public Block findByIdB(Long id) {
		// TODO Auto-generated method stub
		return super.findById(id);
	}
	@Transactional
	public List<Block> getStatusBlock(String status) {
		
		/*Query query = this.getEm().createQuery("select e from "
				+ this.getpersistentClass().getName()+" as e where e.status="+"'"+status+"'");*/
		Query query = this.getEm().createQuery("select e from Block as e where e.status="+"'"+status+"'");
		return query.getResultList();
	}




	

		
		
	


}

