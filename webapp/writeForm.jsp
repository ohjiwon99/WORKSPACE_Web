<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="UTF-8"%>


<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<h1>전화번호부</h1>

	<h2>등록폼</h2>

	<p>
		전화번호를 등록하려면 <br> 아래항목을 기입하고 "등록" 버튼을 클릭하세요
	</p>

	http://localhost:8080/phonebook3/pbc?action=insert&
	name=오지원&hp=010&company=02
	<form action="http://localhost:8080/phonebook3/pbc" method="get">

		<div>
			<label>이름(name)</label> <input type="text" name="name" value="">
		</div>

		<div>
			<label>핸드폰(hp)</label> <input type="text" name="hp" value="">
		</div>

		<div>
			<label>회사(company)</label> <input type="text" name="company" value="">
		</div>

		<input type="text" name="action" value="insert"><br>
		<button type="submit">등록</button>

	</form>

	<br>
	<br>
	<a href="">리스트 페이지 이동</a>










</body>
</html>