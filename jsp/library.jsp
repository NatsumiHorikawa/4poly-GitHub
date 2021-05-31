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
<h1>もってるリスト</h1>
<!-- ヘッダー配置 -->
<jsp:include page="/header.jsp" />

<!-- 絞り込み検索用の検索窓 -->
<form action="/bookshelf/Menu" method="post">
    <input type="hidden" name="from" value="library">
    <input type="text" name="keyword">
    <input type="submit" value="絞り込み検索">
</form><br>

<form action="/bookshelf/Menu" method="get">
    <input type="hidden" name="menu" value="wantBook">
    <input type="submit" value="よみたいリストに切替">
</form><br><hr>

<!-- DBから抽出したデータを基に表形式で表示する部分 -->
<c:choose>
	<c:when test="${not empty libraryList }">
	<c:forEach var="library" items="${libraryList }">
		<c:out value="${library.title }" /><br>
		<c:out value="${library.author }" /><br>
		<c:out value="${library.publisher }" /><br>
		<form action="/bookshelf/Details" method="get">
        	<input type="hidden" name="from" value="library">
        	<input type="hidden" name="isbn" value="${library.isbn }">
        	<input type="submit" value="詳細">
    	</form>
    	<form action="/bookshelf/Edit" method="get">
		    <input type="hidden" name="from" value="library">
		    <input type="hidden" name="isbn" value="${library.isbn }">
		    <input type="submit" value="編集">
		</form>
    	<hr>
	</c:forEach>
	</c:when>
	<c:otherwise>
		<c:out value="libraryDBからのデータ抽出失敗"></c:out>
	</c:otherwise>
</c:choose>


<hr>
</body>
</html>