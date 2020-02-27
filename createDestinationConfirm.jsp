<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html>
<html>
<head>
<meta charset=UTF-8>
<link rel="stylesheet" type="text/css" href="./css/table.css">
<link rel="stylesheet" type="text/css" href="./css/textStyle.css">
<link rel="stylesheet" type="text/css" href="./css/formStyle.css">
<title>宛先情報入力確認画面</title>
</head>
<body>
	<div id="header">
		<jsp:include page="header.jsp" />
	</div>

	<div id="main">
		<div id="top">
			<p>宛先情報入力確認画面</p>
		</div>

		<table class="vertical">

			<tr>
				<th><label>姓</label></th>

				<td><s:property value="familyNameRe" /></td>
			</tr>

			<tr>
				<th><label>名</label></th>

				<td><s:property value="firstNameRe" /></td>
			</tr>

			<tr>
				<th><label>姓ふりがな</label></th>

				<td><s:property value="familyNameKanaRe" /></td>
			</tr>

			<tr>
				<th><label>名ふりがな</label></th>

				<td><s:property value="firstNameKanaRe" /></td>
			</tr>

			<tr>
				<th><label>住所</label></th>

				<td><s:property value="address" /></td>
			</tr>

			<tr>
				<th><label>電話番号</label></th>

				<td><s:property value="phoneNumber" /></td>
			</tr>

			<tr>
				<th><label>メールアドレス</label></th>

				<td><s:property value="mailAddress" /></td>
			</tr>
		</table>

		<s:form action="CreateDestinationCompleteAction">
			<s:submit value="登録"  class="submit_btn"/>
		</s:form>

		<s:form action="CreateDestinationAction">
			<s:submit value="戻る"  class="submit_btn"/>
			<s:hidden id="backFlg" name="backFlg" value="1" />
		</s:form>

	</div>
</body>
</html>