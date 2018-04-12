package com.springboot.pojo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;
import lombok.ToString;

@Data
@ToString
@Table(name = "trade_refund")
@Entity
public class TradeRefundEntity {

	@Id
	@GeneratedValue
	private Integer id;
	//商户订单号，商户网站订单系统中唯一订单号
	private String outTradeNo;
	//支付宝交易号
	private String tradeNo;
	//请二选一设置
	//需要退款的金额，该金额不能大于订单金额，必填
	private String refundAmount;
	//退款的原因说明
	private String refundReason;
	//标识一次退款请求，同一笔交易多次退款需要保证唯一，如需部分退款，则此参数必传
	private String outRequestNo;
	
	
}
