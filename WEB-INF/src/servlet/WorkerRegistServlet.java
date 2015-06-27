package servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.StringEscapeUtils;

import controller.WorkerManager;
import utility.PasswordEncryption;


public class WorkerRegistServlet extends HttpServlet{
	
	public void doGet(HttpServletRequest request,HttpServletResponse response)
			throws ServletException,IOException{
				doPost(request,response);
		}

		public void doPost(HttpServletRequest request,HttpServletResponse response)
			throws ServletException,IOException{

			request.setCharacterEncoding("Windows-31J");
			
			String user_name = StringEscapeUtils.escapeHtml4(request.getParameter("worker_name"));
			String user_id = StringEscapeUtils.escapeHtml4(request.getParameter("worker_id"));
			PasswordEncryption passenc = new PasswordEncryption();
			String password = passenc.getPassword_encryption(StringEscapeUtils.escapeHtml4(request.getParameter("worker_pass")));
			
			
			//店員情報登録へ
			WorkerManager worker = new WorkerManager();
			//かぶりがあったら1, なかったら0が帰ってくる
			int check = worker.Regist(user_name, user_id, password);
			
			if(check == 0)
				//完了画面へ
				response.sendRedirect(response.encodeRedirectURL("./WorkerInfoRegistDone.jsp"));
			
			else{
				
				request.setAttribute("error", "idにかぶりがあります");
				getServletContext().getRequestDispatcher("/jsp/worker/WorkerInfoRegist.jsp").forward(request, response);
			}
				
			
			
		}
}