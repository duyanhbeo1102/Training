<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
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
<h1 class="h3 mb-2 text-gray-800" id='heading'>Room Detail</h1>
  <form action="roomDetail" method="post">
  	Room ID: <input class="form-control form-control-user" type = 'text' id='detailRoomID' name="room_id" readonly/>
 	Room Name:<input  class="form-control form-control-user" type = 'text' id='detailRoomName' name="room_name" />
  	Room Type:<select name="roomType" id ="roomType"class="nav-link dropdown-toggle"></select>
  	Room Price:<input class="form-control form-control-user" type = 'text' id='detailRoomPrice' name="room_price" />
    Room Status:<input class="form-control form-control-user" type = 'text' id='detailRoomStatus'  name="room_status"/>
    Room Note:<input class="form-control form-control-user" type = 'text' id='detailRoomNote'  name="room_note"/>
    Room Image: <img name ="room_image" id="detailRoomImage">
    <button type="submit" name="action" value="Update" class="btn btn-success btn-icon-split">
                    <span class="icon text-white-50">
                      <i class="fas fa-check"></i>
                    </span>
                    <span class="text">Update Room</span>
         </button>
		<a href="${pageContext.request.contextPath}/roomList" class="btn btn-secondary btn-icon-split">
                    <span class="icon text-white-50">
                      <i class="fas fa-arrow-right"></i>
                    </span>
                    <span class="text">Cancel</span>
                  </a>
    </form>
    </div>
	</div>
</body>
</html>