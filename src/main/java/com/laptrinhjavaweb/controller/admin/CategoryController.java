package com.laptrinhjavaweb.controller.admin;

import java.io.IOException;

import javax.inject.Inject;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.laptrinhjavaweb.constant.SystemConstant;
import com.laptrinhjavaweb.model.CategoryModel;
import com.laptrinhjavaweb.service.ICategoryService;
import com.laptrinhjavaweb.utils.FormUtil;

@WebServlet(urlPatterns = {"/admin-category"})
public class CategoryController extends HttpServlet {

	private static final long serialVersionUID = 2686801510274002166L;
	
	@Inject
	private ICategoryService categoryService;
	
	protected void doGet(HttpServletRequest request , HttpServletResponse response) throws ServletException, IOException
	{
		CategoryModel model = FormUtil.toModel(CategoryModel.class, request);
		
		String view="";
		if(model.getType().equals(SystemConstant.LIST)) {
			model.setListResult(categoryService.findAll());
			view="/views/admin/category/listcategory.jsp";
		}
		
		request.setAttribute(SystemConstant.MODEL, model);
		RequestDispatcher rd = request.getRequestDispatcher(view);
		rd.forward(request, response);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}
