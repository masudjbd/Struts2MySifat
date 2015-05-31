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
					<a class="brand" href="./">Sample system</a>
				</div>
			</div>
		</div><%-- navbar/ --%>