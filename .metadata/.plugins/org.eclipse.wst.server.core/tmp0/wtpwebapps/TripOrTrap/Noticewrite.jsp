<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>게시글 등록</title>
</head>

<body>

<form name="frm" enctype="multipart/form-data" action="TOTServer">
<input type="hidden" name="command" value="board_write">
<table>
<tr>
<td>작성자 : </td>
<td align="left"><input type="text" name="name"></td>
</tr>

<tr>
<td>비밀번호 : </td>
<td align="left"><input type="password" name="pass"></td>
</tr>

<tr>
<td>이메일 : </td>
<td align="left"><input type="text" name="email"></td>
</tr>

<tr>
<td>제목 : </td>
<td align="left"><input type="text" name="title"></td>
</tr>

<tr>
<td>게시물 : </td>
<td><textarea rows="10" cols="80" name="content"></textarea></td>
</tr>


<tr>
<td align="left"><input type="submit" value="등록" ></td>
<td align="left"><input type="reset" value="재작성"></td>
<td align="left"><input type="button" value="취소" onclick="location.href='TOTServer?command=board_list'"></td>
</tr>
</table>
</form>



</body>
</html>