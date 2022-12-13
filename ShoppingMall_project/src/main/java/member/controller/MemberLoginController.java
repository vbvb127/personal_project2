package member.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import item.dao.ItemDAO;
import item.vo.ItemVO;
import member.dao.MemberDAO;
import member.vo.MemberVO;

@WebServlet("/MemberLogin.do")
public class MemberLoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public MemberLoginController() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		System.out.println("login");
		request.setCharacterEncoding("utf-8");

		MemberVO vo = new MemberVO();
		MemberDAO memberDAO = new MemberDAO();
		
		String id = request.getParameter("id");
		String password = request.getParameter("password");
		System.out.println(id);
		System.out.println(password);
		
		vo.setM_id(id);
		vo.setM_password(password);
		
		HttpSession session = request.getSession();
		
		//로그인 체크   return 0 : 성공     /    1, -1 : 실패 
		try {
			int login = memberDAO.checkLogin(id,password);
			
			if(login == 0){
				System.out.println("로그인 성공");
				MemberVO member = memberDAO.getUser(vo);
				System.out.println(member.toString());	
				System.out.println("getuser"+member.getM_id());
				session.setAttribute("name", member.getM_name());
				session.setAttribute("id", member.getM_id());
				request.getRequestDispatcher("/GetItemList.do").forward(request, response);
			
			}else{
				System.out.println("실패");
				response.sendRedirect("member/loginJoin.jsp");	
			}

		}catch (Exception e) {
			e.printStackTrace(); //오류 정보 
		}
	
	
	
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
