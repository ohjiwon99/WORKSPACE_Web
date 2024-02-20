package com.javaex.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.javaex.dao.PhoneDao;
import com.javaex.vo.PersonVo;

@WebServlet("/pbc")
public class phonebookController extends HttpServlet {
	// 필드
	private static final long serialVersionUID = 1L;

	// 생성자-기본생성자사용

	// 메소드-gs

	// 메소드-일반
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		System.out.println("phonebookController.goGet");

		String action = request.getParameter("action");
		System.out.println(action);
		// http://localhost:8080/phonebook3/pbc?action=insert

		if ("wform".equals(action)) {
			System.out.println("wform:등록폼");
			// http://localhost:8080/phonebook3/pbc?action=wform

			// 포워드
			// jsp한테 heml그리기! ->응답해줘 ==>포워드forword
			RequestDispatcher rd = request.getRequestDispatcher("/WriteForm.jsp");
			rd.forward(request, response);
			// http://localhost:8080/phonebook3/pbc?name=오지원&hp=010&company=02

			/*******************************************
			 *                  등록
			 * ****************************************/
		} else if ("insert".equals(action)) {
			System.out.println("insert:등록");
			// http://localhost:8080/phonebook3/pbc?action=insert

			String name = request.getParameter("name");
			String hp = request.getParameter("hp");
			String company = request.getParameter("company");

			// vo로 묶기
			PersonVo personVo = new PersonVo(name, hp, company);
			System.out.println(personVo.toString());

			System.out.println(name);
			System.out.println(hp);
			System.out.println(company);
			// http://localhost:8080/phonebook3/pbc?action=insert&name=오지원&hp=010&company=02

			// db관련 업무
			PhoneDao phoneDao = new PhoneDao();

			// db에 저장
			phoneDao.personInsert(personVo);

			/*
			 * [리다이렉트==>엔터 효과를 낸다] //http://localhost:8080/phonebook3/pbc?action=list
			 */
			response.sendRedirect("http://localhost:8080/phonebook3/pbc?action=list");

			// db에서 전체 데이터 가져오기
			// List<PersonVo> personList = phoneDao.personSelect();
			// System.out.println(personList);

			// request 에 담기
			// request.setAttribute("personList", personList);

			// 포워드
			// RequestDispatcher rd = request.getRequestDispatcher("/list.jsp");
			// rd.forward(request, response);
			
			
			/*******************************************
			 *                  리스트
			 * ****************************************/
		} else if ("list".equals(action)) {
			System.out.println("list:리스트");

			// db 사용
			PhoneDao phoneDao = new PhoneDao();

			// list가져오기
			List<PersonVo> PersonList = phoneDao.personSelect();
			// http://localhost:8080/phonebook3/pbc?action=list

			// 데이터담기 포워드
			request.setAttribute("personList", PersonList);

			RequestDispatcher rd = request.getRequestDispatcher("/list.jsp");
			rd.forward(request, response);
			
			
			/*******************************************
			 *                  삭제
			 * ****************************************/
		} else if ("delete".equals(action)) {
			System.out.println("delete:삭제");

			int no = Integer.parseInt(request.getParameter("no"));
			System.out.println(no);

			// db사용
			PhoneDao phoneDao = new PhoneDao();

			// 삭제
			phoneDao.personDelete(no);

			// 리다이렉트
			response.sendRedirect("/phonebook3/pbc?action=list");
		
			
			/*******************************************
			 *                  수정
			 * ****************************************/			
		} else if ("update".equals(action)) {
			System.out.println("update:수정");
			
			int no = Integer.parseInt(request.getParameter("no"));
			System.out.println(no);
			
			
	/*		String name = request.getParameter("name");
			String company =  request.getParameter("hp");
			String hp = request.getParameter("company");
			
			// vo로 묶기
			PersonVo personVo = new PersonVo(name, hp, company);

			
			// db사용
			PhoneDao phoneDao = new PhoneDao();

			// 수정
			phoneDao.personUpdate(personVo);

			// 리다이렉트
			//response.sendRedirect("/phonebook3/pbc?action=list");*/
			
			// 데이터담기 포워드
			request.setAttribute("no", no);

			RequestDispatcher rd = request.getRequestDispatcher("/update.jsp");
			rd.forward(request, response);

			
		
		
		
		} else if ("update2".equals(action)) {
			System.out.println("update2: 수정 후 화면");
			

			int no = Integer.parseInt(request.getParameter("no"));
			System.out.println(no);

			// db사용
			PhoneDao phoneDao = new PhoneDao();
			
			String name = request.getParameter("name");
			String company =  request.getParameter("hp");
			String hp = request.getParameter("company");
			
			System.out.println(name);
			
			// vo로 묶기
			PersonVo personVo = new PersonVo(no, name, hp, company);

			// 수정
			phoneDao.personUpdate(personVo);

			// 리다이렉트
			response.sendRedirect("/phonebook3/pbc?action=list");			
		}

		// http://localhost:8080/phonebook3/pbc?action=wform
		// http://localhost:8080/phonebook3/pbc?action=insert&name=오지원&hp=010&company=02

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request, response);
	}

}
