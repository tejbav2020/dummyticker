package com.redhat.springboot.stocktickerdemo;
import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class StockExchangeValue {
  
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Long id;
  
  @Column(name="script")
  private String script;
  
  private BigDecimal high;
  private BigDecimal low;
  private BigDecimal current;
  
  public StockExchangeValue() {
    
  }
  

  public StockExchangeValue(String script, BigDecimal high, BigDecimal low, BigDecimal current) {
    super();
    this.id = id;
    this.script = script;
    this.high = high;
    this.low = low;
    this.current = current;
  }

  public Long getId() {
    return id;
  }

  public String getScript() {
    return script;
  }

  public BigDecimal getHigh() {
    return high;
  }

  public BigDecimal getLow() {
    return low;
  }
  
  public BigDecimal getCurrent() {
	    return current;
  }

}