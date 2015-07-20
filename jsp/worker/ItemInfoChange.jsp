<%@ page language="java" contentType="text/html; charset=UTF-8" import="java.util.List" import="beans.Item" %>
<html>
<head>
	<title>ItemInfoChange</title>
	<link rel="stylesheet" type="text/css" href="style.css">
</head>
<body>
	<div style="text-align: right;">
		<a href="WorkerTop.jsp">トップに戻る</a><br>
	</div>
	<br>
	<br>
	<%
		HttpSession hs = request.getSession();
		List<Item> items = (List<Item>)hs.getAttribute("items");
	    Item changedItem = null;
		for( Item item : items ){
			if( item.getItemId() == Integer.parseInt(request.getParameter("item_id")) ){
				changedItem = item;
				break;
			}
		}
	%>

	<table style="text-align: left; width: 360px; margin-left: auto; margin-right: auto; height: 360px;" border="1" cellpadding="2" cellspacing="2">
		<tbody>
			<tr align="center">
				<td style="width: 180px; height: 60px;" colspan="2" rowspan="1">商品情報変更</td>
			</tr>
			<tr>
				<td style="text-align: center; width: 180px; height: 60px;">品名<br>
			</td>
				<td style="text-align: center; width: 180px; height: 60px;"><input name="item_name" value="<%= changedItem.getItemName() %>" type="text"></td>
			</tr>
			<tr>
				<td style="text-align: center; width: 180px; height: 60px;">単価</td>
				<td style="text-align: center; width: 180px; height: 60px;"><input name="item_price" value="<%= changedItem.getItemPrice() %>" type="text"></td>
			</tr>
			<tr>
				<td style="text-align: center; width: 180px; height: 60px;">在庫</td>
				<td style="text-align: center; width: 180px; height: 60px;"><input name="item_stock" value="<%= changedItem.getItemStock() %>" type="text"></td>
			</tr>
			<tr>
				<td colspan="2" rowspan="1" style="text-align: center; width: 180px; height: 60px;">
					<button onclick="location.href='ItemInfoChangeCheck.jsp'" name="enter">変更</button>
				</td>
			</tr>
		</tbody>
	</table>
</body>
</html>