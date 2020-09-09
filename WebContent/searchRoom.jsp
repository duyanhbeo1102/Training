<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<%@ page contentType="text/html; charset=UTF-8" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
  <link href="${pageContext.request.contextPath}/css/dataTable.css" rel="stylesheet" type="text/css">
  <link href="${pageContext.request.contextPath}/vendor/fontawesome-free/css/all.min.css" rel="stylesheet" type="text/css">
  <link href="https://fonts.googleapis.com/css?family=Nunito:200,200i,300,300i,400,400i,600,600i,700,700i,800,800i,900,900i" rel="stylesheet">
<link href="http://ajax.googleapis.com/ajax/libs/jqueryui/1.8/themes/base/jquery-ui.css" rel="stylesheet" type="text/css"/>
<script src="http://ajax.googleapis.com/ajax/libs/jquery/1.5/jquery.min.js"></script>
<script src="http://ajax.googleapis.com/ajax/libs/jqueryui/1.8/jquery-ui.min.js"></script>
  <!-- Custom styles for this template -->
  <link href="${pageContext.request.contextPath}/css/sb-admin-2.min.css" rel="stylesheet">
<script type="text/javascript" src="js/jquery-3.5.1.js"></script>
  <!-- Custom styles for this page -->
  <link href="${pageContext.request.contextPath}/vendor/datatables/dataTables.bootstrap4.min.css" rel="stylesheet">
<title>Insert title here</title>
</head>
<body id="page-top">
<div id="wrapper">
<%@include file="sidebar.jsp" %>
<div id="content-wrapper" class="d-flex flex-column">

      <!-- Main Content -->
      <div id="content">
<%@include file="header.jsp" %>
<!--<a href="${pageContext.request.contextPath}/addRoom" target="_parent"><button>Click me !</button></a>  -->
<div class="container-fluid">

          <!-- Page Heading -->
          <h1 class="h3 mb-2 text-gray-800" id='heading'>List of Room</h1>

          <!-- DataTales Example -->
          <div class="card shadow mb-4">
            <div class="card-body">
            <button id="addRoom" class="btn btn-primary btn-icon-split">
                    <span class="icon text-white-50">
                      <i class="fas fa-flag"></i>
                    </span>
                    <span class="text">Add Room</span>
                  </button>
                  <div class="input-group">
                  <form action="searchRoom" method="post">
                  <input type="text" name="searchValue" id="searchInput"
                  class="form-control bg-light small" placeholder="Search for..." 
                  aria-label="Search" aria-describedby="basic-addon2" />
                  
                  <button  type="submit"class="btn btn-primary" type="button" id="searchButton" >
                  <i class="fas fa-search fa-sm"></i>
                	</button>

                  
                  </form>
                  
                  
                  </div>
            <form action="roomList" method="post">
              <div class="table-responsive">
              
              <div class ="button-in-table">
                  <button type="submit" name="action" value = "Delete" class="btn btn-danger btn-icon-split">
                    <span class="icon text-white-50">
                      <i class="fas fa-trash"></i>
                    </span>
                    <span class="text">Delete</span>
                  </button>
                  
              </div>
         
<table class="table table-bordered" id="dataTable" width="100%" cellspacing="0">
		<thead>
                    <tr>
                      <th></th>
                      <th>Name</th>
                      <th>Type</th>
                      <th>Price</th>
                      <th>Detail</th>
                    </tr>
                  </thead>
                  <tfoot>
                    <tr>
                      <th></th>
                      <th>Name</th>
                      <th>Type</th>
                      <th>Price</th>
                      <th>Detail</th>
                    </tr>
                  </tfoot>
	<tbody>
	<c:forEach var="room" items="${rooms}"> 
		<tr>
	<td><input type="checkbox" name="roomCheckedList" value="${room.getRoomID()}"/></td>
    <td>${room.getRoomName()}</td>
    <td>${room.getRt().getRtName()}</td>
    <td>${room.getRoomPrice()}</td>
    <td><button id='roomDetail' type="button" value = "${room.getRoomID()}"  class="btn btn-info btn-circle" onclick ='showDetails(this)'>
                    <i class="fas fa-info-circle"></i>
                  </button></td>
  </tr>
	
	</c:forEach>
	</tbody>
	</table>
	</div>
	              </form>
	              
            </div>
          </div>
          </div>
          </div>
      <!-- End of Main Content -->
		
      <!-- Footer -->
<%@include file="footer.jsp" %>
      <!-- End of Footer -->

    </div>
	</div>
	<!-- Bootstrap core JavaScript-->
  <script src="${pageContext.request.contextPath}/vendor/jquery/jquery.min.js"></script>
  <script src="${pageContext.request.contextPath}/vendor/bootstrap/js/bootstrap.bundle.min.js"></script>


  <dialog id ="addRoomDialog">
  <%@include file="addRoom.jsp" %>
  </dialog>
  <dialog id = "roomDetailDialog">
  <%@include file="roomDetail.jsp" %>
  </dialog>
  
<script src="${pageContext.request.contextPath}/js/roomFunction.js"></script>

  
</body>
</html>