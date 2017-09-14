package com.fireway.user.controller;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.LogoutAware;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.druid.sql.dialect.oracle.ast.stmt.OracleIfStatement.Else;
import com.fireway.entity.Student;
import com.fireway.entity.StudentExample;
import com.fireway.entity.Teacher;
import com.fireway.entity.TeacherExample;
import com.fireway.entity.User;
import com.fireway.entity.UserExample;
import com.fireway.sys.service.MenuListService;
import com.fireway.user.service.StudentService;
import com.fireway.user.service.TeacherService;
import com.fireway.user.service.UserService;
import com.fireway.utils.ContantsUtil;
import com.fireway.utils.DateUtil;
import com.fireway.utils.Encrypt;
import com.fireway.utils.LogUtil;
import com.fireway.utils.Utils;
import com.fireway.utils.jsonUtil;

@Controller
public class LoginController {

	@Resource
	private UserService userService;
	@Resource
	private TeacherService teacherService;
	@Resource
	private StudentService studentService;
	@Resource
	private MenuListService menuListService;
	
	@RequestMapping(value="/common/loginIndex.do",method=RequestMethod.GET)
	public String toHome(){
		
		return "loginIndex";
	}
	
	@RequestMapping(value="/common/login.do",method=RequestMethod.POST)
	@ResponseBody
	public Map<String, Object> toLogin(HttpServletRequest request,HttpServletResponse response,
			String num, String password, boolean rememberMe, String loginType ){
		request.getServletContext().setAttribute("schoolYearAtNow", 
				Utils.getSchoolYearAtNow());
		request.getServletContext().setAttribute("termAtNow", 
				Utils.getTermAtNow());
		Map<String, Object> result = new HashMap<String, Object>();
	try {
		String sucMsg = ",登录成功";
		if (rememberMe){
			Cookie cookie1 = new Cookie("num", num);
			Cookie cookie2 = new Cookie("password", password);
			cookie1.setMaxAge(60 * 60 * 24 * 3);
			cookie2.setMaxAge(60 * 60 * 24 * 3);
			response.addCookie(cookie1);
			response.addCookie(cookie2);
		}
		if ("admin".equals(loginType)){
			//shiro
			try {
				
				UsernamePasswordToken token = new UsernamePasswordToken(num,  Encrypt.md5Encode(password));
				SecurityUtils.getSubject().login(token);
				User user = userService.findByNumAndPassword(num, Encrypt.md5Encode(password));
				
				user.setLoginIp(getIp(request));
				user.setLastLoginTime(DateUtil.dateTimeFormat(null, new Date()));
				UserExample example = new UserExample();
				example.createCriteria().andIdEqualTo(user.getId());
				userService.updateByExample(user, example);
				request.getSession(true).setAttribute(ContantsUtil.USER, user);
				sucMsg = user.getName()+sucMsg;
				result.put("url", "/admin/home.do");
				result.put("success", true);
				result.put("message", sucMsg);
			} catch (UnknownAccountException ex) {//用户名没有找到。  
				result.put("success", false);
				result.put("message", "账号不存在或密码有误，请重新输入");
			} catch (IncorrectCredentialsException ex) {//用户名密码不匹配。 
				result.put("success", false);
				result.put("message", "账号密码不匹配，请重新输入");
			}catch (AuthenticationException e) {//其他的登录错误  
				result.put("success", false);
				result.put("message", "请求异常，请稍后再试...");
			}  
		}
		
		else if ("student".equals(loginType)){
			try {
				UsernamePasswordToken token = new UsernamePasswordToken(num,  Encrypt.md5Encode(password));
				SecurityUtils.getSubject().login(token);
				Student student = null;
				StudentExample example = new StudentExample();
				example.createCriteria().andStudentNumEqualTo(num).andStatusEqualTo(true)
					.andPasswordEqualTo(Encrypt.md5Encode(password));
				List<Student> list = studentService.findByExample(example);
				if (null != list && list.size() >0){
					student = list.get(0);
					request.getSession().setAttribute(ContantsUtil.USER, student);
					//request.setAttribute("menuLists", menuListService.findAll("student"));
					sucMsg = student.getName()+sucMsg;
					result.put("url", "/student/home.do");
					result.put("success", true);
					result.put("message", sucMsg);
				}
			} catch (UnknownAccountException ex) {//用户名没有找到。  
				result.put("success", false);
				result.put("message", "账号不存在或密码有误，请重新输入");
			} catch (IncorrectCredentialsException ex) {//用户名密码不匹配。 
				result.put("success", false);
				result.put("message", "账号密码不匹配，请重新输入");
			}catch (AuthenticationException e) {//其他的登录错误  
				result.put("success", false);
				result.put("message", "请求异常，请稍后再试...");
			}  
		}
		
		else if ("teacher".equals(loginType)){
			try {
				UsernamePasswordToken token = new UsernamePasswordToken(num,  Encrypt.md5Encode(password));
				SecurityUtils.getSubject().login(token);
				Teacher teacher = null;
				TeacherExample example = new TeacherExample();
				example.createCriteria().andTeacherNumEqualTo(num).andStatusEqualTo(true)
					.andPasswordEqualTo(Encrypt.md5Encode(password));
				List<Teacher> list = teacherService.findByExample(example);
				if (null != list && list.size() > 0){
					teacher = list.get(0);
					request.getSession().setAttribute(ContantsUtil.USER, teacher);
					sucMsg = teacher.getName()+sucMsg;
					result.put("url", "/teacher/home.do");
					result.put("success", true);
					result.put("message", sucMsg);
				}
			} catch (UnknownAccountException ex) {//用户名没有找到。  
				result.put("success", false);
				result.put("message", "账号不存在或密码有误，请重新输入");
			} catch (IncorrectCredentialsException ex) {//用户名密码不匹配。 
				result.put("success", false);
				result.put("message", "账号密码不匹配，请重新输入");
			}catch (AuthenticationException e) {//其他的登录错误  
				result.put("success", false);
				result.put("message", "请求异常，请稍后再试...");
			}  
		}
		else{
		result.put("success", false);
		result.put("message", "账号或密码有误，请重新输入");
		}
	} catch (Exception e) {
		e.printStackTrace();
		result.put("success", false);
	}	

		return result;
	}
	
