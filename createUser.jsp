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
<title>ユーザー情報入力画面</title>

</head>
<body>

	<div id="header">
		<jsp:include page="header.jsp" />
	</div>

	<div id="main">
		<div id="top">
			<p>ユーザー情報入力画面</p>
		</div>
		<div>

			<!-- エラーメッセージ -->
			<s:if
				test="familyNameErrorMessageList!=null && familyNameErrorMessageList.size()>0">
				<div id="error">
					<s:iterator value="familyNameErrorMessageList">
						<s:property />
						<br>
					</s:iterator>
				</div>
			</s:if>
			<s:if
				test="firstNameErrorMessageList!=null && firstNameErrorMessageList.size()>0">
				<div id="error">
					<s:iterator value="firstNameErrorMessageList">
						<s:property />
						<br>
					</s:iterator>
				</div>
			</s:if>
			<s:if
				test="familyNameKanaErrorMessageList!=null && familyNameKanaErrorMessageList.size()>0">
				<div id="error">
					<s:iterator value="familyNameKanaErrorMessageList">
						<s:property />
						<br>
					</s:iterator>
				</div>
			</s:if>
			<s:if
				test="firstNameKanaErrorMessageList!=null && firstNameKanaErrorMessageList.size()>0">
				<div id="error">
					<s:iterator value="firstNameKanaErrorMessageList">
						<s:property />
						<br>
					</s:iterator>
				</div>
			</s:if>
			<s:if
				test="emailErrorMessageList!=null && emailErrorMessageList.size()>0">
				<div id="error">
					<s:iterator value="emailErrorMessageList">
						<s:property />
						<br>
					</s:iterator>
				</div>
			</s:if>
			<s:if
				test="userIdErrorMessageList!=null && userIdErrorMessageList.size()>0">
				<div id="error">
					<s:iterator value="userIdErrorMessageList">
						<s:property />
						<br>
					</s:iterator>
				</div>
			</s:if>
			<s:if
				test="passwordErrorMessageList!=null && passwordErrorMessageList.size()>0">
				<div id="error">
					<s:iterator value="passwordErrorMessageList">
						<s:property />
						<br>
					</s:iterator>
				</div>
			</s:if>
			<s:if
				test="setExistsErrorMessage!=null && !setExistsErrorMessage.isEmpty()">
				<div id="error">
					<s:iterator value="setExistsErrorMessage">
						<s:property />
						<br>
					</s:iterator>
				</div>
			</s:if>


			<!-- ユーザー新規登録 -->

			<s:form action="CreateUserConfirmAction">
				<table class="vertical">

					<tr>
						<th><label>姓</label></th>

						<td><s:textfield class="textbox" name="familyName"
								value="%{#session.familyName}" placeholder="姓" /></td>
					</tr>

					<tr>
						<th><label>名</label></th>

						<td><s:textfield class="textbox" name="firstName"
								value="%{#session.firstName}" placeholder="名" /></td>
					</tr>

					<tr>
						<th><label>姓ふりがな</label></th>

						<td><s:textfield class="textbox" name="familyNameKana"
								value="%{#session.familyNameKana}" placeholder="姓ふりがな" /></td>
					</tr>

					<tr>
						<th><label>名ふりがな</label></th>

						<td><s:textfield class="textbox" name="firstNameKana"
								value="%{#session.firstNameKana}" placeholder="名ふりがな" /></td>
					</tr>

					<tr>
						<th><label>性別</label></th>
						<td><s:if test="#session.sex!=null && #session.sex==0">
								<input type="radio" name="sex" value="0" checked>男性
					<input type="radio" name="sex" value="1">女性
					</s:if> <s:elseif test="#session.sex!=null && #session.sex==1">
								<input type="radio" name="sex" value="0">男性
					<input type="radio" name="sex" value="1" checked>女性
					</s:elseif> <s:else>
								<input type="radio" name="sex" value="0" checked>男性
					<input type="radio" name="sex" value="1">女性
					</s:else></td>
					</tr>

					<tr>
						<th><label>メールアドレス</label></th>

						<td><s:textfield class="textbox" name="email"
								value="%{#session.email}" placeholder="メールアドレス" /></td>
					</tr>

					<tr>
						<th><label>ユーザーID</label></th>

						<td><s:textfield class="textbox" name="userId"
								value="%{#session.userIdForCreateUser}" placeholder="ユーザーID" /></td>
					</tr>

					<tr>
						<th><label>パスワード</label></th>

						<td><s:password class="textbox" name="password" value=""
								placeholder="パスワード" /></td>
					</tr>

				</table>

					<s:submit value="確認" class="submit_btn" />

			</s:form>

		</div>
	</div>
</body>
</html>