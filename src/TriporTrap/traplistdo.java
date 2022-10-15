package TriporTrap;

import java.io.IOException;
import java.io.OutputStream;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import TAOTVO.TrapAO;
import TAOTVO.TrapVO;
import oracle.sql.BLOB;

/**
 * Servlet implementation class traplistdo
 */
@WebServlet("/traplist.do")
public class traplistdo extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
    public traplistdo() {
        super();
       
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		
		TrapAO tao=TrapAO.getInstance();
		try {
			List<TrapVO> traplist=tao.selectalltrap();
			
			request.setAttribute("traplist", traplist);
						
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		RequestDispatcher dis=request.getRequestDispatcher("triportrap.jsp");
		dis.forward(request, response);
	}
	
}
