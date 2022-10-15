package TriporTrap;

import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import TAOTVO.TrapAO;
import TAOTVO.TrapVO;
import oracle.sql.BLOB;

@WebServlet("/traplist2.do")
public class traplistdo2 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
    public traplistdo2() {
        super();       
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		
		TrapAO tao=TrapAO.getInstance();
		try {
			List<TrapVO> traplist=tao.selectalltrap();
			JSONArray jarray=new JSONArray();
			JSONObject jobj=new JSONObject();
			
			for(int i=0;i<traplist.size();i++){
				jobj.put("trapperaccount", traplist.get(i).getTrapperaccount());
				jobj.put("addre", traplist.get(i).getAddre());
				jobj.put("latitude", traplist.get(i).getLatitude());
				jobj.put("longitude", traplist.get(i).getLongitude());
				jobj.put("pictureurl", traplist.get(i).getPictureurl());
				jarray.add(jobj);
			}
			
			//out.print(jarray);
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		RequestDispatcher dis=request.getRequestDispatcher("triportraplist.jsp");
		dis.forward(request, response);
	}
	
}
