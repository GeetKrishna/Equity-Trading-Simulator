<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en" style="overflow-y: scroll; ">
<head>

<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta name="description" content="">
<meta name="author" content="">

<title>Broker HomePage - Configure Securities</title>

<!-- Bootstrap Core CSS -->
<link
	href="<c:out value="${pageContext.request.contextPath}"/>/bower_components/bootstrap/dist/css/bootstrap.min.css"
	rel="stylesheet">

<!-- MetisMenu CSS -->
<link
	href="<c:out value="${pageContext.request.contextPath}"/>/bower_components/metisMenu/dist/metisMenu.min.css"
	rel="stylesheet">

<!-- DataTables CSS -->
<link
	href="<c:out value="${pageContext.request.contextPath}"/>/bower_components/datatables-plugins/integration/bootstrap/3/dataTables.bootstrap.css"
	rel="stylesheet">

<!-- DataTables Responsive CSS -->
<link
	href="<c:out value="${pageContext.request.contextPath}"/>/bower_components/datatables-responsive/css/dataTables.responsive.css"
	rel="stylesheet">

<!-- Custom CSS -->
<link
	href="<c:out value="${pageContext.request.contextPath}"/>/dist/css/sb-admin-2.css"
	rel="stylesheet">

<!-- Custom Fonts -->
<link
	href="<c:out value="${pageContext.request.contextPath}"/>/bower_components/font-awesome/css/font-awesome.min.css"
	rel="stylesheet" type="text/css">

<!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
<!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
<!--[if lt IE 9]>
        <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
        <script src="https://oss.maxcdn.com/libs/respond.js/1.4.2/respond.min.js"></script>
    <![endif]-->

<style type="text/css"></style>
<style type="text/css"></style>
</head>

