package controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import DAL.RoomDAO;
import DAL.RoomTypeDAO;
import model.Room;
import model.RoomType;

/**
 * Servlet implementation class RoomListController
 */
public class RoomListController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RoomListController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		RoomDAO roomDB = new RoomDAO();
		
		RoomTypeDAO roomTypeDB = new RoomTypeDAO();
		ArrayList<RoomType> roomTypes = roomTypeDB.all();
		int page = 1, pageSize = 5;

        int totalPage = roomDB.getRoomTotalRows();
        if (request.getParameter("page") != null) {
            page = Integer.parseInt(request.getParameter("page"));
        }

        if (totalPage % pageSize == 0) { // calculator total page to show information
            totalPage = totalPage / pageSize;
        } else {
            totalPage = totalPage / pageSize + 1;
        }
		ArrayList<Room> rooms = roomDB.getRoomFromTo(page, pageSize);
		for(Room r: rooms) {
			for(RoomType rt: roomTypes) {
				if (r.getRt().getRtID() == rt.getRtID()) {
					r.setRt(rt);
				}
			}
			
		}
        System.out.println(page+" space "+totalPage);
		request.setAttribute("roomTypes", roomTypes);
		request.setAttribute("rooms", rooms);
        request.setAttribute("page", page);
        request.setAttribute("totalPage", totalPage);
		request.getRequestDispatcher("roomList.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String action = request.getParameter("action");
		System.out.println("action: "+action);
		if("Delete".equals(action)) {
			try {
				String[] delRooms  =  request.getParameterValues("roomCheckedList");
				String delString = String.join(",", delRooms);
				RoomDAO roomDB = new RoomDAO();
					roomDB.delete(delString);

				response.sendRedirect(request.getContextPath()+"/roomList");
			}
			catch (Exception e) {
				// TODO: handle exception
			}
		}
		else if("Export".equals(action)) {
			try {
				response.setContentType("application/vnd.ms-excel");
	            response.setHeader("Content-Disposition", "attachment; filename=RoomManager.xls");
				RoomDAO roomDB = new RoomDAO();
				XSSFWorkbook  workbook = roomDB.exportToExcel();
				workbook.write(response.getOutputStream());
			}
			catch (Exception e) {
				// TODO: handle exception
			}
		}
		
		
	}

}