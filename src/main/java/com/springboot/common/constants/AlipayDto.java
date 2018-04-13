package com.springboot.common.constants;

import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class AlipayDto {
	
	private String total_amount;
	private String timestamp;
	private String sign;
	private String trade_no;
	private String sign_type;
	private String auth_app_id;
	private String charset;
	private String seller_id;
	private String method;
	private String app_id;
	private String out_trade_no;
	private String version;
	
}