<body>

	<div id="wrapper"
		style="background-image: -webkit-linear-gradient(bottom, #15BD15 0%, #A6A6A6 100%);">

		<!-- Navigation -->
		<nav class="navbar navbar-default navbar-static-top" role="navigation" style="margin-bottom: 0; height: 51px; background-image: -webkit-radial-gradient(center, circle farthest-side, #FFFFFF 0%, #3BE33B 100%);">
            <div class="navbar-header">
                <button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-collapse">
                    <span class="sr-only">Toggle navigation</span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                </button>
                <a class="navbar-brand" style="color: black">Navigation</a>
            </div>
		<!-- /.navbar-header -->

		<ul class="nav navbar-top-links navbar-right">
			<li>
	           	<c:if test="${applicationScope.exchangeIsRunning == 1}">
	           	<img alt="Exchange Running" height="40px"
					src="<c:out value="${pageContext.request.contextPath}"/>/images/exchangeGif.gif">
					</c:if>
            </li>
            <li>	
            	<form action="<c:out value="${pageContext.request.contextPath}"/>/execute/startexecution.htm">
            	     <c:set var="exchangeButtonClass" value="btn btn-success"/>
            		 <c:if test="${applicationScope.exchangeIsRunning == 1}">
	            		<c:set var="exchangeButtonClass" value="btn btn-success disabled"/>
					</c:if>
            	<input type="submit"  class="${exchangeButtonClass}" style="font-weight: bold" value="Start Exchange">           	
            	</form>            	
            </li>
			<!-- /.dropdown -->
			<li class="dropdown"><a class="dropdown-toggle"
				data-toggle="dropdown" href="#" aria-expanded="false"> <i
					class="fa fa-user fa-fw"></i> <i class="fa fa-caret-down"></i>
			</a>
				<ul class="dropdown-menu dropdown-user">
					<li></li>
					<li></li>

					<li><a
						href="<c:out value="${pageContext.request.contextPath}"/>/logout/logout1.htm"><i
							class="fa fa-sign-out fa-fw"></i> Logout</a></li>
				</ul> <!-- /.dropdown-user --></li>
			<!-- /.dropdown -->
		</ul>
		<!-- /.navbar-top-links -->

		<div class="navbar-default sidebar" role="navigation">
			<div class="sidebar-nav navbar-collapse">
				<ul class="nav in" id="side-menu">
					<li><a
						href="<c:out value="${pageContext.request.contextPath}"/>/viewfills/viewfills1.htm" style="color: rgb(23, 184, 70);"><i
							class="fa fa-table fa-fw"></i> View Fills</a></li>
					<li><a href="#" class="active" style="color: rgb(23, 184, 70);"><i class="fa fa-edit fa-fw"></i> Configure Securities<span
							class="fa arrow"></span></a></li>
				</ul>
			</div>
			<!-- /.sidebar-collapse -->
		</div>
		<!-- /.navbar-static-side --> </nav>

		<div id="page-wrapper" style="border-color: green; background-image: url('${pageContext.request.contextPath}/images/greenstripe.jpg'); background-repeat: no-repeat; background-attachment: fixed; background-size: 100% 100%;">
			<div class="row">
				<div class="col-lg-12">

					<div class="page-header" style=" font-size: 35px; font-family: Georgia, Times, 'Times New Roman', serif;">

						Configure Securities
						<%-- 						<img align="top" alt="image here" style="margin-left: 300px;" src="<c:out value="${pageContext.request.contextPath}"/>/images/BabaBroker.JPG"> --%>

						<img style="float: right;   margin-top: -10px;" alt="Baba Broker"
							src="<c:out value="${pageContext.request.contextPath}"/>/images/BabaBrokerGreenLogoHalf.png">
					</div>

				</div>
				<!-- /.col-lg-12 -->
			</div>
			<!-- /.row -->
			<div class="row">
				<div class="col-lg-6">


					<!-- /.panel -->
				</div>

			</div>
			<!-- /.row -->

			<!-- /.row -->

			<!-- /.row -->
			<!--             <div class="row"> -->
			<!--                 <div class="col-lg-6"> -->
			<!--                     <div class="panel panel-default"> -->

			<!--                         /.panel-heading -->
			<div class="panel panel-default">
				<div class="panel-heading" style="background-color: rgb(24, 183, 73); color: white; font-size: 16px">
					<b>Enter Configuration Details and Select Securities</b>
				</div>
				<div class="panel-body">
					<div>
						<c:if test="${not empty error}">
							<p style="color: #FF0000;"><b>Errors Saving Config: </b><br>${error}</p>
						</c:if>
					</div>
					<div>
						<c:if test="${not empty saveMessage}">
							<p style="color: #01DF3A;">
								<b>${saveMessage}</b>
							</p>
						</c:if>
					</div>
					<form id="saveConfigForm" name="saveConfigForm" method="post"
						action="<c:out value="${pageContext.request.contextPath}"/>/saveConfig.htm">
						<table>
							<tr>
								<td><label>Max Price Spread % (0-100): </label> <input
									type="number" name="maxpricespread" class="form-control">

									<label>Max Num of Executions/Order (>0): </label> <input
									type="number" name="maxnumexecutions" class="form-control">

									<label>Max Interval btw Executions (ms): </label> <input
									type="number" name="maxtimebtwexecutions" class="form-control">

									<label>Probable % of Fully Executed Orders (0-100): </label> <input
									type="number" name="probpercentfullexec" class="form-control">
								</td>
								<td>&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;</td>
								<td>
									<table width="300" border="0">
										<tr>
											<td><label>Apply Config: </label></td>
											<td>&emsp;&emsp;</td>
											<td><label>&emsp;</label><select name="multiselect"
												size="3" multiple="multiple" style="height: 160px">
													<c:forEach var="unmappedsecurity"
														items="${unmappedSecurities}">
														<option>
															<c:out value="${unmappedsecurity.securitysymbol}"></c:out>
															&emsp;
															<c:out value="${unmappedsecurity.securityname}"></c:out>
															&emsp;
															<c:out value="${unmappedsecurity.lasttradeprice}" />
														</option>
													</c:forEach>
											</select></td>
										</tr>
										<tr>
											<td></td>
											<td></td>
											<td>&emsp;</td>
										</tr>
										<tr>
											<td></td>
											<td></td>
											<td>

												<button type="button"
													class="btn btn-primary btn-lg btn-block btn-success"
													data-toggle="modal" data-target="#myModal">Save</button> <!--						      	<input type="submit" name="Submit" class="btn btn-primary btn-lg btn-block" value="Save" onclick="return confirm('Are you sure you would like to save this security configuration?')" tabindex="2" style="height: 40px; vertical-align: top;"/>-->
												<div class="modal fade" id="myModal" name="myModal"
													tabindex="-1" role="dialog" aria-labelledby="myModalLabel"
													aria-hidden="true">
													<div class="modal-dialog">
														<div class="modal-content">
															<div class="modal-header">
																<button type="button" class="close" data-dismiss="modal"
																	aria-hidden="true">×</button>
																<h4 class="modal-title" id="myModalLabel">Confirm
																	Save</h4>
															</div>
															<div class="modal-body">Are you sure you would like
																to save this security configuration?</div>
															<div class="modal-footer">
																<button type="button" class="btn btn-default"
																	data-dismiss="modal">Close</button>
																<button type="submit" class="btn btn-primary btn-success">Save
																	</button>
															</div>
														</div>
														<!-- /.modal-content -->
													</div>
													<!--   /.modal-dialog -->
												</div> <!-- /.modal -->
											</td>
										</tr>
									</table>
								</td>
							</tr>
						</table>
					</form>
				</div>

			</div>

			<!--                         /.panel-body -->
			<!-- /.row -->

			<div class="row">
				<div class="col-lg-12">
					<div class="panel panel-default">
						<div class="panel-heading" style="background-color: rgb(24, 183, 73); color: white; font-size: 16px">
							<b>Saved Security Configurations</b>
						</div>
						<!-- /.panel-heading -->

						<div class="panel-body">
							<div class="dataTable_wrapper">
								<div id="dataTables-example_wrapper"
									class="dataTables_wrapper form-inline dt-bootstrap no-footer">
									<!--                                 	<div class="row"> -->
									<!--                                 		<div class="col-sm-6"> -->
									<!--                                 			<div class="dataTables_length" id="dataTables-example_length"> -->
									<%--                                 				<form action="<c:out value="${pageContext.request.contextPath}"/>/changeNumEntries/changedToNew.htm" method="post"> --%>
									<!--                                 				<label>Show  -->
									<!--                                 					<select name="entrynum" aria-controls="dataTables-example" class="form-control input-sm"> -->
									<%--                                 						<option <c:if test='${entryNumCount eq 9}' >selected</c:if>  value="10">10</option> --%>
									<%--                                 						<option <c:if test='${entryNumCount eq 24}' >selected</c:if> value="25">25</option> --%>
									<%--                                 						<option <c:if test='${entryNumCount eq 49}' >selected</c:if> value="50">50</option> --%>
									<%--                                 						<option <c:if test='${entryNumCount eq 99}' >selected</c:if> value="100">100</option> --%>
									<!--                                 					</select> entries/page &emsp; -->
									<!--                                 				</label> -->
									<!--                                 				<input type="submit" name="changeEntriesSubmit" class="btn btn-primary" value="Refresh"> -->
									<!--                                 				</form> -->
									<!--                                 			</div> -->
									<!--                                 		</div> -->
									<!--                                 	</div> -->
									<div class="row">
										<div class="col-sm-12">
											<table
												class="table table-striped table-bordered table-hover dataTable no-footer"
												" id="dataTables-example" role="grid"
												aria-describedby="dataTables-example_info">
												<thead>
													<tr role="row">
														<th class="sorting_asc" tabindex="0"
															aria-controls="dataTables-example" rowspan="1"
															colspan="1" aria-sort="ascending"
															aria-label="Security Symbol: activate to sort column descending"
															style="width: 140px;">Security Symbol</th>
														<th class="sorting" tabindex="0"
															aria-controls="dataTables-example" rowspan="1"
															colspan="1"
															aria-label="Name: activate to sort column ascending"
															style="width: 220px;">Name</th>
														<th class="sorting" tabindex="0"
															aria-controls="dataTables-example" rowspan="1"
															colspan="1"
															aria-label="Last Trade Price: activate to sort column ascending"
															style="width: 150px;">Last Trade Price</th>
														<th class="sorting" tabindex="0"
															aria-controls="dataTables-example" rowspan="1"
															colspan="1"
															aria-label="Max Price Spread: activate to sort column ascending"
															style="width: 165px;">Max Price Spread (%)</th>
														<th class="sorting" tabindex="0"
															aria-controls="dataTables-example" rowspan="1"
															colspan="1"
															aria-label="Max Num Executions/Order: activate to sort column ascending"
															style="width: 122px;">Max Num Executions per Order</th>
														<th class="sorting" tabindex="0"
															aria-controls="dataTables-example" rowspan="1"
															colspan="1"
															aria-label="Max Time btw Executions: activate to sort column ascending"
															style="width: 122px;">Max Time btw Executions (ms)</th>
														<th class="sorting" tabindex="0"
															aria-controls="dataTables-example" rowspan="1"
															colspan="1"
															aria-label="Prob % of Fully Executed Orders: activate to sort column descending"
															style="width: 171px;">Prob % of Fully Executed
															Orders</th>
													</tr>
												</thead>
												<tbody>
													<c:forEach var="security" items="${mappedSecurities}"
														begin="0" end="${mappedSecuritiesCount}" varStatus="loop">
														<c:set var="rowclass" value="gradeA odd" />
														<c:if test="${loop.index  % 2 == 0}">
															<c:set var="rowclass" value="gradeA even" />
														</c:if>
														<tr class="${rowclass}" role="row">
															<td class="sorting_1"><c:out
																	value="${security.securitysymbol}"></c:out></td>
															<td><c:out value="${security.securityname}"></c:out></td>
															<td><c:out value="${security.lasttradeprice}" /></td>
															<td><c:out
																	value="${security.securityConfigMapping.configurationInfo.maxpricespread}"></c:out></td>
															<td><c:out
																	value="${security.securityConfigMapping.configurationInfo.maxnumexecutions}"></c:out></td>
															<td><c:out
																	value="${security.securityConfigMapping.configurationInfo.maxtimebtwexecutions}"></c:out></td>
															<td><c:out
																	value="${security.securityConfigMapping.configurationInfo.probpercentfullexec}"></c:out></td>
														</tr>
													</c:forEach>
												</tbody>
											</table>
										</div>
									</div>
									<!--                               <div class="row"> -->
									<!--                               	<div class="col-sm-6"> -->
									<!--                               		<div class="dataTables_info" id="dataTables-example_info" role="status" aria-live="polite"> -->
									<%--                               			<c:set var="minCount" value="${(entryNumCount+1)*pageNum}"/> --%>
									<%--                               			<c:if test="${minCount > executionCount}"><c:set var="minCount" value="${executionCount}"/></c:if> --%>
									<%--                               			<c:out value="Showing ${(entryNumCount+1) * (pageNum-1) + 1} to ${minCount} of ${executionCount} rows"> --%>
									<%--                               			</c:out> --%>
									<!--                               		</div> -->
									<!--                               	</div> -->
									<!--                               	<div class="col-sm-6"> -->
									<!--                               		<div class="dataTables_paginate paging_simple_numbers" id="dataTables-example_paginate"> -->
									<%--                               			<form action="<c:out value="${pageContext.request.contextPath}"/>/changePageNum/changed.htm" method="post"> --%>
									<%--                               				<input type="hidden" name="pageNum" value="<c:out value="${pageNum}"/>"> --%>
									<!-- 	                              			<ul class="pagination"> -->
									<!-- 	                              				<li class="paginate_button previous disabled" aria-controls="dataTables-example" tabindex="0" id="dataTables-example_previous"><a href="#">Previous</a></li> -->
									<!-- 	                              				<li class="paginate_button active" aria-controls="dataTables-example" tabindex="0"><a href="#">1</a></li> -->
									<%-- 	                              				<li class="paginate_button active" aria-controls="dataTables-example" tabindex="0"><input type="submit" class="pageLinkButton" name="page1Link" value="1" onclick="<c:set var="selectedPageNum" value="1"/>"><!-- <a onclick="form.submit(); <c:set var="selectedPageNum" value="1"/>">1</a>--></li> --%>
									<%--  	                              				<li class="paginate_button " aria-controls="dataTables-example" tabindex="0"><input type="submit" class="pageLinkButton" name="page2Link" value="2" onclick="<c:set var="selectedPageNum" value="2"/>"></li> --%>
									<%--  	                              				<li class="paginate_button " aria-controls="dataTables-example" tabindex="0"><input type="submit" class="pageLinkButton" name="page3Link" value="3" onclick="<c:set var="selectedPageNum" value="3"/>"></li> --%>
									<!--  	                              				<li class="paginate_button " aria-controls="dataTables-example" tabindex="0"><a href="#">4</a></li> -->
									<!--  	                              				<li class="paginate_button " aria-controls="dataTables-example" tabindex="0"><a href="#">5</a></li> -->
									<!--  	                              				<li class="paginate_button " aria-controls="dataTables-example" tabindex="0"><a href="#">6</a></li> -->
									<!-- 	                              				<li class="paginate_button " aria-controls="dataTables-example" tabindex="0"><a href="#">2</a></li> -->
									<!-- 	                              				<li class="paginate_button " aria-controls="dataTables-example" tabindex="0"><a href="#">3</a></li> -->
									<!-- 	                              				<li class="paginate_button " aria-controls="dataTables-example" tabindex="0"><a href="#">4</a></li> -->
									<!-- 	                              				<li class="paginate_button " aria-controls="dataTables-example" tabindex="0"><a href="#">5</a></li> -->
									<!-- 	                              				<li class="paginate_button " aria-controls="dataTables-example" tabindex="0"><a href="#">6</a></li> -->
									<!-- 	                              				<li class="paginate_button next" aria-controls="dataTables-example" tabindex="0" id="dataTables-example_next"><a href="#">Next</a></li> -->
									<!-- 	                             			</ul> -->
									<!--                              			</form> -->
									<!--                              		</div> -->
									<!--                              	</div> -->
								</div>
							</div>
						</div>
						<!-- /.table-responsive -->
						<!--                             <div class="well"> -->
						<!--                                 <h4>DataTables Usage Information</h4> -->
						<!--                                 <p>DataTables is a very flexible, advanced tables plugin for jQuery. In SB Admin, we are using a specialized version of DataTables built for Bootstrap 3. We have also customized the table headings to use Font Awesome icons in place of images. For complete documentation on DataTables, visit their website at <a target="_blank" href="https://datatables.net/">https://datatables.net/</a>.</p> -->
						<!--                                 <a class="btn btn-default btn-lg btn-block" target="_blank" href="https://datatables.net/">View DataTables Documentation</a> -->
						<!--                             </div> -->
					</div>
					<!-- /.panel-body -->
				</div>
				<!-- /.panel -->
			</div>
			<!-- /.col-lg-12 -->
		</div>

	</div>
	<!-- /#page-wrapper -->

	</div>
	<!-- /#wrapper -->

	<!-- jQuery -->
	<script
		src="<c:out value="${pageContext.request.contextPath}"/>/bower_components/jquery/dist/jquery.min.js"></script>

	<!--     Bootstrap Core JavaScript -->
	<script
		src="<c:out value="${pageContext.request.contextPath}"/>/bower_components/bootstrap/dist/js/bootstrap.min.js"></script>

	<!-- Metis Menu Plugin JavaScript -->
	<script
		src="<c:out value="${pageContext.request.contextPath}"/>/bower_components/metisMenu/dist/metisMenu.min.js"></script>

	<!-- DataTables JavaScript -->
	<script
		src="<c:out value="${pageContext.request.contextPath}"/>/bower_components/datatables/media/js/jquery.dataTables.min.js"></script>
	<script
		src="<c:out value="${pageContext.request.contextPath}"/>/bower_components/datatables-plugins/integration/bootstrap/3/dataTables.bootstrap.min.js"></script>

	<!-- Custom Theme JavaScript -->
	<script
		src="<c:out value="${pageContext.request.contextPath}"/>/dist/js/sb-admin-2.js"></script>

	<!-- Page-Level Demo Scripts - Tables - Use for reference -->
	<script>
		$(document).ready(function() {
			$('#dataTables-example').DataTable({
				responsive : true
			});
		});
	</script>



</body>
</html>