<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"
%><!DOCTYPE html PUBLIC
 "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<s:include value="/WEB-INF/jsp/commonHeader.jsp"
><s:param name="addCss"><link href="./css/bootstrap_custom.css" rel="stylesheet" type="text/css"></s:param
></s:include> 
	<body>
<s:include value="/WEB-INF/jsp/navbar.jsp"></s:include> 
	<div id="mainContainer" class="container" style="padding-top:60px">
		<div class="row-fluid"><!-- contents-->
			<div class="span1" ></div>
				<div class="span10">
					<div class="container-fluid"><!-- information-->
						<div class="well well-large"> 
 <p>ID:<s:property value="testDataInputEntity.person_id" /> Me has been deleted.</p>
					    </div>
					</div><!-- /information-->
				</div>
			<div class="span1" ></div>
		</div><!-- contents-->
	</div>
</body>
</html>