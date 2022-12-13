package item.controller;

import java.io.File;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import item.dao.ItemDAO;
import item.vo.ItemVO;


@WebServlet("/InsertItem.do")
public class InsertItemController extends HttpServlet {
	private static final long serialVersionUID = 1L;
      
    public InsertItemController() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException  {
		System.out.println("insertController 들어오나요?");
		
		// 1. 사용자 입력 정보 추출
		String title = request.getParameter("title");
		String item_price = request.getParameter("item_price");
		String item_cnt = request.getParameter("item_cnt");
		String content = request.getParameter("content");
		
		System.out.println("사용자 정보 추출 완료"); 
		
		ItemVO vo = new ItemVO();
		vo.setTitle(title);
		vo.setItem_price(Integer.parseInt(item_price));
		vo.setItem_cnt(Integer.parseInt(item_cnt));
		vo.setContent(content);
		System.out.println("db 연동 완료");
		ItemDAO itemDAO = new ItemDAO();
		ItemVO item = itemDAO.insertItem(vo);
		
		System.out.println(item.toString());
		
		int maxSize = 50 * 1024 * 1024;
		MultipartRequest multi = null; 
		String savePath = request.getServletContext().getRealPath("C:\\Users\\user\\Desktop\\yhj\\JSPSpace\\ShoppingMall_project\\src\\main\\webapp\\shopping\\image");
		  try{
			// 2. DB 연동
				
		    multi = new MultipartRequest(request, savePath, maxSize ,"utf-8",new DefaultFileRenamePolicy());
			//업로드할 폴더
			//파일 업로드 관련 메소드 사용하려면 cos.jar파일 필요
			//MultipartRequest는 생성시 바로 업로드 되기 때문에 이름을 바꾸려면 업로드 후 파일명 변경해야 한다.  
			
			//form에서 보낸 file의 name을 값으로 받기		

			File origin_FIle = new File(savePath+"/"+ multi.getParameter("item_image"));
			File new_File = new File(savePath+"/"+item.getItem_no());
			
			origin_FIle.renameTo(new_File); //파일명 변경
			
		   }catch(Exception e){
			   
			   e.printStackTrace(); // 에러 확인
		   }
		

		
		
				
		// 화면 navigation (back to getBoardList.jsp)
		response.sendRedirect("GetItemList.do");

	
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
