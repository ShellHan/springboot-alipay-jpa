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
<title>订单列表_韩小贝</title>
<meta name="keywords" content="在线支付案例，支付宝支付Demo">
<link rel="stylesheet" href="<%=basePath%>/layui/css/layui.css">
<meta name="description" content="一个Java实现的支付宝微信在线支付在线案例。">
<meta name="renderer" content="webkit">
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
<meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
<meta name="apple-mobile-web-app-status-bar-style" content="black"> 
<meta name="apple-mobile-web-app-capable" content="yes">
<meta name="format-detection" content="telephone=no">
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
			  <legend>订单列表</legend>
			</fieldset>
	    </div>
	</div>
	
	<div class="layui-row">
	    <div class="layui-col-xs12">
			<table class="layui-hide" id="orderListTable"></table>
	    </div>
	</div>
	
</div>
<script src="<%=basePath%>/layui/layui.js"></script>
<script>
layui.use('table', function(){
  var table = layui.table;
  
  table.render({
    elem: '#orderListTable'
    ,url:'/pay/alipay/getTradeAll'
    ,cols: [[
      {field:'nickName', width:100, title: '昵称'}
      ,{field:'qq', width:120, title: 'QQ'}
      ,{field:'buyTime', width:180, title: '支付时间', sort: true,align:'center'}
      ,{field:'way', width:100, title: '支付方式',align:'center'}
      ,{field:'body',width:200, title: '订单详情'}
      ,{field:'message', title: '留言', minWidth: 150}
    ]]
    ,page: true
  });
});
</script>
</body>
</html>