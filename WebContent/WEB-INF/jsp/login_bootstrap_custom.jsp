<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC
 "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<script type="text/javascript" src="./js/common.js"></script>
<script type="text/javascript">
<!--
	function clearFormInput() {
		displayElement(document.getElementById('div_actionerror'), 'none');
		clearForm(document.Login);
	}
// -->
</script>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link href="css/sysstyle.css" rel="stylesheet" type="text/css">
<link href="css/bootstrap_custom.css" rel="stylesheet">

<title>Sample system</title>
</head>
<body>

<div class="navbar navbar-fixed-top"> <!--navbar-->
	<div class="navbar-inner">
		<div class="container-fluid">
			<a class="btn btn-navbar" data-toggle="collapse" data-target=".nav-collapse">
				<span class="icon-bar"></span>
				<span class="icon-bar"></span>
				<span class="icon-bar"></span>
			</a>
			<a class="brand" href="./">Sample system</a>
			<div class="nav-collapse">
			</div>
		</div>
	</div>
</div> <!--/navbar-->

<!-- contents1可変-->
<div class="row-fluid" style="padding-top:60px">
	<div class="span12 well"> </div>
</div>

<div class="row-fluid" style="padding-top:5px; border:1px solid gray;">
	<div class="span12">
		<div>
			<hr style=" height: 4px; background-color: #ad3140;">
			<center><h1>Login screen</h1></center>
			<hr style=" height: 4px; background-color: #ad3140;">
		</div>
	</div>
</div>
<div class="row-fluid" style="padding-top:20px; border:1px solid gray;">
	<div class="span1" style="border:1px solid gray; background-color: #ffffff;">Left(span1)</div>
	<div class="span10" style="border:1px solid gray;">
		<div style="border:1px solid gray; background-color: #cccccc;">
 		</div>
		<div class="row-fluid">
			<div class="span1" style="border:1px solid gray; background-color: #ff0000;"> (span1)</div>
			<div class="span2" style="border:1px solid gray; background-color: #00ff00;"> (span2)</div>
			<div class="span6" style="border:1px solid gray;">
				<div class="container-fluid"><!-- information-->
					<span>入れ子３(span6)</span>
					<s:form action="login" class="form-horizontal">
						<div class="control-group">
							<span class="label label-important">ID</span>
							<s:textfield name="employeeId" cssClass="input-medium" placeholder="ID?" />
						</div>
						<div class="control-group">
							<span class="label label-important">PASSWORD</span>
							<s:password name="employeePassword" cssClass="input-xlarge" placeholder="PASSWORD?" />
						</div>
						<div class="form-actions">
							<s:submit id="loging" value=" lohin " cssClass="btn btn-primary" action="login" method="login"></s:submit>
						</div>
					</s:form>
				</div><!-- /information-->
			</div>
			<div class="span2" style="border:1px solid gray; background-color: #ffff00;"> (span2)</div>
			<div class="span1" style="border:1px solid gray; background-color: #00ffff;"> (span1)</div>
		</div>
	</div>
	<div class="span1"  style="border:1px solid gray; background-color: #ffffff;"> (span1)</div>
</div><!-- contents-->

<hr style="height:4px; border-width:1px;"/>

<!-- contents2固定-->
<div class="row" style="padding-top:10px">
	<div class="span12">
		<blockquote class="well">  </blockquote>
	</div>
</div>
<div class="row" style="padding-top:5px; border:1px solid gray;">
	<div class="span12" style="border:1px solid gray;">
		<div>
			<hr style=" height: 4px; background-color: #ad3140;">
			<center><h1> ddd </h1></center>
			<hr style=" height: 4px; background-color: #ad3140;">
		</div>
	</div>
</div>
<div class="row" style="padding-top:20px; border:1px solid gray;">
	<div class="span1" style="background-color: #ff00ff;"> (span1)</div>
	<div class="span10" style="border:1px solid gray;">
		<div style="border:1px solid gray; background-color: #cccccc;">
			 
		</div>
		<div class="row">
			<div class="span3" style="background-color: #ff0000;"> (span3)</div>
			<div class="span4" style="background-color: #0000ff;">
				<div class="container"><!-- information-->
					<span style="color:white;"> (span4)</span>
				</div><!-- /information-->
			</div>
			<div class="span3" style="background-color: #00ff00;"> (span3)</div>
		</div>
	</div>
	<div class="span1"  style="border:1px solid gray; background-color: #ffffff;"> (span1)</div>
</div><!-- contents-->

</body>
</html>