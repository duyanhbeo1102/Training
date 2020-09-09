package controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DAL.RoomDAO;
import DAL.RoomTypeDAO;
import model.Room;
import model.RoomType;

/**
 * Servlet implementation class SearchRoomController
 */

public class SearchRoomController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SearchRoomController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html;charset=UTF-8");
		request.setCharacterEncoding("utf-8");
		String keyword = request.getParameter("searchValue");
		RoomDAO roomDB = new RoomDAO();
		RoomTypeDAO roomTypeDB = new RoomTypeDAO();
		ArrayList<Room> rooms = roomDB.searchRoom(keyword);
		request.setAttribute("rooms", rooms);
		request.getRequestDispatcher("searchRoom.jsp").forward(request, response);
	}

}
