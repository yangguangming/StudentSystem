package test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

import jedis.JedisResource;
import redis.clients.jedis.Jedis;
import student.Student;

public class JedisTest {
	private Jedis jedis;
	
	
	  public void connectRedis(){
		  jedis=JedisResource.getJedis();
		  
		  System.out.println("jedis"+jedis);
	  }
	  public void testHash(){
		  /*
		  //�������
		  jedis.hset("key", "Student", "1��������2018-1-12������Ա��78");
		  jedis.hset("key", "Student", "2�����ģ�2018-3-12����ƣ�64");
		  //��ȡָ��ֵ ��ȡ����
		  String name=jedis.hget("key", "Student");
		  String name1=jedis.hget("key", "Student");
		  System.out.println(name1+name);
		  //����hash����key�����е���
		  Map<String,String>map=jedis.hgetAll("key");
		  System.out.println("map"+map);
		  //��set���ϻ�ȡkey�������е�key
		  Set<String> hkeys = jedis.hkeys("key");
	        System.out.println(hkeys);
	        //ɾ��ָ����
	        System.out.println("ɾ����"+jedis.del("key","Student1"));
	        //�鿴ָ�����Ƿ����
	        System.out.println("�������"+jedis.hexists("key", "Student1"));
		  
		
		  */
		  Map<String,String>map=jedis.hgetAll("001");
				  System.out.println(map);
		  System.out.println(map.get("name"));
		  
		  // jedis.hmset("004", )
	  }
	  //���map
	  public void addMap(String key,Student stu){
		//  jedis.hset(key, filed, value);
		  Map<String,String >map=new HashMap<String,String>();
		  map.put("Id",stu.getId());
		  map.put("name", stu.getName());
		  map.put("birthday",( stu.getBirthday().toString()));
		  map.put("description", stu.getDescription());
		  map.put("avgscore",(stu.getAvgscore()+""));
	  }
	  /*
	  //����list
	  public void list(){
		  //��ͷ���
		  jedis.lpush("list", "tom","json","bibo","easy");
		  //��β���
		  jedis.rpush("list", "wanmei","kaixuan");
		  //����list�ĳ���
		  jedis.llen("list");
		  //ȡֵ
		  List<String>list=jedis.lrange("list", 0, -1);
		  for(String str:list){
			  System.out.println("list��ֵ��"+str);
		  }
	  }*/
	  public static void main(String[] args) {
		  JedisTest test=new JedisTest();
		  test.connectRedis();
		  test.testHash();
		 // test.list();
	}
}
