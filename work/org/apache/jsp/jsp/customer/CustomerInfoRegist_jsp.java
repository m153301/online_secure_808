/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/7.0.61
 * Generated at: 2015-06-17 15:41:30 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp.jsp.customer;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class CustomerInfoRegist_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final javax.servlet.jsp.JspFactory _jspxFactory =
          javax.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.Map<java.lang.String,java.lang.Long> _jspx_dependants;

  private javax.el.ExpressionFactory _el_expressionfactory;
  private org.apache.tomcat.InstanceManager _jsp_instancemanager;

  public java.util.Map<java.lang.String,java.lang.Long> getDependants() {
    return _jspx_dependants;
  }

  public void _jspInit() {
    _el_expressionfactory = _jspxFactory.getJspApplicationContext(getServletConfig().getServletContext()).getExpressionFactory();
    _jsp_instancemanager = org.apache.jasper.runtime.InstanceManagerFactory.getInstanceManager(getServletConfig());
  }

  public void _jspDestroy() {
  }

  public void _jspService(final javax.servlet.http.HttpServletRequest request, final javax.servlet.http.HttpServletResponse response)
        throws java.io.IOException, javax.servlet.ServletException {

    final javax.servlet.jsp.PageContext pageContext;
    javax.servlet.http.HttpSession session = null;
    final javax.servlet.ServletContext application;
    final javax.servlet.ServletConfig config;
    javax.servlet.jsp.JspWriter out = null;
    final java.lang.Object page = this;
    javax.servlet.jsp.JspWriter _jspx_out = null;
    javax.servlet.jsp.PageContext _jspx_page_context = null;


    try {
      response.setContentType("text/html; charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;

      out.write("\n");
      out.write("<html>\n");
      out.write("<head>\n");
      out.write("\t<title>CustomerInfoRegist</title>\n");
      out.write("\t<link rel=\"stylesheet\" type=\"text/css\" href=\"style.css\">\n");
      out.write("</head>\n");
      out.write("<body>\n");
      out.write("\t<br>\n");
      out.write("\t<br>\n");
      out.write("\t<form action=\"./CustomerRegistServlet\", methd=\"post\">\n");
      out.write("\t<table style=\"text-align: left; width: 360px; margin-left: auto; margin-right: auto; height: 480px;\" border=\"1\" cellpadding=\"2\" cellspacing=\"2\">\n");
      out.write("\t\t<tbody>\n");
      out.write("\t\t\t<tr align=\"center\">\n");
      out.write("\t\t\t\t<td style=\"width: 180px; height: 60px;\" colspan=\"2\" rowspan=\"1\">お客様情報登録</td>\n");
      out.write("\t\t\t</tr>\n");
      out.write("\t\t\t<tr>\n");
      out.write("\t\t\t\t<td style=\"text-align: center; width: 180px; height: 60px;\">氏名</td>\n");
      out.write("\t\t\t\t<td style=\"text-align: center; width: 180px; height: 60px;\"><input name=\"customer_name\" type=\"text\"></td>\n");
      out.write("\t\t\t</tr>\n");
      out.write("\t\t\t<tr>\n");
      out.write("\t\t\t\t<td style=\"text-align: center; width: 180px; height: 60px;\">電話番号</td>\n");
      out.write("\t\t\t\t<td style=\"text-align: center; width: 180px; height: 60px;\"><input name=\"tel\" type=\"text\"></td>\n");
      out.write("\t\t\t</tr>\n");
      out.write("\t\t\t<tr>\n");
      out.write("\t\t\t\t<td style=\"text-align: center; width: 180px; height: 60px;\">クレジットカード番号</td>\n");
      out.write("\t\t\t\t<td style=\"text-align: center; width: 180px; height: 60px;\"><input name=\"credit_number\" type=\"text\"></td>\n");
      out.write("\t\t\t</tr>\n");
      out.write("\t\t\t<tr>\n");
      out.write("\t\t\t\t<td style=\"text-align: center; width: 180px; height: 60px;\">カードタイプ</td>\n");
      out.write("\t\t\t\t<td style=\"text-align: center; width: 180px; height: 60px;\">\n");
      out.write("\t\t\t\t\t<select name=\"credit_type_id\">\n");
      out.write("\t\t\t\t\t\t<option value=\"\">選択してください</option>\n");
      out.write("\t\t\t\t\t\t<option value=\"1\">JCB</option>\n");
      out.write("\t\t\t\t\t\t<option value=\"2\">VISA</option>\n");
      out.write("\t\t\t\t\t\t<option value=\"3\">MasterCard</option>\n");
      out.write("\t\t\t\t\t\t<option value=\"4\">AmericanExpress</option>\n");
      out.write("\t\t\t\t\t</select>\n");
      out.write("\t\t\t\t</td>\n");
      out.write("\t\t\t</tr>\n");
      out.write("\t\t\t<tr>\n");
      out.write("\t\t\t\t<td style=\"text-align: center; width: 180px; height: 60px;\">顧客ID</td>\n");
      out.write("\t\t\t\t<td style=\"text-align: center; width: 180px; height: 60px;\"><input name=\"customer_id\" type=\"text\"></td>\n");
      out.write("\t\t\t</tr>\n");
      out.write("\t\t\t<tr>\n");
      out.write("\t\t\t\t<td style=\"text-align: center; width: 180px; height: 60px;\">パスワード</td>\n");
      out.write("\t\t\t\t<td style=\"text-align: center; width: 180px; height: 60px;\"><input name=\"customer_pass\" type=\"password\"></td>\n");
      out.write("\t\t\t</tr>\n");
      out.write("\t\t\t<tr>\n");
      out.write("\t\t\t\t<td colspan=\"2\" rowspan=\"1\" style=\"text-align: center; width: 180px; height: 60px;\">\n");
      out.write("\t\t\t\t\t<button onclick=\"location.href='CustomerInfoRegistCheck.jsp'\" name=\"enter\">確認</button>\n");
      out.write("\t\t\t\t</td>\n");
      out.write("\t\t\t</tr>\n");
      out.write("\t\t</tbody>\n");
      out.write("\t</table>\n");
      out.write("\t</form>\n");
      out.write("</body>\n");
      out.write("</html>");
    } catch (java.lang.Throwable t) {
      if (!(t instanceof javax.servlet.jsp.SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          try {
            if (response.isCommitted()) {
              out.flush();
            } else {
              out.clearBuffer();
            }
          } catch (java.io.IOException e) {}
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
