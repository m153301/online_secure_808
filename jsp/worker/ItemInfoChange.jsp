<%@ page language="java" contentType="text/html; charset=UTF-8" %>
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
	<table style="text-align: left; width: 360px; margin-left: auto; margin-right: auto; height: 360px;" border="1" cellpadding="2" cellspacing="2">
		<tbody>
			<tr align="center">
				<td style="width: 180px; height: 60px;" colspan="2" rowspan="1">商品情報変更</td>
			</tr>
			<tr>
				<td style="text-align: center; width: 180px; height: 60px;">品名<br>
			</td>
				<td style="text-align: center; width: 180px; height: 60px;"><input name="item_name" value="しめじ" type="text"></td>
			</tr>
			<tr>
				<td style="text-align: center; width: 180px; height: 60px;">単価</td>
				<td style="text-align: center; width: 180px; height: 60px;"><input name="item_price" value="200" type="text"></td>
			</tr>
			<tr>
				<td style="text-align: center; width: 180px; height: 60px;">在庫</td>
				<td style="text-align: center; width: 180px; height: 60px;"><input name="item_stock" value="3" type="text"></td>
			</tr>
			<tr>
				<td colspan="2" rowspan="1" style="text-align: center; width: 180px; height: 60px;">
					<button onclick="location.href='ItemInfoChangeCheck.jsp'" name="enter">確認</button>
				</td>
			</tr>
		</tbody>
	</table>
</body>
</html>