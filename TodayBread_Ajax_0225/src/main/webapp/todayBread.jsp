<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>오늘의 인기빵!</h1>
<table>
	<tr>
		<td colspan="2">
			<img alt="인기빵사진" src="" id="img">
		</td>
	</tr>
	<!-- 
	<tr>
		<th>코드 : </th>
		<td id = "code">*</td>
	</tr>
	 -->
	<tr>
		<th>이름 : </th>
		<td id = "name">*</td>
	</tr>
	<tr>
		<th>가격 : </th>
		<td id = "price">*</td>
	</tr>
	<tr>
		<th>설명 : </th>
		<td id = "intro">*</td>
	</tr>
</table>

<script>
	
	//let code = document.querySelector("#code");
	let name = document.querySelector("#name");
	let price = document.querySelector("#price");
	let intro = document.querySelector("#intro");
	let img = document.querySelector("#img");
	
	let xhr = new XMLHttpRequest();
	
	xhr.onreadystatechange = function(){
		
		if(xhr.readyState == 4 && xhr.status == 200){
			
			let result = JSON.parse(xhr.responseText);
	
			//code.innerHTML = result.code;
			name.innerHTML = result.name;
			price.innerHTML = result.price + "원";
			intro.innerHTML = result.intro;
			img.setAttribute("src", "img/"+ result.img);
			img.setAttribute("width", "300px");
			// img.removeAttribute("width");
		};
	};
	
	// 출력할 빵 코드
	//let codeNum = "br004";
	
	xhr.open("get", "/TodayBread_Ajax_0124/todayBread.do", true);
	xhr.send();
	

</script>
</body>
</html>