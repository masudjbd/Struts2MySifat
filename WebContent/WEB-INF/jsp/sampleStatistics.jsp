<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC
 "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<script type="text/javascript" src="./js/common.js"></script>
<script type="text/javascript" src="./js/jquery-1.8.1.js"></script>
<script type="text/javascript" src="./js/jquery-ui.custom.js"></script>
<script type="text/javascript" src="./js/i18n/jquery.ui.datepicker-ja.js"></script>
<script type="text/javascript">
<!--

	var datepickerMin = '2013/01/01';
	var datepickerMax = '2013/12/31';

	function changeSearchType() {

		var optRadioVal = $('input[name="statisticsInput.statisticsAggregateUnitEnum"]:checked').attr('value');

		if (optRadioVal == 'monthly') {
			$('div#dpStart > *').attr('disabled', 'disabled');
			$('div#dpEnd > *').attr('disabled', 'disabled');
		} else if (optRadioVal == 'daily') {
			$('div#dpStart > *').removeAttr('disabled');
			$('div#dpEnd > *').removeAttr('disabled');
		}
	}

	$(document).ready(function(){

		$.datepicker.setDefaults($.datepicker.regional["ja"]);  

		$('#statisticsForm_statisticsInput_startDate').datepicker(
				{
					showOn: "both",  
					buttonImage: "./img/calendar.png",
					buttonImageOnly: true,  
					buttonText: "",
					minDate: datepickerMin,
					maxDate: datepickerMax
				}
				);

		// To
		$('#statisticsForm_statisticsInput_endDate').datepicker(
				{
					showOn: "both",  
					buttonImage: "./img/calendar.png",
					buttonImageOnly: true,  
					buttonText: "",
					minDate: datepickerMin,
					maxDate: datepickerMax
				}
				);

		changeSearchType();

		$('input[name="statisticsInput.statisticsAggregateUnitEnum"]')
				.change(function() {

					changeSearchType();
				});

	});

// -->
</script>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link href="css/sysstyle.css" rel="stylesheet" type="text/css">
<link href="css/bootstrap_United.css" rel="stylesheet"><!-- bootstrapのUnited -->
	<link href="./css/jquery-ui.custom.css" rel="stylesheet" type="text/css">
</head>
<body>
<s:include value="/WEB-INF/jsp/navbar.jsp"></s:include> 
	<div id="mainContainer" class="container">

<div class="row-fluid" style="padding-top:60px"><!-- contents-->
<div class="span1" ></div>
<div class="span10">

	<div class="container-fluid"><!-- information-->
		<div class="well well-large">
			<s:form id="statisticsForm" action="registSample" cssClass="form-horizontal" cssStyle="padding: 0px 5px" >
				<div id="div_actionerror">
					<font size="3px" color="#ff0000"><s:actionerror /></font>
				</div>
				<s:token/>
				<div class="label label-important">Detail</div>
				<div class="control-group">
					<label class="control-label">Counting unit</label>
					<div class="controls">
						<input type="radio" name="statisticsInput.statisticsAggregateUnitEnum" id="optionsRadios1" value="daily" checked="checked">Daily summary
						<input type="radio" name="statisticsInput.statisticsAggregateUnitEnum" id="optionsRadios2" value="monthly">May not disaggregate
					</div>
				</div>
				<div class="control-group">
					<label class="control-label">During disaggregate</label>
					<div class="input-append date" id="dpStart">
						<input class="input-small" id="statisticsForm_statisticsInput_startDate" name="statisticsInput.startDate" maxlength="10" type="text">
					</div>
					～
					<div class="input-append date" id="dpEnd" data-date="2012-12-31">
						<input class="input-small" id="statisticsForm_statisticsInput_endDate" name="statisticsInput.endDate" maxlength="10" type="text" value="2012-12-31">
					</div>
				</div>
				<div class="form-actions">
					<s:submit id="regist" value="Sign up" cssClass="btn btn-primary"  action="registSample" method="registData" />
					<s:reset cssClass="btn btn-danger" value="Reset" />
				</div>
			</s:form>
	    </div>
	</div><!-- /information-->

</div>
<div class="span1" ></div>


</div><!-- contents-->
</div><!-- container -->
</body>
</html>