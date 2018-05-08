package web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import manage.ManageStudent;
import net.sf.json.JSONObject;
import student.Student;

public class SelectServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doPost(req, resp);
	}
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		resp.setContentType("text/html;charset=utf-8");
		ManageStudent mn=new ManageStudent();
		String id=req.getParameter("id");
		System.out.println(id+"id");
		String show=mn.selectStudent(id);
		System.out.println("show"+show);
		JSONObject jsonObject=JSONObject.fromObject(show);
		Student stu=(Student)JSONObject.toBean(jsonObject, Student.class);
		System.out.println(stu.toString());
		req.setAttribute("stu", stu);
		req.getRequestDispatcher("ModifyStudent.jsp").forward(req, resp);
		
	}

}
