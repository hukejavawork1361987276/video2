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
    <link href="../css/bootstrap.min.css" rel="stylesheet">
    <script src="../js/jquery-1.12.4.min.js"></script>
    <script src="../js/bootstrap.min.js"></script>
   
   <style>
   	   	body{ 
   	   		margin:0 auto;
   	   		width: 1200px;
   	   		
   	   		} 
   	   	
   .collapse navbar-collapse{
   		text-align:center;
   		margin: auto;
   		padding-left: 300px;
   	}
   	
.search{
	
	float: right;
}
   </style>
   
  </head>
  	<body>
  			<div class="jumbotron">
  <div class="container">
    <h2><b>主讲人列表-主讲人管理</b></h2>
  </div>
</div>




<div>
  		
 <button type="button" class="btn btn-primary">添加主讲人</button>





<div class="search">

<b>名称:</b><input type="text" class="form-control" id="exampleInputName2" placeholder="主讲人姓名" style="width: 200px; display: inline;">
<b>职位:</b><input type="text" class="form-control" id="exampleInputName2" placeholder="主讲人职位" style="width: 200px; display: inline;">


 <button type="button" class="btn btn-primary">搜索</button>
</div>
  </div>	
  	<br />
  	<br />
  	
  	
  	
  	<table class="table">
  		<thead>
  <tr>
  	
  	<th width="5px" >序号</th>
  	<th>名称</th>
  	<th>职位</th>
  	<th>简介</th>
 
  	
  	<th width="5px">编辑</th>
  	<th width="5px">删除</th> 	
  </tr>	
  </thead>
  <tbody>
<tr>
	
	<td>1</td>
	<td>白净</td>
	<td>高数讲师</td>
	<td>数学拉格朗日定力</td>
	<td><a href="editSpeaker.html"><span class="glyphicon glyphicon-pencil" aria-hidden="true"></span></a></td>
	<td><span class="glyphicon glyphicon-trash" aria-hidden="true"></span></td>
</tr></tbody>
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
  		
	</body>
</html>

