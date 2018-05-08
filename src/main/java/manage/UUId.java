package manage;

import java.util.UUID;

public class UUId {
	public static String getUUID(){
	String uid= UUID.randomUUID().toString();
	return uid;
	}
}
