<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<jsp:include page="/header.jsp" />
<h1>wantBookリスト編集画面</h1>
wantBookDBからそれぞれのレコードを取得し全列レコード表示
<form action="/bookshelf/Edit" method="post">
    <input type="submit" value="削除">
</form>
<a href="/bookshelf/">TOPに戻る</a>
</body>
</html>