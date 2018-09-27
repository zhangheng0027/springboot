package com.iweb.zh.intercepor;

import java.lang.reflect.Method;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.logging.log4j.util.Strings;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;

import com.iweb.zh.custormannotation.UnInterception;

public class MyInterceptor implements HandlerInterceptor {
	
	private static final Logger log = LoggerFactory.getLogger(MyInterceptor.class);


	@Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
	 	
        HandlerMethod handlerMethod = (HandlerMethod) handler;
        Method method = handlerMethod.getMethod();
        UnInterception unInterception = method.getAnnotation(UnInterception.class);
        if (null != unInterception)
        	return true;
        @SuppressWarnings("unchecked")
		Set<String> power = (Set<String>) request.getSession().getAttribute("power");
        String uri = request.getRequestURI();
        if (!Strings.isBlank(uri) && power.contains(uri)) 
        	return true;
        return false;
    }

//	    @Override
//	    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
//	    	//log.info("执行完方法之后进执行(Controller方法调用之后)，但是此时还没进行视图渲染");
//	    }

//	    @Override
//	    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
//	    	//log.info("整个请求都处理完咯，DispatcherServlet也渲染了对应的视图咯，此时我可以做一些清理的工作了");
//	    }
	
}
