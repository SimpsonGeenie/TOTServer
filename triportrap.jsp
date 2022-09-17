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
			<h1>트랩 확인</h1>			
		</legend>
		<tr>
			<td colspan="5" style="border: white; text-align: right"><a
				href="traplist.do">트랩 새로고침</a></td>
		</tr>
		<tr>
			<th>유저어카운트</th>
			<th>주소</th>
			<th>위도</th>
			<th>경도</th>
			<th>나침반 방향X</th>
			<th>나침반 방향Y</th>
			<th>나침반 방향Z</th>
			<th>사진</th>
			<th>트랩해제 여부</th>
			<th>최근 언락유저</th>
			<th>최근 언락사진</th>
			<th>트랩 해제</th>
			<th>트랩 삭제</th>
		</tr>
		<c:forEach var="traplist" items="${traplist }">
			<tr class="record">
				<td width="5%" align="center">${traplist.trapperaccount }</td>
				<td width="5%" align="center">${traplist.addre }</td>
				<td width="5%" align="center">${traplist.latitude }</td>
				<td width="5%" align="center">${traplist.longitude }</td>
				<td width="5%" align="center">${traplist.heading }</td>
				<td width="5%" align="center">${traplist.pitch }</td>
				<td width="5%" align="center">${traplist.roll }</td>
				<td width="5%" align="center"><img src="http://mustory.ivyro.net/tot/${traplist.pictureurl }" width="150px" height="75px"></td>
				<td width="5%" align="center">${traplist.trapunlock }</td>
				<td width="5%" align="center">${traplist.unlockeraccount }</td>
				<td width="5%" align="center"><img src="http://mustory.ivyro.net/tot/${traplist.unlockpictureurl }"
					width="150px" height="75px" alt="이미지 없음."></td>
				<td width="5%" align="center"><a
					href="trapunlock.do?pictureurl=${traplist.pictureurl }">트랩
						해제</a></td>
				<td width="5%" align="center"><a
					href="trapdel.do?pictureurl=${traplist.pictureurl }">트랩
						삭제</a></td>
			</tr>
		</c:forEach>
	</table>

</body>
</html>