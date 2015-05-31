<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"
%><%@ taglib prefix="s" uri="/struts-tags"
%><!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<s:include value="/WEB-INF/jsp/commonHeader.jsp"
><s:param name="addCss"><link href="./css/bootstrap_custom.css" rel="stylesheet" type="text/css"></s:param
></s:include> 
	<body>
<s:include value="/WEB-INF/jsp/navbar.jsp"></s:include> 

<script type="text/javascript">
<!--
	$(document).ready(function() {

		$('a[name="eventModal"]').click(function() {

			alert('eventModal ');
		});

		// JSON 
		SCHEDULE = [

			{
				ID: 1,
				NAME: 'Week scheduled regular meeting',
				DATE_FROM: '2012/12/21 15:00',
				DATE_TO: '2012/12/21 16:00',
				VENUE: 'UBG building 2F in the conference room',
				MAP_URI: 'http://maps.google.co.in/maps?hl=ja&ie=UTF8&ll=35.73073051430368,139.72137387868193&q=35.73107017830139,139.7217654811981%28UBG%E3%83%93%E3%83%AB2F%E4%B8%AD%E4%BC%9A%E8%AD%B0%E5%AE%A4%29&z=17&output=embed',
				CONTENT: 'Weekly regular meeting',
				DETAIL: 'Make regular meeting weekly.',
				REGISTRANT: 'Fahim Muntasir',
				MEMBER_ID : [
					1,2,3,4
				]
			},

			{
				ID: 2,
				NAME: 'Mahbubur Rahman',
				DATE_FROM: '2012/12/21 16:00',
				DATE_TO: '2012/12/21 16:30',
				VENUE: 'UBG ',
				CONTENT: '   ccc ',
				DETAIL: 'sdfsdfds ',
				REGISTRANT: 'sdfsdafsdf',
				MEMBER_ID : [
					1
				]
			},

			{
				ID: 3,
				NAME: 'safdsfsdf',
				DATE_FROM: '2012/12/28 16:00',
				DATE_TO: '2012/12/29 00:00',
				VENUE: 'sdfsdfsd',
				MAP_URI: 'http://maps.google.co.in/maps?hl=ja&ie=UTF8&ll=35.73073051430368,139.72137387868193&q=35.73107017830139,139.7217654811981%28UBG%E3%83%93%E3%83%AB2F%E5%A4%A7%E4%BC%9A%E8%AD%B0%E5%AE%A4%29&z=17&output=embed',
				CONTENT: 'safsdafsd',
				DETAIL: 'sasdsdfsdfsdf',
				REGISTRANT: 'asfsdafs',
			},

			{
				ID: 4,
				NAME: 'asfsdafas',
				DATE_FROM: '2013/01/06 10:00',
				DATE_TO: '2013/01/06 12:00',
				VENUE: 'dsfasfsa',
				CONTENT: 'asfsfasf',
				DETAIL: 'sdafsfsdfaf',
				REGISTRANT: 'afasfdafsad',
			},

		];

		MEMBER = [

				{
					ID : 1,
					NAME : 'adfafssd',
					JOB : 'PM',
					AUTHORITY : 'asfasfsdf',
					AGE : '30',
					SKILL : 'Spring, Java',
					NOTE : 'w3'
				},

				{
					ID : 2,
					NAME : 'safsdaf',
					JOB : 'DBA',
					AUTHORITY : 'XYZ',
					AGE : '21',
					SKILL : 'Office',
					NOTE : '2U'
				},

				{
					ID : 3,
					NAME : 'asfdsf',
					JOB : 'PG',
					AUTHORITY : 'SE',
					AGE : '22',
					SKILL : 'DBA',
					NOTE : 'SDE'
				},

				{
					ID : 4,
					NAME : 'EDSF',
					JOB : 'PG',
					AUTHORITY : 'DSF',
					AGE : '23',
					SKILL : 'C#',
					NOTE : 'sdsf'
				},

				{
					ID : 5,
					NAME : 'sdafdsf',
					JOB : 'PG',
					AUTHORITY : 'asfdsf',
					AGE : '24',
					SKILL : 'C++',
					NOTE : ''
				},

				{
					ID : 6,
					NAME : 'sdafsfs',
					JOB : 'PG',
					AUTHORITY : 'asfds',
					AGE : '25',
					SKILL : 'VB',
					NOTE : ''
				},

				{
					ID : 7,
					NAME : 'sdfaasf',
					JOB : 'PG',
					AUTHORITY : 'asfsdf',
					AGE : '26',
					SKILL : 'PHP',
					NOTE : ''
				},

				{
					ID : 8,
					NAME : 'asfaf',
					JOB : 'PG',
					AUTHORITY : 'asfdfsa',
					AGE : '27',
					SKILL : 'Perl',
					NOTE : ''
				},

				{
					ID : 9,
					NAME : 'safsdfasda',
					JOB : 'PG',
					AUTHORITY : 'asfasfsdf',
					AGE : '28',
					SKILL : 'FORTLAN',
					NOTE : ''
				},

				{
					ID : 10,
					NAME : 'asfdsfds',
					JOB : 'PG',
					AUTHORITY : 'safasfsd',
					AGE : '29',
					SKILL : 'COBOL',
					NOTE : ''
				}

		];

		if (SCHEDULE.length > 0) {

			for (var i = 0; i < SCHEDULE.length; i++) {

				$('#eventTable > tbody').append('<tr>');

				var linkText = '<a name="eventModal" onClick="modalShow(\'' + SCHEDULE[i].ID + '\')" data-toggle="modal">' + SCHEDULE[i].NAME + '</a>'

				addTr = $('#eventTable > tbody > tr:last');

				addTr.append('<td>' + linkText + '</td>');
				addTr.append('<td>' + SCHEDULE[i].DATE_FROM + '</td>');
				addTr.append('<td>' + SCHEDULE[i].DATE_TO + '</td>');
				addTr.append('<td>' + SCHEDULE[i].CONTENT + '</td>');

				memberIdList = SCHEDULE[i].MEMBER_ID;

				if (memberIdList == null) {
					addTr.append('<td />');
					continue;
				}

				for (var memIdCount = 0; memIdCount < memberIdList.length; memIdCount++) {

					if (memIdCount == 0) {
						addTr.append('<td />');
					}

					for (var memCount = 0; memCount < MEMBER.length; memCount++) {

						if (memberIdList[memIdCount] == MEMBER[memCount].ID) {

							content = $('#eventTable > tbody > tr:last > td:last');
							contentText = content.text();
							content.text(contentText + ' ' + MEMBER[memCount].NAME);
							break;
						}
					}
				}

			}
		}

		for (var i = 0; i < MEMBER.length; i++) {

			$('#memberTable > tbody').append('<tr>');

			addTr = $('#memberTable > tbody > tr:last');

			addTr.append('<td style="text-align: right;">' + MEMBER[i].ID + '</td>');
			addTr.append('<td>' + MEMBER[i].NAME + '</td>');
			addTr.append('<td>' + MEMBER[i].JOB + '</td>');
			addTr.append('<td>' + MEMBER[i].AUTHORITY + '</td>');
			addTr.append('<td style="text-align: right;">' + MEMBER[i].AGE + '</td>');
			addTr.append('<td>' + MEMBER[i].SKILL + '</td>');
			addTr.append('<td>' + MEMBER[i].NOTE + '</td>');
		}

	});

	function modalShow(eventId) {

		for (var i = 0; i < SCHEDULE.length; i++) {

			if (SCHEDULE[i].ID == eventId) {

				$('#eventName').text(SCHEDULE[i].NAME);
				$('#dlEvent > dd:eq(0)').text(SCHEDULE[i].DATE_FROM + ' - ' + SCHEDULE[i].DATE_TO);

				if (SCHEDULE[i].MAP_URI != undefined) {
					$('#dlEvent > dd:eq(1)').html('<a onclick=\'window.open("' + SCHEDULE[i].MAP_URI + '", "", "width=600px,height=480px")\'" target="_blank">' + SCHEDULE[i].VENUE + '</a>');
				} else {
					$('#dlEvent > dd:eq(1)').text(SCHEDULE[i].VENUE);
				}

				$('#dlEvent > dd:eq(2)').text(SCHEDULE[i].CONTENT);
				$('#dlEvent > dd:eq(3)').text(SCHEDULE[i].DETAIL);
				$('#dlEvent > dd:eq(4)').text(SCHEDULE[i].REGISTRANT);

				$('#memberList').children().remove();

				memberIdList = SCHEDULE[i].MEMBER_ID;

				if (memberIdList == null) {
					$('#ddMemberList > p').text('計 0名');
					$('#eventModal').modal('show');
					continue;
				}

				for (var memIdCount = 0; memIdCount < memberIdList.length; memIdCount++) {

					$('#memberList').append('<li />');

					for (var memCount = 0; memCount < MEMBER.length; memCount++) {

						if (memberIdList[memIdCount] == MEMBER[memCount].ID) {

							$('#memberList > li:last').text(MEMBER[memCount].NAME);
							break;
						}
					}
				}

				$('#ddMemberList > p').text('  ' + memberIdList.length + ' ');
				$('#eventModal').modal('show');

				break;
			}

		}

	}

