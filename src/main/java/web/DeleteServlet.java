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
		System.out.println("��ȡҳ�����ݿ�ʼ");
		String id=req.getParameter("id");
		System.out.println("��ʼִ��");
		mn.deleteStudent(id);
		System.out.println("���ɾ��������");
		resp.sendRedirect(req.getContextPath()+"/ShowServlet");
	}
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req,resp);
	}
}
