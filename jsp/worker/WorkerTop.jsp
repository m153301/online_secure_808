<%@ page language="java" contentType="text/html; charset=UTF-8" %>
<html>
<head>
  <title>ClerkTop</title>
  <link rel="stylesheet" type="text/css" href="style.css">
</head>
<body>
かとうさん ようこそ<br>
<br>
	<div class="title">
		☆商品☆<br>
		<a href="../worker/ItemInfoRegist.jsp">商品登録</a><br>
		<a href="ItemInfoChangeList.jsp">商品編集</a><br>
		<a href="RecommendRegist.jsp">おすすめ登録</a><br>
		<br>
		☆売上☆<br>

		<form method = "post" action="./SaleBrowseServlet">
		<input type="submit" value="売上確認">
		</form>
		<br>
		☆発注履歴☆<br>

		<form method = "post" action="./OrderedBrowseServlet">
		<input type="submit" value="発注履歴確認">
		</form>

		<br>
		☆その他☆<br>
		<a href="../worker/WorkerInfoRegist.jsp">店員登録</a><br>
		<a href="LogOut.jsp">ログアウト</a><br>
	</div>
</body>
</html>