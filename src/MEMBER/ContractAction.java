package MEMBER;

import java.io.IOException;

import javax.servlet.*;
import javax.servlet.http.*;

import UTIL.Action;

public class ContractAction  implements Action {
	 @Override
	 public void execute(HttpServletRequest request, HttpServletResponse response)
	 throws ServletException, IOException {
	 String url = "member/contract.jsp";

	 RequestDispatcher dispatcher=request.getRequestDispatcher(url);
	 dispatcher.forward(request, response);
	 }
	}