package com.ssafy.ws.interceptor;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

@Component
public class SessionInterceptor implements HandlerInterceptor{
	/**
	 * 사용자의 요청을 처리하기 전에 session에 loginUser가 있는지 판단한다.
	 * 정보가 있다면 그대로 진행하고, 정보가 없다면 index 페이지로 이동시킨다.
	 */
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
		HttpSession session = request.getSession();
		// 세션에 로그인 정보가 있다면 그대로 진행한다.
		if(session.getAttribute("loginUser")!=null) {
			return true;
		}
		// 세션 정보가 없다면 index로 redirect 시킨다.
		else {
			//response.sendRedirect(request.getContextPath()+"/index");
			
//			RequestDispatcher rd = request.getRequestDispatcher(request.getContextPath()+"/index");
//            request.setAttribute("msg", "로그인 후 등록이 가능합니다.");
//            rd.forward(request, response);
//			return false;
			
//			session.setAttribute("msg", "로그인부터!");
			response.setContentType("text/html; charset=UTF-8");
			PrintWriter out = response.getWriter();            
			out.println("<script>alert('로그인 후 글쓰기 가능합니다.'); history.go(-1);</script>");
			out.flush();
            response.sendRedirect(request.getContextPath()+"/index");
            return false;
		}
	}
}
/*
인터셉터 (Interceptor)
1. Interceptor란 컨트롤러에 들어오는 요청 HttpRequest와 컨트롤러가 응답하는 HttpResponse를 가로채는 역할을 한다.
인터셉터는 관리자만 접근할 수 있는 관리자 페이지에 접근하기 전에 관리자 인증을 하는 용도로 활용될 수 있다.
2. 인터셉터는 Servlet의 앞/뒤에서 HttpRequest, HttpResponse을 가로채는 Filter와 그 역할이 유사하다.
     하지만, Filter와 Interceptor는 분명히 다르다.

[Filter와 Interceptor의 차이]
(1) 호출 시점
Filter는 DispatcherServlet이 실행되기 전 , Interceptor는 DispatcherServlet이 실행된 후

(2) 설정 위치
Filter는 web.xml , Interceptor는 spring-servlet.xml이다.

(3) 구현 방식
Filter는 web.xml에서 설정을 하면 구현이 가능하지만, Interceptor는 설정은 물론 메서드 구현이 필요하다.

[HandlerInterceptor 인터페이스 구현]
(1) preHandle() 메서드는  컨트롤러가 호출되기 전에 실행된다. 
       매개변수 obj는 Dispatcher의 HandlerMapping 이 찾아준 컨트롤러의 메서드를 참조할 수 있는 HandlerMethod 객체이다.
(2) postHandle() 메서드는 컨트롤러가 실행된 후에 호출된다.
(3) afterComplete() 은 뷰에서 최종 결과가 생성하는 일을 포함한 모든 일이 완료 되었을 때 실행된다.

[HandlerInterceptorAdapter 클래스를 상속 받아 구현]
preHandle(), postHandle() , afterCompletion() 메서드가 구현되어 있으므로 필요한 메서드만 오버라이딩 하면 된다.
*/
















