<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<html>
<head>
<link rel="stylesheet"
	href="${pageContext.request.contextPath }/css/bootstrap.min.css">
<script
	src="${pageContext.request.contextPath }/js/jquery-1.11.3.min.js"></script>
<script src="${pageContext.request.contextPath }/js/bootstrap.js"></script>
</head>
<body>
	<div>

		<button class="btn btn-primary btn-sm" data-toggle="modal"
			data-target="#excel">下载Excel模板</button>
		<!-- Excel模态框（Modal） -->
		<div class="modal fade" id="excel" tabindex="-1" role="dialog"
			aria-labelledby="myModalLabel" aria-hidden="true">
			<div class="modal-dialog">
				<div class="modal-content">
					<div class="modal-header">
						<button type="button" class="close" data-dismiss="modal"
							aria-hidden="true">&times;</button>
						<h4 class="modal-title" id="myModalLabel">下载Excel模板</h4>
					</div>
					<form action="${pageContext.request.contextPath }/exportWebExcel"
						method="post">
						<div class="modal-body">
							单选题数量:&nbsp;&nbsp;<input type="text" name="danxuan" value=""
								title="请输入单选题数量" /> <br /> <br /> 多选题数量:&nbsp;&nbsp;<input
								type="text" name="duoxuan" /> <br /> <br /> 判断题数量:<input
								type="text" name="panduan" /><br /> <br />
						</div>
						<div class="modal-footer">
							<button type="button" class="btn btn-default"
								data-dismiss="modal">关闭</button>
							<input type="submit" class="btn btn-primary" value="确认">
						</div>
					</form>
				</div>
				<!-- /.modal-content -->
			</div>
			<!-- /.modal -->
		</div>



		<p></p>
		<!-- -------------------多个模态框样式套用有冲突，解决的办法很简单，用DIV将每个dialog的代码片段包裹一下-------------------------------------------- -->
		<p></p>
		<div>
			<!-- 按钮触发模态框 -->
			<button class="btn btn-primary btn-sm" data-toggle="modal"
				data-target="#wordMT">下载Word模板</button>

			<!-- Excel模态框（Modal） -->
			<div class="modal fade" id="wordMT" tabindex="-1" role="dialog"
				aria-labelledby="myModalLabel" aria-hidden="true">
				<div class="modal-dialog">
					<div class="modal-content">
						<div class="modal-header">
							<button type="button" class="close" data-dismiss="modal"
								aria-hidden="true">&times;</button>
							<h4 class="modal-title" id="myModalLabel">下载Word模板</h4>
						</div>
						<form action="${pageContext.request.contextPath }/exporWebWord"
							method="post">
							<div class="modal-body">
								单选题数量:&nbsp;&nbsp;<input type="text" name="danxuan" value=""
									title="请输入单选题数量" /> <br /> <br /> 多选题数量:&nbsp;&nbsp;<input
									type="text" name="duoxuan" /> <br /> <br /> 判断题数量:<input
									type="text" name="panduan" /><br /> <br />
							</div>
							<div class="modal-footer">
								<button type="button" class="btn btn-default"
									data-dismiss="modal">关闭</button>
								<input type="submit" class="btn btn-primary" value="确认">
							</div>
						</form>
					</div>
					<!-- /.modal-content -->
				</div>
				<!-- /.modal -->
			</div>


			<p></p>
			<!-- 上传Excel```````````````````````` -->
			<div>
				<!-- 按钮触发模态框 -->
				<button class="btn btn-primary btn-sm" data-toggle="modal"
					data-target="#DRexcel">上传Excel试题</button>

				<!-- Excel模态框（Modal） -->
				<div class="modal fade" id="DRexcel" tabindex="-1" role="dialog"
					aria-labelledby="myModalLabel" aria-hidden="true">
					<div class="modal-dialog">
						<div class="modal-content">
							<div class="modal-header">
								<button type="button" class="close" data-dismiss="modal"
									aria-hidden="true">&times;</button>
								<h4 class="modal-title" id="myModalLabel">导入Excel试题</h4>
							</div>
							<form action="${pageContext.request.contextPath }/importWebExcel"
								method="post" enctype="multipart/form-data">
								<div class="modal-body">
									<input type="file" name="fileName">
								</div>
								<div class="modal-footer">
									<button type="button" class="btn btn-default"
										data-dismiss="modal">关闭</button>
									<input type="submit" class="btn btn-primary" value="确认">
								</div>
							</form>
						</div>
						<!-- /.modal-content -->
					</div>
					<!-- /.modal -->
				</div>



				<p></p>
				<!-- 上传Excel2```````````````````````` -->
				<div>
					<!-- 按钮触发模态框 -->
					<button class="btn btn-primary btn-sm" data-toggle="modal"
						data-target="#DRexcel2">上传Excel试题2</button>

					<!-- Excel模态框（Modal） -->
					<div class="modal fade" id="DRexcel2" tabindex="-1" role="dialog"
						aria-labelledby="myModalLabel" aria-hidden="true">
						<div class="modal-dialog">
							<div class="modal-content">
								<div class="modal-header">
									<button type="button" class="close" data-dismiss="modal"
										aria-hidden="true">&times;</button>
									<h4 class="modal-title" id="myModalLabel">导入Excel试题</h4>
								</div>
								<form
									action="${pageContext.request.contextPath }/importWebExcel2"
									method="post" enctype="multipart/form-data">
									<div class="modal-body">
										<input type="file" name="fileName">
									</div>
									<div class="modal-footer">
										<button type="button" class="btn btn-default"
											data-dismiss="modal">关闭</button>
										<input type="submit" class="btn btn-primary" value="确认">
									</div>
								</form>
							</div>
							<!-- /.modal-content -->
						</div>
						<!-- /.modal -->
					</div>


					<p></p>
					<!-- 上传txt文件```````````````````````` -->
					<div>
						<!-- 按钮触发模态框 -->
						<button class="btn btn-primary btn-sm" data-toggle="modal"
							data-target="#txt">上传txt试题2</button>

						<!-- Excel模态框（Modal） -->
						<div class="modal fade" id="txt" tabindex="-1" role="dialog"
							aria-labelledby="myModalLabel" aria-hidden="true">
							<div class="modal-dialog">
								<div class="modal-content">
									<div class="modal-header">
										<button type="button" class="close" data-dismiss="modal"
											aria-hidden="true">&times;</button>
										<h4 class="modal-title" id="myModalLabel">导入txt试题</h4>
									</div>
									<form
										action="${pageContext.request.contextPath }/importTxtData"
										method="post" enctype="multipart/form-data">
										<div class="modal-body">
											<input type="file" name="fileName">
										</div>
										<div class="modal-footer">
											<button type="button" class="btn btn-default"
												data-dismiss="modal">关闭</button>
											<input type="submit" class="btn btn-primary" value="确认">
										</div>
									</form>
								</div>
								<!-- /.modal-content -->
							</div>
							<!-- /.modal -->
						</div>

						<p></p>
						<!-- 上传Word```````````````````````` -->
						<div>
							<!-- 按钮触发模态框 -->
							<button class="btn btn-primary btn-sm" data-toggle="modal"
								data-target="#DRword">上传Word试题</button>

							<!-- Excel模态框（Modal） -->
							<div class="modal fade" id="DRword" tabindex="-1" role="dialog"
								aria-labelledby="myModalLabel" aria-hidden="true">
								<div class="modal-dialog">
									<div class="modal-content">
										<div class="modal-header">
											<button type="button" class="close" data-dismiss="modal"
												aria-hidden="true">&times;</button>
											<h4 class="modal-title" id="myModalLabel">导入Word试题</h4>
										</div>
										<form
											action="${pageContext.request.contextPath }/importWebWord"
											method="post" enctype="multipart/form-data">
											<div class="modal-body">
												<input type="file" name="fileName">
											</div>
											<div class="modal-footer">
												<button type="button" class="btn btn-default"
													data-dismiss="modal">关闭</button>
												<input type="submit" class="btn btn-primary" value="确认">
											</div>
										</form>
									</div>
									<!-- /.modal-content -->
								</div>
								<!-- /.modal -->
							</div>


							<p></p>
							<p></p>
							<a class="btn btn-primary btn-sm"
								href="${pageContext.request.contextPath }/exportWebExamPaper">下载Word试卷</a>
							<p></p>
							<p></p>
							<a class="btn btn-primary btn-sm"
								href="${pageContext.request.contextPath }/exportWebExcel2">下载Excel模板2</a>
							<p></p>
							<p></p>
							<a class="btn btn-primary btn-sm"
								href="${pageContext.request.contextPath }/exportExcelPaper">下载Excel试题2</a>
							<p></p>
							<p></p>
							<a class="btn btn-primary btn-sm"
								href="${pageContext.request.contextPath }/exportTxtTemplate">下载txt模板</a>
							<p></p>
							<p></p>
							<a class="btn btn-primary btn-sm"
								href="${pageContext.request.contextPath }/exportTxtPaper">下载txt试题</a>
								
								
</body>
</html>
