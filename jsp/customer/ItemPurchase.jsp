<%@ page language="java" contentType="text/html; charset=UTF-8" %>
<html>
<head>
	<title>ItemPurchase</title>
	<link rel="stylesheet" type="text/css" href="style.css">
</head>
<body>
	<div style="text-align: right;">
		<a href="CustomerTop.html">トップに戻る</a><br><br>
		<a href="ItemList.html">商品一覧に戻る</a><br>
	</div>
	<div></div>
	<br>
	<br>
	<table style="text-align: left; width: 360px; margin-left: auto; margin-right: auto; height: 300px;" border="1" cellpadding="2" cellspacing="2">
		<tbody>
			<tr>
				<td style="text-align: center; width: 180px; height: 60px;">△商品名△</td>
				<td style="text-align: center; width: 180px; height: 60px;">あああああ</td>
			</tr>
			<tr>
				<td style="text-align: center; width: 180px; height: 60px;">△単価△</td>
				<td style="text-align: center; width: 180px; height: 60px;">あああああ</td>
			</tr>
			<tr>
				<td style="text-align: center; width: 180px; height: 60px;">△在庫△</td>
				<td style="text-align: center; width: 180px; height: 60px;">あああああ</td>
			</tr>
			<tr>
				<td colspan="2" rowspan="1" style="text-align: center; width: 180px; height: 60px;">購入する個数を選んでください<br>
					<select name="number">
						<option value="">選択してください</option>
						<option value="1">1</option>
						<option value="2">2</option>
						<option value="3">3</option>
						<option value="4">4</option>
					</select>
				</td>
			</tr>
			<tr>
				<td colspan="2" rowspan="1" style="text-align: center; width: 180px; height: 60px;">
					<button onclick="location.href='ItemPurchaseCheck.jsp'" name="enter">確認</button>
				</td>
			</tr>
		</tbody>
	</table>
</body>
</html>