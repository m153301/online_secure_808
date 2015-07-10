package servlet;

/*****************************************************************************/
//		売上確認をするServlet
/*****************************************************************************/

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import beans.Ordered;
import beans.Orderedlist;
import controller.OrderedBrowseManager;

public class OrderedBrowseServlet extends HttpServlet{

	private static final long serialVersionUID = 1L;

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		doPost(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
												throws ServletException, IOException{


		request.setCharacterEncoding("UTF-8");

		OrderedBrowseManager manager = new OrderedBrowseManager();
		ArrayList<Orderedlist> orderedList = manager.orderedBrowse();


		request.setAttribute("OrderedList", orderedList);
		getServletContext().getRequestDispatcher("/jsp/worker/OrderedBrowse.jsp").forward(request, response);
	}

}
