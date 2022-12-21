package item.controller;

import java.io.File;
import java.io.IOException;
import java.util.Enumeration;

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
	
		
		
		// form 에서 파일을 받기위해 설정한  enctype="multipart/form-data"은 HttpServletRequest로 받아 오는 경우 null이 된다. 
		// 이때는 form에서 받아오는 값을 MultipartRequest로 받는다. 
		int maxSize = 50 * 1024 * 1024;
		String origin_path = "C:\\Users\\user\\Desktop\\yhj\\JSPSpace\\ShoppingMall_project\\src\\main\\webapp\\shopping\\origin_image\\";
	try{
		MultipartRequest multi = new MultipartRequest(request, origin_path, maxSize ,"utf-8",new DefaultFileRenamePolicy());
		
		// 1. 사용자 입력 정보 추출
		String title = multi.getParameter("title");
		String item_price = multi.getParameter("item_price");
		String item_cnt = multi.getParameter("item_cnt");
		String content = multi.getParameter("content");
		
		ItemVO item = new ItemVO();
		item.setTitle(title);
		item.setItem_price(Integer.parseInt(item_price));
		item.setItem_cnt(Integer.parseInt(item_cnt));
		item.setContent(content);
		ItemDAO itemDAO = new ItemDAO();
		itemDAO.insertItem(item);
		
		//파일 정보
		
		Enumeration<String> file = multi.getFileNames();
		
		while(file.hasMoreElements()) {
			String name  = (String)file.nextElement();
			String file_name = multi.getFilesystemName(name);
		
		
		System.out.println("file_name : "+file_name);
		String type =  file_name.substring(file_name.lastIndexOf(".") + 1);
			// 2. DB 연동
				
			//업로드할 폴더
			//파일 업로드 관련 메소드 사용하려면 cos.jar파일 필요
			//MultipartRequest는 생성시 바로 업로드 되기 때문에 이름을 바꾸려면 업로드 후 파일명 변경해야 한다.  
			
			//form에서 보낸 file의 name을 값으로 받기		

			File origin_FIle = new File(origin_path+file_name);
			File new_File = new File("C:\\Users\\user\\Desktop\\yhj\\JSPSpace\\ShoppingMall_project\\src\\main\\webapp\\shopping\\image\\"+item.getItem_no()+"."+type);
			System.out.println(new_File);
			
			origin_FIle.renameTo(new_File); //파일명 변경
			}
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
