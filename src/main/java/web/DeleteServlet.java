package web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import manage.ManageStudent;
public class DeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		ManageStudent mn=new ManageStudent();
		System.out.println("获取页面数据开始");
		String id=req.getParameter("id");
		System.out.println("开始执行");
		mn.deleteStudent(id);
		System.out.println("完成删除操作！");
		resp.sendRedirect(req.getContextPath()+"/ShowServlet");
	}
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req,resp);
	}
}
