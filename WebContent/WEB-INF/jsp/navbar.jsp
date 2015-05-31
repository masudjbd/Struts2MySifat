<%@ page language="java" contentType="text/html; charset=UTF-8"	pageEncoding="UTF-8"
%><%@ taglib prefix="s" uri="/struts-tags"
%>		<script type="text/javascript">
		<!--
			$(document).ready(function()
			{
				autoResize();
			});

			var timer = false;

			$(window).resize(function(){

				if (timer != false) {
					clearTimeout(timer);
				}

				timer = setTimeout(function() {

					autoResize();

				}, 150);

			});

			function autoResize() {

				var navHeight = $('#navbar').height();

				$('#mainContainer').css("padding-top", navHeight);
			}

		// -->
		</script>
		<div id="navbar" class="navbar navbar-fixed-top"><%-- /navbar --%>
			<div class="navbar-inner">
				<div class="container-fluid">
					<button type="button" class="btn btn-navbar" data-toggle="collapse" data-target=".nav-collapse">
						<span class="icon-bar"></span>
						<span class="icon-bar"></span>
						<span class="icon-bar"></span>
					</button>
					<a class="brand" href="./">Sample system</a>
					<div class="nav-collapse">
						<ul class="nav pull-right" style="padding-top:15px;">
							<li><span><s:property value="tenpo.TenpoName"/>Store</span></li>
							<li><span><s:property value="employee.Department"/>Dept</span></li>
							<li><span><s:property value="#session.employee.employeeName"/>Name</span></li>
							<li class="divider-vertical"></li>
							<li><a href="logout">Logout</a></li>
						</ul>
					</div>
				</div>
			</div>
		</div><%-- navbar/ --%>