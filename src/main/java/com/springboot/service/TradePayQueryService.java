package com.springboot.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alipay.api.AlipayApiException;
import com.alipay.api.AlipayClient;
import com.alipay.api.DefaultAlipayClient;
import com.alipay.api.domain.AlipayTradeQueryModel;
import com.alipay.api.request.AlipayTradeQueryRequest;
import com.springboot.common.constants.SystemConstants;
import com.springboot.pojo.TradeEntity;
import com.springboot.repository.TradeRepository;

@Service
public class TradePayQueryService {

	@Autowired
	private TradeRepository tradeRepository;
	
	private static final Logger logger = LoggerFactory.getLogger(TradePayQueryService.class);
	
	public String tradePayQuery(String outTradeNo,String tradeNo){
		
		String result = null; //返回结果
		
		//获得初始化的AlipayClient
		AlipayClient alipayClient = new DefaultAlipayClient(SystemConstants.AliPayConfig.gatewayUrl, SystemConstants.AliPayConfig.app_id, SystemConstants.AliPayConfig.merchant_private_key, "json", SystemConstants.AliPayConfig.charset, SystemConstants.AliPayConfig.alipay_public_key, SystemConstants.AliPayConfig.sign_type);
				
		//设置请求参数
		AlipayTradeQueryRequest alipayRequest = new AlipayTradeQueryRequest();
		
		AlipayTradeQueryModel model = new AlipayTradeQueryModel();
		model.setOutTradeNo(outTradeNo);
		model.setTradeNo(tradeNo);

		alipayRequest.setBizModel(model);
		
		//请求
		try {
			result = alipayClient.execute(alipayRequest).getBody();
			logger.info("查询结果为：result{}",result);
		} catch (AlipayApiException e) {
			logger.error("支付查询失败  tradePayQuery 错误为：{}",e.getMessage());
		}
		
		return result;
	}
	
	public List<TradeEntity> getAllTrade(){
		List<TradeEntity> findAll = tradeRepository.findAll();
		return findAll;
	}
	
}
