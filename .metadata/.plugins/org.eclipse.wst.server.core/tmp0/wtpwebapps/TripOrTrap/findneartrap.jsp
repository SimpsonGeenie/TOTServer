<%@page import="TriporTrap.traplistdo2"%>
<%@page import="org.json.simple.*"%>
<%@page import="java.util.*"%>
<%@page import="TAOTVO.*"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<%
request.setCharacterEncoding("utf-8");
double lat=Double.parseDouble(request.getParameter("lat"));
double lon=Double.parseDouble(request.getParameter("lon"));

TrapAO tao=TrapAO.getInstance();
try {
	List<TrapVO> traplist=tao.selectneartrap(lat, lon);
	
	JSONObject jobj=new JSONObject();
	JSONArray jarray=new JSONArray();	
	
	for(int i=0;i<traplist.size();i++){
		JSONObject jobjin=new JSONObject();
		jobjin.put("trappicaccount", traplist.get(i).getTrappicaccount());
		jobjin.put("trapperaccount", traplist.get(i).getTrapperaccount());
		jobjin.put("addre", traplist.get(i).getAddre());
		jobjin.put("latitude", traplist.get(i).getLatitude());
		jobjin.put("longitude", traplist.get(i).getLongitude());
		jobjin.put("pictureurl", traplist.get(i).getPictureurl());
		jarray.add(0, jobjin);
		jobj.put("trap", jarray);
	}
	out.print(jobj);
	out.flush();
} catch (Exception e) {
}

%>