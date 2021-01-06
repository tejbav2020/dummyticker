package com.redhat.springboot.stocktickerdemo;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface StockExchangeValueRepository extends 
    JpaRepository<StockExchangeValue, Long>{
	
	
	
  StockExchangeValue findByScript(String script);
  
  List<StockExchangeValue> findAll();
}