package TriporTrap;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.*;
import javax.servlet.http.*;

import TAOTVO.*;
import UTIL.*;

public class MyTraps implements Action {
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		

		TrapAO tao=TrapAO.getInstance();
		try {
			List<TrapVO> traplist=tao.selectalltrap();
			
			request.setAttribute("traplist", traplist);
		} catch (Exception e) {

			e.printStackTrace();
		}
		
	}
}
