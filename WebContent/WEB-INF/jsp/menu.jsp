<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"
%><%@ taglib prefix="s" uri="/struts-tags"
%><!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<s:include value="/WEB-INF/jsp/commonHeader.jsp"
><s:param name="addCss"><link href="./css/bootstrap_custom.css" rel="stylesheet" type="text/css"></s:param
></s:include> 
	<body>
<s:include value="/WEB-INF/jsp/navbar.jsp"></s:include> 
	<div id="mainContainer" class="container">
		<div class="row">
			<div class="span3">
				<ul class="nav nav-list bs-docs-sidenav">
					<li><a href="sample"><i class="icon-chevron-right"></i>Select sample</a></li>
					<li><a href="sample2"><i class="icon-chevron-right"></i>Select Sample(ajax/json)</a></li>
					<li><a href="registSample"><i class="icon-chevron-right"></i>registSample</a></li>
					<li><a href="updateSample"><i class="icon-chevron-right"></i>updateSample</a></li>
					<li><a href="sampleTab"><i class="icon-chevron-right"></i>(Bonus) how to use the tab</a></li>
				</ul>
			</div>
			<div class="span9">
				<div style="margin-top:30px">
					<div class="page-header">
					  <h1>Contents <small>sample... </small></h1>
					</div>

					<ul class="thumbnails">
						<li class="span4">
							<div class="thumbnail">
								<a href="sample">Select Sample</a>
								<div class="caption">
								<p>Search This is a sample of processing</p>
								</div>
							</div>
						</li>
					</ul>
					<ul class="thumbnails">
						<li class="span4">
							<div class="thumbnail">
								<a href="sample2">Select Sample(ajax/json)</a>
								<div class="caption">
								<p>This is a sample to perform the search processing asynchronously.</p>
								<p>ajax, jsonUsing, make the process of obtaining a search result in asynchronous.</p>
								</div>
							</div>
						</li>
					</ul>
					<ul class="thumbnails">
						<li class="span4">
							<div class="thumbnail">
								<a href="registSample">registSample</a>
								<div class="caption">
								<p>This is a sample of the new registration.</p>
								<p>Input check → check Dauarogu → DB registration → registration completion screen</p>
								</div>
							</div>
						</li>
					</ul>
					<ul class="thumbnails">
						<li class="span4">
							<div class="thumbnail">
								<a href="updateSample">updateSample</a>
								<div class="caption">
								<p>Update, it is a sample of the deletion process.</p>
								<p>Search → update (or delete)</p>
								</div>
							</div>
						</li>
					</ul>
					<ul class="thumbnails">
						<li class="span4">
							<div class="thumbnail">
								<a href="joinregistSample">JoinregistSample</a>
								<div class="caption">
								<p>This is a sample of registration. </p>
								<p>Input check → check Dauarogu → DB registration → registration completion screen</p>
								</div>
							</div>
						</li>
					</ul>


				</div>
			</div>
		</div>
	</div>
	</body>
</html>