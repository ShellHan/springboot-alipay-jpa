package com.springboot.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.alipay.api.AlipayApiException;
import com.alipay.api.AlipayClient;
import com.alipay.api.DefaultAlipayClient;
import com.alipay.api.domain.AlipayTradeRefundModel;
import com.alipay.api.request.AlipayTradeRefundRequest;
import com.springboot.common.constants.SystemConstants;
import com.springboot.pojo.TradeRefundEntity;

@Service
public class TradeRefundServie {

	private static final Logger logger = LoggerFactory.getLogger(TradeRefundServie.class);
			
	public String tradeRefund (TradeRefundEntity refund){
		
		//获得初始化的AlipayClient
		AlipayClient alipayClient = new DefaultAlipayClient(SystemConstants.AliPayConfig.gatewayUrl, SystemConstants.AliPayConfig.app_id, SystemConstants.AliPayConfig.merchant_private_key, "json", SystemConstants.AliPayConfig.charset, SystemConstants.AliPayConfig.alipay_public_key, SystemConstants.AliPayConfig.sign_type);
					
		//设置请求参数
		AlipayTradeRefundRequest alipayRequest = new AlipayTradeRefundRequest();
		
		AlipayTradeRefundModel model = new AlipayTradeRefundModel();
		model.setOutTradeNo(refund.getOutTradeNo());
		model.setTradeNo(refund.getTradeNo());
		model.setRefundAmount(refund.getRefundAmount());
		model.setRefundReason(refund.getRefundReason());
		model.setOutRequestNo(refund.getOutRequestNo());;
		
		alipayRequest.setBizModel(model);
		
		//请求
		String result = null;
		try {
			result = alipayClient.execute(alipayRequest).getBody();
			logger.info("退款信息为：result：{}",result);
		} catch (AlipayApiException e) {
			logger.error("还款失败  TradeRefund 错误为：{}",e.getMessage());
		}

		//输出
		return result;
		
	}
	
}
