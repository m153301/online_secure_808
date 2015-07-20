package servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.StringEscapeUtils;

import beans.Item;
import controller.CustomerManager;
import controller.ItemInfoChangeManager;
import utility.PasswordEncryption;


public class ItemInfoChangeListServlet extends HttpServlet{
	
	public void doGet(HttpServletRequest request,HttpServletResponse response)
			throws ServletException,IOException{
				doPost(request,response);
		}

		public void doPost(HttpServletRequest request,HttpServletResponse response)
			throws ServletException,IOException{
			
			request.setCharacterEncoding("UTF-8");
			ItemInfoChangeManager iicm = new ItemInfoChangeManager();
			List<Item> items = iicm.searchItemInfoAll();
			request.setAttribute("items", items);
			getServletContext().getRequestDispatcher("/jsp/worker/ItemInfoChangeList.jsp").forward(request, response);

		}
}