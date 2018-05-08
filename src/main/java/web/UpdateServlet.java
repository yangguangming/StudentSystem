package web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import manage.ManageStudent;
import student.Student;

public class UpdateServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	}

	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		resp.setContentType("text/html;charset=utf-8");
	//修改学生数据
		ManageStudent mn=new ManageStudent();
		Student student=new Student();
		System.out.println("获取页面数据开始");
		student.setId(req.getParameter("id"));
		student.setName(req.getParameter("name"));
		student.setBirthday(req.getParameter("birthday"));
		student.setDescription(req.getParameter("description"));
		student.setAvgscore(Integer.parseInt(req.getParameter("avgscore")));
		System.out.println(req.getParameter("id")+req.getParameter("name")+req.getParameter("birthday")+
				req.getParameter("avgscore")+req.getParameter("description"));
		System.out.println("开始执行");
		mn.updateStudent(student);
		System.out.println("完成修改操作！");
		resp.sendRedirect(req.getContextPath()+"/ShowServlet");
	}
	
}
