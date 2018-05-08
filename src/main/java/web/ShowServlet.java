package web;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import jedis.JedisResource;
import net.sf.json.JSONObject;
import redis.clients.jedis.Jedis;
import student.Student;

public class ShowServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Jedis jedis;

	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doPost(req, resp);
	}
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		resp.setContentType("text/html;charset=utf-8");
		jedis=JedisResource.getJedis();
		//总记录数
		Long zcard = jedis.zcard("STUDENT_SCORE");
		System.out.println(zcard);
		//页数
		int i=10;
		int pages = (int) Math.ceil(zcard/10.0);
		req.setAttribute("count", pages);
		System.out.println(pages);
		String parameter = req.getParameter("p");
		if(parameter==null)parameter="1";
		int	page=Integer.parseInt(parameter);
		int index = (page-1)*i;
		Set<String> zrevrangeByScore = jedis.zrevrangeByScore("STUDENT_SCORE", 100, 0, index, i);
		ArrayList<Student> student = new ArrayList<>();
		for(String str:zrevrangeByScore){
			String show=jedis.hget("STUDENT_MANAGE", str);
			JSONObject jsonObject=JSONObject.fromObject(show);
			Student stu=(Student)JSONObject.toBean(jsonObject, Student.class);
			System.out.println("学生信息"+show);
			student.add(stu);
		}
		//将数据封装到list里面
		req.setAttribute("list", student);
		req.getRequestDispatcher("listStudent.jsp").forward(req, resp);
	}

}
