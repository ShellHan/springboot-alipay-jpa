package com.springboot.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alipay.api.AlipayApiException;
import com.alipay.api.AlipayClient;
import com.alipay.api.DefaultAlipayClient;
import com.alipay.api.domain.AlipayTradePagePayModel;
import com.alipay.api.request.AlipayTradePagePayRequest;
import com.springboot.common.constants.SystemConstants;
import com.springboot.pojo.TradeEntity;
import com.springboot.repository.TradeRepository;

@Service
public class TradePayService {

	private static final Logger logger = LoggerFactory.getLogger(TradePayService.class);
	
	@Autowired
	private TradeRepository tradeRepository;
	
	public String tradePay(TradeEntity tradeEntity){
		
		String result = null;
		
		//获得初始化的AlipayClient
		AlipayClient alipayClient = new DefaultAlipayClient(SystemConstants.AliPayConfig.gatewayUrl, SystemConstants.AliPayConfig.app_id, SystemConstants.AliPayConfig.merchant_private_key, "json", SystemConstants.AliPayConfig.charset, SystemConstants.AliPayConfig.alipay_public_key, SystemConstants.AliPayConfig.sign_type);
		
		//设置请求参数
		AlipayTradePagePayRequest alipayRequest = new AlipayTradePagePayRequest();
		alipayRequest.setReturnUrl(SystemConstants.AliPayConfig.return_url);
		alipayRequest.setNotifyUrl(SystemConstants.AliPayConfig.notify_url);
		
		//商户订单号，商户网站订单系统中唯一订单号，必填
		String out_trade_no = tradeEntity.getOutTradeNo();
		//付款金额，必填
		String total_amount = tradeEntity.getTotalAmount(); 
		//订单名称，必填
		String subject = tradeEntity.getSubject();
		//商品描述，可空
		String body = tradeEntity.getBody();
		
		AlipayTradePagePayModel model=new AlipayTradePagePayModel();
        model.setOutTradeNo(out_trade_no);
        model.setSubject(subject);
        model.setTotalAmount(total_amount);
        model.setBody(body);
        model.setTimeoutExpress("");
        // 销售产品码 必填 立即到账
        model.setProductCode("FAST_INSTANT_TRADE_PAY");
        alipayRequest.setBizModel(model);
		
        //请求
    	try {
			result = alipayClient.pageExecute(alipayRequest).getBody();
			logger.info("调用 支付接口 返回信息：result:{}",result);
		} catch (AlipayApiException e) {
			logger.error("支付失败  tradePay 错误为：{}",e.getMessage());
		}
    	
    	//插入返回结果
    	tradeEntity.setResult(result);
    	//保存到数据库
    	tradeRepository.save(tradeEntity);
    	
    	return result;
	}
	
}
