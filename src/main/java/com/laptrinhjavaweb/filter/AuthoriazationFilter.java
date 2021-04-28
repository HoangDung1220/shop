package com.laptrinhjavaweb.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.laptrinhjavaweb.constant.SystemConstant;
import com.laptrinhjavaweb.model.UserModel;
import com.laptrinhjavaweb.utils.SessionUtil;


public class AuthoriazationFilter implements Filter{

	
	
	private ServletContext context;

	public void init(FilterConfig filterConfig) throws ServletException {
		this.context = filterConfig.getServletContext();
		
	}

	public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain chain)
			throws IOException, ServletException {
	
		HttpServletRequest request = (HttpServletRequest) servletRequest;
		HttpServletResponse response = (HttpServletResponse) servletResponse;
		
		String url = request.getRequestURI();
		if (url.startsWith("/shop/home")) {
			UserModel user = (UserModel) SessionUtil.getInstance().getValue(request, "USERMODEL");
			if (user!=null) {
			if (user.getRoleModel().getCode().equals(SystemConstant.ADMIN)) {
				chain.doFilter(servletRequest, servletResponse);

			}
			else 
				if (user.getRoleModel().getCode().equals(SystemConstant.USER)){
					response.sendRedirect(request.getContextPath()+"/dang-nhap?action=login&message=not_permission&alert=danger");

				}
				
			}
		
			
			else
				if (user == null)
			{
				response.sendRedirect(request.getContextPath()+"/dang-nhap?action=login&message=not_login&alert=danger");

			}

				


			
		}
		
		else 
		{

			chain.doFilter(servletRequest, servletResponse);
		}
		
	}

	public void destroy() {
		
	}

}
