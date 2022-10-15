<%@page import="TriporTrap.traplistdo2"%>
<%@page import="org.json.simple.*"%>
<%@page import="java.util.*"%>
<%@page import="TAOTVO.*"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<%

String trappicaccount=request.getParameter("trappicaccount");

	
	
	
	TrapAO tao=TrapAO.getInstance();
	try {
		TrapVO traplist=tao.selecttrap(trappicaccount);
		int percent=traplist.getIsunlocked();
		JSONObject jobj=new JSONObject();
		JSONArray jarray=new JSONArray();	
		
			JSONObject jobjin=new JSONObject();
			jobjin.put("isunlocked", traplist.getIsunlocked());			
			jarray.add(0, jobjin);
			jobj.put("trap", jarray);
		
		out.print(jobj);
		out.flush();
	} catch (Exception e) {
	}
	
%>
