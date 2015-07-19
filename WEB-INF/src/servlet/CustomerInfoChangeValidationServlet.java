package servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.StringEscapeUtils;

import controller.CustomerInfoChangeManager;
import controller.CustomerManager;
import utility.PasswordEncryption;


public class CustomerInfoChangeValidationServlet extends HttpServlet{
	
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
			userInfo.add(request.getParameter("creditr_type_id"));
			userInfo.add(request.getParameter("customer_id"));
			userInfo.add(request.getParameter("customer_password"));
			
			CustomerInfoChangeManager cm = new CustomerInfoChangeManager();
			
			List<String> errors = cm.validator(userInfo);
			request.setAttribute("errors", errors);
			
			if( errors.isEmpty() ){
				getServletContext().getRequestDispatcher("/jsp/customer/CustomerInfoChangeCheck.jsp").forward(request, response);
			} 
			else {
				for( String error : errors ){
					System.out.println(error);
				}
				getServletContext().getRequestDispatcher("/jsp/customer/CustomerInfoChange.jsp").forward(request, response);
			}
		}
}
