package manage;
import jedis.JedisResource;
import net.sf.json.JSONObject;
import redis.clients.jedis.Jedis;
import student.Student;
public class ManageStudent {
	private static Jedis jedis;
	private final String key1="STUDENT_MANAGE";
	private final String key2="STUDENT_SCORE";
	static{
		jedis=JedisResource.getJedis();
	}
	//添加数据
	public void addStudent(Student stu){
		System.out.println("进来了");
		String uuid=UUId.getUUID();
		stu.setId(uuid);
		String value=JSONObject.fromObject(stu).toString();
		System.out.println(key1+uuid+value);
		jedis.hset(key1, stu.getId(), value);
		jedis.zadd(key2, stu.getAvgscore(), stu.getId());
	}
	//修改数据
	public void updateStudent(Student stu){
		String id=stu.getId();
		String value=JSONObject.fromObject(stu).toString();
		jedis.hset(key1, id, value);
	}
	//删除数据
	public void deleteStudent(String Id ){
		if(Id!=null){
			jedis.hdel(key1, Id);
			jedis.zrem(key2, Id);
			}
	}
	//查询单条数据
	public String selectStudent(String Id){
		return jedis.hget("STUDENT_MANAGE", Id);
	}
	public static void main(String[] args) {
		long total=jedis.zcard("STUDENT_SCORE");
		int pages=(int) Math.ceil(32/10.0);
		System.out.println(pages);
		System.out.println(total);
	}
}

