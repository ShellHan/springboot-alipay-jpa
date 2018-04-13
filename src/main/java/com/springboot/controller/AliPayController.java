package com.springboot.controller;

import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSONObject;
import com.alipay.api.AlipayApiException;
import com.alipay.api.internal.util.AlipaySignature;
import com.springboot.common.constants.AlipayDto;
import com.springboot.common.constants.CommonParams;
import com.springboot.common.constants.ResultDTO;
import com.springboot.common.constants.SystemConstants;
import com.springboot.pojo.AlipayEntity;
import com.springboot.pojo.TradeEntity;
import com.springboot.pojo.TradeRefundEntity;
import com.springboot.repository.AlipayRepository;
import com.springboot.service.TradeCloseService;
import com.springboot.service.TradePayQueryService;
import com.springboot.service.TradePayService;
import com.springboot.service.TradeRefundQueryService;
import com.springboot.service.TradeRefundServie;

@Controller
@RequestMapping("/alipay")
public class AliPayController {

	private static final Logger LOGGER = LoggerFactory.getLogger(AliPayController.class);


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
	@Autowired
	private AlipayRepository alipayRepository;

	@RequestMapping(value = "/tradePay")
	public String tradePay(CommonParams comm, Map<String, Object> map) {
		String result = tradePayService.tradePay(comm);
		map.put("result", result);
		return "alipay";
	}

	@RequestMapping(value = "/tradePayQuery", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
	@ResponseBody
	public ResultDTO<String> tradePayQuery(@RequestParam String outTradeNo, @RequestParam String tradeNo) {

		String data = tradePayQueryService.tradePayQuery(outTradeNo, tradeNo);

		ResultDTO<String> result = new ResultDTO<>();
		result.setData(data);
		result.setErrorCode("88888888");
		result.setStatus("200");
		result.setMsg("success");

		return result;

	}

	@RequestMapping(value = "/tradeClose", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
	@ResponseBody
	public ResultDTO<String> tradeClose(@RequestParam String outTradeNo, @RequestParam String tradeNo) {

		String data = tradeCloseService.tradeClose(outTradeNo, tradeNo);

		ResultDTO<String> result = new ResultDTO<>();
		result.setData(data);
		result.setErrorCode("88888888");
		result.setStatus("200");
		result.setMsg("success");

		return result;

	}

	@RequestMapping(value = "/tradeRefund", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
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

	@RequestMapping(value = "/tradeRefundQuery", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
	@ResponseBody
	public ResultDTO<String> tradeRefundQuery(@RequestParam String outTradeNo, @RequestParam String tradeNo,
			String outRequestNo) {

		String data = tradeRefundQueryService.refundQuery(outTradeNo, tradeNo, outRequestNo);

		ResultDTO<String> result = new ResultDTO<>();
		result.setData(data);
		result.setErrorCode("88888888");
		result.setStatus("200");
		result.setMsg("success");

		return result;

	}

	@RequestMapping(value = "/list")
	public String getList(AlipayDto alipayDto) {

		Map<String, String> params = new HashMap<String, String>();
		params.put("total_amount", alipayDto.getTotal_amount());
		params.put("timestamp", alipayDto.getTimestamp());
		params.put("sign", alipayDto.getSign());
		params.put("trade_no", alipayDto.getTrade_no());
		params.put("sign_type", alipayDto.getSign_type());
		params.put("auth_app_id", alipayDto.getAuth_app_id());
		params.put("charset", alipayDto.getCharset());
		params.put("seller_id", alipayDto.getSeller_id());
		params.put("method", alipayDto.getMethod());
		params.put("app_id", alipayDto.getApp_id());
		params.put("out_trade_no", alipayDto.getOut_trade_no());
		params.put("version", alipayDto.getVersion());
		
		boolean signVerified = false;
		try {
			signVerified = AlipaySignature.rsaCheckV1(params, SystemConstants.AliPayConfig.alipay_public_key,SystemConstants.AliPayConfig.charset, SystemConstants.AliPayConfig.sign_type);
		} catch (AlipayApiException e) {
			LOGGER.info("验签失败:{}",e.getMessage());
		} // 调用SDK验证签名

		AlipayEntity alipayEntity = new AlipayEntity();
		alipayEntity.setTotalAmount(alipayDto.getTotal_amount());
		alipayEntity.setTimestamp(alipayDto.getTimestamp());
		alipayEntity.setSign(alipayDto.getSign());
		alipayEntity.setTradeNo(alipayDto.getTrade_no());
		alipayEntity.setSignType(alipayDto.getSign_type());
		alipayEntity.setAuthAppId(alipayDto.getAuth_app_id());
		alipayEntity.setCharset(alipayDto.getCharset());
		alipayEntity.setSellerId(alipayDto.getSeller_id());
		alipayEntity.setMethod(alipayDto.getMethod());
		alipayEntity.setAppId(alipayDto.getApp_id());
		alipayEntity.setOutTradeNo(alipayDto.getOut_trade_no());
		alipayEntity.setVersion(alipayDto.getVersion());
		
		// ——请在这里编写您的程序（以下代码仅作参考）——
		if (signVerified) {
			alipayRepository.save(alipayEntity);
		}
		
		return "list";
	}

	@RequestMapping("/getTradeAll")
	@ResponseBody
	public Map<String, Object> getTradeAll() {

		List<TradeEntity> allTrade = tradePayQueryService.getAllTrade();

		Map<String, Object> result = new HashMap<>();
		result.put("code", 0);
		result.put("msg", "");
		result.put("count", allTrade.size());
		result.put("data", allTrade);

		return result;
	}

}
