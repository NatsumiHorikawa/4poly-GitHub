<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>よみたいリスト</h1>
<jsp:include page="/header.jsp" />

<!-- 絞り込み検索用の検索窓 -->
<form action="/bookshelf/Menu" method="post">
    <input type="hidden" name="from" value="wantBook">
    <input type="text" name="keyword">
    <input type="submit" value="絞り込み検索">
</form><br>

<form action="/bookshelf/Menu" method="get">
<input type="hidden" name="menu" value="library">
<input type="submit" value="もってるリストに切替">
</form><br><hr>

<!-- DBから抽出したデータを基に表形式で表示する部分 -->
<c:choose>
	<c:when test="${not empty wantBookList }">
	<c:forEach var="wantBook" items="${wantBookList }">
		<c:out value="${wantBook.title }" /><br>
		<c:out value="${wantBook.author }" /><br>
		<c:out value="${wantBook.publisher }" /><br>
		<form action="/bookshelf/Details" method="get">
        	<input type="hidden" name="from" value="wantBook">
        	<input type="hidden" name="isbn" value="${wantBook.isbn }">
        	<input type="submit" value="詳細">
    	</form>
    	<form action="/bookshelf/Edit" method="get">
    		<input type="hidden" name="from" value="library">
    		<input type="submit" value="編集">
		</form>
    	<hr>
	</c:forEach>
	</c:when>
	<c:otherwise>
		<c:out value="wantbookDBからのデータ抽出失敗"></c:out>
	</c:otherwise>
</c:choose>
<hr>
</body>
</html>