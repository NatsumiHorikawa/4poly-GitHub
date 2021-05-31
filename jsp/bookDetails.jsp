<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="model.*,java.util.List" %>
<%
List<Library> libraryList =
                (List<Library>)request.getAttribute("libraryList");
%>
<%
List<WantBook> wantBookList =
                (List<WantBook>)request.getAttribute("wantBookList");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<jsp:include page="/header.jsp" />
<h1>本の詳細ページ</h1>
<hr>
<!-- もってるリストの一覧表示 -->
<% if(libraryList != null){ %>
    <% for(Library l : libraryList){ %>
        <%= l.getIsbn() %>/<br>
        <%= l.getTitle() %>/<br>
        <%= l.getAuthor() %>/<br>
        <%= l.getPublisher() %>/<br>
        <%= l.getOverview() %>/<br><hr>
        <% } %>

    <% }else if(wantBookList != null){ %>
<!-- よみたいリストの一覧表示 -->
    <% for(WantBook w : wantBookList){ %>
        <%= w.getIsbn() %>/<br>
        <%= w.getTitle() %>/<br>
        <%= w.getAuthor() %>/<br>
        <%= w.getPublisher() %>/<br>
        <%= w.getOverview() %>/<br><hr>
        <% } %>
    <% }else { %>
<!-- 何もデータがない場合 -->
    <c:out value="該当データはありません" />
<% } %>
<form action="/bookshelf/Details" method="post">
    <input type="hidden" name="from" value="library">
    <input type="submit" value="もってるリストに戻る">
</form>
<form action="/bookshelf/Details" method="post">
    <input type="hidden" name="from" value="wantBook">
    <input type="submit" value="よみたいリストに戻る">
</form>
</body>
</html>