package com.fireway.exceptionResolver;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.shiro.authz.AuthorizationException;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

@Component
public class MyExceptionResolver implements HandlerExceptionResolver {

	public ModelAndView resolveException(HttpServletRequest request, HttpServletResponse response,
			Object object,
			Exception exception) {

		//是否为ajax请求  
        String requestType = request.getHeader("X-Requested-With");  
         try {
			if(exception instanceof AuthorizationException){  
			    response.setStatus(401);//无权限异常  主要用于ajax请求返回  
			    response.addHeader("Error-Json", "{success:false,message:'没有权限',script:''}");  
			    response.setContentType("text/html;charset=utf-8");  
			    response.getWriter().write("权限不足，请联系管理员!!!");
			    if("XMLHttpRequest".equals(requestType)){  
			        return new ModelAndView();  
			    }  
			    return new ModelAndView("redirect:/noPermissionUI.jsp");  
			}
		} catch (IOException e) {
			e.printStackTrace();  
		}  
		
		
		return null;
	}

}
