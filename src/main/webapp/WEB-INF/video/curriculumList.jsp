<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
     <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="zh-CN">
  <head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- 上述3个meta标签*必须*放在最前面，任何其他内容都*必须*跟随其后！ -->
    <title>Hello World</title>
   <link href='<c:url value="/css/bootstrap.min.css"></c:url>' rel="stylesheet">
    <script src='<c:url value="/js/jquery-1.12.4.min.js"></c:url>'></script>
    <script src='<c:url value="/js/bootstrap.min.js"></c:url>'></script>
   
   <style>
  
   body{
   	margin:0 auto;
   	width: 1200px;
   	
   }
   </style>
   
  </head>
  	<body>
  		<div class="jumbotron">
  <div class="container">
    <h2><b>课程列表-课程管理</b></h2>
  </div>
</div>

  	<div>
  		
  			<button type="button" class="btn btn-primary">添加课程</button>
  		
  	</div>
  	
  	<div>
  	<table class="table">
  		<thead>
  <tr>
  	<th width="5px" >序号</th>
  	<th>标题</th>
  	<th>学科</th>
  	<th>简介</th>
  	<th width="5px">编辑</th>
  	<th width="5px">删除</th> 	
  </tr>	
  </thead>
  <tbody>
<tr>
	<td>1</td>
	<td>数学</td>
	<td>高数</td>
	<td>大学的数学粉条感觉更返回空发VB发女版vmcvnlzkxvn bn,mcvxz淡饭黄齑对方科目的承诺方给每个参VC女项目上线 女性吗</td>
	<td><span class="glyphicon glyphicon-pencil" aria-hidden="true"></span></td>
	<td><span class="glyphicon glyphicon-trash" aria-hidden="true"></span></td>
</tr>
</tbody>
		</table>
  		
  		
  		<nav aria-label="Page navigation">
  <ul class="pagination">
    <li>
      <a href="#" aria-label="Previous">
        <span aria-hidden="true">&laquo;</span>
      </a>
    </li>
    <li><a href="#">1</a></li>
    <li><a href="#">2</a></li>
    <li><a href="#">3</a></li>
    <li><a href="#">4</a></li>
    <li><a href="#">5</a></li>
    <li>
      <a href="#" aria-label="Next">
        <span aria-hidden="true">&raquo;</span>
      </a>
    </li>
  </ul>
</nav>
  	</div>
	</body>
</html>
