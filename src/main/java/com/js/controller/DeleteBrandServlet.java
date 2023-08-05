package com.js.controller;

import java.io.IOException;
import java.sql.ResultSet;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.js.dao.ProductCRUD;

@WebServlet("/deleteBrand")
public class DeleteBrandServlet extends HttpServlet{
	
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String brand=req.getParameter("brand");
		ProductCRUD pc =new ProductCRUD();
		
		int res=pc.deleteProductByBrand(brand);
		if(res>0) {
			RequestDispatcher rd= req.getRequestDispatcher("view");
			rd.forward(req, resp);
		}else {
			RequestDispatcher rd= req.getRequestDispatcher("result.jsp");
			req.setAttribute("msg", "Failed to Delete Product");
			rd.forward(req, resp);
		}

	}
	
	

}


