<%@page import="TriporTrap.traplistdo2"%>
<%@page import="org.json.simple.*"%>
<%@page import="java.util.*"%>
<%@page import="MEMBER.*"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<%
request.setCharacterEncoding("utf-8");
String trapperaccount=request.getParameter("trapperaccount");
String trapperpw=request.getParameter("trapperpw");

System.out.println("유저account : "+trapperaccount);
int trapperaccountint=0;

MemberDAO mao=MemberDAO.getInstance();
int result=0;
try {
	if(trapperaccount!=null)
		trapperaccountint=Integer.parseInt(trapperaccount);
	MemberVO mvo=new MemberVO();
	mvo.setTrapperaccount(trapperaccountint);
	mvo.setTrapperpw(trapperpw);
	
	result=mao.insertMember(mvo);
	JSONObject jobj=new JSONObject();
	JSONArray jarray=new JSONArray();	
	JSONObject jobjin=new JSONObject();
	if(result>0){
		jobjin.put("trapperaccount", result+"");
	}else if(result==0){
		jobjin.put("trapperaccount", "fail");
	}	
		jarray.add(0, jobjin);
		jobj.put("trap", jarray);
	
	out.print(jobj);
	out.flush();
} catch (Exception e) {
}

%>