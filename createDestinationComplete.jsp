<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<!-- ３秒後決済確認画面へ -->
<META http-equiv="Refresh" content="3;URL=SettlementConfirmAction">

<meta charset=UTF-8>
<link rel="stylesheet" type="text/css" href="./css/textStyle.css">
<link rel="stylesheet" type="text/css" href="./css/formStyle.css">
<title>宛先情報入力完了画面</title>
</head>
<body>
	<div id="header">
		<jsp:include page="header.jsp" />
	</div>

	<div id="main">
		<div id="top">
			<p>宛先情報入力完了画面</p>
		</div>
	<div id="complete">
		<p>宛先情報入力が完了しました。</p>
	</div>
	</div>
</body>
</html>