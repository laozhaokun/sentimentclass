<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link type="text/css" rel="stylesheet" href="style.css">
<title>sentiment classification system</title>
<script type="text/javascript">
	function validateForm() {
		var x = document.getElementById("source").value.trim();
		if (x == null || x == "") {
			alert("Please input something.");
			return false;
		} else if (x.length > 1000) {
			alert("The length must be less than 1000.");
			return false;
		}
	}
</script>
</head>
<div id="header">
	<p>
		<a href="index.jsp">A simple Sentiment Detection System</a>
	</p>
</div>
<body>
	<div id="content">
		<h2>Please input some text(English) to get label.</h2>
		<form action="getLabelAction" method="post" onsubmit="return validateForm()" >
			<textarea rows="10" cols="100" name="text" id="source">${text}</textarea>
			<input type="submit" value="submit"/>
		</form>
		<c:if test="${label != null }">
			<h2>
				We predict the emotion of your text is :<span id="ret">${label}</span>
			</h2>
			<!--  
			<h3>Predict error? Your correct feedback is very important to us.</h3>
			<form action="updateLabelAction" method="post">
				<s:if test="label == 'positive'">
					<input type="radio" name="updateLabel" value="negative" /><p>negative</p>
				</s:if>
				<s:elseif test="label == 'negative'">
					<input type="radio" name="updateLabel" value="positive" /><p>positive</p>
				</s:elseif>
				<br/>
				<input type="button" value="submit" onclick="" />
			</form>-->
		</c:if>
	</div>
	<jsp:include page="footer.html"></jsp:include>
</body>
</html>
