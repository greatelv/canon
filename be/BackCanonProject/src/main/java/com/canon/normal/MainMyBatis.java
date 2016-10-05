package com.canon.normal;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.Path;

import com.canon.normal.second.MybatisBookCodeStarter;

@WebServlet("/mainMybatis")
@Path("/mainMaybatis")
public class MainMyBatis extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private void start() {
//		new MybatisSampleCodeStarter().start();
		new MybatisBookCodeStarter().start();
	}
	
	@Override
	public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		super.doGet(req, resp);
		start();
		
		System.out.println("done");
		
		resp.setContentType("text/html");
		resp.getWriter().write("hello!");
	}
}
