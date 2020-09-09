package controller;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Base64;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import org.apache.commons.compress.utils.IOUtils;

import com.google.gson.Gson;

import DAL.RoomDAO;
import DAL.RoomTypeDAO;
import model.Room;
import model.RoomType;

/**
 * Servlet implementation class RoomDetailController
 */
public class RoomDetailController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RoomDetailController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		int id = Integer.parseInt(request.getParameter("id"));
		RoomDAO roomDB = new RoomDAO();
		Room room = roomDB.get(id);
		System.out.println(room.getRoomImage64());
		RoomTypeDAO roomTypeDB = new RoomTypeDAO();
		ArrayList<RoomType> roomTypes = roomTypeDB.all();
		String roomTypeJson = new Gson().toJson(roomTypes);
		String roomJson = new Gson().toJson(room);
		String bothJson = "["+roomTypeJson+","+roomJson+"]";
		 response.setContentType("application/json");
		    response.setCharacterEncoding("UTF-8");
		    response.getWriter().write(bothJson);
		    
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		request.setCharacterEncoding("utf-8");
		// TODO Auto-generated method stub
		String action = request.getParameter("action");
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
		Room room = new Room(room_id, room_name, rt, room_price, room_status, room_note,img64);
		RoomDAO roomDB = new RoomDAO();
		if ("Update".equals(action)) {
		    roomDB.update(room);
		} else if ("Delete".equals(action)) {
//		    roomDB.delete(room_id);
		}
		response.sendRedirect(request.getContextPath()+"/roomList");
	}

}
