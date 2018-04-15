/**
 * 
 */
package com.springboot.common.constants;

/**
* @description: 
* @author: hanbei
* @date 创建时间：2018年3月12日
* @version 1.0 
*/

public class SystemConstants {
	
	/**
	 * 系统常量
	 */
	public interface System {
		int CODE_TIMEOUT = 1800; // session超时时间
		int REDIS_LOCK_EXPIRE =5;//redis 锁超时5秒钟
		int REDIS_LOCK_KEY_TIME =10;//redis 锁key值的时间
		int REDIS_LOCK_WAIT_TIME =30;//redis 锁等待最大时间15秒钟
		long DEFAULT_ACQUIRY_RESOLUTION_MILLIS=200;//redis 锁 等待时频率毫秒
		long NO_RESULT_VALUE = -9999L;
		String SYSTEM_NAME="spring_boot";
		String PRODUCT_TYPE="spring";
	}
	
	public interface AliPayConfig {
		
		// 应用ID,您的APPID，收款账号既是您的APPID对应支付宝账号
		String app_id = "2016091000482326";
		
		// 商户私钥，您的PKCS8格式RSA2私钥
	    String merchant_private_key = "MIIEvQIBADANBgkqhkiG9w0BAQEFAASCBKcwggSjAgEAAoIBAQCcv2vBpOp71VVWVdZZtxV7WEyYHtn2kyEIeN4GDiZdZq1vRHWBOnjNO+RFX2DmDcU14p/7VZOIwA2g1p/C3u0XMMlrJLRlFicQp4ZiJnzpBmbFILBREKzRQFo04fUfYskFXNiuzRaejMi7vfWjJst+vNGb5p9Qqei35dBxMwoN/arkr6wns42VCttlZB8PflQuW+HR2/R4UE1YRDa9Crm8/GgtQF5qqAGXVR1LImcR5nSMQnyLuoZQOPVNlG0lOWQwbM27AzKguQuSkJO6SPlE6DUM0zlwU9RXOtyk2sXSHt8NjUQnwebArW9oBi/byjH6lESue6i4VJzsQnjg0N9lAgMBAAECggEAJJ1+gWyRrb2mwpUojip7ZSW6Nqq2RagWxlDdpFJ32cebaet2+2n6QA7mguIF05eR4sV+k4po/T/HrzOTfETw40LtOg8H6LklBPntJU5STWjGZvP82+LmS7cZm1LRHLTJumv23dZgm0bNuTVlhOgSDxfyatWTj5cxGowfheHjTmL9G4YQ5ZDa3VB++c3UMnUwDODZBwCV05jslfICp8H33ZfEeBfaDDnQHWEm0oPBDTlxDPqtMzoML0hxaQCfMYyxDzej72ICkZN07tMNgSib5c4t2BvlG71ctRS9LHQog+n6UUFTxSlO6vkRXZf+AabyyHWdHof7I8n9+t5TAdiF4QKBgQDuntWhhAzyVWj4neqCVoBhfE2cYIBTG+zu5VVKOjWa2r1GIjEqs3KYyFMGuXRJAQEOxHjjhUw4qNENldOb+Cc4fAC4no+08/WiscG7Kk9+w2eUIZ3Leole+JAcct/P47Ri9HsEERufYFoh5IQzMod+m6sex5IZTJh4Ft7RVXFGHQKBgQCoKgoxxny+XMGi7cnyEWEJBL+pbWJwaXgVrRmOL2DbiL0mfl7H0qKmV9MctjEXx2CJAc0jzd9OFUsqMqCXFI7kL3xeCUWOTbsOikmhqPBY53CMNj7bckeZkOBTC9kh17LwKapntj6qs41OcGewjDcBLBoiZ5aBsh3OKi6yhy8b6QKBgQCUhwdgjspkOOerANiMon0ssOu6L5MQqCw1k0ggeNUO+6Keuf+ynZnyIZcUc3E/U8GtyHua20jTZ7kgZKcfyTnYfc8RG5lFwCigSVbWQoLS25xoZvhKRI6nL768BoDrbMfGZHkB0ghIjvfrassi9wvBsfG0qfJ1jujEry+oSy/DvQKBgC6B+fHMMEHBi3gRBZHiBpEk9BDahKgMMz7jcbbmGYZ9qbpUpsfi1ELm9SbyqF8oL+WUTvTBAiopL3GLMOi3sdEf5Oho7giuLLaXvkdsXpRn5bORaQ7t6ylobPHqy/FVI1LSYyNtvqUdJU51PegQz0GOveeX+IMEDMQw3FtZkcjJAoGAN/D/7vb5RIkx1u974cbdyDaZ+S0soobeDuABE9idh3wxMDtPJu8Ku9cAnQTslmeMqkb+cZ7Ltv1VnvKm2pCQbi0AXbggqJ06apYM+N5BpewQjEmF1z7vWkgY2TXzuz17xjs3n1FTFv/jTnzqv363OldDZr81nHqL+8LlMkKJYkM=";
		
		// 支付宝公钥,查看地址：https://openhome.alipay.com/platform/keyManage.htm 对应APPID下的支付宝公钥。
	    String alipay_public_key = "MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEA422UlEWlLqNj/b8F0FxkOSg6Tb2R+YTvokX5FHuR72ZjMWHf9lyJwTQ3v4yOFv6r37sq4GEWFs1OPiYU2x5qNDvY3pqBB/37biEufvYS6qN69TDC5Pdelh8Q5eGv/tPm8Nux20g9fGL7BLG7FFbVDmxQThJRuE7WRa6IwDr33C26NZOJVGKR3B1QTc9QmN+Dd99w6X6KHjQBAGLBcqb5Eaic02vzSI8Lhg45hYUpFi77Z4wE7AopV8xJUb2OFp3ZEbNoGUMgiNBkwStjdT9afkALDscTTVnZH+842EeseET8pK8NLdG/Uj2PKNqyBsLbSsv1owKOXijrEPhMC3CVbwIDAQAB";

		// 服务器异步通知页面路径  需http://格式的完整路径，不能加?id=123这类自定义参数，必须外网可以正常访问
		String notify_url = "http://工程公网访问地址/alipay.trade.page.pay-JAVA-UTF-8/notify_url.jsp";

		// 页面跳转同步通知页面路径 需http://格式的完整路径，不能加?id=123这类自定义参数，必须外网可以正常访问
		String return_url = "http://47.100.63.21:8080/pay/alipay/alipayRet";

		// 签名方式
		String sign_type = "RSA2";
		
		// 字符编码格式
		String charset = "utf-8";
		
		// 支付宝网关
		String gatewayUrl = "https://openapi.alipaydev.com/gateway.do";
		
	}
	
}


