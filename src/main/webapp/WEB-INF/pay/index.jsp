<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path;
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<head>
<title>在线支付_韩小贝</title>
<meta name="keywords" content="在线支付案例，支付宝支付Demo">
<link rel="stylesheet" href="<%=basePath%>/layui/css/layui.css"/>
<meta name="description" content="一个Java实现的支付宝微信在线支付在线案例。">
<meta name="renderer" content="webkit">
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
<meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
<meta name="apple-mobile-web-app-status-bar-style" content="black"> 
<meta name="apple-mobile-web-app-capable" content="yes">
<meta name="format-detection" content="telephone=no">
</head>
</head>
<body>
<div class="layui-container">
	
<div class="layui-row">
    <div class="layui-col-xs12">
        	<ul class="layui-nav">
			  <li class="layui-nav-item"><a href="<%=basePath%>/index">在线支付</a></li>
			  <li class="layui-nav-item"><a href="<%=basePath%>/alipay/list">订单查询</a></li>
			  <li class="layui-nav-item"><a href="http://blog.java1234.com/blog/articles/388.html" target="_blank">跟着峰哥学支付宝/微信支付</a></li>
			</ul>
    </div>
</div>	
	<div class="layui-row">
	    <div class="layui-col-xs12">
	        <fieldset class="layui-elem-field layui-field-title" style="margin-top: 20px;">
			  <legend>在线支付</legend>
			</fieldset>
	        <form class="layui-form" method="post" action="/alipay/tradePay">
			    <div class="layui-form-item" pane="">
			        <label class="layui-form-label">支付金额:</label>
				    <div class="layui-input-block">
				      <input type="radio" name="productId" value="1" title="09元-请小贝喝杯奶茶" >
				    </div>
				    <div class="layui-input-block">
				      <input type="radio" name="productId" value="2" title="29元-请小贝吃肯德基" checked>
				    </div>
				    <div class="layui-input-block">
				      <input type="radio" name="productId" value="3" title="49元-请小贝吃顿饭">
				    </div>
			    </div>
			  
			  
			     <div class="layui-form-item">
				    <label class="layui-form-label">支付人:</label>
				    <div class="layui-input-block">
				      <input type="text" name="nickName" lay-verify="required" placeholder="请输入您的大名或者昵称" autocomplete="off" class="layui-input">
				    </div>
				  </div>
				  
				  <div class="layui-form-item">
				    <label class="layui-form-label">QQ:</label>
				    <div class="layui-input-block">
				      <input type="text" name="qq" lay-verify="required|number"  placeholder="请输入您的QQ号" autocomplete="off" class="layui-input">
				    </div>
				  </div>
				  
				  <div class="layui-form-item layui-form-text">
				    <label class="layui-form-label">留言:</label>
				    <div class="layui-input-block">
				      <textarea id="message" name="message" placeholder="请输入留言内容" class="layui-textarea"></textarea>
				    </div>
				  </div>
				  
				  <div class="layui-form-item">
				    <label class="layui-form-label">支付方式:</label>
				    <div class="layui-input-block">
				      <input type="radio" name="way" value="支付宝" title="支付宝" checked="">
				      <input type="radio" name="way" value="微信" title="微信" disabled>
				    </div>
				  </div>
				  <div class="layui-form-item">
				    <div class="layui-input-block">
				      <button class="layui-btn" lay-submit="" lay-filter="demo1">支付提交</button>
				    </div>
				  </div>
	        </form>
	        <div class="layui-col-xs12">
	        	<strong style="color: red;">此支付接口为沙箱测试接口！扫码支付请使用安卓版 <<沙箱测试应用>> </strong>
	        </div>
	    </div>
	</div>
	
  </div>

<script src="<%=basePath%>/layui/layui.js"></script> 
<script>
layui.use('element', function(){
  var element = layui.element; //导航的hover效果、二级菜单等功能，需要依赖element模块
  
  
});
</script>
<script>
layui.use('form', function(){
  
  var form = layui.form;
 
   //监听提交
  form.on('submit(demo1)', function(data){
    if(data.field.way=='支付宝'){
    	data.form.action="/pay/alipay/tradePay";
    }else if(data.field.way=='微信'){
    	data.form.action="/pay/weixinpay/pay";
    }
    return true;
  });

});
</script>
</body>
</html>
