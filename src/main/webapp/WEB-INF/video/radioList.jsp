<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
             <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
   <%@taglib prefix="fy" uri="http://zhiyou100.com/common/"%> 
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
   	   		
   	   	
   .collapse navbar-collapse{
   		text-align:center;
   		margin: auto;
   		padding-left: 300px;
   		padding-top: 10px;
   	}
   	
.search{
	
	float: right;
}
   </style>
   
   <script type="text/javascript">
 /*   function selectAll(theCheck) {
	 //找到全选的checkbox,获取checked属性
	 //找到所有tr中的checkbox,让其checked的属性为全选的checked属性
	 var arr = document.getElementsByName("deleVideo");
	 for(var i = 0; i < arr.length; i++){
	 arr[i].checked = theCheck.checked;
	 }
	 } */
	 
	 function convert(){
		//找到所有tr中的checkbox,让其checked的属性改为他的相反
		var arr = document.getElementsByName("deleVideo");
		for(var i = 0; i < arr.length; i++){
		arr[i].checked = !arr[i].checked;
		}
		}
   
   </script>
  </head>
  	<body>
  			<div class="jumbotron">
  <div class="container">
    <h2><b>视频列表-视频管理</b></h2>
  </div>
</div>




<div>

 
 <a href='<c:url value="/vedio/addVideo.action"></c:url>'><button type="button" class="btn btn-primary" style="width: 103px;height: 40px;font-size: x-small;"> 添加课程</button></a>

<!-- <button  class="btn btn-primary" type="button" onclick="document.getElementById('dele').submit();">
 批量删除<span class="badge">?</span>
</button> -->
<button  type="button" class="btn btn-primary btn-lg" data-toggle="modal" data-target="#myModal1" 
style="font-size: x-small;">
 批量删除<span class="badge">?</span>
</button>

<!-- Modal -->
<div class="modal fade" id="myModal1" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
  <div class="modal-dialog" role="document">
    <div class="modal-content">
      <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
        <h4 class="modal-title" id="myModalLabel">警告</h4>
      </div>
      <div class="modal-body">
       需要删除吗?
      </div>
      <div class="modal-footer">
        <button type="button" class="btn btn-default" data-dismiss="modal">否</button>
        <button type="button" class="btn btn-primary" onclick="document.getElementById('dele').submit();">是</button>
      </div>
    </div>
  </div>
</div>
<!--  -->
<!--  -->


<div style="float: right;" >
	
<form action='<c:url value="/vedio/videoList.action"></c:url>' >
	<div class="form-group" style="float: right;">
 <button type="submit" class="btn btn-primary">搜索</button>
 </div>
	
<div class="form-group" style="float: right;"> 
<select class="form-control" name="courseid" >
	<option value="">请输入课程</option>
   <c:forEach items="${allCourse}" var="allCourse" varStatus="inco">
   <option value="${allCourse.id}" >${allCourse.course_name}</option>
   </c:forEach>
 </select>
</div>
	
	
	
	
<div class="form-group" style="float: right;"> 
<select class="form-control" name="speakid"  >
	<option value="">请输入主讲人</option>
   <c:forEach items="${allSpeaker}" var="allSpeaker" varStatus="inco">
   <option value="${allSpeaker.id}" >${allSpeaker.speaker_name}</option>
   </c:forEach>
 </select>
</div>	
	
<div class="form-group"  style="float: right;" >
<input type="text" name="titlelike" class="form-control" id="exampleInputName2" placeholder="请输入视频标题" style="width: 200px;float: right; ">
</div>

 </form>
</div>
  	</div>	
  	
  	<br />
  	<br />
  	
  	<table class="table">
  		<thead>
  <tr>
  	<th width="5px" ><input type="checkbox" onclick="convert()" /></th>
  	<th width="5px" >序号</th>
  	<th>名称</th>
  	<th>介绍</th>
  	<th width="5px" >讲师</th>
  	<th>课程</th>
  	<th width="7px" >秒长(秒)</th>
  	<th width="7px" >播放次数</th>
  	<th width="5px">编辑</th>
  	<th width="5px">删除</th> 	
  </tr>	
  </thead>
  <tbody>
  <form  id="dele" action='<c:url value="/vedio/deleVideo.action"></c:url>' method="post">
  <c:forEach items="${ page.rows }" var="videoList" varStatus="inco">
<tr>
	 <th width="5px" ><input name="deleVideo" value="${videoList.id}" type="checkbox" /></th>
	<td>${inco.count}</td>
	 <td>${videoList.video_title}</td>
	<td>${videoList.video_descr}</td>
	<td>${videoList.speakerName}</td>
	<td>${videoList.courseName}</td>
	<td>${videoList.video_length}</td>
	<td>${videoList.video_play_times}</td> 
	<td><a href="<c:url value="/vedio/editVideo.action"></c:url>?id=${videoList.id}"><span class="glyphicon glyphicon-pencil" aria-hidden="true"></span></a></td>
	<td>
	<%-- <a href="<c:url value="/vedio/deleOneVideo.action"></c:url>?id=${videoList.id}">
	<span class="glyphicon glyphicon-trash" aria-hidden="true"></span>
	</a> --%>
	
	 <a class="btn btn-primary btn-lg" data-toggle="modal" data-target="#myModal2" >
	<span class="glyphicon glyphicon-trash" aria-hidden="true"></span>
	</a>
	

<div class="modal fade" id="myModal2" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
  <div class="modal-dialog" role="document">
    <div class="modal-content">
      <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
        <h4 class="modal-title" id="myModalLabel">警告</h4>
      </div>
      <div class="modal-body">
       需要删除吗?
      </div>
      <div class="modal-footer">
        <button type="button" class="btn btn-default" data-dismiss="modal">否</button>
     <a href="<c:url value="/vedio/deleOneVideo.action"></c:url>?id=${videoList.id}">   <button type="button" class="btn btn-primary">是</button></a>
      </div>
    </div>
  </div>
</div>
	<!--  -->
	</td>
</tr>
</c:forEach>
<input type="hidden" >
</form>

</tbody>
		</table>
  		
  		
<fy:page url="${pageContext.request.contextPath}/vedio/videoList.action"></fy:page>
	</body>
</html>
