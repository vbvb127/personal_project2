package member.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import member.dao.MemberDAO;
import member.vo.MemberVO;

@WebServlet("/MemberCreate.do")
public class MemberCreateController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public MemberCreateController() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		System.out.println("create");

		MemberVO vo = new MemberVO();
		MemberDAO memberDAO = new MemberDAO();
		
		String name = request.getParameter("name");
		String id = request.getParameter("id");
		String password = request.getParameter("password");
		String address = request.getParameter("address");
		String tel = request.getParameter("tel");
		
		vo.setM_name(name);
		vo.setM_id(id);
		vo.setM_password(password);
		vo.setM_address(address);
		vo.setM_tel(tel);
		
		
		memberDAO.createMember(vo);
		response.sendRedirect("member/loginJoin.jsp");	
	
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
