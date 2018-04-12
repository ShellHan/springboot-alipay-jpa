package com.springboot.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.alipay.api.AlipayApiException;
import com.alipay.api.AlipayClient;
import com.alipay.api.DefaultAlipayClient;
import com.alipay.api.domain.AlipayTradeFastpayRefundQueryModel;
import com.alipay.api.request.AlipayTradeFastpayRefundQueryRequest;
import com.springboot.common.constants.SystemConstants;

@Service
public class TradeRefundQueryService {

	private static final Logger logger = LoggerFactory.getLogger(TradeRefundQueryService.class);
	
	public String refundQuery(String outTradeNo,String tradeNo,String outRequestNo){
		
		String result = null;
		
		//获得初始化的AlipayClient
		AlipayClient alipayClient = new DefaultAlipayClient(SystemConstants.AliPayConfig.gatewayUrl, SystemConstants.AliPayConfig.app_id, SystemConstants.AliPayConfig.merchant_private_key, "json", SystemConstants.AliPayConfig.charset, SystemConstants.AliPayConfig.alipay_public_key, SystemConstants.AliPayConfig.sign_type);
			
		//设置请求参数
		AlipayTradeFastpayRefundQueryRequest alipayRequest = new AlipayTradeFastpayRefundQueryRequest();
		
		AlipayTradeFastpayRefundQueryModel model = new AlipayTradeFastpayRefundQueryModel();
		model.setOutRequestNo(outRequestNo);
		model.setOutTradeNo(outTradeNo);
		model.setTradeNo(tradeNo);
		
		alipayRequest.setBizModel(model);
		//请求
		try {
			result = alipayClient.execute(alipayRequest).getBody();
		} catch (AlipayApiException e) {
			logger.error("还款查询失败  TradeRefund 错误为：{}",e.getMessage());
		}
		
		return result;
		
	}
	
}
