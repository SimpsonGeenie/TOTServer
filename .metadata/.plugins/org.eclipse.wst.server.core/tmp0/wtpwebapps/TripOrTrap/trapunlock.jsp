<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Trap 해제</title>
</head>
<body>
<input type="hidden" name="traplist" value="${traplist.pictureurl }">
<form method="post" name="frm" enctype="multipart/form-data">
<table>
<tr>
<td>유저번호 : </td>
<td align="left"><input type="text" name="unlockeraccount"></td>
</tr>

<tr>
<td>사진 : </td>
<td align="left"><input type="file" name="unlockpictureurl" > </td>
</tr>

<tr>
<td align="left"><input type="submit" value="트랩 해제" ></td>
<td align="left"><input type="reset" value="재작성"></td>
<td align="left"><input type="button" value="취소" onclick="triportrap.jsp"></td>
</tr>
</table>
</form>
</body>
</html>