package QnABBS;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import MEMBER.MemberVO;
import UTIL.Action;

public class QnaWriteAction implements Action {
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url = "NonageServlet?command=qna_list";

		 HttpSession session = request.getSession();
		 MemberVO loginUser = (MemberVO) session.getAttribute("loginUser");

		 if (loginUser == null) {
		 url = "NonageServlet?command=login_form";
		 } else {
			 QnaVO qnaVO = new QnaVO();
			 qnaVO.setSubject(request.getParameter("subject"));
			 qnaVO.setContent(request.getParameter("content"));
			 QnaDAO qnaDAO = QnaDAO.getInstance();
			 qnaDAO.insertqna(qnaVO, loginUser.getId()); 
		 }
		 request.getRequestDispatcher(url).forward(request, response);
		 }
	
}