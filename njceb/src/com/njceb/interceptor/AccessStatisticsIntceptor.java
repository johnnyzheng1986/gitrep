package com.njceb.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

public class AccessStatisticsIntceptor implements HandlerInterceptor {
	
	private static org.apache.log4j.Logger log = Logger.getLogger(AccessStatisticsIntceptor.class);

	@Override
	public void afterCompletion(HttpServletRequest arg0,
			HttpServletResponse arg1, Object arg2, Exception arg3)
			throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void postHandle(HttpServletRequest arg0, HttpServletResponse arg1,
			Object arg2, ModelAndView arg3) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response,
			Object arg2) throws Exception {
		// TODO Auto-generated method stub
		final String LOGIN_URL = "../index.jsp";
		String uri = request.getRequestURI().substring(request.getRequestURI().lastIndexOf("/") +1);
		log.info("===请求URL=====["+uri+"]");
		//登录请求不过滤
		if(uri !=null && uri.equals("login.do")){
			return true;
		}
		String userName = (String) request.getSession(true).getAttribute("LOGINUSER");
        if(userName==null || "".equals(userName) ) {  
            //校验失败
        	response.sendRedirect(LOGIN_URL);
        }
        
        return true;
	}

}
