package com.sunshineroad.framework.util.aspost;


import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class InitData {

	public static List<Person> getPersons() {
		List<Person> persons = new ArrayList<Person>();
		persons.add(new Person("张三", new Date(), 25, 4022.34));
		persons.add(new Person("李四", new Date(), 56, 3580.3));
		persons.add(new Person("王宇", new Date(), 45, 5454.34));
		persons.add(new Person("小强", new Date(), 57, 5876.24));
		persons.add(new Person("微微", new Date(), 54, 4022.68));
		persons.add(new Person("丽丽", new Date(), 12, 5878.12));
		persons.add(new Person("张娜", new Date(), 37, 5454.00));
		persons.add(new Person("王华", new Date(), 60, 2221));
		persons.add(new Person("阿超", new Date(), 55, 4587));
		persons.add(new Person("黑子", new Date(), 22, 9788));
		persons.add(new Person("小王", new Date(), 37, 2212.24));
		persons.add(new Person("剌剌", new Date(), 27, 8785.24));
		persons.add(new Person("荷花", new Date(), 18, 5454.34));
		return persons;
	}
	
	public static Map<String, Object> getHashMap() {
		Map<String, Object> data = new HashMap<String, Object>();
		data.put("name", "张三");
		data.put("age", 35);
		data.put("birthday", "1985-01-03");
		data.put("address", "辽宁沈阳");
		data.put("phone", "13988888888");
		return data;
	}
}

