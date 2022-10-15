package QnABBS;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import MEMBER.MemberVO;
import UTIL.Action;

public class QnaViewAction implements Action {
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url = "bbs/qnaView.jsp";

		 HttpSession session = request.getSession();
		 MemberVO loginUser = (MemberVO) session.getAttribute("loginUser");

		 if (loginUser == null) {
		 url = "NonageServlet?command=login_form";
		 } else {
			 int qseq = Integer.parseInt(request.getParameter("qseq"));
			 QnaDAO qnaDAO = QnaDAO.getInstance();
			 QnaVO qnaVO = qnaDAO.getQna(qseq);
			 request.setAttribute("qnaVO", qnaVO);
		 }
		 request.getRequestDispatcher(url).forward(request, response);
		 }
	
}