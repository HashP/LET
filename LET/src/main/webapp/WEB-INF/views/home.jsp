<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page session="false"%>
<html>
<head>
<title>Home</title>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap.min.css">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap-theme.min.css">
<script src="https://code.jquery.com/jquery-3.1.1.min.js"
	integrity="sha256-hVVnYaiADRTO2PzUGmuLJr8BLUSjGIZsDYGmIJLv2b8="
	crossorigin="anonymous"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/js/bootstrap.min.js"></script>
</head>
<body>


	<div class="container">

		<div class="page-header">
			<h1>인코딩</h1>
			<P>The time on the server is ${serverTime}.</P>
		</div>

		<form class="form-inline" id="encodingForm">
			<div class="form-group">
				<label for="exampleInputEmail1">깨진 문자</label> <input type="text"
					class="form-control" id="targetText"
					placeholder="입력">
			</div>
			<button type="submit" class="btn btn-default">변환</button>
		</form>
		<p class="lead">결과</p>
		<textarea id="resultArea" class="form-control" rows="22"></textarea>
	</div>


</body>
<script type="text/javascript">
	$(document).ready(function() {

		$("#encodingForm").submit(function(event){
			event.preventDefault();
			
			var targetText = $("#targetText").val();
			console.log(targetText);
			
			$.ajax({
				url:"/encodingText",
				type: "POST",
				data: {"targetText":targetText},
				dataType: "text",
				success: function(result) {
					$("#resultArea").text(result);
				},
				error : function() {
					$("#resultArea").text("에러발생");				
				}
			});
		});
	});
</script>
</html>
