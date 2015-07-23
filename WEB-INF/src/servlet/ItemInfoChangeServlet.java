package servlet;

import java.io.IOException;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import beans.User;

import org.apache.commons.lang3.StringEscapeUtils;

import controller.ItemInfoChangeManager;

public class ItemInfoChangeServlet extends HttpServlet{
	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
		throws ServletException, IOException{
		doPost(request, response);
	}
	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
		throws ServletException, IOException{

		request.setCharacterEncoding("UTF-8");

		int itemId = Integer.parseInt(request.getParameter("item_id"));
		String itemName = StringEscapeUtils.escapeHtml4(request.getParameter("item_name"));
		int itemPrice = Integer.parseInt(StringEscapeUtils.escapeHtml4(request.getParameter("item_price")));
		int itemStock = Integer.parseInt(StringEscapeUtils.escapeHtml4(request.getParameter("item_stock")));
		
		HttpSession session = request.getSession();
		User worker = (User) session.getAttribute("worker");
		String workerId = worker.getUserId();

		Date date = new Date();
		
		ItemInfoChangeManager iicm = new ItemInfoChangeManager();
		
		iicm.orderItem(workerId, itemId, itemName, itemPrice, itemStock, date);
		
		getServletContext().getRequestDispatcher("/jsp/worker/ItemInfoChangeDone.jsp").forward(request, response);
		
	}
}