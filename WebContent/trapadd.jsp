<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Trap 등록</title>
<link href="main.css" rel="stylesheet">
</head>
<body>
<form method="post" name="frm" enctype="multipart/form-data">
<table>
<tr>
<td>유저번호 : </td>
<td align="left"><input type="text" name="useraccount"></td>
</tr>

<tr>
<td>주소 : </td>
<td align="left"><input type="text" name="address"></td>
</tr>

<tr>
<td>위도 : </td>
<td align="left"><input type="text" name="latitude"></td>
</tr>
<tr>
<td>경도 : </td>
<td align="left"><input type="text" name="longitude"></td>
</tr>
<tr>
<td>방향 : </td>
<td align="left"><input type="text" name="compasshead"></td>
</tr>
<tr>
<td>사진 : </td>
<td align="left"><input type="file" name="pictureurl" id="pictureurl"> </td>
</tr>

<tr>
<td align="left"><input type="submit" value="등록" ></td>
<td align="left"><input type="reset" value="재작성"></td>
<td align="left"><input type="button" value="취소" onclick="triportrap.jsp"></td>
</tr>
</table>
</form>
</body>
</html>