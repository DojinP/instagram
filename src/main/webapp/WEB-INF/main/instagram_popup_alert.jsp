<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Insert title here</title>
	<%
		/* popup alert을 출력해주는 jsp 페이지 */
		
		// alert 메시지와 다음으로 redirect 될 path를 호출하여 저장
		String msg = (String)request.getAttribute("alertMsg");
		String url = (String)request.getAttribute("rediPath");
	%>
	
	<script type="text/javascript">
		/* alert 출력과 redirect 시행 */
		var message = "<%= msg %>";
		var returnUrl = "<%= url %>";
		alert(message); 
		document.location.href = returnUrl; 
	</script>
	
</head>
<body>

</body>
</html>