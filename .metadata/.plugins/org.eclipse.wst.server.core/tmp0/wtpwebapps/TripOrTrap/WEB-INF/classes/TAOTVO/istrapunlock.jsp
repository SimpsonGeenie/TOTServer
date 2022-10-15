<%@page import="org.json.simple.*"%>
<%@page import="java.util.*"%>
<%@page import="TAOTVO.*"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<%
request.setCharacterEncoding("utf-8");
int unlockedq=Integer.parseInt(request.getParameter("unlockedq"));

	
	TrapAO tao=TrapAO.getInstance();
	JSONObject jobj=new JSONObject();
		JSONArray jarray=new JSONArray();	
		
			JSONObject jobjin=new JSONObject();
			jobjin.put("unlockpercent", unlockedq+"");			
			jarray.add(0, jobjin);
			jobj.put("trap", jarray);
		
		out.print(jobj);
		out.flush();
	
%>
