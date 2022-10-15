package TriporTrap;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.*;
import javax.servlet.http.*;

import TAOTVO.*;
import UTIL.*;

public class TrapListOther implements Action {
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session = request.getSession();
		String url = "triportrap.jsp";
		
		TrapAO tao=TrapAO.getInstance();
		try {
			List<TrapVO> traplist=tao.selectalltrap();
			
			request.setAttribute("traplist", traplist);
		} catch (Exception e) {

			e.printStackTrace();
		}
		RequestDispatcher dispatcher = request.getRequestDispatcher(url);
		 dispatcher.forward(request, response);
		
	}
}
