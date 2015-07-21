<%@ page language="java" contentType="text/html; charset=UTF-8" %>
<%@ page import="beans.Purchase" %> 
<%@ page import="java.util.ArrayList" %> 
<%@ page import="java.util.Iterator" %> 
<% 
ArrayList<Purchase> purchaseList = (ArrayList)request.getAttribute("PurchaseList"); 
%>
<html>
<head>
	<title>PurchaseHistory</title>
	<link rel="stylesheet" type="text/css" href="style.css">
</head>
<body>
	<div style="text-align: right;">
		<a href="CustomerTop.jsp">トップに戻る</a><br>
	</div>
	<br>
	<br>
	<table style="text-align: left; width: 450px; margin-left: auto; margin-right: auto; height: 360px;" border="1" cellpadding="2" cellspacing="2">
		<tbody>
			<tr>
				<td colspan="3" rowspan="1" style="text-align: center; width: 150px; height: 60px;">購入履歴</td>
			</tr>
			<%
			Iterator<Purchase> iterator=purchaseList.iterator();
			
			while(iterator.hasNext())
			{
				Purchase purchase = iterator.next();
				out.println("<tr>");
					out.println("<td style='text-align: center; width: 180px; height: 60px;'>" + purchase.getBuyDate() + "</td>");
					out.println("<td style='text-align: center; width: 180px; height: 60px;'>" + purchase.getItemName() + "</td>");
					out.println("<td style='text-align: center; width: 180px; height: 60px;'>" + purchase.getPurchaceQuantity() + "</td>");

				out.println("</tr>");
			}
			%>
		</tbody>
	</table>
</body>
</html>