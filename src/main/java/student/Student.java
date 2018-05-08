package student;

import java.text.SimpleDateFormat;
import java.util.Date;

import manage.UUId;

/**
 * 3.3:��ʹ��Redis �����ݿ� (Jedis��ΪDriver) ƽ���Servlet /JSP/JSTL ��һ��ѧ�����ݹ�����.
A:ѧ�����ݰ���:
 Id �ַ������ͳ��� 40,
���� (name)�ַ������ͳ��� 40,
��������(birthday) ��������,
��ע (description)�ַ������ͳ��� 255,
ƽ����(avgscore) ��������,

B:����:
����ƽ���ֵ����ҳ(ÿҳ10����¼),չʾѧ�����������ֶ�,ÿ���� �޸ĺ�ɾ�� ����;
����޸������ܹ��޸ĸ�ѧ������;
���ɾ��������ɾ��һ��ѧ������;
�б�ҳ�·��з�ҳ����,����ܹ���ת����Ӧ��ҳ��;
�б�ҳ�Ϸ�����������,���¼��һ��ѧ������.

���� �����ύ��github ,Ҫ��ʹ��maven
�����ǵ�Ӧ�ò��𵽹���İ����Ʒ�����,���������ʵ�ַ

 * @author Administrator
 *
 */
public class Student {
	private  String Id;
	private   String name;
	private  String birthday;
	private  String description;
	private  int avgscore;
	public Student(){
		
	}
	public Student(String Id,int avgscore){
		this.Id=Id;
		this.avgscore=avgscore;
	}
	public Student(String Id,String name,String birthday,String description,int avgscore){
		this.Id=Id;
		this.name=name;
		this.birthday=birthday;
		this.description =description;
		this.avgscore=avgscore;
	}
	
	public String getId() {
		return Id;
	}
	
	public void setId(String id) {
		Id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getBirthday() {
		return birthday;
	}
	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public int getAvgscore() {
		return avgscore;
	}
	public void setAvgscore(int string) {
		this.avgscore = string;
	}
	public String toString() {
		return "Student [Id=" + Id + ", name=" + name + ", birthday=" + birthday + ", description=" + description
				+ ", avgscore=" + avgscore + "]";
	}
	
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Student other = (Student) obj;
		if (Id == null) {
			if (other.Id != null)
				return false;
		} else if (!Id.equals(other.Id))
			return false;
		if (avgscore != other.avgscore)
			return false;
		if (birthday == null) {
			if (other.birthday != null)
				return false;
		} else if (!birthday.equals(other.birthday))
			return false;
		if (description == null) {
			if (other.description != null)
				return false;
		} else if (!description.equals(other.description))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}
	
	
	
}