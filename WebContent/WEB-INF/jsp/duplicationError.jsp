<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"
%><!DOCTYPE html PUBLIC
 "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<s:include value="/WEB-INF/jsp/commonHeader.jsp"
><s:param name="addCss"><link href="./css/bootstrap_custom.css" rel="stylesheet" type="text/css"></s:param
></s:include> 
<body onload="defaultFocus()">
<s:include value="/WEB-INF/jsp/navbarBlank.jsp"></s:include> 

<div class="row-fluid" style="padding-top:60px"><!-- contents-->
	<div class="span1" ></div>
		<div class="span10">
			<div class="container-fluid"><!-- information-->
				<div class="well well-large alert alert-block"> 
					<p>Request has been sent double. Please take care to search and more than once the depression of the execution button.</p>
					<p><a href="" onClick="history.back(); return false;">Go back</a></p>
				</div>
			</div><!-- /information-->
		</div>
	<div class="span1" ></div>

</div><!-- contents-->

</body>
</html>