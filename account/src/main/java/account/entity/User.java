package account.entity;

import java.io.Serializable;
import java.util.Date;

@SuppressWarnings("serial")
public class User implements Serializable {
	private int Id;
	private String Name;
	private String Telephone;
	private int Tender;
	private Date Date;
	private int Age;
	private String Password;

	public String getName() {
		return Name;
	}

	public void setName(String Name) {
		this.Name = Name;
	}

	public String getPassword() {
		return Password;
	}

	public void setPassword(String Password) {
		this.Password = Password;
	}

	public String getTelephone() {
		return Telephone;
	}

	public String setTelephone(String Telephone) {
		return this.Telephone = Telephone;
	}

	public int getId() {
		return Id;
	}

	public void setId(int Id) {
		this.Id = Id;
	}

	public int getAge() {
		return Age;
	}

	public void setAge(int age) {
		Age = age;
	}

	public Date getDate() {
		return Date;
	}

	public void setDate(Date date) {
		Date = date;
	}

	public int getTender() {
		return Tender;
	}

	public void setTender(int tender) {
		Tender = tender;
	}

	public User(String Name, String password, int Age, int Tender, String Telephone) {
		super();
		this.Age = Age;
		this.Name = Name;
		this.Password = password;
		this.Telephone = Telephone;
		this.Date = new Date();// 获取当前的日期
		// SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式
		// String str = df.format(date);//获取String类型的时间
		// this.Date = df;
		this.Tender = Tender;
	}
	public User() {
		super();
	}
	
	

	@Override
	public String toString() {
		return    "user  [Id=" + Id + ",Name=" + Name + ",Tender=" + Tender + ",Password=" + Password + ",Telephone=" + Telephone
				+ ",Date=" + Date+"]";
	}
}
