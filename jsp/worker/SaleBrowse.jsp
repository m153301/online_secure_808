<%@ page language="java" contentType="text/html; charset=UTF-8" %>
<%@ page import="beans.Sale" %>
<%@ page import="java.util.Date"%>
<%@ page import="java.util.ArrayList" %>
<%@ page import="java.util.Iterator" %>

<%
ArrayList<Sale> saleList = (ArrayList<Sale>)request.getAttribute("SaleList");
%>

<html>
<head>
	<title>SaleBrowse</title>
	<link rel="stylesheet" type="text/css" href="style.css">
</head>
<body>
<div style="text-align: right;">
	<a href="WorkerTop.jsp">トップに戻る</a><br>
</div>
<br>
<br>
<div style="margin: 0pt auto; width: 700px; height: 850px; border:#d0d0d0 solid 5px;">
	<div class="title" style="text-align: center;">売上</div>
	<br>

<%
Iterator<Sale> iterator = saleList.iterator();

//System.out.println(saleList.size());

while(iterator.hasNext()){

//System.out.println("aaaaaa");

	int i = 0;

	Sale sale = iterator.next();

	int total = 0;

	Date buyDate = sale.getBuyDate();
	Date buyDate2 = sale.getBuyDate();

	while(buyDate.equals(buyDate2)){

		if(i == 0){
			out.println(sale.getBuyDate());
			out.println("<table style='text-align: center; width: 600px; height: 300px;' border='1' cellpadding='2' cellspacing='2'>");
			out.println("<tr>");
			out.println("<td> 商品名 </td>");
			out.println("<td> 単価 </td>");
			out.println("<td> 売上数 </td>");
			out.println("<td> 計 </td>");
			out.println("</tr>");
		}

		if(iterator.hasNext()){
			if(i == 0){
				sale = iterator.next();
			}
			out.println("<tr>");
			out.println("<td>"+ sale.getItemName() +"</td>");
			out.println("<td>"+ sale.getItemPrice() +"</td>");
			out.println("<td>"+ sale.getPurchaceQuantity() +"</td>");
			int subtotal = sale.getItemPrice() * sale.getPurchaceQuantity();
			total = total + subtotal;
			out.println("<td>"+ subtotal +"</td>");
			out.println("</tr>");

			buyDate2 = sale.getBuyDate();
			i++;

		}
		else{
			i = 0;
			break;
		}
	}

	out.println("<tr>");
	out.println("<td> 計 </td>");
	out.println("<td> - </td>");
	out.println("<td> - </td>");
	out.println("<td>"+ total + "</td>");
	out.println("</tr>");
}
%>

</div>
</body>


</html>





