package member.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/MemberLogout.do")
public class MemberLogoutControllor extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public MemberLogoutControllor() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		
		// 1. Web Browser와 연결된 session 객체를 강제로 종료
		session.invalidate();

		// 2. Session 종료 후 login 화면으로 이동
		response.sendRedirect(request.getContextPath()+"/member/loginJoin.jsp");

	
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
