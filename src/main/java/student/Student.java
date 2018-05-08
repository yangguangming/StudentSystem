package student;

import java.text.SimpleDateFormat;
import java.util.Date;

import manage.UUId;

/**
 * 3.3:请使用Redis 做数据库 (Jedis做为Driver) 平配合Servlet /JSP/JSTL 做一个学生数据管理功能.
A:学生数据包含:
 Id 字符串类型长度 40,
姓名 (name)字符串类型长度 40,
出生日期(birthday) 日期类型,
备注 (description)字符串类型长度 255,
平均分(avgscore) 整数类型,

B:功能:
按照平均分倒序分页(每页10条记录),展示学生数据所有字段,每行有 修改和删除 链接;
点击修改链接能够修改该学生数据;
点击删除链接能删除一个学生数据;
列表页下方有分页链接,点击能够跳转到相应的页数;
列表页上方有新增链接,点击录入一个学生数据.

此题 代码提交到github ,要求使用maven
将你们的应用部署到购买的阿里云服务器,并给出访问地址

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