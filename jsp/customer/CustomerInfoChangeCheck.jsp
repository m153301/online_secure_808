<%@ page language="java" contentType="text/html; charset=UTF-8" %>
<html>
<head>
	<title>CustomerInfoChangeCheck</title>
	<link rel="stylesheet" type="text/css" href="style.css">
</head>
<body>
	<table style="text-align: left; width: 360px; margin-left: auto; margin-right: auto; height: 360px;" border="1" cellpadding="2" cellspacing="2">
		<tbody>
			<tr align="center">
				<td style="width: 180px; height: 60px;" colspan="2" rowspan="1">お客様情報変更</td>
			</tr>
			<tr>
				<td style="text-align: center; width: 180px; height: 60px;">氏名</td>
				<td style="text-align: center; width: 180px; height: 60px;"></td>
			</tr>
			<tr>
				<td style="text-align: center; width: 180px; height: 60px;">電話番号</td>
				<td style="text-align: center; width: 180px; height: 60px;"></td>
			</tr>
			<tr>
				<td style="text-align: center; width: 180px; height: 60px;">クレジットカード番号</td>
				<td style="text-align: center; width: 180px; height: 60px;"></td>
			</tr>
			<tr>
				<td style="text-align: center; width: 180px; height: 60px;">カードタイプ</td>
				<td style="text-align: center; width: 180px; height: 60px;"></td>
			</tr>
			<tr>
				<td colspan="2" rowspan="1" style="text-align: center; width: 180px; height; 60px;">以上の内容で変更します
					<button onclick="location.href='CustomerInfoChangeDone.jsp'" name="enter">変更</button>
				</td>
			</tr>
		</tbody>
	</table>
	<br>
	<br>
</body>
</html>