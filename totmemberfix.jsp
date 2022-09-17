<%@page import="TriporTrap.traplistdo2"%>
<%@page import="org.json.simple.*"%>
<%@page import="java.util.*"%>
<%@page import="MEMBER.*"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<%
request.setCharacterEncoding("utf-8");
String trapperid=request.getParameter("trapperid");
String trapperpw=request.getParameter("trapperpw");

System.out.println("유저아이디 : "+trapperid);
String trapperidreturn;

MemberDAO mao=MemberDAO.getInstance();

try {
	
	MemberVO mvo=new MemberVO();
	mvo.setTrapperid(trapperid);
	mvo.setTrapperpw(trapperpw);
	
	int result=mao.insertMember(mvo);
	JSONObject jobj=new JSONObject();
	JSONArray jarray=new JSONArray();	
	JSONObject jobjin=new JSONObject();
	if(result>0){
		jobjin.put("returnuserid", result);
	}else if(result==0){
		jobjin.put("returnuserid", "fail");
	}	
		jarray.add(0, jobjin);
		jobj.put("trap", jarray);
	
	out.print(jobj);
	out.flush();
} catch (Exception e) {
}

%>