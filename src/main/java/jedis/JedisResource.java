package jedis;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;
public class JedisResource {
		//服务器的Ip地址
	    private static String ADDR = "39.105.1.245";
	    //端口号
	    private static int PORT = 6379;
	    //密码
	    private static String AUTH = "123456";
	    //连接实例的最大连接数
	    private static int MAX_ACTIVE = 1024;
	    //控制一个pool最多有多少个状态为idle(空闲的)的jedis实例
	    private static int MAX_IDLE = 200;
	    //等待可用连接的最大时间，单位毫秒，默认值为-1，表示永不超时。如果超过等待时间，则直接抛出JedisConnectionException
	    private static int MAX_WAIT = 10000;
	    //连接超时的时间　　
	    private static int TIMEOUT = 10000;
	    private static boolean TEST_ON_BORROW = true;
	    private static JedisPool jedisPool = null;
	    private static Jedis  resource= null;
	    /**
	     * 初始化Redis连接池
	     */
	    static {
	        try {
	        	System.out.println("初始化开始！");
	            JedisPoolConfig config = new JedisPoolConfig();
	            config.setMaxTotal(MAX_ACTIVE);
	            config.setMaxIdle(MAX_IDLE);
	            config.setMaxWaitMillis(MAX_WAIT);
	            config.setTestOnBorrow(TEST_ON_BORROW);
	            jedisPool = new JedisPool(config, ADDR, PORT, TIMEOUT, AUTH);
	            System.out.println("初始化完毕！");
	        } catch (Exception e) {
	            e.printStackTrace();
	        }
	    }
	    /**
	     * 获取Jedis实例
	     */
	    public synchronized static Jedis getJedis() {
	        try {
	            if (jedisPool != null) {
	                 resource = jedisPool.getResource();
	                 System.out.println("resource"+resource +"jedisPool"+jedisPool);
	                return resource;
	            } else {
	            	System.out.println("进来第一个");
	                return null;
	            }
	        } catch (Exception e) {
	            e.printStackTrace();
	            System.out.println("进来第二个");
	            return null;
	        }
	    }
	    /***
	     * 
	     * 释放资源
	     */
	    public static void returnResource(final Jedis jedis) {
	            if(jedis != null) {
	            	 System.out.println("关闭操作");
	                jedisPool.close();
	            }
	    }
	}