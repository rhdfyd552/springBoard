package kr.or.ddit.interceptor;


import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import kr.or.ddit.notice.service.NoticeServiceInf;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

public class LoginInterceptor extends HandlerInterceptorAdapter{	
	Logger logger = LoggerFactory.getLogger(LoginInterceptor.class);
	
	@Resource(name="noticeService")
	private NoticeServiceInf noticeService;
	
	@Override
	public boolean preHandle(HttpServletRequest request,
			HttpServletResponse response, Object handler) throws Exception {
		HttpSession session = request.getSession();
		
		logger.debug("{}","인터셉터================================");
		
		if(session.getAttribute("loginUser") != null){			
			return true;
		}else{
			response.sendRedirect("login/login");
			return false;
		}
	}

}
