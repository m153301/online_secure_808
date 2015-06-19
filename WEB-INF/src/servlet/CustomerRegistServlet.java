package servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.StringEscapeUtils;

import controller.CustomerManager;
import utility.PasswordEncryption;


public class CustomerRegistServlet extends HttpServlet{
	
	public void doGet(HttpServletRequest request,HttpServletResponse response)
			throws ServletException,IOException{
				doPost(request,response);
		}

		public void doPost(HttpServletRequest request,HttpServletResponse response)
			throws ServletException,IOException{

			request.setCharacterEncoding("Windows-31J");
			
			String customer_name = StringEscapeUtils.escapeHtml4(request.getParameter("customer_name"));
			String tel = StringEscapeUtils.escapeHtml4(request.getParameter("tel"));
			String credit_number = StringEscapeUtils.escapeHtml4(request.getParameter("credit_number"));
			String credit_type = request.getParameter("credit_type_id");
			String user_id = StringEscapeUtils.escapeHtml4(request.getParameter("customer_id"));
			PasswordEncryption passenc = new PasswordEncryption();
			String password = passenc.getPassword_encryption(StringEscapeUtils.escapeHtml4(request.getParameter("customer_pass")));
			
			//顧客登録しにいく
			CustomerManager customer = new CustomerManager();
			
			//idの重複チェック
			int check = customer.Regist(user_id, tel, credit_type, customer_name, password,
					credit_number);
			
			if(check == 0){
				
				//完了画面へ
				response.sendRedirect(response.encodeRedirectURL("./CustomerInfoRegistDone.jsp"));
				
			}
			
			else{
				request.setAttribute("error", "idかぶってるよ");
				getServletContext().getRequestDispatcher("/jsp/customer/CustomerInfoRegist.jsp").forward(request, response);
			}
			
			
			
			
			
		}
}