
package servlet;

/*****************************************************************************/
//		商品を追加するservlet
/*****************************************************************************/

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controller.ItemInfoRegistManager;
import beans.Item;

public class ItemInfoRegistServlet extends HttpServlet{

	private static final long serialVersionUID = 1L;

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		doPost(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
												throws ServletException, IOException{


		request.setCharacterEncoding("UTF-8");

		String item_name = request.getParameter("item_name");
		int item_price = Integer.parseInt(request.getParameter("item_price"));
		int item_stock = Integer.parseInt(request.getParameter("item_stock"));

		Item item = new Item(0,item_name,item_price,item_stock);

		ItemInfoRegistManager manager = new ItemInfoRegistManager();

		manager.registItemInfo(item);


//		HttpSession session = request.getSession(true);
//		User user = (User)session.getAttribute("user");

//		String user_id = request.getParameter(user.getUserId());



//		response.sendRedirect(response.encodeRedirectURL("./dekita.jsp"));
	}

}
