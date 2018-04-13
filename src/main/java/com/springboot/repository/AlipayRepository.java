package com.springboot.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.springboot.pojo.AlipayEntity;

@Repository("alipayRepository")
public interface AlipayRepository extends JpaRepository<AlipayEntity, Integer>{
	
}
