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
	//�������
	public void addStudent(Student stu){
		System.out.println("������");
		String uuid=UUId.getUUID();
		stu.setId(uuid);
		String value=JSONObject.fromObject(stu).toString();
		System.out.println(key1+uuid+value);
		jedis.hset(key1, stu.getId(), value);
		jedis.zadd(key2, stu.getAvgscore(), stu.getId());
	}
	//�޸�����
	public void updateStudent(Student stu){
		String id=stu.getId();
		String value=JSONObject.fromObject(stu).toString();
		jedis.hset(key1, id, value);
	}
	//ɾ������
	public void deleteStudent(String Id ){
		if(Id!=null){
			jedis.hdel(key1, Id);
			jedis.zrem(key2, Id);
			}
	}
	//��ѯ��������
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

