package com.bjsxt.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bjsxt.pojo.People;
import com.bjsxt.service.PeopleService;
import com.bjsxt.service.impl.PeopleServiceImpl;

/**
 * 
 */
@WebServlet("/sho")
public class ShowServlet extends HttpServlet {
	private PeopleService peopleService=new PeopleServiceImpl();
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		List<People> list = peopleService.show();
		System.out.println("查询到的结果:"+list);
		req.setAttribute("list", list);
		req.getRequestDispatcher("/index.jsp").forward(req, resp);
		return;
	}

}
