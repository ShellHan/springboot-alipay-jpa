package com.springboot.controller;

import java.util.List;

import javax.websocket.server.PathParam;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.fastjson.JSONObject;
import com.springboot.common.constants.ResultDTO;
import com.springboot.pojo.TradeEntity;
import com.springboot.pojo.TradeRefundEntity;
import com.springboot.service.TradeCloseService;
import com.springboot.service.TradePayQueryService;
import com.springboot.service.TradePayService;
import com.springboot.service.TradeRefundQueryService;
import com.springboot.service.TradeRefundServie;

@RestController
@RequestMapping("/alipay")
public class AliPayController {
	
	private static final  Logger LOGGER = LoggerFactory.getLogger(AliPayController.class);
	
	@Autowired
	private TradeCloseService tradeCloseService;
	@Autowired
	private TradePayQueryService tradePayQueryService;
	@Autowired
	private TradePayService tradePayService;
	@Autowired
	private TradeRefundQueryService tradeRefundQueryService;
	@Autowired
	private TradeRefundServie tradeRefundServie;
	
	@RequestMapping(value = "/tradePay" , method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
	@ResponseBody
	public ResultDTO<String> tradePay(TradeEntity trade) {
		
		String data = tradePayService.tradePay(trade);
		
		 ResultDTO<String> result = new ResultDTO<>();
		 result.setData(data);
		 result.setErrorCode("88888888");
		 result.setStatus("200");
		 result.setMsg("success");
		
		return result;
		
	}
	
	@RequestMapping(value = "/tradePayQuery" , method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
	@ResponseBody
	public ResultDTO<String> tradePayQuery(@RequestParam String outTradeNo ,@RequestParam String tradeNo) {
		
		 String data = tradePayQueryService.tradePayQuery(outTradeNo, tradeNo);
		
		 ResultDTO<String> result = new ResultDTO<>();
		 result.setData(data);
		 result.setErrorCode("88888888");
		 result.setStatus("200");
		 result.setMsg("success");
		
		return result;
		
	}
	
	
	@RequestMapping(value = "/tradeClose" , method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
	@ResponseBody
	public ResultDTO<String> tradeClose(@RequestParam String outTradeNo ,@RequestParam String tradeNo) {
		
		 String data = tradeCloseService.tradeClose(outTradeNo, tradeNo);
		
		 ResultDTO<String> result = new ResultDTO<>();
		 result.setData(data);
		 result.setErrorCode("88888888");
		 result.setStatus("200");
		 result.setMsg("success");
		
		return result;
		
	}
	
	@RequestMapping(value = "/tradeRefund" , method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
	@ResponseBody
	public ResultDTO<String> tradeRefund(TradeRefundEntity refund) {
		
		 String data = tradeRefundServie.tradeRefund(refund);
		
		 ResultDTO<String> result = new ResultDTO<>();
		 result.setData(data);
		 result.setErrorCode("88888888");
		 result.setStatus("200");
		 result.setMsg("success");
		
		return result;
		
	}
	
	@RequestMapping(value = "/tradeRefundQuery" , method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
	@ResponseBody
	public ResultDTO<String> tradeRefundQuery(@RequestParam String outTradeNo ,@RequestParam String tradeNo,String outRequestNo) {
		
		 String data = tradeRefundQueryService.refundQuery(outTradeNo, tradeNo, outRequestNo);
		
		 ResultDTO<String> result = new ResultDTO<>();
		 result.setData(data);
		 result.setErrorCode("88888888");
		 result.setStatus("200");
		 result.setMsg("success");
		
		return result;
		
	}
	
	@RequestMapping("/getTradeAll")
	@ResponseBody
	public ResultDTO<String> getTradeAll(){
		 List<TradeEntity> allTrade = tradePayQueryService.getAllTrade();
		 ResultDTO<String> result = new ResultDTO<>();
		 String data = JSONObject.toJSON(allTrade).toString();
		 result.setData(data);
		 result.setErrorCode("88888888");
		 result.setStatus("200");
		 result.setMsg("success");
		 
		 return result;
	}
	
}
