package com.springboot.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.springboot.pojo.TradeEntity;

@Repository("tradeRepository")
public interface TradeRepository extends JpaRepository<TradeEntity, Integer>{
	
}
