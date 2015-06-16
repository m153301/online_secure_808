<%@ page language="java" contentType="text/html; charset=UTF-8" %>
<html>
<head>
	<title>ItemInfoChangeList</title>
	
</head>
<body>
	<div style="text-align: right;"><a href="WorkerTop.jsp">トップに戻る</a><br></div>
	<br>
	<br>
	<table style="text-align: left; width: 490px; margin-left: auto; margin-right: auto; height: 540px;" border="1" cellpadding="2" cellspacing="2">
		<tbody>
			<tr align="center">
				<td colspan="4" rowspan="1">商品情報変更</td>
			</tr>
			<tr>
				<td style="text-align: center; width: 40px; height: 60px;">変更</td>
				<td style="text-align: center; width: 75px; height: 60px;">商品名</td>
				<td style="text-align: center; width: 150px; height: 60px;">単価</td>
				<td style="vertical-align: middle; width: 150px; text-align: center;">在庫</td>
			</tr>
			<tr>
				<td style="text-align: center; width: 40px; height: 60px;"><input name="nameko" value="1" type="radio"></td>
				<td style="text-align: center; width: 75px; height: 60px;">なめこ</td>
				<td style="text-align: center; width: 150px; height: 60px;">300円</td>
				<td style="vertical-align: middle; width: 150px; text-align: center;">あと100個</td>
			</tr>
			<tr>
				<td style="text-align: center; width: 40px; height: 60px;"><input name="shimeji" value="1" type="radio"> </td>
				<td style="text-align: center; width: 75px; height: 60px;">しめじ</td>
				<td style="text-align: center; width: 150px; height: 60px;">200円</td>
				<td style="vertical-align: middle; width: 150px; text-align: center;">あと3個</td>
			</tr>
			<tr>
				<td style="text-align: center; width: 40px; height: 60px;"><input name="maitake" value="1" type="radio"> </td>
				<td style="text-align: center; width: 75px; height: 60px;">まいたけ</td>
				<td style="text-align: center; width: 150px; height: 60px;">280円</td>
				<td style="vertical-align: middle; width: 150px; text-align: center;">あと20個</td>
			</tr>
			<tr>
				<td style="text-align: center; width: 40px; height: 60px;"><input name="shiitake" value="1" type="radio"> </td>
				<td style="text-align: center; width: 75px; height: 60px;">しいたけ</td>
				<td style="text-align: center; width: 150px; height: 60px;">1100円</td>
				<td style="vertical-align: middle; width: 150px; text-align: center;">あと200個</td>
			</tr>
			<tr>
				<td style="text-align: center; width: 40px; height: 60px;"><input name="matsutake" value="1" type="radio"> </td>
				<td style="text-align: center; width: 75px; height: 60px;">松茸</td>
				<td style="text-align: center; width: 150px; height: 60px;">2000円</td>
				<td style="vertical-align: middle; width: 150px; text-align: center;">あと3個</td>
			</tr>
			<tr>
				<td style="text-align: center; width: 40px; height: 60px;"><input name="eringi" value="1" type="radio"> </td>
				<td style="text-align: center; width: 75px; height: 60px;">エリンギ</td>
				<td style="vertical-align: middle; text-align: center;">20000円</td>
				<td style="vertical-align: middle; width: 172px; text-align: center;">あと3個</td>
			</tr>
			<tr>
				<td colspan="4" rowspan="1" style="text-align: center;">
					<button onclick="location.href='ItemInfoChange.jsp'" name="enter">変更</button>
				</td>
			</tr>
		</tbody>
	</table>
</body>
</html>