package com.redhat.springboot.stocktickerdemo;
import java.math.BigDecimal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ForexController {
  

  
  @Autowired
  private StockExchangeValueRepository repository;
  
  @GetMapping("/stock-exchange/script/{script}")
  public StockExchangeValue retrieveExchangeValue(@PathVariable String script) {
    
    StockExchangeValue exchangeValue = 
        repository.findByScript(script);
    
    return exchangeValue;
  }
  
  
  @GetMapping("/stock-exchange/scripts")
  public List<StockExchangeValue> retrieveExchangeValue() {
    
    List<StockExchangeValue> exchangeValue = 
        repository.findAll();
    
    return exchangeValue;
  }
  
  @PostMapping(value="/stock-exchange/create/script", consumes = MediaType.APPLICATION_JSON_VALUE)
  public StockExchangeValue create(@RequestBody StockExchangeValue body) {
    
	  String script = body.getScript();
	  BigDecimal high = body.getHigh();
	  BigDecimal low = body.getLow();
	  BigDecimal current = body.getCurrent();
	  StockExchangeValue sev = new StockExchangeValue(script, high, low, current);
      repository.save(sev);
      
      return sev;     
      
  } 
}