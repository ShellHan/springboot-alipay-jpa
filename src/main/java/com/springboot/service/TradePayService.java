package com.springboot.service;

import java.util.UUID;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alipay.api.AlipayApiException;
import com.alipay.api.AlipayClient;
import com.alipay.api.DefaultAlipayClient;
import com.alipay.api.domain.AlipayTradePagePayModel;
import com.alipay.api.request.AlipayTradePagePayRequest;
import com.springboot.common.constants.CommonParams;
import com.springboot.common.constants.SystemConstants;
import com.springboot.pojo.TradeEntity;
import com.springboot.repository.TradeRepository;

@Service
public class TradePayService {

	private static final Logger logger = LoggerFactory.getLogger(TradePayService.class);
	
	@Autowired
	private TradeRepository tradeRepository;
	
	public String tradePay(CommonParams comm){
		
		String result = null;
		
		//获得初始化的AlipayClient
		AlipayClient alipayClient = new DefaultAlipayClient(SystemConstants.AliPayConfig.gatewayUrl, SystemConstants.AliPayConfig.app_id, SystemConstants.AliPayConfig.merchant_private_key, "json", SystemConstants.AliPayConfig.charset, SystemConstants.AliPayConfig.alipay_public_key, SystemConstants.AliPayConfig.sign_type);
		
		//设置请求参数
		AlipayTradePagePayRequest alipayRequest = new AlipayTradePagePayRequest();
		alipayRequest.setReturnUrl(SystemConstants.AliPayConfig.return_url);
		alipayRequest.setNotifyUrl(SystemConstants.AliPayConfig.notify_url);
		
		
		//商户订单号，商户网站订单系统中唯一订单号，必填
		String out_trade_no = UUID.randomUUID().toString().replace("-", "").substring(0, 12);
		
		//付款金额，必填
		String total_amount = null; 
		String body = null;
		switch (comm.getProductId()) {
		case 1:
			total_amount = "9";
			body = "09元-请小贝喝杯奶茶";
			break;
		case 2:
			total_amount = "29";
			body = "29元-请小贝吃肯德基";
			break;
		case 3:
			total_amount = "49";
			body = "49元-请小贝吃顿饭";
			break;

		default:
			break;
		}
		//订单名称，必填
		String subject = body;
		//商品描述，可空
		
		
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
			logger.debug("调用 支付接口 返回信息：result:{}",result);
		} catch (AlipayApiException e) {
			logger.error("支付失败  tradePay 错误为：{}",e.getMessage());
		}
    	
    	TradeEntity tradeEntity = new TradeEntity();
    	
    	//插入返回结果
    	tradeEntity.setBody(body);
    	tradeEntity.setOutTradeNo(out_trade_no);
    	tradeEntity.setTotalAmount(total_amount);
    	tradeEntity.setNickName(comm.getNickName());
    	tradeEntity.setQq(comm.getQq());
    	tradeEntity.setSubject(subject);
    	tradeEntity.setWay(comm.getWay());
    	tradeEntity.setMessage(comm.getMessage());
    	
    	logger.debug("插入数据库数据为：tradeEntity：{}",tradeEntity);
    	
    	//保存到数据库
    	tradeRepository.save(tradeEntity);
    	
    	return result;
	}
	
	
	
}
