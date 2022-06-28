package web.filter;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpFilter;
import javax.servlet.http.HttpServletRequest;


@WebFilter("/*")
public class CharactorEncodingFilter extends HttpFilter implements Filter {

	private static final long serialVersionUID = 1L;
	
	public void destroy() {	//서블릿
	}	
	
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		//전처리
		System.out.println("전처리");
		HttpServletRequest HttpRequest = (HttpServletRequest) request;
		if(!HttpRequest.getMethod().equalsIgnoreCase("get")) {
			request.setCharacterEncoding("UTF-8");
			System.out.println("인코딩됨!");
			
			//IgnoreCase: 문자열을 대소문자 구분하지 않고 하겠다는 말임.
			
		}
			
		chain.doFilter(request, response);
		//후처리
		System.out.println("후처리");
	}

	public void init(FilterConfig fConfig) throws ServletException {

	}

}
