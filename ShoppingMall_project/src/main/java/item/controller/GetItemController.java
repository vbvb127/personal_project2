package item.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import item.dao.ItemDAO;
import item.vo.ItemVO;


@WebServlet("/GetItem.do")
public class GetItemController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public GetItemController() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String item_no = request.getParameter("item_no");
		ItemDAO itemDAO = new ItemDAO();
		
		ItemVO vo = new ItemVO();
		vo.setItem_no(item_no);
		
		ItemVO item = itemDAO.getItem(vo);
		System.out.println(item.toString());
		
		HttpSession session = request.getSession();
		session.setAttribute("item", item);
		response.sendRedirect("shopping/shoppingDetail.jsp");
		
		
		
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
