<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>TripOrTrap 서버테스트</title>
</head>
<body>

	<table class="list" border="1" width="100%">
		<legend>
			<h1>유저 확인</h1>			
		</legend>
		<tr>
			<td colspan="5" style="border: white; text-align: right"><a
				href="traplist.do">어드민 새로고침</a></td>
		</tr>
		<tr>
			<th>유저어카운트</th>
			<th>이름</th>
			<th>유저ID</th>
			<th>유저PW</th>
			<th>닉네임</th>
			<th>Email</th>
			<th>전화번호</th>
			<th>가입일자</th>
			<th>점수</th>
			<th>트랩 갯수</th>
		</tr>
		<c:forEach var="memberlist" items="${memberlist }">
			<tr class="record">
				<td width="5%" align="center">${memberlist.trapperaccount }</td>
				<td width="5%" align="center">${memberlist.trappername }</td>
				<td width="5%" align="center">${memberlist.userid }</td>
				<td width="5%" align="center">${memberlist.userpw }</td>
				<td width="5%" align="center">${memberlist.usernickname }</td>
				<td width="5%" align="center">${memberlist.email }</td>
				<td width="5%" align="center">${memberlist.phone }</td>
				<td width="5%" align="center">${memberlist.joindate }</td>
				<td width="5%" align="center">${memberlist.Score }</td>
				<td width="5%" align="center">${memberlist.howmanytrap }</td>
				<td width="5%" align="center"><a href="memberfix.do?trapperaccount=${traplist.trapperaccount }">유저 정보 수정</a></td>
				<td width="5%" align="center"><a href="memberdel.do?trapperaccount=${traplist.trapperaccount }">강제 탈퇴</a></td>
			</tr>
		</c:forEach>
	</table>

</body>
</html>