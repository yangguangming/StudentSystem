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
		  //添加数据
		  jedis.hset("key", "Student", "1，张三，2018-1-12，程序员，78");
		  jedis.hset("key", "Student", "2，李四，2018-3-12，会计，64");
		  //获取指定值 获取名字
		  String name=jedis.hget("key", "Student");
		  String name1=jedis.hget("key", "Student");
		  System.out.println(name1+name);
		  //返回hash表中key中所有的域
		  Map<String,String>map=jedis.hgetAll("key");
		  System.out.println("map"+map);
		  //用set集合获取key域中所有的key
		  Set<String> hkeys = jedis.hkeys("key");
	        System.out.println(hkeys);
	        //删除指定域
	        System.out.println("删除吗"+jedis.del("key","Student1"));
	        //查看指定域是否存在
	        System.out.println("存在与否"+jedis.hexists("key", "Student1"));
		  
		
		  */
		  Map<String,String>map=jedis.hgetAll("001");
				  System.out.println(map);
		  System.out.println(map.get("name"));
		  
		  // jedis.hmset("004", )
	  }
	  //添加map
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
	  //操作list
	  public void list(){
		  //从头添加
		  jedis.lpush("list", "tom","json","bibo","easy");
		  //从尾添加
		  jedis.rpush("list", "wanmei","kaixuan");
		  //返回list的长度
		  jedis.llen("list");
		  //取值
		  List<String>list=jedis.lrange("list", 0, -1);
		  for(String str:list){
			  System.out.println("list的值是"+str);
		  }
	  }*/
	  public static void main(String[] args) {
		  JedisTest test=new JedisTest();
		  test.connectRedis();
		  test.testHash();
		 // test.list();
	}
}
