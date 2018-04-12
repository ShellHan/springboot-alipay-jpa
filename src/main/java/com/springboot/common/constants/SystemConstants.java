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
	    String merchant_private_key = "";
		
		// 支付宝公钥,查看地址：https://openhome.alipay.com/platform/keyManage.htm 对应APPID下的支付宝公钥。
	    String alipay_public_key = "";

		// 服务器异步通知页面路径  需http://格式的完整路径，不能加?id=123这类自定义参数，必须外网可以正常访问
		String notify_url = "http://工程公网访问地址/alipay.trade.page.pay-JAVA-UTF-8/notify_url.jsp";

		// 页面跳转同步通知页面路径 需http://格式的完整路径，不能加?id=123这类自定义参数，必须外网可以正常访问
		String return_url = "http://工程公网访问地址/alipay.trade.page.pay-JAVA-UTF-8/return_url.jsp";

		// 签名方式
		String sign_type = "RSA2";
		
		// 字符编码格式
		String charset = "utf-8";
		
		// 支付宝网关
		String gatewayUrl = "https://openapi.alipaydev.com/gateway.do";
		
	}
	
}


