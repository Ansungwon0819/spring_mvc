<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>vo02만듬</h1>
	
	<!-- 전달받은 자료가 객체라면, 자바코드에서와 마찬가지로
		객체.변수명과 같이 내부 변수를 하나하나 따로 출력할 수 있습니다. -->
	<h3>${BaseVO }</h3>
	<h3>${BaseVO.name }</h3>
	<h3>${BaseVO.age }</h3>
	<h3>${BaseVO.job }</h3>
</body>
</html>