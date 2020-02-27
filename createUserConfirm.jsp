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
<title>ユーザー情報入力確認画面</title>
</head>
<body>

	<div id="header">
		<jsp:include page="header.jsp" />
	</div>

	<div id="main">
		<div id="top">
			<p>ユーザー情報入力確認画面</p>
		</div>

		<table class="vertical">
			<tr>
				<th><label>姓</label></th>

				<td><s:property value="familyName" /></td>
			</tr>

			<tr>
				<th><label>名</label></th>

				<td><s:property value="firstName" /></td>
			</tr>

			<tr>
				<th><label>姓ふりがな</label></th>

				<td><s:property value="familyNameKana" /></td>
			</tr>

			<tr>
				<th><label>名ふりがな</label></th>

				<td><s:property value="firstNameKana" /></td>
			</tr>

			<tr>
				<th>性別</th>
				<s:if test='sex.equals("0")'>
					<td>男性</td>
				</s:if>
				<s:else>
					<td>女性</td>
				</s:else>
			</tr>

			<tr>
				<th><label>メールアドレス</label></th>

				<td><s:property value="email" /></td>
			</tr>

			<tr>
				<th><label>ユーザーID</label></th>

				<td><s:property value="userId" /></td>
			</tr>

			<tr>
				<th><label>パスワード</label></th>

				<td><s:property value="password" /></td>
			</tr>
		</table>

		<s:form action="CreateUserCompleteAction">
			<s:submit value="登録"  class="submit_btn"/>
		</s:form>



		<s:form action="CreateUserAction">
			<s:submit value="戻る" class="submit_btn" />
			<s:hidden id="backFlg" name="backFlg" value="1" />
		</s:form>
	</div>
</body>
</html>