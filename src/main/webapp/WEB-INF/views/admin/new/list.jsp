<%@include file="/common/taglib.jsp"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ include file="/common/taglib.jsp" %>
    
	<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
	<html>

	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>Danh sách bài viết</title>
	</head>

	<body>
		
	<div class="main-content">
	
	
	<form action ="<c:url value='/home-admin-new'/>" id="formSubmit" method="get">
		
    <div class="main-content-inner">
        <div class="breadcrumbs ace-save-state" id="breadcrumbs">
            <ul class="breadcrumb">
                <li>
                    <i class="ace-icon fa fa-home home-icon"></i>
                    <a href="#">Trang chủ</a>
                </li>
            </ul><!-- /.breadcrumb -->
        </div>
        <div class="page-content">
            <div class="row" >
                <div class="col-xs-12">
                 <div class ="table-responsive">
                  <table class="table table-bordered">
   					 <thead>
    					  <tr>
      						  <th>Tiltle</th>
        					  <th>ShortDescription</th>
       						 
   			 				  </tr>
   							  </thead>
    						  <tbody>
    						  
    						  <c:forEach var="list" items ="${listNew}">
    						  <tr>
    						  <td>${list.tiltle}</td>
    						  <td>${list.shortDescription}</td>
    						  </tr>
    						  
    						  
    						
    						  
    						  
    						  </c:forEach>
    						  
    						  <tr>
    						  <td>${model.page}</td>
    						  <td>${model.totalPage }</td>
    						  </tr>
    						  
    						  </tbody>
				
  </table>
			<div class="container">
			    <nav aria-label="Page navigation">
			        <ul class="pagination" id="pagination"></ul>
			    </nav>
			</div>  
          <input type="hidden" value="" id="page" name="page"/>
          <input type="hidden" value="" id="maxPageItem" name ="maxPageItem"/>
          <input type="hidden" value="" id="sortName" name="sortName"/>
          <input type="hidden" value="" id="sortBy" name ="sortBy"/>
          
  
</div>
                 
                 
                 </div>
                </div>
            </div>
        </div>
      
     
 
<script type="text/javascript">
var currentPage =${model.page};
var totalPages = ${model.totalPage};

var limit =1;

    $(function () {
        window.pagObj = $('#pagination').twbsPagination({
            totalPages: totalPages,
           // visiblePages: 10,
            startPage:currentPage,
            onPageClick: function (event, page) {
            	if (currentPage!=page){
               	$('#maxPageItem').val(limit);
            	$('#page').val(page);
            	$('#sortName').val('tiltle');
            	$('#sortBy').val('desc');
				$('#formSubmit').submit();
            	} 
            }
        });
    });
</script>
   </form>
    </div>      
        

	</body>

	</html>