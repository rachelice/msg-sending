package com.sunshineroad.framework.util.aspost;


import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 该实体类用于填充excel模板
 */
public class Person {

	private String name;
	
	private Date birthday;
	
	private int age;
	
	private double salary;

	private static SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
	
	public Person() {}
	
	public Person(String name, Date birthday, int age, double salary) {
		super();
		this.name = name;
		this.birthday = birthday;
		this.age = age;
		this.salary = salary;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	/**
	 * 值得注意的是 
	 * 由于不知道怎么在Aspose框架上处理导出时间格式的问题
	 * 只好在这里处理了,算是一个变通的解决方案吧
	 */
	public String getBirthday() {
		return format.format(birthday);
	}

	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public double getSalary() {
		return salary;
	}

	public void setSalary(double salary) {
		this.salary = salary;
	}
}