// -->
</script>

	<div class="container">
		<div class="row-fluid" style="padding-top:60px"> 
			<div class="span12">
				<h2>tab</h2>
				<div class="tabbable"><!-- Only required for left/right tabs -->
					<ul class="nav nav-tabs">
						<li class="active"><a href="#tabEvent" data-toggle="tab">Events</a></li>
						<li><a href="#tabCalendar" data-toggle="tab">Calendar</a></li>
						<li><a href="#tabMember" data-toggle="tab">Members</a></li>
					</ul>
					<div class="tab-content">
						<div class="tab-pane active" id="tabEvent">
							<p>Events</p>
							<table id="eventTable" class="table table-striped table-bordered table-condensed">
								<thead>
									<tr>
										<td>Name</td>
										<td>Date and time(From)</td>
										<td>Date and time(To)</td>
										<td>Contents</td>
										<td>Participant</td>
									</tr>
								</thead>
								<tbody />
							</table>
						</div>
						<div class="tab-pane" id="tabCalendar">
							<p>Calendar</p>
						</div>
						<div class="tab-pane" id="tabMember">
							<p>Members</p>
							<table id="memberTable" class="table table-striped table-bordered table-condensed">
								<thead>
									<tr>
										<td>ID</td>
										<td>Name</td>
										<td>Occupation</td>
										<td>Authority</td>
										<td>Age</td>
										<td>Skill</td>
										<td>Remarks</td>
									</tr>
								</thead>
								<tbody />
							</table>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>

	<%-- Modal --%>
	<div id="eventModal" class="modal hide fade" tabindex="-1" role="dialog" aria-labelledby="eventModalLabel" aria-hidden="true" >
		<div class="modal-header">
			<button type="button" class="close" data-dismiss="modal" aria-hidden="true">×</button>
			<h3 id="eventModalLabel">Event Details</h3>
		</div>
		<div class="modal-body">
			<h3 id="eventName">Week scheduled regular meeting</h3>
			<div class="tabbable">
				<ul class="nav nav-tabs">
					<li class="active"><a href="#tabEventDetail" data-toggle="tab">Detail</a></li>
					<li><a href="#tabEventMember" data-toggle="tab">Participate predetermined</a></li>
				</ul>
				<div class="tab-content">
					<div class="tab-pane active" id="tabEventDetail">
						<dl id="dlEvent" class="dl-horizontal">
							<dt>When the urge India to open</dt><dd>2012/12/21 15:00 - 2012/12/21 16:00</dd>
							<dt>Open reminder place</dt><dd>UBG building 2F in the conference room</dd>
							<dt>Contents</dt><dd>Weekly regular meeting</dd>
							<dt>Detail</dt><dd>We'll do every week the weekly regular meeting.</dd>
							<dt>Registrant</dt><dd>Sato Ichiro</dd>
						</dl>
					</div>
					<div class="tab-pane" id="tabEventMember">
						<dl class="dl-horizontal">
							<dt>Participate predetermined</dt>
							<dd id="ddMemberList">
								<ul id="memberList" class="inline">
								</ul><p></p>
							</dd>
						</dl>
					</div>
				</div>
			</div>
		</div>
		<div class="modal-footer">
			<button class="btn" data-dismiss="modal" aria-hidden="true">Close</button>
			<button id="btn_execute"  class="btn btn-primary" ><i class="icon-ok-sign icon-white"></i>&nbsp;Change</button>
		</div>
	</div>
	</body>
</html>