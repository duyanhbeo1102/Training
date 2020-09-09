package controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Base64;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import org.apache.commons.compress.utils.IOUtils;

import DAL.RoomDAO;
import DAL.RoomTypeDAO;
import model.Room;
import model.RoomType;

/**
 * Servlet implementation class AddRoomController
 */
@MultipartConfig
public class AddRoomController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddRoomController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		request.setCharacterEncoding("utf-8");
		// TODO Auto-generated method stub
		RoomTypeDAO roomTypeDB = new RoomTypeDAO();
		ArrayList<RoomType> roomTypes = roomTypeDB.all();
		request.setAttribute("roomTypes", roomTypes);
		request.getRequestDispatcher("addRoom.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		request.setCharacterEncoding("utf-8");
		// TODO Auto-generated method stub
		int room_id = Integer.parseInt(request.getParameter("room_id"));
		String room_name = request.getParameter("room_name");
		int rt_id = Integer.parseInt(request.getParameter("roomType"));
		double room_price = Double.parseDouble(request.getParameter("room_price"));
		String room_note = request.getParameter("room_note");
		int room_status = Integer.parseInt(request.getParameter("room_status"));
		Part imagePart = request.getPart("room_image");
        InputStream partInputStream = imagePart.getInputStream();
		byte[] bytes = IOUtils.toByteArray(partInputStream);
		partInputStream.read(bytes);
        String img64=  new String(Base64.getEncoder().encodeToString(bytes));
       
		RoomType rt = new RoomType();
		rt.setRtID(rt_id);
		Room room = new Room(room_id, room_name, rt, room_price, room_status, room_note, img64);
		RoomDAO roomDB = new RoomDAO();
		try {
			roomDB.insert(room);
		}
		catch (Exception e) {
			// TODO: handle exceptionre
		}
		response.sendRedirect(request.getContextPath()+"/roomList");
	}

}
