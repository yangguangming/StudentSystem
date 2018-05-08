package jedis;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;
public class JedisResource {
		//��������Ip��ַ
	    private static String ADDR = "39.105.1.245";
	    //�˿ں�
	    private static int PORT = 6379;
	    //����
	    private static String AUTH = "123456";
	    //����ʵ�������������
	    private static int MAX_ACTIVE = 1024;
	    //����һ��pool����ж��ٸ�״̬Ϊidle(���е�)��jedisʵ��
	    private static int MAX_IDLE = 200;
	    //�ȴ��������ӵ����ʱ�䣬��λ���룬Ĭ��ֵΪ-1����ʾ������ʱ����������ȴ�ʱ�䣬��ֱ���׳�JedisConnectionException
	    private static int MAX_WAIT = 10000;
	    //���ӳ�ʱ��ʱ�䡡��
	    private static int TIMEOUT = 10000;
	    private static boolean TEST_ON_BORROW = true;
	    private static JedisPool jedisPool = null;
	    private static Jedis  resource= null;
	    /**
	     * ��ʼ��Redis���ӳ�
	     */
	    static {
	        try {
	        	System.out.println("��ʼ����ʼ��");
	            JedisPoolConfig config = new JedisPoolConfig();
	            config.setMaxTotal(MAX_ACTIVE);
	            config.setMaxIdle(MAX_IDLE);
	            config.setMaxWaitMillis(MAX_WAIT);
	            config.setTestOnBorrow(TEST_ON_BORROW);
	            jedisPool = new JedisPool(config, ADDR, PORT, TIMEOUT, AUTH);
	            System.out.println("��ʼ����ϣ�");
	        } catch (Exception e) {
	            e.printStackTrace();
	        }
	    }
	    /**
	     * ��ȡJedisʵ��
	     */
	    public synchronized static Jedis getJedis() {
	        try {
	            if (jedisPool != null) {
	                 resource = jedisPool.getResource();
	                 System.out.println("resource"+resource +"jedisPool"+jedisPool);
	                return resource;
	            } else {
	            	System.out.println("������һ��");
	                return null;
	            }
	        } catch (Exception e) {
	            e.printStackTrace();
	            System.out.println("�����ڶ���");
	            return null;
	        }
	    }
	    /***
	     * 
	     * �ͷ���Դ
	     */
	    public static void returnResource(final Jedis jedis) {
	            if(jedis != null) {
	            	 System.out.println("�رղ���");
	                jedisPool.close();
	            }
	    }
	}