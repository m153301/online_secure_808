package servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.lang3.StringEscapeUtils;

import beans.User;
import controller.CustomerInfoChangeManager;
import controller.CustomerManager;
import utility.PasswordEncryption;


public class CustomerInfoChangeServlet extends HttpServlet{
	
	public void doGet(HttpServletRequest request,HttpServletResponse response)
			throws ServletException,IOException{
				doPost(request,response);
		}

		public void doPost(HttpServletRequest request,HttpServletResponse response)
			throws ServletException,IOException{

			request.setCharacterEncoding("UTF-8");
			
			List<String> userInfo = new ArrayList<String>();

			userInfo.add(request.getParameter("customer_name"));
			userInfo.add(request.getParameter("tel"));
			userInfo.add(request.getParameter("credit_number"));
			userInfo.add(request.getParameter("customer_password"));
			
			CustomerInfoChangeManager cm = new CustomerInfoChangeManager();
			List<String> errors = cm.validator(userInfo);
			request.setAttribute("errors", errors);
			
			if( errors.isEmpty() ){
				HttpSession session = request.getSession();
				User user = (User)session.getAttribute("customer");

				String userName = StringEscapeUtils.escapeHtml4(request.getParameter("customer_name"));
				String tel = StringEscapeUtils.escapeHtml4(request.getParameter("tel"));
				String cardNum = StringEscapeUtils.escapeHtml4(request.getParameter("credit_number"));
				String cardType = request.getParameter("credit_type_id");
				PasswordEncryption passenc = new PasswordEncryption();
				String userPass = passenc.getPassword_encryption(StringEscapeUtils.escapeHtml4(request.getParameter("customer_password")));
				cm.updateCustomerInfo(user.getUserId(), userName, userPass, tel, cardNum, cardType);

				getServletContext().getRequestDispatcher("/jsp/customer/CustomerInfoChangeDone.jsp").forward(request, response);
			} 
			else {
				getServletContext().getRequestDispatcher("/jsp/customer/CustomerInfoChange.jsp").forward(request, response);
			}
		}
}
