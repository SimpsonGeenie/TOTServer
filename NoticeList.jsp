<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>공지 게시판</title>
</head>
<body>

<table class="bbslist" border="1">
<tr><td colspan="5" style="text-align:right"><a href="TOTServer?command=board_write_form">게시글 등록</a></td></tr>
<tr>
<th>번호</th><th>제목</th><th>작성자</th><th>작성일</th>
</tr>

<c:forEach var="bbslist" items="${bbslist }">
<tr>
<td>${bbslist.notinum }</td>
<td><a href="TOTServer?command=board_view&num=${bbslist.notinum }">
${bbslist.title }</a></td>
<td>${bbslist.admin }</td>
<td><fmt:formatDate value="${bbslist.indate }"/></td>
</tr>
</c:forEach>

</table>

</body>
</html>