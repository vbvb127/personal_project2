package member.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import member.dao.MemberDAO;
import member.vo.MemberVO;


@WebServlet("/MemberUpdate.do")
public class MemberUpdateController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public MemberUpdateController() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String name = request.getParameter("name");
		String id = request.getParameter("id");
		String password = request.getParameter("password");
		String address = request.getParameter("address");
		String tel = request.getParameter("tel");
		
		MemberVO vo = new MemberVO();
		vo.setM_id(id);
		vo.setM_name(name);
		vo.setM_password(password);
		vo.setM_address(address);
		vo.setM_tel(tel);
		
		
		MemberDAO memberDAO = new MemberDAO();
		memberDAO.updateMember(vo);
		//update
		
		
		
		
		//정보를 가지고 다시 update 페이지로 이동
		
			HttpSession session = request.getSession();
			request.setAttribute("user_vo", vo);
			session.setAttribute("name", vo.getM_name());
			session.setAttribute("id", vo.getM_id());
			
			request.getRequestDispatcher("shopping/shoppingMain.jsp").forward(request, response);

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
