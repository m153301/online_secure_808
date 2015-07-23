
package servlet;

/*****************************************************************************/
//		おすすめされた商品一覧を取得するservlet
/*****************************************************************************/

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.util.ArrayList;
import beans.Item;
import controller.RecommendGetManager;

public class RecommendedItemGetServlet extends HttpServlet{

	private static final long serialVersionUID = 1L;

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		doPost(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
												throws ServletException, IOException{


		request.setCharacterEncoding("UTF-8");

		//おすすめ情報をCustomerTopに渡す
		ArrayList<Item> recommendedItemList = new ArrayList<Item>();
		RecommendGetManager recommendGetManager = new RecommendGetManager();
		recommendedItemList = recommendGetManager.getRecommendedItem();
		request.setAttribute("RecommendedItemList", recommendedItemList);

		getServletContext().getRequestDispatcher("/jsp/customer/CustomerTop.jsp").forward(request, response);
	}

}
