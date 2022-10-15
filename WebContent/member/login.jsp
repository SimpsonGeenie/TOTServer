<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<article>	
<form method="post" action="NonageServlet?command=login">
		<fieldset>
		<h1>Login</h1>
			<table>
			<tr><td>
			<label>User ID</label></td><td> 
			<input name="id" type="text" value="${id}" value="one"></td>
			 <tr><td>
			<label>Password</label></td> 
			<td><input name="pwd" type="password" value="1111"></td>
			</tr>
			</table>
		</fieldset>
		<div class="clear"></div>
		<div id="buttons">
			<input type="submit" value="로그인" class="submit"> 
			<input	 type="button" value="회원가입" class="cancel" onclick="location='NonageServlet?command=join_form'"> 
			<input type="button" value="아이디 비밀번호 찾기" class="submit" onclick="location='NonageServlet?command=find_id_form'">
		</div>
		
	</form>
</article>