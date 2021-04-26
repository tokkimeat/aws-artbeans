<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<div id="test"></div>
<button id="bnt">버튼</button>

<script>
this.a = 1;
var btnClick = function(){
	
	this.innerText = (this.innerText=='버튼')?'다시한번더!':'버튼';
	
}
document.querySelector('#btn').addEventListener('click',btnClick){
	
});
</script>

</body>
</html>