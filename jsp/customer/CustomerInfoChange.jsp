<%@ page language="java" contentType="text/html; charset=UTF-8" %>

<html>
<head>
	<title>CustomerInfoChange</title>
	<link rel="stylesheet" type="text/css" href="style.css">
</head>
<body>
	<br>
	<br>
	<table style="width: 360px; margin-left: auto; margin-right: auto; height: 360px;" border="1" cellpadding="2" cellspacing="2">
		<tbody>
			<tr align="center">
				<td style="width: 180px; height: 60px;" colspan="2" rowspan="1">お客様情報変更</td>
			</tr>
			<tr>
				<td style="text-align: center; width: 180px; height: 60px;">氏名</td>
				<td style="text-align: center; width: 180px; height: 60px;"><input name="customer_name" type="text"> </td>
			</tr>
			<tr>
				<td style="text-align: center; width: 180px; height: 60px;">電話番号</td>
				<td style="text-align: center; width: 180px; height: 60px;"><input name="tel" type="text"> </td>
			</tr>
			<tr>
				<td style="text-align: center; width: 180px; height: 60px;">クレジットカード番号</td>
				<td style="text-align: center; width: 180px; height: 60px;"><input name="credit_number" type="text"></td>
			</tr>
			<tr>
				<td style="text-align: center; width: 180px; height: 60px;">カードタイプ</td>
				<td style="text-align: center; width: 180px; height: 60px;">
					<select name="credit_type_id">
						<option value="">選択してください</option>
						<option value="1">JCB</option>
						<option value="2">VISA</option>
						<option value="3">MasterCard</option>
						<option value="4">AmericanExpress</option>
					</select>
				</td>
			</tr>
			<tr>
				<td colspan="2" rowspan="1" style="text-align: center; width: 180px; height: 60px;">
					<button onclick="location.href='CustomerInfoChangeCheck.jsp'" name="enter">確認</button>
				</td>
			</tr>
		</tbody>
	</table>
	<br>
	<br>
	<br>
</body>
</html>