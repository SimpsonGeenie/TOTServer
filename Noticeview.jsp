<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>게시글</title>
</head>

<body>

<form name="frm" enctype="multipart/form-data" action="BoardServlet">
<input type="hidden" name="command" value="board_write">
<table>
<tr>
<th>작성자</th><td>${bbs.name}</td>
<th>이메일</th><td>${bbs.email}</td>
</tr>
<tr>
<th>작성일</th><td><fmt:formatDate value="${bbs.writedate}"/> </td>
<th>조회수</th><td>${bbs.readcount}</td>
</tr>
<tr>
<th>제 목</th><td colspan="3">${bbs.title}</td>
</tr>
<tr>
<th>내 용</th><td colspan="3"><pre>${bbs.name}</pre></td>
</tr>



<tr>
<td align="left"><input type="button" value="수정" onclick="open_win('BoardServlet?command=board_fix&num=${bbs.num}','fix')"></td>
<td align="left"><input type="button" value="삭제" onclick="open_win('BoardServlet?command=board_del&num=${bbs.num}','del')"></td>
<td align="left"><input type="button" value="목록" onclick="location.href='BoardServlet?command=board_list'"></td>
<td align="left"><input type="button" value="등록" onclick="location.href='BoardServlet?command=board_write_form'"></td>
</tr>
</table>
</form>



</body>
</html>