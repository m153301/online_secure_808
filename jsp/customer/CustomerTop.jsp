<%@ page language="java" contentType="text/html; charset=UTF-8" %>
<html>
<head>
	<link rel="stylesheet" type="text/css" href="style.css">
</head>
<body>
	<div class="title">
		☆おすすめ☆<br>
		キャベツ<br>
		<br>
		☆買い物☆<br>
		<form method = "post" action="../customer/ItemListServlet">
		<input type="submit" value="商品一覧">
		</form>
		
		<form method = "post" action="../customer/PurchaseHistoryServlet">
		<input type="submit" value="購入履歴">
		</form>
		<br>
		☆その他☆<br>
		<a href="CustomerInfoChange.jsp">お客様情報の変更</a><br>
		<a href="LogOut.jsp">ログアウト</a><br>
	</div>
</body></html>