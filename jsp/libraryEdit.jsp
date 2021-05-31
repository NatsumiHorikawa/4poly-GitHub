<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql"  %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<jsp:include page="/header.jsp" />
<h1>libraryリスト編集画面</h1>
<!--  libraryDBからそれぞれのレコードを取得し全列レコード表示<br> -->
<c:choose>
	<c:when test="${not empty libraryList }">
		<c:forEach var="library" items="${libraryList }">
			<form action="/bookshelf/Edit" method="post">

				ISBN:<c:out value="${library.isbn }" /><br>
				<input type="text" name="isbn"><br>
				タイトル:<c:out value="${library.title }" /><br>
				<input type="text" name="title"><br>
				著  者:<c:out value="${library.author }" /><br>
				<input type="text" name="author"><br>
				出版社:<c:out value="${library.publisher }" /><br>
				<input type="text" name="publisher"><br>
				概  要:<c:out value="${library.overview }" /><br>
				<input type="text" name="overview"><br>
				<input type="hidden" name="from" value="library">

				<input type="submit" value="更新">
			</form>
    		<hr>
		</c:forEach>
		</c:when>
	<c:otherwise>
		<c:out value="libraryDBからのデータ抽出失敗"></c:out>
	</c:otherwise>
</c:choose>


<sql:setDataSource var="db" driver="com.mysql.jdbc.Driver"
     url="jdbc:mysql://172.16.71.104:3306/management"
     user="user17"  password="user17pass"/>

<sql:query dataSource="${db}" var="rs">
SELECT * from library;
</sql:query>

<table border="1" >
<tr>
<th>ISBN</th>
<th>TITLE</th>
<th>AUTHOR</th>
<th>PUBLISHER</th>
<th>OVERVIEW</th>
</tr>
<c:forEach var="library" items="${rs.rows}">
<tr>
<td><c:out value="${library.isbn}"/></td>
<td><c:out value="${library.title}"/></td>
<td><c:out value="${library.author}"/></td>
<td><c:out value="${library.publisher}"/></td>
<td><c:out value="${library.overview}"/></td>
</tr>
</c:forEach>
</table>

</body>
</html>