package com.laptrinhjavaweb.controller.web;

import java.io.IOException;
import java.util.ResourceBundle;

import javax.inject.Inject;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.laptrinhjavaweb.model.UserModel;
import com.laptrinhjavaweb.service.ICategoryService;
import com.laptrinhjavaweb.service.IUserService;
import com.laptrinhjavaweb.utils.FormUtil;
import com.laptrinhjavaweb.utils.SessionUtil;

@WebServlet(urlPatterns = {"/trang-chu","/dang-nhap","/thoat"})

public class HomeController extends HttpServlet {
	
	@Inject
	private ICategoryService categoryService;
	@Inject
	private IUserService userService;
    ResourceBundle resourceBundle = ResourceBundle.getBundle("message");

	private static final long serialVersionUID = 1L;
   
    public HomeController() {
        super();
       
    }
    
    


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	String action = null;
	action = request.getParameter("action");
	
	if (action != null && action.equals("login")) {
		String message = request.getParameter("message");
		String alert = request.getParameter("alert");
		
		if (message!=null && alert!=null) {
			request.setAttribute("message", resourceBundle.getString(message));
			request.setAttribute("alert", alert);
		}
		RequestDispatcher rd1 = request.getRequestDispatcher("/WEB-INF/views/login.jsp");
		rd1.forward(request, response);
	} else 
	if (action!=null && action.equals("logout")) {
		SessionUtil.getInstance().removeValue(request, "USERMODEL");
		response.sendRedirect(request.getContextPath()+"/trang-chu");
	}
	
	else if (action==null)
	{
			RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/views/web/home.jsp");
	        rd.forward(request, response);
	}
	
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		UserModel userModel = null;
		String action = request.getParameter("action");
	
		if (action == null) {
			 response.sendRedirect(request.getContextPath()+"/trang-chu");

		}
		if (action!=null && action.equals("login")) {
		 userModel = FormUtil.toModel(UserModel.class, request);
		 userModel = userService.findUserByAccount(userModel.getUserName(),userModel.getPassword(),1);	
		 if (userModel!=null) {
		    if (userModel.getRoleModel().getCode().equals("USER")) {
		    	SessionUtil.getInstance().putValue(request, "USERMODEL", userModel);
			response.sendRedirect(request.getContextPath()+"/trang-chu");
		}  else 
			if  (userModel.getRoleModel().getCode().equals("ADMIN")) {
		    	SessionUtil.getInstance().putValue(request, "USERMODEL", userModel);
				response.sendRedirect(request.getContextPath()+"/home");
			} 
				
		 } else 
			 if (userModel == null)
		 {
			 response.sendRedirect(request.getContextPath()+"/dang-nhap?action=login&message=username_password_invalid&alert=danger");

		 }
		}
	}

}
