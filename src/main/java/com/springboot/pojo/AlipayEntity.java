package com.springboot.pojo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;
import lombok.ToString;

@Data
@ToString
@Table(name = "alipay")
@Entity
public class AlipayEntity {
	
	@Id
	@GeneratedValue
	private Integer id;
	private String totalAmount;
	private String timestamp;
	private String sign;
	private String tradeNo;
	private String signType;
	private String authAppId;
	private String charset;
	private String sellerId;
	private String method;
	private String appId;
	private String outTradeNo;
	private String version;
	
}
