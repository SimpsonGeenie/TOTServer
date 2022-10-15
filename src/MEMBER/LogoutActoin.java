package MEMBER;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import UTIL.Action;

public class LogoutActoin implements Action {
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//String url="NonageServlet?command=index";
		String url="member/logout.jsp";
		HttpSession session = request.getSession();

		if (session != null) {
			session.invalidate();
		}
		request.getRequestDispatcher(url).forward(request, response);
	}
}