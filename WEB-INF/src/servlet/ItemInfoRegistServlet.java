
package servlet;

/*****************************************************************************/
//		商品を登録するservlet
/*****************************************************************************/

import java.io.IOException;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import beans.Item;
import beans.Ordered;
import controller.ItemInfoRegistManager;


public class ItemInfoRegistServlet extends HttpServlet{

	private static final long serialVersionUID = 1L;

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		doPost(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
												throws ServletException, IOException{


		request.setCharacterEncoding("UTF-8");

		//まず商品をItemテーブルに格納。最初は発注した数が在庫になる。
		//item_idを返すようにする
		String item_name = request.getParameter("item_name");
		int item_price = Integer.parseInt(request.getParameter("item_price"));
		int item_stock = Integer.parseInt(request.getParameter("item_stock"));

		Item item = new Item( 0, item_name, item_price, item_stock);

		ItemInfoRegistManager manager = new ItemInfoRegistManager();
		int item_id = manager.registItemInfo(item);

		//次に、いつ誰が何をいくつ登録・発注したかを記録する。


		Date date = new Date();

		//セッションを実装したらここを使う
		//セッションからユーザIDを取得
		HttpSession session = request.getSession(true);
		Ordered ordered = new Ordered(0, session.getId(), item_id, item_stock, date);

		//セッションを実装していないときは、user_idは指定
		//Ordered ordered = new Ordered(0, "3510", item_id, item_stock, date);

		ItemInfoRegistManager manager2 = new ItemInfoRegistManager();
		manager2.registItemLog(ordered);

		response.sendRedirect(response.encodeRedirectURL("./ItemInfoRegistDone.jsp"));
	}

}