	@ResponseBody
	@RequestMapping(value="/common/logout.do",method=RequestMethod.GET)
	public Object toLogout(HttpSession session){
		
		try{
			if (null != session && null != session.getAttribute("user")){
				session.invalidate();
				return jsonUtil.newJson("message", "退出账号成功");
			}
		}catch (Exception e) {
			return jsonUtil.newJson("message", "该账号已退出");
			
		}
		return jsonUtil.newJson("message", "你已退出账号");
	}
	
	
	@RequestMapping(value="/admin/home.do",method=RequestMethod.GET)
	public String adminHome(){
		
		
		
		return "admin/home";
	}
	
	@RequestMapping(value="/teacher/home.do",method=RequestMethod.GET)
	public String teacherHome(){
		
		
		
		return "teacher/home";
	}
	
	@RequestMapping(value="/student/home.do",method=RequestMethod.GET)
	public String studentHome(){
		
		
		
		return "student/home";
	}
	

	
	
	
	private static String getIp(HttpServletRequest request) {
		/**
	      * 从Request对象中获得客户端IP，处理了HTTP代理服务器和Nginx的反向代理截取了ip
	      * @param request
	      * @return ip
	      */
	        String remoteAddr = request.getRemoteAddr();
	        String forwarded = request.getHeader("X-Forwarded-For");
	        String realIp = request.getHeader("X-Real-IP");

	        String ip = null;
	        if (realIp == null) {
	            if (forwarded == null) {
	                ip = remoteAddr;
	            } else {
	                ip = remoteAddr + "/" + forwarded.split(",")[0];
	            }
	        } else {
	            if (realIp.equals(forwarded)) {
	                ip = realIp;
	            } else {
	                if(forwarded != null){
	                    forwarded = forwarded.split(",")[0];
	                }
	                ip = realIp + "/" + forwarded;
	            }
	        }
	        return ip;
    }
	
	
	
}
