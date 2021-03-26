package com.laptrinhjavaweb.controller.web;

import java.io.IOException;

import javax.inject.Inject;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.laptrinhjavaweb.model.CategoryModel;
import com.laptrinhjavaweb.model.UserModel;
import com.laptrinhjavaweb.service.ICategoryService;
import com.laptrinhjavaweb.service.IUserService;
import com.laptrinhjavaweb.utils.FormUtil;

@WebServlet(urlPatterns = {"/trang-chu","/dang-nhap"})

public class HomeController extends HttpServlet {
	
	@Inject
	private ICategoryService categoryService;
	@Inject
	private IUserService userService;
	
	private static final long serialVersionUID = 1L;
   
    public HomeController() {
        super();
       
    }
    
    


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	String action = request.getParameter("action");
	if (action != null && action.equals("login")) {
		RequestDispatcher rd1 = request.getRequestDispatcher("/WEB-INF/views/login.jsp");
		rd1.forward(request, response);
	}
		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/views/web/home.jsp");
	rd.forward(request, response);
	
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
   
		UserModel userModel = null;
		String action = request.getParameter("action");
		if (action!=null && action.equals("login")) {
			response.sendRedirect(request.getContextPath()+"/trang-chu");

		 userModel = FormUtil.toModel(UserModel.class, request);
		
		 userModel = userService.findUserByAccount(userModel.getUserName(),userModel.getPassword(),1);	
		if (userModel.getRoleModel().getCode().equals("USER")) {
			response.sendRedirect(request.getContextPath()+"/trang-chu");
		} 
		}
	}

}
