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
String trappername=request.getParameter("trappername");
String trappernickname=request.getParameter("trappernickname");
String trapperphone=request.getParameter("trapperphone");
System.out.println("trappername : "+trappername);

MemberDAO mao=MemberDAO.getInstance();
int result=0;

try {
	
	System.out.println("어디서 문제냐");
	MemberVO mvo=new MemberVO();
	mvo.setTrapperid(trapperid);
	mvo.setTrapperpw(trapperpw);
	mvo.setTrappername(trappername);
	mvo.setTrappernickname(trappernickname);
	mvo.setTrapperphone(trapperphone);
	
	result=mao.insertMember(mvo);
	JSONObject jobj=new JSONObject();
	JSONArray jarray=new JSONArray();	
	JSONObject jobjin=new JSONObject();
	
		jobjin.put("trapperaccount", result+"");
	
		jarray.add(0, jobjin);
		jobj.put("trap", jarray);
	
	out.print(jobj);
	out.flush();
} catch (Exception e) {
}

%>