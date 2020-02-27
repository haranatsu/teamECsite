<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html>
<html>
<head>
<meta charset=UTF-8>
<link rel="stylesheet" type="text/css" href="./css/textStyle.css">
<link rel="stylesheet" type="text/css" href="./css/formStyle.css">
<title>ユーザ情報入力完了画面</title>

<!-- ３秒後ログイン画面へ -->
<meta http-equiv="refresh" content="3;URL='LoginAction'" />

</head>
<body>
	<div id="header">
		<jsp:include page="header.jsp" />
	</div>

	<div id="main">
		<div id="top">
			<p>ユーザー情報入力完了画面</p>
		</div>

	<div id="complete">
		<p>ユーザー情報入力が完了しました。</p>
	</div>
	</div>
</body>
</html>