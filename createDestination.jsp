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
<title>宛先情報入力画面</title>
</head>
<body>
	<div id="header">
		<jsp:include page="header.jsp" />
	</div>

	<div id="main">
		<div id="top">
			<p>宛先情報入力画面</p>
		</div>

		<!-- エラーメッセージ -->


		<!-- エラーメッセージが存在する -->
		<s:if
			test="familyNameErrorMessageList!=null && familyNameErrorMessageList.size()>0">
			<!-- エラーメッセージを表示する -->
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
			test="addressErrorMessageList!=null && addressErrorMessageList.size()>0">
			<div id="error">
				<s:iterator value="addressErrorMessageList">
					<s:property />
					<br>
				</s:iterator>
			</div>
		</s:if>
		<s:if
			test="phoneNumberErrorMessageList!=null && phoneNumberErrorMessageList.size()>0">
			<div id="error">
				<s:iterator value="phoneNumberErrorMessageList">
					<s:property />
					<br>
				</s:iterator>
			</div>
		</s:if>
		<s:if test="passCheck!=null && passCheck.size()>0">
			<div id="error">
				<s:iterator value="passCheck">
					<s:property />
					<br>
				</s:iterator>
			</div>
		</s:if>


		<s:form action="CreateDestinationConfirmAction">

			<table class="vertical">

				<tr>
					<th><label>姓</label></th>

					<td><s:textfield class="textbox" name="familyNameRe"
							value="%{#session.familyNameRe}" placeholder="姓" /></td>
				</tr>

				<tr>
					<th><label>名</label></th>

					<td><s:textfield class="textbox" name="firstNameRe"
							value="%{#session.firstNameRe}" placeholder="名" /></td>
				</tr>

				<tr>
					<th><label>姓ふりがな</label></th>

					<td><s:textfield class="textbox" name="familyNameKanaRe"
							value="%{#session.familyNameKanaRe}" placeholder="姓ふりがな" /></td>
				</tr>

				<tr>
					<th><label>名ふりがな</label></th>

					<td><s:textfield class="textbox" name="firstNameKanaRe"
							value="%{#session.firstNameKanaRe}" placeholder="名ふりがな" /></td>
				</tr>

				<tr>
					<th><label>住所</label></th>

					<td><s:textfield class="textbox" name="address"
							value="%{#session.address}" placeholder="住所" /></td>
				</tr>

				<tr>
					<th><label>電話番号</label></th>

					<td><s:textfield class="textbox" name="phoneNumber"
							value="%{#session.phoneNumber}" placeholder="電話番号" /></td>
				</tr>

				<tr>
					<th><label>メールアドレス</label></th>

					<td><s:textfield class="textbox" name="mailAddress"
							value="%{#session.mailAddress}" placeholder="メールアドレス" /></td>
				</tr>

			</table>

				<s:submit value="確認" class="submit_btn"/>

		</s:form>
	</div>
</body>
</html>