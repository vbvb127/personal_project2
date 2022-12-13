package item.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import item.dao.ItemDAO;
import item.vo.ItemVO;


@WebServlet("/GetItemList.do")
public class GetItemListController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public GetItemListController() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		ItemVO vo = new ItemVO();
		ItemDAO itemDAO = new ItemDAO();
	
		
		List<ItemVO> itemList = itemDAO.getItemList(vo);

		HttpSession session = request.getSession();
		session.setAttribute("itemList", itemList);
		
		request.getRequestDispatcher("shopping/shoppingMain.jsp").forward(request, response);

		

	
	
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
