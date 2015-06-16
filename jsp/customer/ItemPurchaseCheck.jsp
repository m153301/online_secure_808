<%@ page language="java" contentType="text/html; charset=UTF-8" %>
<html>
<head>
	<title>ItemPurchaseCheck</title>
	
</head>
<body>
	<div style="text-align: right;">
		<a href="CustomerTop.jsp">トップに戻る</a><br><br>
		<a href="ItemList.jsp">商品一覧に戻る</a><br>
	</div>
	<br>
	<br>
	<table style="text-align: left; width: 360px; margin-left: auto; margin-right: auto; height: 360px;" border="1" cellpadding="2" cellspacing="2">
		<tbody>
			<tr>
				<td style="text-align: center; width: 180px; height: 60px;" rowspan="1" colspan="2">購入商品</td>
			</tr>
			<tr>
				<td style="text-align: center; width: 180px; height: 60px;">□商品名□</td>
				<td style="text-align: center; width: 180px; height: 60px;">あああああ</td>
			</tr>
			<tr>
				<td style="text-align: center; width: 180px; height: 60px;">□単価□</td>
				<td style="text-align: center; width: 180px; height: 60px;">あああああ</td>
			</tr>
			<tr>
				<td style="text-align: center; width: 180px; height: 60px;">□購入数□</td>
				<td style="text-align: center; width: 180px; height: 60px;">3</td>
			</tr>
			<tr>
				<td style="text-align: center; width: 180px; height: 60px;">□合計□</td>
				<td style="text-align: center; width: 180px; height: 60px;">600円</td>
			</tr>
			<tr>
				<td colspan="2" rowspan="1" style="text-align: center; width: 180px; height: 60px;">
					<button onclick="location.href='ItemPurchaseDone.jsp'" name="enter">確定</button>
				</td>
			</tr>
		</tbody>
	</table>
</body>
</html>