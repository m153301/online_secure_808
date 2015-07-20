package servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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
		int itemPrice = Integer.parseInt(request.getParameter("item_price"));
		int itemStock = Integer.parseInt(request.getParameter("item_stock"));
		String itemName = request.getParameter("item_name");
		
		ItemInfoChangeManager iicm = new ItemInfoChangeManager();
		
		iicm.updateItemInfo(itemId, itemName, itemPrice, itemStock);
		
		getServletContext().getRequestDispatcher("/jsp/worker/ItemInfoChangeDone.jsp").forward(request, response);
		
	}
}