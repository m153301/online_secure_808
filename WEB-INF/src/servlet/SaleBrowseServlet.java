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

import beans.Sale;
import controller.SaleBrowseManager;

public class SaleBrowseServlet extends HttpServlet{

	private static final long serialVersionUID = 1L;

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		doPost(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
												throws ServletException, IOException{


		request.setCharacterEncoding("UTF-8");

		SaleBrowseManager manager = new SaleBrowseManager();
		ArrayList<Sale> saleList = manager.saleBrowse();

		int i;

		for(i=0; i<saleList.size(); i++){
			System.out.println(saleList.get(i).getItemName());
			System.out.println(saleList.get(i).getPurchaceQuantity());
		}

		request.setAttribute("SaleList", saleList);
		getServletContext().getRequestDispatcher("/jsp/worker/SaleBrowse.jsp").forward(request, response);
	}

}
