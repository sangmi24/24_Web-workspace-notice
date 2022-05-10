package com.kh.notice.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kh.notice.model.service.NoticeService;
import com.kh.notice.model.vo.Notice;

/**
 * Servlet implementation class NoticeInsertController
 */
@WebServlet("/insert.no")
public class NoticeInsertController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public NoticeInsertController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//1) 인코딩 셋팅(Post 방식일 경우에만)
		request.setCharacterEncoding("UTF-8");
		
		//2) 요청 시 전달값 뽑아서 변수에 기록 및 VO 객체로 가공
		// 제목, 내용, 작성자 회원번호 
		String userNo = request.getParameter("userNo"); // "1"
		// 일부로 파싱 안함 => notice에서 스트링으로 했기 때문
		String noticeTitle = request.getParameter("title");
		String noticeContent = request.getParameter("content");
		
		Notice n = new Notice(); //가공하기.  기본생성자 
		n.setNoticeWriter(userNo);
		n.setNoticeTitle(noticeTitle);
		n.setNoticeContent(noticeContent);
		
		System.out.println(userNo);
		
		// 3) NoticeService의 어떤 메소드를 호출해서 결과 받기
		int result = new NoticeService().insertNotice(n);
		
		// 4) 결과에 따라 응답페이지 지정
		if(result >0 ) { 
		  //성공=> /jsp/list.no 로 요청(리스트 페이지가 보여지도록) 
		  
			request.getSession().setAttribute("alertMsg", "성공적으로 공지사항이 등록되었습니다.");
			
			response.sendRedirect(request.getContextPath()+ "/list.no");
			
			
		}else { //실패 => 에러페이지로 포워딩 
			
			request.setAttribute("errorMsg", "공지사항 등록 실패");
			
			request.getRequestDispatcher("views/common/errorPage.jsp").forward(request, response);
			
		}
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
