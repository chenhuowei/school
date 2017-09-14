package com.fireway.shiro.realm;


import javax.annotation.Resource;

import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;

import com.fireway.entity.Student;
import com.fireway.entity.Teacher;
import com.fireway.entity.User;
import com.fireway.rolePermission.service.RoleInfoService;
import com.fireway.user.service.StudentService;
import com.fireway.user.service.TeacherService;
import com.fireway.user.service.UserService;
import com.sun.org.apache.xml.internal.security.keys.keyresolver.implementations.PrivateKeyResolver;

public class MyRealm extends AuthorizingRealm {

	private UserService userService;
	public void setUserService(UserService userService) {
		this.userService = userService;
	}
	@Resource
	private RoleInfoService roleInfoService;
	@Resource
	private StudentService studentService;
	@Resource
	private TeacherService teacherService;
	
	 /** 
     * 角色权限认证; 
     */  
	@Override
	protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
		 //获取登录时输入的用户名  
        String loginName=(String) principalCollection.fromRealm(getName()).iterator().next();  
        //到数据库查是否有此对象  
        User user = userService.findByUserNum(loginName);
        Student student = studentService.findStudentByNum(loginName);
        Teacher teacher = teacherService.findTeacherByNum(loginName);
        if(null !=user ){  
            //权限信息对象info,用来存放查出的用户的所有的角色（role）及权限（permission）  
            SimpleAuthorizationInfo info=new SimpleAuthorizationInfo();  
            //用户的角色集合  
            info.setRoles(roleInfoService.findRoleNamesByUserId(user.getId()));  
            //用户的角色对应的所有权限，如果只使用角色定义访问权限，下面的四行可以不要  
//            Set<UserRole> userRoles = user.getUserRoles();  
//            for (UserRole userRole : userRoles) {  
//                info.addStringPermissions(userRole.getRole().getPermissionNames());  
//            }  
            return info;  
        }  
    
        if(null !=student ){  
        	//权限信息对象info,用来存放查出的用户的所有的角色（role）及权限（permission）  
        	SimpleAuthorizationInfo info=new SimpleAuthorizationInfo();  
        	//用户的角色集合  
        	//info.setRoles(roleInfoService.findRoleNamesByUserId(user.getId()));  
        	//用户的角色对应的所有权限，如果只使用角色定义访问权限，下面的四行可以不要  
//            Set<UserRole> userRoles = user.getUserRoles();  
//            for (UserRole userRole : userRoles) {  
//                info.addStringPermissions(userRole.getRole().getPermissionNames());  
//            }  
        	return info;  
        }  
        if(null !=teacher ){  
        	//权限信息对象info,用来存放查出的用户的所有的角色（role）及权限（permission）  
        	SimpleAuthorizationInfo info=new SimpleAuthorizationInfo();  
        	//用户的角色集合  
        	//info.setRoles(roleInfoService.findRoleNamesByUserId(user.getId()));  
        	//用户的角色对应的所有权限，如果只使用角色定义访问权限，下面的四行可以不要  
//            Set<UserRole> userRoles = user.getUserRoles();  
//            for (UserRole userRole : userRoles) {  
//                info.addStringPermissions(userRole.getRole().getPermissionNames());  
//            }  
        	return info;  
        }  
		return null;
	}
	 /** 
     * 登录认证; 
     */  
	@Override
	protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
		 //UsernamePasswordToken对象用来存放提交的登录信息  
        UsernamePasswordToken token=(UsernamePasswordToken) authenticationToken;  
    	//String userName = (String) authenticationToken.getPrincipal();
        //查出是否有此用户  
        User user=userService.findByUserNum(token.getUsername()); 
        Student student = studentService.findStudentByNum(token.getUsername());
        Teacher teacher = teacherService.findTeacherByNum(token.getUsername());
        if(null!=user){  
            //若存在，将此用户存放到登录认证info中  
        	
            return new SimpleAuthenticationInfo(user.getUserNum(), user.getPassword(), getName());  
        
        }  
        if(null!=student){  
        	//若存在，将此用户存放到登录认证info中  
        	
        	return new SimpleAuthenticationInfo(student.getStudentNum(), student.getPassword(), getName());  
        	
        }  
        if(null!=teacher){  
        	//若存在，将此用户存放到登录认证info中  
        	
        	return new SimpleAuthenticationInfo(teacher.getTeacherNum(), teacher.getPassword(), getName());  
        	
        }  
		return null;
	}

}
