package web.servlet.api;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/api/v1/username")
public class GetUsername extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public void init(ServletConfig config) throws ServletException {
		System.out.println("최초 1회만 시행");
	}

	public void destroy() {
		System.out.println("서블릿 객체가 소멸될 때 1회만 실행");
	}

//	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		System.out.println(request.getMethod()); //request: 요청이 들어온다 response: 응답
//		System.out.println("서비스 호출");
//	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String t = request.getParameter("test");
		String name = request.getParameter("name");
		System.out.println("Get요청 들어옴");
		System.out.println("Read");
		
		System.out.println("test: + t");
		
		request.setAttribute("name", name);
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/views/user.jsp");
		//dispathcher: 연결할 대상 선택
		dispatcher.forward(request, response);
		
		
		
		
//		response.setContentType("application/json; charset=UTF-8");
//		response.setCharacterEncoding("UTF-8");	//UTF-8로 인코딩하여 응답하라
//		response.getWriter().println("<html><head></head><body>");
//		response.getWriter().println("<h1>안녕하세요</h1><<p>" + name + "</p></body></html>");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
		System.out.println("Post요청 들어옴");
		System.out.println("Create");
	}

	@Override
	protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		super.doPut(req, resp);
			System.out.println("Put요청 들어옴");
			System.out.println("Update");
	}
	
	@Override
	protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		super.doDelete(req, resp);
			System.out.println("Delete요청 들어옴");
			System.out.println("Delete");
	}
}
