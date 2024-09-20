<%@ page language="java"
         contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@include file="./include/header.jsp"%>

<!-- Main content -->
<section class="content">
	<div class="row">
		<!-- left column -->
		<div class="col-md-12">
			<!-- general form elements -->
			<div class='box'>
				<div class="box-header with-border">
					<h3 class="box-title">Board List</h3>
				</div>
				<div class='box-body'>
					<!-- 추가  -->
					<select name="searchType" id="searchType">
						<option value="title">제목</option>
						<option value="writer">작성자</option>
					</select> 
					<input type="text" name='searchKeyword' id="searchKeyword">
					<button id='searchBtn'>Search</button>
					<!-- 기존 -->
					<button id='newBtn'>New Board</button>
				</div>
				
				
				
			</div>
			<div class="box">
				<div class="box-header with-border">
					<h3 class="box-title">LIST PAGING</h3>
				</div>
				<div class="box-body">
					<table class="table table-bordered">
						<tr>
							<th style="width: 10px">BNO</th>
							<th>TITLE</th>
							<th>WRITER</th>
							<th>REGDATE</th>
							<th style="width: 40px">VIEWCNT</th>
						</tr>
						
						<tbody id="tbody">
						<!-- 구현 부 -->

							<tr>
								<td>oooo</td>
								<td><a  href=''>oooo</a></td>
								<td>oooo</td>
								<td>oooo</td>
								<td><span class="badge bg-red">oooo</span></td>
							</tr>

						
						</tbody>
					</table>
				</div>
				<!-- /.box-body -->


				<div class="box-footer">

					
				</div>

			</div>
		</div>
	</div>
</section>
</div>
<!-- /.content -->





<%@include file="./include/footer.jsp"%>


<script>


</script>