
package servlet;

/*****************************************************************************/
//		売上確認をするServlet
/*****************************************************************************/

import java.io.IOException;
import java.sql.ResultSet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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
		ResultSet saleList = manager.saleBrowse();

		response.sendRedirect(response.encodeRedirectURL("./SaleBrowse.jsp"));
	}

}
