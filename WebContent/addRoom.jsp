<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8"> 
<title>Insert title here</title>
</head>
<body id="page-top">
<div id="wrapper">
<div id="content-wrapper" class="d-flex flex-column">

      <!-- Main Content -->
      <div id="content">
<div class="container-fluid">
	<form action="addRoom" method="post" enctype='multipart/form-data'>
		Room ID: <input type="text" class="form-control form-control-user" name="room_id" ><br> 
		Room Name: <input type="text" name="room_name" class="form-control form-control-user"><br> 
		Room Type: <select name="roomType" class="nav-link dropdown-toggle">
                    
                    <c:forEach items="${roomTypes}" var="rt">
                        <option value="${rt.getRtID()}"> ${rt.getRtName()} </option>
                    </c:forEach>
                </select>
                <br>
        Room Price<input type="text" class="form-control form-control-user" name="room_price" value=""><br> 
		Room Note<input type="text"  class="form-control form-control-user" name="room_note" value=""> <br>
		Room Status<input type="text" class="form-control form-control-user" name="room_status" value=""><br> 
		Room Image<input type="file" name="room_image" />
		<button type="submit" name="action" value="AddRoom" class="btn btn-success btn-icon-split">
                    <span class="icon text-white-50">
                      <i class="fas fa-check"></i>
                    </span>
                    <span class="text">Add Room</span>
         </button>
		<a href="${pageContext.request.contextPath}/roomList" class="btn btn-secondary btn-icon-split">
                    <span class="icon text-white-50">
                      <i class="fas fa-arrow-right"></i>
                    </span>
                    <span class="text">Cancel</span>
                  </a>
	</form>
		</div>
      <!-- End of Main Content -->
	</div>
      <!-- Footer -->
      <!-- End of Footer -->

    </div>
	</div>
</body>
</html>