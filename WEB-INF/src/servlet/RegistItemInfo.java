
package servlet;

/*****************************************************************************/
//		商品を追加するservlet
/*****************************************************************************/

import java.io.IOException;
import java.security.NoSuchAlgorithmException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import utility.HashPassword;
import beans.Student;
import control.AddStudent;

public class RegistItemInfo extends HttpServlet{


	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		doPost(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
												throws ServletException, IOException{


		request.setCharacterEncoding("UTF-8");

		String studentID = request.getParameter("studentID");
		String password = request.getParameter("password");
		String name = request.getParameter("name");
		String studentClass = request.getParameter("class");
		int number = Integer.parseInt(request.getParameter("number"));

		String password2;
		try {
			password2 = HashPassword.getHash(studentID, password );

		System.out.println(password2);


		Student student = new Student(studentID,password2,name,studentClass,number);

		AddStudent manager = new AddStudent();

		manager.addStudent(student);

		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}




		response.sendRedirect(response.encodeRedirectURL("./dekita.jsp"));
	}

}
