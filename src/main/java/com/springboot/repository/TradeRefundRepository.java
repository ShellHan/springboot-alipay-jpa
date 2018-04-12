package com.springboot.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.springboot.pojo.TradeRefundEntity;

@Repository("tradeRefundRepository")
public interface TradeRefundRepository extends JpaRepository<TradeRefundEntity, Integer>{
	
}
