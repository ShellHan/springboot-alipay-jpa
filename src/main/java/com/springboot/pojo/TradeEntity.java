package com.springboot.pojo;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.data.annotation.CreatedDate;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Data;
import lombok.ToString;

/**
 * 交易实体类
 * @author hanbei
 *
 */
@Data
@ToString
@Table(name = "trade")
@Entity
public class TradeEntity {
	
	@Id
	@GeneratedValue
	private Integer id;
	private String outTradeNo;	//商户订单号，商户网站订单系统中唯一订单号，必填
	private String totalAmount;	//付款金额，必填
	private String subject;		//订单名称，必填
	private String body;		//商品描述，可空
	private String result; 		//返回结果
	private String nickName;
	private String qq;
	@JsonFormat(timezone = "GMT+8", pattern = "yyyy-MM-dd HH:mm:ss")
	private Date buyTime;
	private String way;
	private String message;
	
}
