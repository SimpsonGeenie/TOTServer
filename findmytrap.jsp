<%@page import="TriporTrap.traplistdo2"%>
<%@page import="org.json.simple.*"%>
<%@page import="java.util.*"%>
<%@page import="TAOTVO.*"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<%
request.setCharacterEncoding("utf-8");
String trapperaccount=request.getParameter("trapperaccount");
TrapAO tao=TrapAO.getInstance();
try {
	TrapVO traplist=tao.selectmytrap(trapperaccount);
	
	JSONObject jobj=new JSONObject();
	JSONArray jarray=new JSONArray();	
	
	
		JSONObject jobjin=new JSONObject();
		jobjin.put("trappicaccount", traplist.getTrappicaccount());
		jobjin.put("addre", traplist.getAddre());
		jobjin.put("pictureurl", traplist.getPictureurl());
		jarray.add(0, jobjin);
		jobj.put("trap", jarray);

	out.print(jobj);
	out.flush();
} catch (Exception e) {
}

%>